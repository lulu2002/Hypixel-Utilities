package me.lulu.hypixelutilities.resource;

import com.google.common.collect.Lists;
import me.lulu.hypixelutilities.util.McUtil;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;

import java.util.List;

public class ResourceSingle implements Resource {
    private InventoryPlayer inventory = McUtil.getPlayer().inventory;

    private ItemStack item;
    private String name;

    public ResourceSingle(String name, ItemStack item) {
        this.name = name;
        this.item = item;
    }

    @Override
    public boolean hasEnough() {
        return getAmountToRequire(item) <= 0;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public List<ItemStack> getRequire() {
        return Lists.newArrayList(new ItemStack(item.getItem(), getAmountToRequire(item)));
    }

    private int getAmountToRequire(ItemStack item) {
        return item.stackSize - getPlayerAmount(item);
    }

    private int getPlayerAmount(ItemStack item) {
        int total = 0;

        for (ItemStack invItem : inventory.mainInventory) {
            if (item.isItemEqual(invItem))
                total += invItem.stackSize;
        }

        return total;
    }
}
