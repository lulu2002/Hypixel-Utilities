package me.lulu.hypixelutilities.craft

import net.minecraft.enchantment.Enchantment
import net.minecraft.enchantment.EnchantmentData
import net.minecraft.init.Items
import net.minecraft.item.ItemStack

object QuickCraftItems {
    fun bookOfPower(): ItemStack {
        val book = ItemStack(Items.enchanted_book)
        Items.enchanted_book.addEnchantment(book, EnchantmentData(Enchantment.power, 1))
        return book
    }

    fun bookOfProt(): ItemStack {
        val book = ItemStack(Items.enchanted_book)
        Items.enchanted_book.addEnchantment(book, EnchantmentData(Enchantment.protection, 1))
        return book
    }

    fun bookOfProjProt(): ItemStack {
        val book = ItemStack(Items.enchanted_book)
        Items.enchanted_book.addEnchantment(book, EnchantmentData(Enchantment.projectileProtection, 1))
        return book
    }

    fun bookOfSharp(): ItemStack {
        val book = ItemStack(Items.enchanted_book)
        Items.enchanted_book.addEnchantment(book, EnchantmentData(Enchantment.sharpness, 1))
        return book
    }

    fun bookOfThoth(): ItemStack {
        val book = ItemStack(Items.enchanted_book)
        Items.enchanted_book.addEnchantment(book, EnchantmentData(Enchantment.protection, 3))
        Items.enchanted_book.addEnchantment(book, EnchantmentData(Enchantment.sharpness, 2))
        Items.enchanted_book.addEnchantment(book, EnchantmentData(Enchantment.power, 2))
        Items.enchanted_book.addEnchantment(book, EnchantmentData(Enchantment.punch, 1))
        Items.enchanted_book.addEnchantment(book, EnchantmentData(Enchantment.fireAspect, 1))
        return book
    }

    fun philoPick(): ItemStack {
        val pick = ItemStack(Items.diamond_pickaxe)
        pick.itemDamage = 1559
        return pick
    }
}
