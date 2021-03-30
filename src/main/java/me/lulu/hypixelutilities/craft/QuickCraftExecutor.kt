package me.lulu.hypixelutilities.craft

import me.lulu.hypixelutilities.util.clientPlayer

object QuickCraftExecutor {

    fun execute(craft: QuickCraft) {
        clientPlayer.sendChatMessage("/internal_autocraftitem " + craft.nameInHypixel)
    }

}
