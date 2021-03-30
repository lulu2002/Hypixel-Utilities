package me.lulu.hypixelutilities.command

import net.minecraft.command.CommandBase
import net.minecraft.command.CommandException
import net.minecraft.command.ICommandSender
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.util.BlockPos

class CommandAdapter(private val command: Command) : CommandBase() {
    override fun getCommandName(): String {
        return command.label
    }

    override fun getCommandUsage(iCommandSender: ICommandSender): String {
        return command.description
    }

    @Throws(CommandException::class)
    override fun processCommand(iCommandSender: ICommandSender, strings: Array<String>) {
        if (iCommandSender is EntityPlayer) command.onCommand(iCommandSender, strings)
    }

    override fun addTabCompletionOptions(
        sender: ICommandSender,
        args: Array<String>,
        blockPos: BlockPos
    ): List<String> {
        return command.onTabComplete(sender, args)!!
    }

    override fun getRequiredPermissionLevel(): Int {
        return -1
    }

    override fun canCommandSenderUseCommand(p_canCommandSenderUseCommand_1_: ICommandSender): Boolean {
        return true
    }
}
