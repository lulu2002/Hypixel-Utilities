package me.lulu.hypixelutilities.craft

import me.lulu.hypixelutilities.util.mc
import net.minecraft.client.gui.GuiButton

class ButtonDrawerCenterAlign(
    private val buttonWidth: Int,
    private val buttonHeight: Int,
    private val buttonsPerRow: Int,
    private val guiWidth: Int,
    private val guiHeight: Int
) : ButtonDrawer {
    private val screenWidth = mc.displayWidth
    private val buttonSpace: Int
    private val xToCenter: Int
    private val yMargin = 10
    private var drawingRowSlot = 0
    private var currentY = yMargin
    override fun draw(button: GuiButton) {
        if (drawingRowSlot >= buttonsPerRow) nextLine()
        button.height = buttonHeight
        button.width = buttonWidth
        button.xPosition = drawingRowSlot * buttonSpace + xToCenter
        button.yPosition = currentY
        drawingRowSlot++
    }

    private fun nextLine() {
        drawingRowSlot = 0
        currentY += yMargin + buttonHeight
    }

    init {
        buttonSpace = guiWidth / buttonsPerRow
        xToCenter = (buttonSpace - buttonWidth) / 2
    }
}
