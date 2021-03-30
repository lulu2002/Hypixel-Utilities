package me.lulu.hypixelutilities.hud

import me.lulu.hypixelutilities.util.fontRenderer

abstract class ListStringHud @JvmOverloads constructor(
    private val startX: Int,
    private val startY: Int,
    private val lineHeight: Int = 9
) : SimpleHud() {
    override fun render() {
        var y = startY
        for (s in list) {
            fontRenderer.drawStringWithShadow(s, startX.toFloat(), y.toFloat(), 0)
            y += lineHeight
        }
    }

    protected abstract val list: List<String?>

}
