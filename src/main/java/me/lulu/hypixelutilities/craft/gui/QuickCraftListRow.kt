package me.lulu.hypixelutilities.craft.gui

import me.lulu.hypixelutilities.craft.QuickCraft
import me.lulu.hypixelutilities.craft.QuickCraftExecutor
import me.lulu.hypixelutilities.craft.isFavorite
import me.lulu.hypixelutilities.craft.toggleFavorite
import me.lulu.hypixelutilities.util.clientPlayer
import me.lulu.hypixelutilities.util.mc
import net.minecraft.client.gui.GuiScreen
import net.minecraft.client.renderer.RenderHelper
import org.apache.commons.lang3.text.WordUtils
import org.lwjgl.input.Keyboard
import java.util.*

class QuickCraftListRow(private val guiScreen: GuiScreen) {
    private val quickCrafts: MutableList<QuickCraft> = ArrayList()
    private lateinit var craftButtons: MutableMap<QuickCraft, Range>
    fun add(craft: QuickCraft) {
        quickCrafts.add(craft)
    }

    fun render(x: Int, y: Int, height: Int, mouseX: Int, mouseY: Int) {
        val renderer = mc.fontRendererObj
        val size = quickCrafts.size
        val space = x / size
        var index = 0
        craftButtons = HashMap()
        for (craft in quickCrafts) {
            val name = WordUtils.capitalizeFully(craft.name, *charArrayOf('_')).replace("_", " ")
            val stringWidth = renderer.getStringWidth(name)
            val startX = space * index + (space - stringWidth) / 2
            craftButtons[craft] = Range(startX, y, startX + stringWidth, y + height)
            renderer.drawString(name, startX, y + 4, getColor(craft, mouseX, mouseY))
            drawItemTexture(y, craft, stringWidth, startX)
            index++
        }
    }

    private fun drawItemTexture(y: Int, craft: QuickCraft, stringWidth: Int, startX: Int) {
        val item = craft.item

        //prevent dark block
        RenderHelper.disableStandardItemLighting()
        RenderHelper.enableGUIStandardItemLighting()
        mc.renderItem.renderItemAndEffectIntoGUI(
            item, startX + stringWidth + 2, y
        )
        RenderHelper.enableGUIStandardItemLighting()
    }

    private fun getColor(craft: QuickCraft, mouseX: Int, mouseY: Int): Int {
        val favoriteColor = if (craft.isFavorite()) 0xFFFF00 else 0xFFFFFF
        val hoveringCraft = getMouseCraft(mouseX, mouseY)
        val isHovering = hoveringCraft != null && hoveringCraft.name == craft.name
        return if (isHovering) 0x3D85C6 else favoriteColor
    }

    fun onClick(mouseX: Int, mouseY: Int) {
        val quickCraft = getMouseCraft(mouseX, mouseY) ?: return
        if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)) quickCraft.toggleFavorite() else QuickCraftExecutor.execute(
            quickCraft
        )
        clientPlayer.playSound("random.click", 0.3f, 1f)
    }

    fun getMouseCraft(mouseX: Int, mouseY: Int): QuickCraft? {
        for ((key, value) in craftButtons!!) {
            if (value.isInRange(mouseX, mouseY)) {
                return key
            }
        }
        return null
    }
}
