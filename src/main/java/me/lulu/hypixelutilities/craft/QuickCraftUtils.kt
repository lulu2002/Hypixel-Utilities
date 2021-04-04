package me.lulu.hypixelutilities.craft

import me.lulu.hypixelutilities.HypixelUtilities


fun QuickCraft.isFavorite(): Boolean {
    return config.isFavorite(this)
}

fun QuickCraft.toggleFavorite() {
    val config = config
    if (isFavorite()) config.removeQuickCraft(this) else config.addQuickCraft(this)
}

private val config: QuickCraftConfig
    private get() = HypixelUtilities.QUICK_CRAFT_CONFIG
