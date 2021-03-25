package me.lulu.hypixelutilities.craft;

import lombok.experimental.UtilityClass;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

@UtilityClass
public class QuickCraftItems {

    public ItemStack bookOfPower() {
        ItemStack book = new ItemStack(Items.enchanted_book);
        book.addEnchantment(Enchantment.power, 1);
        return book;
    }

}
