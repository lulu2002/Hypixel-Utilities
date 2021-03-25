package me.lulu.hypixelutilities.craft;

import lombok.Getter;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public enum QuickCraft {
    APPRENTICE_HELMET(new ItemStack(Items.iron_helmet)),
    APPRENTICE_SWORD(new ItemStack(Items.iron_sword)),
    APPRENTICE_BOW(new ItemStack(Items.bow)),
    MASTERS_COMPASS(new ItemStack(Items.compass)),
    VORPAL_SWORD(new ItemStack(Items.iron_sword)),
    BOOK_OF_SHARPENING("SHARP_ONE_BOOK", new ItemStack(Items.enchanted_book)),
    BOOK_OF_POWER("POWER_ONE_BOOK", new ItemStack(Items.enchanted_book)),
    DRAGON_SWORD(new ItemStack(Items.diamond_sword)),
    LEATHER_ECONOMY("EIGHT_LEATHER", new ItemStack(Items.leather)),
    BOOK_OF_PROTECTION("PROT_BOOK", new ItemStack(Items.enchanted_book)),
    ARTEMIS_BOOK("PROJ_PROT_BOOK", new ItemStack(Items.enchanted_book)),
    DRAGON_ARMOR(new ItemStack(Items.diamond_chestplate)),
    DUST_OF_LIGHT("EIGHT_GLOWSTONE", new ItemStack(Items.glowstone_dust)),
    BREWING_ARTIFACT("NETHER_WART", new ItemStack(Items.nether_wart)),
    NECTAR("REGEN_POTION", new ItemStack(Items.potionitem)),
    FLAMING_ARTIFACT("BLAZE_ROD", new ItemStack(Items.blaze_rod)),
    DELICIOUS_MEAL("EIGHT_STEAKS", new ItemStack(Items.cooked_beef)),
    POTION_OF_TOUGHNESS("", new ItemStack(Items.potionitem)),
    SPIKED_ARMOR("", new ItemStack(Items.leather_chestplate)),
    SEVEN_LEAGUE_BOOTS(new ItemStack(Items.diamond_boots)),
    IRON_PACK("IRON_INGOTS", new ItemStack(Items.iron_ingot)),
    OBSIDIAN(new ItemStack(Blocks.obsidian)),
    TARNHELM(new ItemStack(Items.diamond_helmet)),
    PHILOSOPHERS_PICKAXE("PHILOSOPHER_PICK", new ItemStack(Items.diamond_pickaxe)),
    ENLIGHTENING_PACK("", new ItemStack(Items.experience_bottle)),
    LIGHT_ANVIL(new ItemStack(Blocks.anvil)),
    LIGHT_ENCHANTMENT_TABLE("", new ItemStack(Blocks.enchanting_table)),
    BOOK_OF_THOTH(new ItemStack(Items.enchanted_book)),
    EVES_TEMPTATION("APPLES", new ItemStack(Items.apple)),
    HEALING_FRUIT("MELON", new ItemStack(Items.melon)),
    HOLY_WATER("ABSORPTION_POT", new ItemStack(Items.potionitem)),
    LIGHT_APPLE(new ItemStack(Items.golden_apple)),
    GOLDEN_HEAD(new ItemStack(Items.skull)),
    PANDORAS_BOX(new ItemStack(Blocks.chest)),
    PANACEA(new ItemStack(Items.potionitem)),
    CUPIDS_BOW(new ItemStack(Items.bow)),
    ARROW_ECONOMY("ARROWS_ECONOMY", new ItemStack(Items.arrow)),
    SADDLE(new ItemStack(Items.saddle)),
    POTION_OF_VELOCITY(new ItemStack(Items.potionitem)),
    FENRIR(new ItemStack(Items.spawn_egg)),
    FORGE(new ItemStack(Blocks.furnace)),
    QUICK_PICK("EFFICIENCY_PICKAXE", new ItemStack(Items.iron_pickaxe)),
    LUMBERJACKS_AXE("LUMBERJACK_AXE", new ItemStack(Items.iron_axe)),
    ENHANCEMENT_BOOK(new ItemStack(Items.enchanted_book)),
    GOLD_PACK(new ItemStack(Items.gold_ingot)),
    SUGAR_RUSH("SUGAR_CANE", new ItemStack(Items.reeds)),
    BACKPACK(new ItemStack(Blocks.ender_chest)),
    FUSION_ARMOR(new ItemStack(Items.diamond_chestplate)),
    LUCKY_SHEARS(new ItemStack(Items.shears)),
    THE_DEEP(new ItemStack(Items.fishing_rod)),
    SWAN_SONG(new ItemStack(Items.iron_sword)),
    TREASURE_OF_EL_DORADO("EL_DORADO", new ItemStack(Blocks.chest)),
    ARTEMIS_BOW(new ItemStack(Items.bow)),
    FLASK_OF_ICHOR(new ItemStack(Items.potionitem)),
    EXODUS(new ItemStack(Items.diamond_helmet)),
    HIDE_OF_LEVIATHAN(new ItemStack(Items.diamond_boots)),
    TABLETS_OF_DESTINY(new ItemStack(Items.enchanted_book)),
    AXE_OF_PERUN(new ItemStack(Items.diamond_axe)),
    EXCALIBUR(new ItemStack(Items.diamond_sword)),
    ANDURIL(new ItemStack(Items.iron_sword)),
    DEATHS_SCYTHE(new ItemStack(Items.diamond_hoe)),
    CHEST_OF_FATE(new ItemStack(Blocks.chest)),
    CORNUCOPIA(new ItemStack(Items.golden_carrot)),
    ESSENCE_OF_YGGDRASIL(new ItemStack(Items.experience_bottle)),
    VOIDBOX(new ItemStack(Blocks.ender_chest)),
    DEUS_EX_MACHINA(new ItemStack(Items.potionitem)),
    DICE_OF_GOD(new ItemStack(Blocks.end_portal_frame)),
    KINGS_ROD(new ItemStack(Items.fishing_rod)),
    DAREDEVIL(new ItemStack(Items.spawn_egg)),
    FLASK_OF_CLEANSING(new ItemStack(Items.potionitem)),
    SHOES_OF_VIDAR(new ItemStack(Items.diamond_boots)),
    POTION_OF_VITALITY(new ItemStack(Items.potionitem)),
    MINERS_BLESSING(new ItemStack(Items.diamond_pickaxe)),
    AMBROSIA(new ItemStack(Items.glowstone_dust)),
    BLOODLUST(new ItemStack(Items.diamond_sword)),
    MODULAR_BOW(new ItemStack(Items.bow)),
    EXPERT_SEAL(new ItemStack(Items.nether_star)),
    HERMES_BOOTS(new ItemStack(Items.diamond_boots)),
    BARBARIAN_CHESTPLATE(new ItemStack(Items.diamond_chestplate)),
    FATES_CALL("", new ItemStack(Items.flower_pot)),
    THE_MARK(new ItemStack(Items.snowball)),
    WARLOCK_PANTS(new ItemStack(Items.chainmail_leggings));

    @Getter
    private String nameInHypixel;
    @Getter
    private ItemStack item;

    QuickCraft() {
        this(new ItemStack(Blocks.air));
    }

    QuickCraft(ItemStack item) {
        this.nameInHypixel = name();
        this.item = item;
    }

    QuickCraft(String nameInHypixel, ItemStack item) {
        this.nameInHypixel = nameInHypixel;
        this.item = item;
    }
}
