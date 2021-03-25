package me.lulu.hypixelutilities;

import me.lulu.hypixelutilities.craft.gui.QuickCraftGui;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;


public class TestEvents {

    @SubscribeEvent
    public void onKeyInput(InputEvent.KeyInputEvent e) {
        if (HypixelUtilities.CRAFT_KEY.isPressed())
            Minecraft.getMinecraft().displayGuiScreen(new QuickCraftGui());
    }
}
