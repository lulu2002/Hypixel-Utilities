package me.lulu.hypixelutilities.resource;

import net.minecraft.item.ItemStack;

import java.util.List;

public interface Resource {

    boolean hasEnough();

    String getName();

    List<ItemStack> getRequire();

}
