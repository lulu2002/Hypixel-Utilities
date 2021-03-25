package me.lulu.hypixelutilities;

import me.lulu.hypixelutilities.util.McUtil;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.event.CommandEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ChatListener {

    @SubscribeEvent
    public void onChat(CommandEvent e) {
        McUtil.getPlayer().addChatMessage(new ChatComponentText(e.command.getCommandName() + " " + String.join(" ", e.parameters)));
    }

}
