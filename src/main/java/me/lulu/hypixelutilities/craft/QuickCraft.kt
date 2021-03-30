package me.lulu.hypixelutilities.craft

import me.lulu.hypixelutilities.util.addLores
import net.minecraft.init.Blocks
import net.minecraft.init.Items
import net.minecraft.item.ItemStack

enum class QuickCraft {
    AMBROSIA(ItemStack(Items.glowstone_dust)),
    ANDURIL(ItemStack(Items.iron_sword), "§9Resistance I"),
    APPRENTICE_BOW(ItemStack(Items.bow).setStackDisplayName("§aApprentice Bow")),
    APPRENTICE_HELMET(ItemStack(Items.iron_helmet).setStackDisplayName("§aApprentice Helmet")),
    APPRENTICE_SWORD(ItemStack(Items.iron_sword).setStackDisplayName("§aApprentice Sword")),
    ARROW_ECONOMY("ARROWS_ECONOMY", ItemStack(Items.arrow)),
    ARTEMIS_BOOK("PROJ_PROT_BOOK", QuickCraftItems.bookOfProjProt(), "§Crafted by"),
    ARTEMIS_BOW(ItemStack(Items.bow).setStackDisplayName("§aArtemis' Bow")),
    AXE_OF_PERUN(ItemStack(Items.diamond_axe).setStackDisplayName("§6Axe of Perun")),
    BACKPACK(ItemStack(Items.skull), "§7use this handy backpack"),
    BARBARIAN_CHESTPLATE(ItemStack(Items.diamond_chestplate).setStackDisplayName("§aBarbarian Chestplate")),
    BLOODLUST(ItemStack(Items.diamond_sword).setStackDisplayName("§cBloodlust")),
    BOOK_OF_POWER("POWER_ONE_BOOK", QuickCraftItems.bookOfPower(), "§7Crafted by"),
    BOOK_OF_PROTECTION("PROT_BOOK", QuickCraftItems.bookOfProt(), "§7Crafted by"),
    BOOK_OF_SHARPENING("SHARP_ONE_BOOK", QuickCraftItems.bookOfSharp(), "§7Crafted by"),
    BOOK_OF_THOTH(QuickCraftItems.bookOfThoth()),
    BREWING_ARTIFACT("NETHER_WART", ItemStack(Items.nether_wart)),
    CHEST_OF_FATE(ItemStack(Blocks.chest).setStackDisplayName("§aChest of Fate")),
    CORNUCOPIA(ItemStack(Items.golden_carrot, 3).setStackDisplayName("§6Cornucopia")),
    CUPIDS_BOW(ItemStack(Items.bow).setStackDisplayName("§cCupid's Bow")),
    DAREDEVIL(ItemStack(Items.spawn_egg)),
    DEATHS_SCYTHE(ItemStack(Items.iron_hoe).setStackDisplayName("§aDeath's Scythe")),
    DELICIOUS_MEAL("EIGHT_STEAKS", ItemStack(Items.cooked_beef)),
    DEUS_EX_MACHINA(ItemStack(Items.potionitem)),
    DICE_OF_GOD(ItemStack(Blocks.end_portal_frame).setStackDisplayName("§aDice of God")),
    DRAGON_ARMOR(ItemStack(Items.diamond_chestplate).setStackDisplayName("§aDragon Armor")),
    DRAGON_SWORD(ItemStack(Items.diamond_sword), "§7Weaponsmith Ultimate."),
    DUST_OF_LIGHT("EIGHT_GLOWSTONE", ItemStack(Items.glowstone_dust)),
    ENHANCEMENT_BOOK(ItemStack(Items.enchanted_book).setStackDisplayName("§aEnhancement Book")),
    ENLIGHTENING_PACK("", ItemStack(Items.experience_bottle)),
    ESSENCE_OF_YGGDRASIL(ItemStack(Items.experience_bottle)),
    EVES_TEMPTATION("APPLES", ItemStack(Items.apple)),
    EXCALIBUR(ItemStack(Items.diamond_sword).setStackDisplayName("§6Excalibur")),
    EXODUS(ItemStack(Items.diamond_helmet).setStackDisplayName("§6Exodus")),
    EXPERT_SEAL(ItemStack(Items.nether_star).setStackDisplayName("§aExpert Seal")),
    FATES_CALL("", ItemStack(Items.flower_pot)),
    FENRIR(ItemStack(Items.spawn_egg)),
    FLAMING_ARTIFACT("BLAZE_ROD", ItemStack(Items.blaze_rod)),
    FLASK_OF_CLEANSING(ItemStack(Items.potionitem)),
    FLASK_OF_ICHOR(ItemStack(Items.potionitem)),
    FORGE(ItemStack(Blocks.furnace)),
    FUSION_ARMOR(ItemStack(Items.diamond_chestplate).setStackDisplayName("§aFusion Armor")),
    GOLDEN_HEAD(ItemStack(Items.skull)),
    GOLD_PACK(ItemStack(Items.gold_ingot)), HEALING_FRUIT("MELON", ItemStack(Items.melon)),
    HERMES_BOOTS(ItemStack(Items.diamond_boots).setStackDisplayName("§aHermes' Boots")),
    HIDE_OF_LEVIATHAN(ItemStack(Items.diamond_leggings).setStackDisplayName("§aHide of Leviathan")),
    HOLY_WATER("ABSORPTION_POT", ItemStack(Items.potionitem)),
    IRON_PACK("IRON_INGOTS", ItemStack(Items.iron_ingot)),
    KINGS_ROD(ItemStack(Items.fishing_rod).setStackDisplayName("§aKing's Rod")),
    LEATHER_ECONOMY("EIGHT_LEATHER", ItemStack(Items.leather)),
    LIGHT_ANVIL(ItemStack(Blocks.anvil)), LIGHT_APPLE(ItemStack(Items.golden_apple)),
    LIGHT_ENCHANTMENT_TABLE("", ItemStack(Blocks.enchanting_table)),
    LUCKY_SHEARS(ItemStack(Items.shears).setStackDisplayName("§aLucky Shears")),
    LUMBERJACKS_AXE("LUMBERJACK_AXE", ItemStack(Items.iron_axe)),
    MASTERS_COMPASS(ItemStack(Items.compass)),
    MINERS_BLESSING(ItemStack(Items.diamond_pickaxe).setStackDisplayName("§aMiner's Blessing")),
    MODULAR_BOW(ItemStack(Items.bow).addLores("§aCurrent Mode: §6Punch")),
    NECTAR("REGEN_POTION", ItemStack(Items.potionitem)),
    OBSIDIAN(ItemStack(Blocks.obsidian)), PANACEA(ItemStack(Items.potionitem)),
    PANDORAS_BOX(ItemStack(Blocks.chest)),
    PHILOSOPHERS_PICKAXE(
        "PHILOSOPHER_PICK",
        QuickCraftItems.philoPick().setStackDisplayName("§aPhilosopher's Pickaxe")
    ),
    POTION_OF_TOUGHNESS("", ItemStack(Items.potionitem)),
    POTION_OF_VELOCITY(ItemStack(Items.potionitem)),
    POTION_OF_VITALITY(ItemStack(Items.potionitem)),
    QUICK_PICK("EFFICIENCY_PICKAXE", ItemStack(Items.iron_pickaxe)),
    SADDLE(ItemStack(Items.saddle)),
    SEVEN_LEAGUE_BOOTS(ItemStack(Items.diamond_boots).setStackDisplayName("§aSeven-league Boots")),
    SHOES_OF_VIDAR(ItemStack(Items.diamond_boots).setStackDisplayName("§aShoes of Vidar")),
    SPIKED_ARMOR("", ItemStack(Items.leather_chestplate)),
    SUGAR_RUSH("SUGAR_CANE", ItemStack(Items.reeds)),
    SWAN_SONG(ItemStack(Items.iron_sword)),
    TABLETS_OF_DESTINY(ItemStack(Items.enchanted_book).setStackDisplayName("§aTablets of Destiny")),
    TARNHELM(ItemStack(Items.diamond_helmet).setStackDisplayName("§aTarnhelm")),
    THE_DEEP(ItemStack(Items.fishing_rod).setStackDisplayName("§aThe Deep")),
    THE_MARK(ItemStack(Items.snowball).setStackDisplayName("§aThe Mark")),
    TREASURE_OF_EL_DORADO("EL_DORADO", ItemStack(Items.filled_map).setStackDisplayName("§aTreasure of El Dorado")),
    VOIDBOX(ItemStack(Blocks.ender_chest)),
    VORPAL_SWORD(ItemStack(Items.iron_sword)),
    WARLOCK_PANTS(ItemStack(Items.chainmail_leggings).setStackDisplayName("§aWarlock Pants"));

    val nameInHypixel: String
    val item: ItemStack

    constructor() : this(ItemStack(Blocks.air)) {}
    constructor(item: ItemStack, vararg lores: String) {
        nameInHypixel = name
        this.item = item
        item.addLores(*lores)
    }

    constructor(nameInHypixel: String, item: ItemStack, vararg lores: String) {
        this.nameInHypixel = nameInHypixel
        this.item = item

        item.addLores(*lores)
    }
}
