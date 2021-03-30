package me.lulu.hypixelutilities.resource

import com.google.common.collect.Lists
import net.minecraft.item.ItemStack
import java.util.*

class ResourceGroup(override val name: String, vararg resources: Resource?) : Resource {
    private val resources: List<Resource>
    override fun hasEnough(): Boolean {
        for (resource in resources) {
            if (resource.hasEnough()) return true
        }
        return false
    }

    override val require: List<ItemStack>
        get() {
            val all: MutableList<ItemStack> = ArrayList()
            for (resource in resources) {
                all.addAll(resource.require)
            }
            return all
        }

    init {
        this.resources = Lists.newArrayList<Resource>(*resources)
    }
}
