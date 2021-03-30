package me.lulu.hypixelutilities

import club.sk1er.mods.core.universal.UniversalMinecraft
import me.lulu.hypixelutilities.craft.gui.TestGui
import net.minecraftforge.client.event.GuiScreenEvent
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent
import net.minecraftforge.fml.common.gameevent.InputEvent.KeyInputEvent
import org.lwjgl.input.Keyboard

class TestEvents {
    @SubscribeEvent
    fun onKeyInput(e: KeyInputEvent) {
        if (HypixelUtilities.CRAFT_KEY.isPressed) {
            UniversalMinecraft.getMinecraft().displayGuiScreen(TestGui())
        }
    }

    @SubscribeEvent
    fun onKeyboardInput(e: GuiScreenEvent.KeyboardInputEvent) {
        if (Keyboard.isKeyDown(HypixelUtilities.CRAFT_KEY.keyCode)) {
            UniversalMinecraft.getMinecraft().displayGuiScreen(TestGui())
        }
    }
}
