package me.lulu.hypixelutilities.craft.gui;

import me.lulu.hypixelutilities.craft.QuickCraft;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.Tessellator;
import net.minecraftforge.fml.client.GuiScrollingList;

public class QuickCraftGuiList extends GuiScrollingList {
    private static int ITEMS_PER_ROW = 4;

    private QuickCraftListRow[] rows;

    public QuickCraftGuiList(Minecraft client, int width, int height) {
        super(client, width, height, 0, height, 0, 24);

        initRows();
    }

    private void initRows() {
        QuickCraft[] crafts = QuickCraft.values();
        rows = new QuickCraftListRow[getRowsSize(crafts.length)];

        for (int i = 0; i < rows.length; i++)
            rows[i] = new QuickCraftListRow();

        for (int i = 0; i < crafts.length; i++) {
            QuickCraft craft = crafts[i];
            rows[i / ITEMS_PER_ROW].add(craft);
        }
    }

    private int getRowsSize(int length) {
        boolean hasMore = length % ITEMS_PER_ROW != 0;
        int size = length / ITEMS_PER_ROW;

        if (hasMore)
            size++;

        return size;
    }

    @Override
    protected int getSize() {
        return rows.length;
    }

    @Override
    protected void elementClicked(int i, boolean b) {
        rows[i].onClick(mouseX, mouseY);
    }

    @Override
    protected boolean isSelected(int i) {
        return false;
    }

    @Override
    protected void drawBackground() {

    }

    @Override
    protected void drawSlot(int i, int width, int height, int barTop, Tessellator tessellator) {
        rows[i].render(width, height, barTop);
    }

    @Override
    public void actionPerformed(GuiButton button) {
        super.actionPerformed(button);
    }


}
