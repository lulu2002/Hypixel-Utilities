package me.lulu.hypixelutilities.hud

import com.google.common.collect.Lists
import lombok.experimental.UtilityClass
import java.util.*

object HudManager {
    private val huds: MutableList<Hud> = ArrayList()

    fun addHud(hud: Hud) {
        huds.add(hud)
    }

    fun clearHuds() {
        huds.clear()
    }

    fun removeHud(hud: Hud) {
        huds.remove(hud)
    }

    fun getHuds(): List<Hud> {
        return Lists.newArrayList(huds)
    }
}
