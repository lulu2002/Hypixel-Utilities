package me.lulu.hypixelutilities.command;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;

import java.util.List;

public class CommandAdapter extends CommandBase {

    private Command command;

    public CommandAdapter(Command command) {
        this.command = command;
    }

    @Override
    public String getCommandName() {
        return command.getLabel();
    }


    @Override
    public String getCommandUsage(ICommandSender iCommandSender) {
        return command.getDescription();
    }

    @Override
    public void processCommand(ICommandSender iCommandSender, String[] strings) throws CommandException {
        if (iCommandSender instanceof EntityPlayer)
            command.onCommand(( EntityPlayer ) iCommandSender, strings);
    }

    @Override
    public List<String> addTabCompletionOptions(ICommandSender sender, String[] args, BlockPos blockPos) {
        return command.onTabComplete(sender, args);
    }

    @Override
    public int getRequiredPermissionLevel() {
        return -1;
    }

    @Override
    public boolean canCommandSenderUseCommand(ICommandSender p_canCommandSenderUseCommand_1_) {
        return true;
    }
}
