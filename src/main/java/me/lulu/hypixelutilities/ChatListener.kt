package me.lulu.hypixelutilities

import me.lulu.hypixelutilities.util.clientPlayer
import net.minecraft.util.ChatComponentText
import net.minecraftforge.event.CommandEvent
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent
import java.lang.String

class ChatListener {
    @SubscribeEvent
    fun onChat(e: CommandEvent) {
        clientPlayer.addChatMessage(ChatComponentText(e.command.commandName + " " + String.join(" ", *e.parameters)))
    }
}
