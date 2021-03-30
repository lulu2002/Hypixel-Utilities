package me.lulu.hypixelutilities.craft

import net.minecraft.client.gui.GuiButton
import java.util.stream.Collectors

abstract class ListButtons<E>(
    private val buttonWidth: Int,
    private val buttonHeight: Int,
    private val guiWidth: Int,
    private val guiHeight: Int,
    private val buttonsPerRow: Int
) {
    fun generateButtons(eList: Collection<E>): List<GuiButton> {
        val drawer: ButtonDrawer =
            ButtonDrawerCenterAlign(buttonWidth, buttonHeight, buttonsPerRow, guiWidth, guiHeight)
        return eList.stream()
            .map { e: E ->
                val button = toButton(e)
                drawer.draw(button)
                button
            }
            .collect(Collectors.toList())
    }

    protected abstract fun toButton(e: E): GuiButton
}
