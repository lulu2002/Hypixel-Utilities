package me.lulu.hypixelutilities.util;

import lombok.experimental.UtilityClass;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;

@UtilityClass
public class McUtil {

    public EntityPlayerSP getPlayer() {
        return Minecraft.getMinecraft().thePlayer;
    }
}
