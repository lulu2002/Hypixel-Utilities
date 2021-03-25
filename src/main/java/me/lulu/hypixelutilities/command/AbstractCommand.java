package me.lulu.hypixelutilities.command;

import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;

import java.util.List;

public abstract class AbstractCommand implements Command {

    private String label;
    private String description;

    public AbstractCommand(String label, String description) {
        this.label = label;
        this.description = description;
    }

    @Override
    public abstract void onCommand(EntityPlayer sender, String[] args);

    @Override
    public final String getLabel() {
        return label;
    }

    @Override
    public final String getDescription() {
        return description;
    }

    @Override
    public List<String> onTabComplete(ICommandSender sender, String[] args) {
        return null;
    }
}
