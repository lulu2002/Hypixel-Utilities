package me.lulu.hypixelutilities.items;

import me.lulu.hypixelutilities.resource.ResourceHud;
import me.lulu.hypixelutilities.resource.ResourceSingle;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class DragonSwordHud extends ResourceHud {

    public DragonSwordHud() {
        super(
                new ResourceSingle("鑽劍", new ItemStack(Items.diamond_sword)),
                new ResourceSingle("烈焰粉", new ItemStack(Items.blaze_powder, 2)),
                new ResourceSingle("黑耀石", new ItemStack(Blocks.obsidian, 2))
        );
    }
}
