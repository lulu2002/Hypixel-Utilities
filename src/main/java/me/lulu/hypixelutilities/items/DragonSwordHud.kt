package me.lulu.hypixelutilities.items

import me.lulu.hypixelutilities.resource.ResourceHud
import me.lulu.hypixelutilities.resource.ResourceSingle
import net.minecraft.init.Blocks
import net.minecraft.init.Items
import net.minecraft.item.ItemStack

class DragonSwordHud : ResourceHud(
    ResourceSingle("鑽劍", ItemStack(Items.diamond_sword)),
    ResourceSingle("烈焰粉", ItemStack(Items.blaze_powder, 2)),
    ResourceSingle("黑耀石", ItemStack(Blocks.obsidian, 2))
)
