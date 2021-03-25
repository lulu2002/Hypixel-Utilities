package me.lulu.hypixelutilities.craft;

import me.lulu.hypixelutilities.util.McUtil;
import net.minecraft.client.entity.EntityPlayerSP;

public class QuickCraftExecutor {

    public static void execute(QuickCraft craft) {
        EntityPlayerSP player = McUtil.getPlayer();
        player.sendChatMessage("/internal_autocraftitem " + craft.getNameInHypixel());
    }

}
