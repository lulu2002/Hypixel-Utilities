package me.lulu.hypixelutilities.resource

import com.google.common.collect.Lists
import me.lulu.hypixelutilities.util.clientPlayer
import net.minecraft.entity.player.InventoryPlayer
import net.minecraft.item.ItemStack

class ResourceSingle(override val name: String, private val item: ItemStack) : Resource {
    private val inventory: InventoryPlayer = clientPlayer.inventory
    override fun hasEnough(): Boolean {
        return getAmountToRequire(item) <= 0
    }

    override val require: List<ItemStack>
        get() = Lists.newArrayList(ItemStack(item.item, getAmountToRequire(item)))

    private fun getAmountToRequire(item: ItemStack): Int {
        return item.stackSize - getPlayerAmount(item)
    }

    private fun getPlayerAmount(item: ItemStack): Int {

        var total = 0
        for (invItem in inventory.mainInventory) {
            if (item.isItemEqual(invItem)) total += invItem.stackSize
        }
        return total
    }
}
