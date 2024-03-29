package com.liudehuang.datasource.utils;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class KeyWorker {
    private static final long twepoch = 1561095400000L;
    private static final long workerIdBits = 5L;
    private static final long datacenterIdBits = 5L;
    private static final long sequenceBits = 12L;
    private static final long workerIdShift = 12L;
    private static final long datacenterIdShift = 17L;
    private static final long timestampLeftShift = 22L;
    private static final long sequenceMask = 4095L;
    private static long lastTimestamp = -1L;
    private long sequence = 0L;
    private long workerId = 1L;
    private static long workerMask = 31L;
    private long processId = 1L;
    private static long processMask = 31L;
    private static KeyWorker keyWorker = null;

    public static synchronized long nextId() throws IdGeneratorException {
        return keyWorker.getNextId();
    }

    private KeyWorker() {
        this.workerId = this.getMachineNum();
        RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
        this.processId = Long.valueOf(runtimeMXBean.getName().split("@")[0]);
        this.workerId &= workerMask;
        this.processId &= processMask;
    }

    public synchronized long getNextId() throws IdGeneratorException {
        long timestamp = this.timeGen();
        if (timestamp < lastTimestamp) {
            throw new IdGeneratorException("Clock moved backwards.  Refusing to generate id for " + (lastTimestamp - timestamp) + " milliseconds");
        } else {
            if (lastTimestamp == timestamp) {
                this.sequence = this.sequence + 1L & 4095L;
                if (this.sequence == 0L) {
                    timestamp = this.tilNextMillis(lastTimestamp);
                }
            } else {
                this.sequence = 0L;
            }

            lastTimestamp = timestamp;
            long nextId = timestamp - 1561095400000L << 22 | this.processId << 17 | this.workerId << 12 | this.sequence;
            return nextId;
        }
    }

    private long tilNextMillis(long lastTimestamp) {
        long timestamp;
        for(timestamp = this.timeGen(); timestamp <= lastTimestamp; timestamp = this.timeGen()) {
        }

        return timestamp;
    }

    private long timeGen() {
        return System.currentTimeMillis();
    }

    private long getMachineNum() {
        long machinePiece = 0L;
        StringBuilder sb = new StringBuilder();
        Enumeration e = null;

        try {
            e = NetworkInterface.getNetworkInterfaces();
        } catch (SocketException var6) {
            var6.printStackTrace();
        }

        if (null != e) {
            while(e.hasMoreElements()) {
                NetworkInterface ni = (NetworkInterface)e.nextElement();
                sb.append(ni.toString());
            }

            machinePiece = (long)sb.toString().hashCode();
        }

        return machinePiece;
    }

    static {
        keyWorker = new KeyWorker();
    }
}