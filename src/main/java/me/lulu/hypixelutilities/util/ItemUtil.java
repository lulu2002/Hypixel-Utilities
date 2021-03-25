package me.lulu.hypixelutilities.util;

import lombok.experimental.UtilityClass;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;

@UtilityClass
public class ItemUtil {

    public void addLore(ItemStack itemStack, String... lore) {
        NBTTagCompound nbt = itemStack.getTagCompound();
        if (nbt == null) nbt = new NBTTagCompound();

        NBTTagList loreTag = new NBTTagList();

        for (String s : lore)
            loreTag.appendTag(new NBTTagString(s));

        NBTTagCompound displayTag = nbt.getCompoundTag("display");

        if (displayTag == null)
            displayTag = new NBTTagCompound();

        displayTag.setTag("Lore", loreTag);

        nbt.setTag("display", displayTag);

        itemStack.setTagCompound(nbt);
    }

}
