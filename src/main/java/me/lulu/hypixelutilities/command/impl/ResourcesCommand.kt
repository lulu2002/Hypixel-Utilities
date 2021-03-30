package me.lulu.hypixelutilities.command.impl

import me.lulu.hypixelutilities.command.AbstractCommand
import me.lulu.hypixelutilities.hud.Hud
import me.lulu.hypixelutilities.hud.HudManager
import me.lulu.hypixelutilities.items.AndruilHud
import me.lulu.hypixelutilities.items.DragonSwordHud
import me.lulu.hypixelutilities.util.clientPlayer
import net.minecraft.command.CommandBase.getPlayer
import net.minecraft.entity.player.EntityPlayer

class ResourcesCommand : AbstractCommand("resources", "顯示資源列表") {
    override fun onCommand(sender: EntityPlayer?, args: Array<String>) {
        if (args.size < 1) return
        val item = args[0].toLowerCase()
        val hud: Hud
        HudManager.clearHuds()
        hud = when (item) {
            "dragonsword", "ds" -> DragonSwordHud()
            "andruil", "ad" -> AndruilHud()
            else -> {
                clientPlayer.sendChatMessage("null")
                return
            }
        }



        HudManager.addHud(hud)
    }
}
