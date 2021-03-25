package me.lulu.hypixelutilities.craft.gui;

public class Range {
    private int start;
    private int end;

    public Range(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public boolean isInRange(int i) {
        return i >= start && i < end;
    }
}
