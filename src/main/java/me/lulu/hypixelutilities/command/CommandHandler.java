package me.lulu.hypixelutilities.command;

import net.minecraftforge.client.ClientCommandHandler;

public class CommandHandler {

    public CommandHandler() {

    }

    public void registerCommand(Command command) {
        ClientCommandHandler handler = ClientCommandHandler.instance;
        handler.registerCommand(new CommandAdapter(command));
    }

}
