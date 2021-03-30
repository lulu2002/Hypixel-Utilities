package me.lulu.hypixelutilities.craft.gui

import me.lulu.hypixelutilities.craft.ListButtons
import me.lulu.hypixelutilities.craft.QuickCraft
import net.minecraft.client.gui.GuiButton
import net.minecraft.client.gui.GuiScreen
import net.minecraftforge.fml.client.GuiScrollingList
import java.io.IOException

class QuickCraftGui : GuiScreen() {
    private val buttons: List<GuiButton>? = null
    private val listButtons: ListButtons<QuickCraft>? = null
    private var list: GuiScrollingList? = null
    override fun initGui() {
        super.initGui()
        initList()
    }

    private fun initList() {
        list = QuickCraftGuiList(mc, this, width, height)
    }

    @Throws(IOException::class)
    override fun actionPerformed(button: GuiButton) {
    }

    override fun drawScreen(mouseX: Int, mouseY: Int, partialTicks: Float) {
        list!!.drawScreen(mouseX, mouseY, partialTicks)
        super.drawScreen(mouseX, mouseY, partialTicks)
    }
}
