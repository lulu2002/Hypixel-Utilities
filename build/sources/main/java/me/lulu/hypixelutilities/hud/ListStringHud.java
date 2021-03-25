package me.lulu.hypixelutilities.hud;

import java.util.List;

public abstract class ListStringHud extends SimpleHud {

    private int startX;
    private int startY;
    private int lineHeight;

    public ListStringHud(int startX, int startY) {
        this(startX, startY, 9);
    }

    public ListStringHud(int startX, int startY, int lineHeight) {
        this.startX = startX;
        this.startY = startY;
        this.lineHeight = lineHeight;
    }

    @Override
    public void render() {
        int y = startY;
        for (String s : getList()) {
            getFontRenderer().drawStringWithShadow(s, startX, y, 0);
            y += lineHeight;
        }
    }


    protected abstract List<String> getList();
}
