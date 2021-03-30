package me.lulu.hypixelutilities.command

import net.minecraft.command.ICommandSender
import net.minecraft.entity.player.EntityPlayer

abstract class AbstractCommand(override val label: String, override val description: String) : Command {
    abstract override fun onCommand(sender: EntityPlayer?, args: Array<String>)
    override fun onTabComplete(sender: ICommandSender?, args: Array<String>): List<String>? {
        return null
    }
}
