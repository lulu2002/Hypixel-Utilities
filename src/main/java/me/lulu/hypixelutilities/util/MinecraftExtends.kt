package me.lulu.hypixelutilities.util

import net.minecraft.client.Minecraft
import net.minecraft.client.entity.EntityPlayerSP
import net.minecraft.client.gui.FontRenderer
import net.minecraft.util.ChatComponentText


val Any.clientPlayer: EntityPlayerSP
    get() = mc.thePlayer

val Any.mc: Minecraft
    get() = Minecraft.getMinecraft()

val Any.fontRenderer: FontRenderer
    get() = mc.fontRenderer;

fun EntityPlayerSP.addChatMessage(string: String) = addChatMessage(ChatComponentText(string))
