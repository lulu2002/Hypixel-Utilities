package me.lulu.hypixelutilities.command

import net.minecraftforge.client.ClientCommandHandler

class CommandHandler {
    fun registerCommand(command: Command) {
        val handler = ClientCommandHandler.instance
        handler.registerCommand(CommandAdapter(command))
    }
}
