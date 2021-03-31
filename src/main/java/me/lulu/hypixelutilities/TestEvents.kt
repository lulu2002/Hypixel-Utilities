package me.lulu.hypixelutilities

import me.lulu.hypixelutilities.craft.gui.QuickCraftGuiNew
import me.lulu.hypixelutilities.util.mc
import net.minecraft.client.gui.inventory.GuiContainer
import net.minecraftforge.client.event.GuiScreenEvent
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent
import net.minecraftforge.fml.common.gameevent.InputEvent.KeyInputEvent
import org.lwjgl.input.Keyboard

class TestEvents {
    @SubscribeEvent
    fun onKeyInput(e: KeyInputEvent) {
        if (HypixelUtilities.CRAFT_KEY.isPressed) {
            mc.displayGuiScreen(QuickCraftGuiNew())
        }
    }


    @SubscribeEvent
    fun onKeyboardInput(e: GuiScreenEvent.KeyboardInputEvent) {
        if (Keyboard.isKeyDown(HypixelUtilities.CRAFT_KEY.keyCode)
            && (mc.currentScreen is GuiContainer || mc.currentScreen is QuickCraftGuiNew)) {
            checkOpen()
        }
    }

    private fun checkOpen() {
        val gui = QuickCraftGuiNew()

        if (mc.currentScreen is QuickCraftGuiNew)
            mc.currentScreen = null
        else
            mc.displayGuiScreen(gui)
    }
}
