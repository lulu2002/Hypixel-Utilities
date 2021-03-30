package me.lulu.hypixelutilities.craft.gui

import club.sk1er.elementa.UIComponent
import me.lulu.hypixelutilities.util.mc
import net.minecraft.client.renderer.RenderHelper
import net.minecraft.item.ItemStack

class UIItem(val itemStack: ItemStack) : UIComponent() {

    var hovering: UIComponent.() -> Unit = {}
        private set

    override fun draw() {
        beforeDraw()

        RenderHelper.disableStandardItemLighting()
        RenderHelper.enableGUIStandardItemLighting()
        mc.renderItem.renderItemAndEffectIntoGUI(itemStack, getLeft().toInt(), getTop().toInt())
        RenderHelper.enableGUIStandardItemLighting()

        super.draw()
    }

    override fun getWidth(): Float {
        return 16f
    }

    override fun getHeight(): Float {
        return 16f
    }


    fun onHovering(method: UIComponent.() -> Unit) = apply {
        hovering = method
    }
}
