package me.lulu.hypixelutilities.resource

import net.minecraft.item.ItemStack

interface Resource {
    fun hasEnough(): Boolean
    val name: String
    val require: List<ItemStack>
}
