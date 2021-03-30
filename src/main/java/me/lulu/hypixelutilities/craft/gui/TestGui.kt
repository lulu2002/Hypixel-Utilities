package me.lulu.hypixelutilities.craft.gui

import club.sk1er.elementa.UIComponent
import club.sk1er.elementa.WindowScreen
import club.sk1er.elementa.components.ScrollComponent
import club.sk1er.elementa.components.UIBlock
import club.sk1er.elementa.constraints.CenterConstraint
import club.sk1er.elementa.constraints.CramSiblingConstraint
import club.sk1er.elementa.constraints.SiblingConstraint
import club.sk1er.elementa.dsl.asConstraint
import club.sk1er.elementa.dsl.childOf
import club.sk1er.elementa.dsl.constrain
import club.sk1er.elementa.dsl.pixels
import com.example.examplemod.ComponentsGui
import me.lulu.hypixelutilities.craft.QuickCraft
import me.lulu.hypixelutilities.craft.QuickCraftExecutor
import me.lulu.hypixelutilities.craft.isFavorite
import me.lulu.hypixelutilities.craft.toggleFavorite
import me.lulu.hypixelutilities.util.clientPlayer
import net.minecraft.enchantment.Enchantment
import org.lwjgl.input.Keyboard
import java.awt.Color


class TestGui : WindowScreen() {

    private var mouseX = 0
    private var mouseY = 0
    private val items = ArrayList<UIItem>()


    override fun drawScreen(mouseX: Int, mouseY: Int, partialTicks: Float) {
        this.mouseX = mouseX
        this.mouseY = mouseY

        super.drawScreen(mouseX, mouseY, partialTicks)

        items.forEach { t: UIComponent ->
            if (t is UIItem && t.isHovered()) {
                t.hovering(t)
            }
        }
    }

    init {

        val list = ScrollComponent().constrain {
            x = 10.pixels()
            y = CenterConstraint()

            width = 150.pixels()
            height = 150.pixels()

        } childOf window

        val quickCrafts = QuickCraft.values()
        quickCrafts.sortBy { quickCraft -> quickCraft.name }
        quickCrafts.sortByDescending { quickCraft -> quickCraft.isFavorite() }
        val padding = 2f
        val itemsPerRow = 5
        val startX = 5
        val startY = 5

        fun getNextY(i: Int) = if (i == 0) startY.pixels() else SiblingConstraint(padding)

        repeat(quickCrafts.size) { i ->
            val quickCraft = quickCrafts[i]
            val itemStack = quickCraft.item.copy()

            val defaultColor =
                if (quickCraft.isFavorite()) Color(255, 255, 255, 40)
                else Color(0, 0, 0, 0)

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
            }.onMouseClick {
                if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)) {
                    quickCraft.toggleFavorite()
                } else QuickCraftExecutor.execute(quickCraft)
                clientPlayer.playSound("random.click", 0.3f, 1f)
            } childOf list

            val item = UIItem(itemStack).constrain {
                x = CenterConstraint()
                y = CenterConstraint()
            }.onHovering {
                drawHoveringText(listOf(quickCraft.fancyName, "點擊來合成"), mouseX, mouseY, fontRendererObj)
            } childOf background

            items.add(item)
        }


        quickCrafts
//            .filter { quickCraft -> quickCraft.isFavorite() }
            .forEach { quickCraft ->
//
//                val block = UIBlock(Color(0f, 0f, 0f, .5f)).constrain {
//                    x = CenterConstraint()
//                    y = SiblingConstraint(padding = 2f)
//
//                    width = 150.pixels()
//                    height = 40.pixels()
//                }.onMouseEnter {
//                    setColor(Color(0f, 0f, 0f, .9f).asConstraint())
//                }.onMouseLeave {
//                    setColor(Color(0f, 0f, 0f, .5f).asConstraint())
//                } childOf list
//
//
//                UIItem(quickCraft.item).constrain {
//                    x = CenterConstraint()
//
//                    y = CenterConstraint() - 4.pixels()
//                } childOf block
//
//                UIText(quickCraft.fancyName).constrain {
//                    x = CenterConstraint()
//                    y = SiblingConstraint(padding = 1f)
//
//                    textScale = (1F).pixels()
//
//                } childOf block
            }
    }


    override fun doesGuiPauseGame(): Boolean {
        return false
    }

    override fun drawDefaultBackground() {

    }

}
