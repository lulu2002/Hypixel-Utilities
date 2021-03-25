package me.lulu.hypixelutilities;

import me.lulu.hypixelutilities.command.CommandHandler;
import me.lulu.hypixelutilities.command.impl.CraftCommand;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.EventBus;
import org.lwjgl.input.Keyboard;

@Mod(modid = HypixelUtilities.MODID, version = HypixelUtilities.VERSION)
public class HypixelUtilities {
    public static final String MODID = "Hypixel Utilities";
    public static final String VERSION = "1.0";

    public static final KeyBinding CRAFT_KEY = new KeyBinding("開啟快速合成界面", Keyboard.KEY_C, "HypixelUtilities");

    @EventHandler
    public void init(FMLInitializationEvent event) {
        registerEvents();
        registerCommands();
        registerKeyBinds();
    }

    private void registerKeyBinds() {
        ClientRegistry.registerKeyBinding(CRAFT_KEY);
    }

    private void registerEvents() {
        EventBus bus = MinecraftForge.EVENT_BUS;

        bus.register(new ChatListener());
        bus.register(new TestEvents());
//        bus.register(new HudListener());
    }

    private void registerCommands() {
        CommandHandler handler = new CommandHandler();

//        handler.registerCommand(new ResourcesCommand());
        handler.registerCommand(new CraftCommand());
    }
}
