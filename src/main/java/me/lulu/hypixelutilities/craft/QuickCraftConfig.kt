package me.lulu.hypixelutilities.craft

import net.minecraftforge.common.config.Configuration
import net.minecraftforge.common.config.Property
import java.io.File

class QuickCraftConfig {
    private val config: Configuration
    private lateinit var quickCrafts: ArrayList<String>


    init {
        config = Configuration(File("config/hypixel-utilities.cfg"))
        config.load()
        load()
    }

    private fun load() {
        quickCrafts = ArrayList()
        quickCrafts.addAll(getQuickCrafts().stringList)
    }

    private fun save() {
        getQuickCrafts().set(quickCrafts.toTypedArray())
        config.save()
    }

    fun addQuickCraft(quickCraft: QuickCraft) {
        quickCrafts.add(quickCraft.name)
        save()
    }

    fun isFavorite(quickCraft: QuickCraft): Boolean {
        return quickCrafts.contains(quickCraft.name)
    }

    fun removeQuickCraft(quickCraft: QuickCraft) {
        quickCrafts.remove(quickCraft.name)
        save()
    }

    private fun getQuickCrafts(): Property {
        return config[Configuration.CATEGORY_GENERAL, "Quick_Crafts", arrayOfNulls(0), "儲存優先顯示的快速合成"]
    }
}
