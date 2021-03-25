package me.lulu.hypixelutilities.command.impl;

import me.lulu.hypixelutilities.command.AbstractCommand;
import me.lulu.hypixelutilities.hud.Hud;
import me.lulu.hypixelutilities.hud.HudManager;
import me.lulu.hypixelutilities.items.AndruilHud;
import me.lulu.hypixelutilities.items.DragonSwordHud;
import me.lulu.hypixelutilities.util.McUtil;
import net.minecraft.entity.player.EntityPlayer;

public class ResourcesCommand extends AbstractCommand {

    public ResourcesCommand() {
        super("resources", "顯示資源列表");
    }

    @Override
    public void onCommand(EntityPlayer sender, String[] args) {
        if (args.length < 1)
            return;

        String item = args[0].toLowerCase();
        Hud hud;

        HudManager.clearHuds();

        switch (item) {
            case "dragonsword":
            case "ds":
                hud = new DragonSwordHud();
                break;
            case "andruil":
            case "ad":
                hud = new AndruilHud();
                break;
            default:
                McUtil.getPlayer().sendChatMessage("null");
                return;
        }

        HudManager.addHud(hud);
    }
}
