package me.lulu.hypixelutilities.hud;

import lombok.AccessLevel;
import lombok.Getter;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;

public abstract class SimpleHud implements Hud {

    @Getter(AccessLevel.MODULE)
    private FontRenderer fontRenderer = Minecraft.getMinecraft().fontRendererObj;

}
