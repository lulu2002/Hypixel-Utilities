package me.lulu.hypixelutilities

import me.lulu.hypixelutilities.craft.gui.QuickCraftGui
import me.lulu.hypixelutilities.util.mc
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent
import net.minecraftforge.fml.common.gameevent.InputEvent.KeyInputEvent

class TestEvents {
    @SubscribeEvent
    fun onKeyInput(e: KeyInputEvent?) {
        if (HypixelUtilities.CRAFT_KEY.isPressed())
            mc.displayGuiScreen(QuickCraftGui())
    }
}
