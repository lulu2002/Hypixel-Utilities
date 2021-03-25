package me.lulu.hypixelutilities.craft;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;

public class ButtonDrawerCenterAlign implements ButtonDrawer {

    private final int buttonWidth, buttonHeight;
    private final int guiWidth, guiHeight;
    private final int buttonsPerRow;

    private final int screenWidth = Minecraft.getMinecraft().displayWidth;
    private final int buttonSpace;
    private final int xToCenter;
    private final int yMargin = 10;

    private int drawingRowSlot;
    private int currentY = yMargin;


    public ButtonDrawerCenterAlign(int buttonWidth, int buttonHeight, int buttonsPerRow, int guiWidth, int guiHeight) {
        this.buttonWidth = buttonWidth;
        this.buttonHeight = buttonHeight;
        this.buttonsPerRow = buttonsPerRow;
        this.guiWidth = guiWidth;
        this.guiHeight = guiHeight;

        this.buttonSpace = guiWidth / buttonsPerRow;
        this.xToCenter = (buttonSpace - buttonWidth) / 2;
    }

    @Override
    public void draw(GuiButton button) {
        if (drawingRowSlot >= buttonsPerRow)
            nextLine();

        button.height = this.buttonHeight;
        button.width = this.buttonWidth;
        button.xPosition = (this.drawingRowSlot * this.buttonSpace + xToCenter);
        button.yPosition = currentY;

        drawingRowSlot++;
    }

    private void nextLine() {
        drawingRowSlot = 0;
        currentY += (yMargin + buttonHeight);
    }
}
