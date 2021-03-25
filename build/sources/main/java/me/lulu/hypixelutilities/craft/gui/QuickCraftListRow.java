package me.lulu.hypixelutilities.craft.gui;

import me.lulu.hypixelutilities.craft.QuickCraft;
import me.lulu.hypixelutilities.craft.QuickCraftExecutor;
import me.lulu.hypixelutilities.util.McUtil;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.SoundList;
import net.minecraft.client.audio.SoundRegistry;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraftforge.client.event.sound.SoundEvent;
import org.apache.commons.lang3.text.WordUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuickCraftListRow extends Gui {

    private List<QuickCraft> quickCrafts = new ArrayList<>();
    private Map<QuickCraft, Range> craftButtons;

    public void add(QuickCraft craft) {
        this.quickCrafts.add(craft);
    }

    public void render(int width, int height, int barTop) {
        FontRenderer renderer = Minecraft.getMinecraft().fontRendererObj;
        int size = quickCrafts.size();
        int space = width / size;
        int index = 0;

        craftButtons = new HashMap<>();

        for (QuickCraft craft : quickCrafts) {
            String name = WordUtils.capitalizeFully(craft.name(), new char[]{'_'}).replace("_", " ");
            int stringWidth = renderer.getStringWidth(name);
            int startX = (space * index) + ((space - stringWidth) / 2);

            int i = renderer.drawString(name, startX, height, 0xFFFFFF);

            craftButtons.put(craft, new Range(startX, startX + i));

            index++;
        }
    }

    public void onClick(int mouseX, int mouseY) {
        for (Map.Entry<QuickCraft, Range> entry : craftButtons.entrySet()) {
            if (entry.getValue().isInRange(mouseX)) {
                QuickCraftExecutor.execute(entry.getKey());
            }
        }
    }
}
