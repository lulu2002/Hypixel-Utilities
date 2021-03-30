package me.lulu.hypixelutilities.resource

import com.google.common.collect.Lists
import me.lulu.hypixelutilities.hud.ListStringHud
import net.minecraft.init.Blocks
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.util.EnumChatFormatting
import java.util.*
import java.util.stream.Collectors

open class ResourceHud(vararg resource: Resource?) : ListStringHud(5, 5) {
    private val resource: List<Resource>
    override val list: List<String?>
        protected get() {
            val list: MutableList<String?> = ArrayList()
            for (resource in resource) {
                var str = getColor(resource).toString() + resource.name
                if (!resource.hasEnough()) str = str + "(缺 " + requireStr(resource.require) + ")"
                list.add(str)
            }
            return list
        }

    private fun requireStr(require: List<ItemStack>): String {
        return require!!.stream()
            .filter { itemStack: ItemStack? -> itemStack!!.item !== Item.getItemFromBlock(Blocks.air) }
            .filter { itemStack: ItemStack? -> itemStack!!.stackSize > 0 }
            .map { itemStack: ItemStack? -> itemStack!!.stackSize.toString() + "x " + itemStack.displayName }
            .collect(Collectors.joining(" 或 "))
    }

    private fun getColor(resource: Resource): EnumChatFormatting {
        return if (resource.hasEnough()) EnumChatFormatting.GREEN else EnumChatFormatting.GRAY
    }

    init {
        this.resource = Lists.newArrayList<Resource>(*resource)
    }
}
