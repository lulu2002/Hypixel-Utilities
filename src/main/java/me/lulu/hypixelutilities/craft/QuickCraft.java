package me.lulu.hypixelutilities.craft;

import com.google.common.collect.Lists;
import lombok.Getter;
import me.lulu.hypixelutilities.util.ItemUtil;
import me.lulu.hypixelutilities.util.McUtil;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public enum QuickCraft {
    AMBROSIA(new ItemStack(Items.glowstone_dust)),
    ANDURIL(new ItemStack(Items.iron_sword), "§9Resistance I"),
    APPRENTICE_BOW(new ItemStack(Items.bow).setStackDisplayName("§aApprentice Bow")),
    APPRENTICE_HELMET(new ItemStack(Items.iron_helmet).setStackDisplayName("§aApprentice Helmet")),
    APPRENTICE_SWORD(new ItemStack(Items.iron_sword).setStackDisplayName("§aApprentice Sword")),
    ARROW_ECONOMY("ARROWS_ECONOMY", new ItemStack(Items.arrow)),
    ARTEMIS_BOOK("PROJ_PROT_BOOK", new ItemStack(Items.enchanted_book)),
    ARTEMIS_BOW(new ItemStack(Items.bow).setStackDisplayName("§aArtemis' Bow")),
    AXE_OF_PERUN(new ItemStack(Items.diamond_axe).setStackDisplayName("§6Axe of Perun")),
    BACKPACK(new ItemStack(Blocks.ender_chest), "§7use this handy backpack"),
    BARBARIAN_CHESTPLATE(new ItemStack(Items.diamond_chestplate).setStackDisplayName("§aBarbarian Chestplate")),
    BLOODLUST(new ItemStack(Items.diamond_sword).setStackDisplayName("§cBloodlust")),
    BOOK_OF_POWER("POWER_ONE_BOOK", QuickCraftItems.bookOfPower(), "§7Category: §bWeaponsmith"),
    BOOK_OF_PROTECTION("PROT_BOOK", new ItemStack(Items.enchanted_book)),
    BOOK_OF_SHARPENING("SHARP_ONE_BOOK", new ItemStack(Items.enchanted_book)),
    BOOK_OF_THOTH(new ItemStack(Items.enchanted_book)),
    BREWING_ARTIFACT("NETHER_WART", new ItemStack(Items.nether_wart)),
    CHEST_OF_FATE(new ItemStack(Blocks.chest).setStackDisplayName("§aChest of Fate")),
    CORNUCOPIA(new ItemStack(Items.golden_carrot, 3).setStackDisplayName("§6Cornucopia")),
    CUPIDS_BOW(new ItemStack(Items.bow)),
    DAREDEVIL(new ItemStack(Items.spawn_egg)),
    DEATHS_SCYTHE(new ItemStack(Items.diamond_hoe)),
    DELICIOUS_MEAL("EIGHT_STEAKS", new ItemStack(Items.cooked_beef)),
    DEUS_EX_MACHINA(new ItemStack(Items.potionitem)),
    DICE_OF_GOD(new ItemStack(Blocks.end_portal_frame)),
    DRAGON_ARMOR(new ItemStack(Items.diamond_chestplate)),
    DRAGON_SWORD(new ItemStack(Items.diamond_sword), "§7Weaponsmith Ultimate."),
    DUST_OF_LIGHT("EIGHT_GLOWSTONE", new ItemStack(Items.glowstone_dust)),
    ENHANCEMENT_BOOK(new ItemStack(Items.enchanted_book)),
    ENLIGHTENING_PACK("", new ItemStack(Items.experience_bottle)),
    ESSENCE_OF_YGGDRASIL(new ItemStack(Items.experience_bottle)),
    EVES_TEMPTATION("APPLES", new ItemStack(Items.apple)),
    EXCALIBUR(new ItemStack(Items.diamond_sword)),
    EXODUS(new ItemStack(Items.diamond_helmet)),
    EXPERT_SEAL(new ItemStack(Items.nether_star)),
    FATES_CALL("", new ItemStack(Items.flower_pot)),
    FENRIR(new ItemStack(Items.spawn_egg)),
    FLAMING_ARTIFACT("BLAZE_ROD", new ItemStack(Items.blaze_rod)),
    FLASK_OF_CLEANSING(new ItemStack(Items.potionitem)),
    FLASK_OF_ICHOR(new ItemStack(Items.potionitem)),
    FORGE(new ItemStack(Blocks.furnace)),
    FUSION_ARMOR(new ItemStack(Items.diamond_chestplate)),
    GOLDEN_HEAD(new ItemStack(Items.skull)),
    GOLD_PACK(new ItemStack(Items.gold_ingot)),
    HEALING_FRUIT("MELON", new ItemStack(Items.melon)),
    HERMES_BOOTS(new ItemStack(Items.diamond_boots)),
    HIDE_OF_LEVIATHAN(new ItemStack(Items.diamond_boots)),
    HOLY_WATER("ABSORPTION_POT", new ItemStack(Items.potionitem)),
    IRON_PACK("IRON_INGOTS", new ItemStack(Items.iron_ingot)),
    KINGS_ROD(new ItemStack(Items.fishing_rod)),
    LEATHER_ECONOMY("EIGHT_LEATHER", new ItemStack(Items.leather)),
    LIGHT_ANVIL(new ItemStack(Blocks.anvil)),
    LIGHT_APPLE(new ItemStack(Items.golden_apple)),
    LIGHT_ENCHANTMENT_TABLE("", new ItemStack(Blocks.enchanting_table)),
    LUCKY_SHEARS(new ItemStack(Items.shears)),
    LUMBERJACKS_AXE("LUMBERJACK_AXE", new ItemStack(Items.iron_axe)),
    MASTERS_COMPASS(new ItemStack(Items.compass)),
    MINERS_BLESSING(new ItemStack(Items.diamond_pickaxe)),
    MODULAR_BOW(new ItemStack(Items.bow)),
    NECTAR("REGEN_POTION", new ItemStack(Items.potionitem)),
    OBSIDIAN(new ItemStack(Blocks.obsidian)),
    PANACEA(new ItemStack(Items.potionitem)),
    PANDORAS_BOX(new ItemStack(Blocks.chest)),
    PHILOSOPHERS_PICKAXE("PHILOSOPHER_PICK", new ItemStack(Items.diamond_pickaxe)),
    POTION_OF_TOUGHNESS("", new ItemStack(Items.potionitem)),
    POTION_OF_VELOCITY(new ItemStack(Items.potionitem)),
    POTION_OF_VITALITY(new ItemStack(Items.potionitem)),
    QUICK_PICK("EFFICIENCY_PICKAXE", new ItemStack(Items.iron_pickaxe)),
    SADDLE(new ItemStack(Items.saddle)),
    SEVEN_LEAGUE_BOOTS(new ItemStack(Items.diamond_boots)),
    SHOES_OF_VIDAR(new ItemStack(Items.diamond_boots)),
    SPIKED_ARMOR("", new ItemStack(Items.leather_chestplate)),
    SUGAR_RUSH("SUGAR_CANE", new ItemStack(Items.reeds)),
    SWAN_SONG(new ItemStack(Items.iron_sword)),
    TABLETS_OF_DESTINY(new ItemStack(Items.enchanted_book)),
    TARNHELM(new ItemStack(Items.diamond_helmet)),
    THE_DEEP(new ItemStack(Items.fishing_rod)),
    THE_MARK(new ItemStack(Items.snowball)),
    TREASURE_OF_EL_DORADO("EL_DORADO", new ItemStack(Blocks.chest)),
    VOIDBOX(new ItemStack(Blocks.ender_chest)),
    VORPAL_SWORD(new ItemStack(Items.iron_sword)),
    WARLOCK_PANTS(new ItemStack(Items.chainmail_leggings));

    @Getter
    private String nameInHypixel;
    @Getter
    private ItemStack item;

    QuickCraft() {
        this(new ItemStack(Blocks.air));
    }

    QuickCraft(ItemStack item, String... lores) {
        this.nameInHypixel = name();
        this.item = item;
        ItemUtil.addLore(item, lores);
    }

    QuickCraft(String nameInHypixel, ItemStack item, String... lores) {
        this.nameInHypixel = nameInHypixel;
        this.item = item;
        ItemUtil.addLore(item, lores);
    }
}
