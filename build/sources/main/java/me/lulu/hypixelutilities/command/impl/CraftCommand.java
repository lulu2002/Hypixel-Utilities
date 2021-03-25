package me.lulu.hypixelutilities.command.impl;

import me.lulu.hypixelutilities.command.AbstractCommand;
import me.lulu.hypixelutilities.craft.QuickCraft;
import me.lulu.hypixelutilities.craft.QuickCraftExecutor;
import me.lulu.hypixelutilities.craft.gui.QuickCraftGui;
import net.minecraft.client.Minecraft;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.Timer;
import net.minecraft.util.Util;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class CraftCommand extends AbstractCommand {

    public CraftCommand() {
        super("c", "craft uhc item");
    }

    @Override
    public void onCommand(EntityPlayer sender, String[] args) {

        if (args.length <= 0) {
            new Thread(() -> {
                try {
                    Thread.sleep(50L);
                    Minecraft.getMinecraft().displayGuiScreen(new QuickCraftGui());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
            return;
        }

        QuickCraft craft = QuickCraft.valueOf(args[0].toUpperCase());
        QuickCraftExecutor.execute(craft);
    }

    @Override
    public List<String> onTabComplete(ICommandSender sender, String[] args) {
        if (args.length <= 0)
            return null;

        String s = args[0];

        return getCompleteOptions().stream()
                .filter(craft -> craft.startsWith(s.toUpperCase()))
                .sorted()
                .collect(Collectors.toList());
    }

    private Collection<String> getCompleteOptions() {
        return Arrays.stream(QuickCraft.values())
                .map(Enum::name)
                .collect(Collectors.toSet());
    }
}
