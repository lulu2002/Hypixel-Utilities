package me.lulu.hypixelutilities.craft.gui

import club.sk1er.elementa.UIComponent
import club.sk1er.elementa.components.ScrollComponent
import club.sk1er.elementa.components.UIBlock
import club.sk1er.elementa.components.UITextInput
import club.sk1er.elementa.constraints.CenterConstraint
import club.sk1er.elementa.constraints.CramSiblingConstraint
import club.sk1er.elementa.constraints.RelativeConstraint
import club.sk1er.elementa.constraints.SiblingConstraint
import club.sk1er.elementa.dsl.asConstraint
import club.sk1er.elementa.dsl.childOf
import club.sk1er.elementa.dsl.constrain
import club.sk1er.elementa.dsl.pixels
import me.lulu.hypixelutilities.craft.QuickCraft
import me.lulu.hypixelutilities.craft.QuickCraftExecutor
import me.lulu.hypixelutilities.craft.isFavorite
import me.lulu.hypixelutilities.craft.toggleFavorite
import me.lulu.hypixelutilities.util.clientPlayer
import org.lwjgl.input.Keyboard
import java.awt.Color
import java.util.*


class QuickCraftGuiNew : WindowScreenTest() {

    private var mouseX = 0
    private var mouseY = 0
    private val items = mutableMapOf<QuickCraft, UIItem>()
    private val list: UIComponent

    override fun drawScreen(mouseX: Int, mouseY: Int, partialTicks: Float) {
        this.mouseX = mouseX
        this.mouseY = mouseY

//        items.forEach { t -> t.draw() }

        super.drawScreen(mouseX, mouseY, partialTicks)

        items.forEach { (q, t) ->
            try {
                if (t is UIItem && t.isHovered())
                    t.hovering(t)
            } catch (ex: Exception) {

            }
        }
    }

    init {

        list = ScrollComponent().constrain {
            x = 5.pixels()
            y = CenterConstraint()

            width = 150.pixels()
            height = 200.pixels()

        } childOf window

        val input = UITextInput("Search").constrain {
            x = 5.pixels()
            y = SiblingConstraint(alignOpposite = true)

            width = 60.pixels()
            height = 20.pixels()
        } childOf window

        input.onUpdate {
            val name = it

            items.forEach { quickCraft, uiItem ->
                if (quickCraft.name.startsWith(name, ignoreCase = true)) {
                    uiItem.unhide()
                    uiItem.parent.unhide()
                } else {
                    uiItem.hide()
                    uiItem.parent.hide()
                }
            }
        }

        input.active = true

        window.onMouseClick { mouseX, mouseY, mouseButton ->
            input.active = input.isHovered()
        }

        updateIcons()
    }

    private fun updateIcons(
        padding: Float = 2f,
        itemsPerRow: Int = 5,
        startX: Int = 5,
        startY: Int = 5,
        quickCrafts: List<QuickCraft> = QuickCraft.values().asList()
    ) {
        quickCrafts.sortedBy { quickCraft -> quickCraft.name }
        quickCrafts.sortedByDescending { quickCraft -> quickCraft.isFavorite() }

        fun getNextY(i: Int) =
            if (i == 0) startY.pixels()
            else SiblingConstraint(padding)

        repeat(quickCrafts.size) { i ->
            val quickCraft = quickCrafts[i]
            val itemStack = quickCraft.item.copy()

            val defaultColor =
                if (quickCraft.isFavorite())
                    Color(255, 255, 255, 40)
                else
                    Color(0, 0, 0, 0)

            val background = UIBlock(defaultColor).constrain {
                val nextLine = i % itemsPerRow == 0

                x = if (nextLine) startX.pixels() else SiblingConstraint(padding)
                y = if (nextLine) getNextY(i) else CramSiblingConstraint()

                width = 20.pixels()
                height = 20.pixels()
            }.onMouseEnter {
                setColor(Color(0f, 0f, 0f, .5f).asConstraint())
            }.onMouseLeave {
                setColor(defaultColor.asConstraint())
            }.onMouseClick { mouseX, mouseY, mouseButton ->
                if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)) {
                    quickCraft.toggleFavorite()
                } else QuickCraftExecutor.execute(quickCraft)
                clientPlayer.playSound("random.click", 0.3f, 1f)
            } childOf list

            val item = UIItem(itemStack).constrain {
                x = CenterConstraint()
                y = CenterConstraint()
            }.onHovering {
                drawHoveringText(listOf(quickCraft.fancyName, "???????????????"), mouseX, mouseY, fontRendererObj)
            } childOf background

            items.put(quickCraft, item)
        }
    }


    override fun doesGuiPauseGame(): Boolean {
        return true
    }

}
