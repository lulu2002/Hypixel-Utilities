package me.lulu.hypixelutilities.craft.gui

import me.lulu.hypixelutilities.craft.QuickCraft
import me.lulu.hypixelutilities.craft.isFavorite
import me.lulu.hypixelutilities.util.mc
import net.minecraft.client.Minecraft
import net.minecraft.client.gui.GuiButton
import net.minecraft.client.gui.GuiScreen
import net.minecraft.client.renderer.Tessellator
import net.minecraftforge.fml.client.GuiScrollingList
import java.util.*
import java.util.stream.Collectors

class QuickCraftGuiList(
    client: Minecraft?,
    val guiScreen: GuiScreen,
    width: Int,
    height: Int
) : GuiScrollingList(client, width, height, 0, height, 0, 24) {
    private lateinit var rows: Array<QuickCraftListRow?>

    private val quickCraftSorted: List<QuickCraft>
        private get() = Arrays.stream(QuickCraft.values())
            .sorted(Comparator.comparing { obj: QuickCraft -> obj.name })
            .sorted { o1: QuickCraft, o2: QuickCraft -> java.lang.Boolean.compare(o2.isFavorite(), o1.isFavorite()) }
            .collect(Collectors.toList())

    private fun initRows() {
        val crafts = quickCraftSorted
        rows = arrayOfNulls(getRowsSize(crafts.size))

        for (i in rows.indices) rows[i] = QuickCraftListRow(guiScreen)
        for (i in crafts.indices) {
            val craft = crafts[i]
            rows[i / ITEMS_PER_ROW]!!.add(craft)
        }
    }

    private fun getRowsSize(length: Int): Int {
        val hasMore = length % ITEMS_PER_ROW != 0
        var size = length / ITEMS_PER_ROW
        if (hasMore) size++
        return size
    }

    override fun getSize(): Int {
        return rows.size
    }

    override fun elementClicked(i: Int, b: Boolean) {
        rows[i]!!.onClick(mouseX, mouseY)
        initRows()
    }

    override fun isSelected(i: Int): Boolean {
        return false
    }

    override fun drawBackground() {}

    override fun drawSlot(i: Int, width: Int, height: Int, barTop: Int, tessellator: Tessellator) {
        rows[i]!!.render(width, height, slotHeight, mouseX, mouseY)
    }

    override fun drawScreen(mouseX: Int, mouseY: Int) {
        if (mc.displayWidth <= 600) ITEMS_PER_ROW =
            1 else if (mc.displayWidth <= 1000) ITEMS_PER_ROW = 2 else ITEMS_PER_ROW = 4
        super.drawScreen(mouseX, mouseY)
    }

    override fun actionPerformed(button: GuiButton) {
        super.actionPerformed(button)
    }

    companion object {
        private var ITEMS_PER_ROW = 4
    }

    init {
        initRows()
    }
}
