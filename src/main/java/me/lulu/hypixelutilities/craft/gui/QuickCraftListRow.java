package me.lulu.hypixelutilities.craft.gui;

import me.lulu.hypixelutilities.craft.QuickCraft;
import me.lulu.hypixelutilities.craft.QuickCraftExecutor;
import me.lulu.hypixelutilities.craft.QuickCraftUtils;
import me.lulu.hypixelutilities.util.McUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiScreen;
import org.apache.commons.lang3.text.WordUtils;
import org.lwjgl.input.Keyboard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuickCraftListRow {
    private GuiScreen guiScreen;

    private List<QuickCraft> quickCrafts = new ArrayList<>();
    private Map<QuickCraft, Range> craftButtons;

    public QuickCraftListRow(GuiScreen guiScreen) {
        this.guiScreen = guiScreen;
    }

    public void add(QuickCraft craft) {
        this.quickCrafts.add(craft);
    }

    public void render(int x, int y, int height, int mouseX, int mouseY) {
        FontRenderer renderer = Minecraft.getMinecraft().fontRendererObj;
        int size = quickCrafts.size();
        int space = x / size;
        int index = 0;

        craftButtons = new HashMap<>();

        for (QuickCraft craft : quickCrafts) {
            String name = WordUtils.capitalizeFully(craft.name(), new char[]{'_'}).replace("_", " ");
            int stringWidth = renderer.getStringWidth(name);
            int startX = (space * index) + ((space - stringWidth) / 2);

            craftButtons.put(craft, new Range(startX, y, startX + stringWidth, y + height));

            renderer.drawString(name, startX, y + 4, getColor(craft, mouseX, mouseY));

            Minecraft minecraft = Minecraft.getMinecraft();
            minecraft.getRenderItem().renderItemAndEffectIntoGUI(
                    craft.getItem(), startX + stringWidth + 2, y);


            index++;
        }
    }

    private int getColor(QuickCraft craft, int mouseX, int mouseY) {
        int favoriteColor = QuickCraftUtils.isFavorite(craft) ? 0xFFFF00 : 0xFFFFFF;
        QuickCraft hoveringCraft = getMouseCraft(mouseX, mouseY);

        boolean isHovering = (hoveringCraft != null && hoveringCraft.name().equals(craft.name()));

        return isHovering ? 0x3D85C6 : favoriteColor;
    }

    public void onClick(int mouseX, int mouseY) {
        QuickCraft quickCraft = getMouseCraft(mouseX, mouseY);


        if (quickCraft == null)
            return;

        if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT))
            QuickCraftUtils.toggleFavorite(quickCraft);
        else
            QuickCraftExecutor.execute(quickCraft);

        McUtil.getPlayer().playSound("random.click", 0.3F, 1);
    }

    public QuickCraft getMouseCraft(int mouseX, int mouseY) {

        for (Map.Entry<QuickCraft, Range> entry : craftButtons.entrySet()) {
            if (entry.getValue().isInRange(mouseX, mouseY)) {
                return entry.getKey();
            }
        }

        return null;
    }
}
