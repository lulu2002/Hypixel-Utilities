package me.lulu.hypixelutilities.command;

import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;

import java.util.List;

public interface Command {

    void onCommand(EntityPlayer sender, String[] args);

    String getLabel();

    String getDescription();

    List<String> onTabComplete(ICommandSender sender, String[] args);
}
