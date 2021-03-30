package me.lulu.hypixelutilities.craft.gui

class Range(private val startX: Int, private val startY: Int, private val endX: Int, private val endY: Int) {
    fun isInRange(x: Int, y: Int): Boolean {
        return x in startX until endX && y in startY until endY
    }
}
