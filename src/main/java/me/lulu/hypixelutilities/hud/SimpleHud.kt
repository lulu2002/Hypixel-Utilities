package me.lulu.hypixelutilities.hud

import lombok.AccessLevel
import lombok.Getter
import me.lulu.hypixelutilities.util.mc

abstract class SimpleHud : Hud {
    @Getter(AccessLevel.MODULE)
    private val fontRenderer = mc.fontRendererObj
}
