package me.lulu.hypixelutilities

import me.lulu.hypixelutilities.command.CommandHandler
import me.lulu.hypixelutilities.craft.QuickCraftConfig
import net.minecraft.client.settings.KeyBinding
import net.minecraftforge.common.MinecraftForge
import net.minecraftforge.fml.client.registry.ClientRegistry
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.event.FMLInitializationEvent
import org.lwjgl.input.Keyboard

@Mod(
    modid = HypixelUtilities.MODID,
    name = "Hypixel Utilities",
    modLanguageAdapter = "net.shadowfacts.forgelin.KotlinAdapter",
    version = HypixelUtilities.VERSION
)
class HypixelUtilities {
    @Mod.EventHandler
    fun init(event: FMLInitializationEvent) {
        registerEvents()
        registerCommands()
        registerKeyBinds()
    }

    private fun registerKeyBinds() {
        ClientRegistry.registerKeyBinding(CRAFT_KEY)
    }

    private fun registerEvents() {
        val bus = MinecraftForge.EVENT_BUS
        bus.register(ChatListener())
        bus.register(TestEvents())
        //        bus.register(new HudListener());
    }

    private fun registerCommands() {
        val handler = CommandHandler()

//        handler.registerCommand(new ResourcesCommand());
//        handler.registerCommand(CraftCommand())
    }

    companion object {
        const val MODID = "Hypixel Utilities"
        const val VERSION = "3.0"
        val CRAFT_KEY = KeyBinding("開啟快速合成界面", Keyboard.KEY_C, "HypixelUtilities")
        val QUICK_CRAFT_CONFIG = QuickCraftConfig()
    }
}
