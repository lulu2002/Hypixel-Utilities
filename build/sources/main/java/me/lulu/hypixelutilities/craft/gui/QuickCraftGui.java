package me.lulu.hypixelutilities.craft.gui;

import me.lulu.hypixelutilities.craft.ListButtons;
import me.lulu.hypixelutilities.craft.QuickCraft;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.fml.client.GuiScrollingList;

import java.io.IOException;
import java.util.List;

public class QuickCraftGui extends GuiScreen {

    private List<GuiButton> buttons;

    private ListButtons<QuickCraft> listButtons;
    private GuiScrollingList list;

    @Override
    public void initGui() {
        super.initGui();
        initList();
    }

    private void initList() {
        this.list = new QuickCraftGuiList(Minecraft.getMinecraft(), this, this.width, this.height);
    }

    @Override
    protected void actionPerformed(GuiButton button) throws IOException {

    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        this.list.drawScreen(mouseX, mouseY, partialTicks);
        super.drawScreen(mouseX, mouseY, partialTicks);
    }
}
