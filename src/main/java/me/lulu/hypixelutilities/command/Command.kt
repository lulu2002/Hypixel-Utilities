package me.lulu.hypixelutilities.command

import net.minecraft.command.ICommandSender
import net.minecraft.entity.player.EntityPlayer

interface Command {
    fun onCommand(sender: EntityPlayer?, args: Array<String>)
    val label: String
    val description: String
    fun onTabComplete(sender: ICommandSender?, args: Array<String>): List<String>?
}
