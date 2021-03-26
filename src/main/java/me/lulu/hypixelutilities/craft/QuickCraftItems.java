package me.lulu.hypixelutilities.craft;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentData;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class QuickCraftItems {

    public static ItemStack bookOfPower() {
        ItemStack book = new ItemStack(Items.enchanted_book);
        Items.enchanted_book.addEnchantment(book, new EnchantmentData(Enchantment.power, 1));
        return book;
    }

    public static ItemStack bookOfProt() {
        ItemStack book = new ItemStack(Items.enchanted_book);
        Items.enchanted_book.addEnchantment(book, new EnchantmentData(Enchantment.protection, 1));
        return book;
    }

    public static ItemStack bookOfProjProt() {
        ItemStack book = new ItemStack(Items.enchanted_book);
        Items.enchanted_book.addEnchantment(book, new EnchantmentData(Enchantment.projectileProtection, 1));
        return book;
    }

    public static ItemStack bookOfSharp() {
        ItemStack book = new ItemStack(Items.enchanted_book);
        Items.enchanted_book.addEnchantment(book, new EnchantmentData(Enchantment.sharpness, 1));
        return book;
    }

    public static ItemStack bookOfThoth() {
        ItemStack book = new ItemStack(Items.enchanted_book);
        Items.enchanted_book.addEnchantment(book, new EnchantmentData(Enchantment.protection, 3));
        Items.enchanted_book.addEnchantment(book, new EnchantmentData(Enchantment.sharpness, 2));
        Items.enchanted_book.addEnchantment(book, new EnchantmentData(Enchantment.power, 2));
        Items.enchanted_book.addEnchantment(book, new EnchantmentData(Enchantment.punch, 1));
        Items.enchanted_book.addEnchantment(book, new EnchantmentData(Enchantment.fireAspect, 1));
        return book;
    }

    public static ItemStack philoPick() {
        ItemStack pick = new ItemStack(Items.diamond_pickaxe);
        pick.setItemDamage(1559);
        return pick;
    }
}
