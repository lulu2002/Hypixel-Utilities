package me.lulu.hypixelutilities.craft.gui;

import me.lulu.hypixelutilities.HypixelUtilities;
import me.lulu.hypixelutilities.craft.QuickCraft;
import me.lulu.hypixelutilities.craft.QuickCraftUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.Tessellator;
import net.minecraftforge.fml.client.GuiScrollingList;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class QuickCraftGuiList extends GuiScrollingList {
    private static int ITEMS_PER_ROW = 4;

    private QuickCraftListRow[] rows;
    private GuiScreen guiScreen;

    public QuickCraftGuiList(Minecraft client, GuiScreen guiScreen, int width, int height) {
        super(client, width, height, 0, height, 0, 24);
        this.guiScreen = guiScreen;
        initRows();
    }

    private void initRows() {
        List<QuickCraft> crafts = getQuickCraftSorted();
        rows = new QuickCraftListRow[getRowsSize(crafts.size())];

        for (int i = 0; i < rows.length; i++)
            rows[i] = new QuickCraftListRow(guiScreen);

        for (int i = 0; i < crafts.size(); i++) {
            QuickCraft craft = crafts.get(i);
            rows[i / ITEMS_PER_ROW].add(craft);
        }
    }

    private List<QuickCraft> getQuickCraftSorted() {
        return Arrays.stream(QuickCraft.values())
                .sorted(Comparator.comparing(Enum::name))
                .sorted((o1, o2) -> Boolean.compare(QuickCraftUtils.isFavorite(o2), QuickCraftUtils.isFavorite(o1)))
                .collect(Collectors.toList());
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
        initRows();
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
        rows[i].render(width, height, this.slotHeight, mouseX, mouseY);
    }

    @Override
    protected void drawScreen(int mouseX, int mouseY) {
        if (Minecraft.getMinecraft().displayWidth <= 600)
            ITEMS_PER_ROW = 1;
        else if (Minecraft.getMinecraft().displayWidth <= 1000)
            ITEMS_PER_ROW = 2;
        else
            ITEMS_PER_ROW = 4;

        super.drawScreen(mouseX, mouseY);
    }

    @Override
    public void actionPerformed(GuiButton button) {
        super.actionPerformed(button);
    }


}
