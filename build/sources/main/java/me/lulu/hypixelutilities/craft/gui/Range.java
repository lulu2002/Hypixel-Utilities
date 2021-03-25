package me.lulu.hypixelutilities.craft.gui;

public class Range {
    private int startX, startY;
    private int endX, endY;

    public Range(int startX, int startY, int endX, int endY) {
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
    }

    public boolean isInRange(int x, int y) {
        return x >= startX && x < endX && y >= startY && y < endY;
    }
}
