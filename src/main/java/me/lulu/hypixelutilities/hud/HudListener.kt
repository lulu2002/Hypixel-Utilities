package me.lulu.hypixelutilities.hud

import net.minecraftforge.client.event.RenderGameOverlayEvent
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent
import java.util.function.Consumer

class HudListener {
    @SubscribeEvent
    fun onRenderGameOverlay(e: RenderGameOverlayEvent) {
        if (e.type == RenderGameOverlayEvent.ElementType.TEXT) {
            HudManager.getHuds().forEach(Consumer { obj: Hud -> obj.render() })
        }
    }
}
