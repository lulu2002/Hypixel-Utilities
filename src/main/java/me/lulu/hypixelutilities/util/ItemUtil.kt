package me.lulu.hypixelutilities.util

import lombok.experimental.UtilityClass
import net.minecraft.item.ItemStack
import net.minecraft.nbt.NBTTagCompound
import net.minecraft.nbt.NBTTagList
import net.minecraft.nbt.NBTTagString


fun ItemStack.addLores(vararg lore: String): ItemStack {
    var nbt = this.tagCompound

    if (nbt == null)
        nbt = NBTTagCompound()

    val loreTag = NBTTagList()

    for (s in lore)
        loreTag.appendTag(NBTTagString(s))

    var displayTag = nbt.getCompoundTag("display")
    if (displayTag == null) displayTag = NBTTagCompound()
    displayTag.setTag("Lore", loreTag)
    nbt.setTag("display", displayTag)
    this.tagCompound = nbt

    return this
}
