package me.lulu.hypixelutilities.items

import me.lulu.hypixelutilities.resource.ResourceGroup
import me.lulu.hypixelutilities.resource.ResourceHud
import me.lulu.hypixelutilities.resource.ResourceSingle
import net.minecraft.init.Blocks
import net.minecraft.init.Items
import net.minecraft.item.ItemStack

class AndruilHud : ResourceHud(
    ResourceSingle("烈焰桿", ItemStack(Items.blaze_rod, 1)),
    ResourceGroup(
        "鐵",
        ResourceSingle("鐵錠", ItemStack(Items.iron_ingot, 18)),
        ResourceSingle("鐵磚", ItemStack(Blocks.iron_block, 2))
    ),
    ResourceSingle("羽毛", ItemStack(Items.feather, 6))
)
