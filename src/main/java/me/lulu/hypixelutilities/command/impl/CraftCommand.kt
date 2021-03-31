package me.lulu.hypixelutilities.command.impl

import me.lulu.hypixelutilities.command.AbstractCommand
import me.lulu.hypixelutilities.craft.QuickCraft
import me.lulu.hypixelutilities.craft.QuickCraftExecutor
import me.lulu.hypixelutilities.craft.gui.QuickCraftGuiNew
import me.lulu.hypixelutilities.util.mc
import net.minecraft.command.ICommandSender
import net.minecraft.entity.player.EntityPlayer
import java.util.*
import java.util.stream.Collectors

class CraftCommand : AbstractCommand("c", "craft uhc item") {
    override fun onCommand(sender: EntityPlayer?, args: Array<String>) {
        if (args.size <= 0) {
            mc.currentScreen = null
            mc.displayGuiScreen(QuickCraftGuiNew())
            return
        }
        val craft = QuickCraft.valueOf(args[0].toUpperCase())
        QuickCraftExecutor.execute(craft)
    }

    override fun onTabComplete(sender: ICommandSender?, args: Array<String>): List<String>? {
        if (args.size <= 0) return null
        val s = args[0]
        return completeOptions.stream()
            .filter { craft: String -> craft.startsWith(s.toUpperCase()) }
            .sorted()
            .collect(Collectors.toList())
    }

    private val completeOptions: Collection<String>
        private get() = Arrays.stream(QuickCraft.values())
            .map { obj: QuickCraft -> obj.name }
            .collect(Collectors.toSet())
}
