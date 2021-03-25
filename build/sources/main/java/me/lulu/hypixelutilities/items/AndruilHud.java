package me.lulu.hypixelutilities.items;

import me.lulu.hypixelutilities.resource.ResourceGroup;
import me.lulu.hypixelutilities.resource.ResourceHud;
import me.lulu.hypixelutilities.resource.ResourceSingle;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class AndruilHud extends ResourceHud {

    public AndruilHud() {
        super(
                new ResourceSingle("烈焰桿", new ItemStack(Items.blaze_rod, 1)),
                new ResourceGroup("鐵",
                        new ResourceSingle("鐵錠", new ItemStack(Items.iron_ingot, 18)),
                        new ResourceSingle("鐵磚", new ItemStack(Blocks.iron_block, 2))
                ),
                new ResourceSingle("羽毛", new ItemStack(Items.feather, 6))
        );
    }
}
