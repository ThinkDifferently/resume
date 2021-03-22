package com.resume.java.util;

public class StopWatch {

    private long startTime;

    public StopWatch() {

    }

    public void start() {
        this.startTime = System.currentTimeMillis();
    }

    public long getElapsedTime() {
        return System.currentTimeMillis() - this.startTime;
    }
}