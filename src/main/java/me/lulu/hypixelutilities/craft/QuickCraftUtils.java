package me.lulu.hypixelutilities.craft;

import lombok.experimental.UtilityClass;
import me.lulu.hypixelutilities.HypixelUtilities;

@UtilityClass
public class QuickCraftUtils {
    public boolean isFavorite(QuickCraft quickCraft) {
        return getConfig().isFavorite(quickCraft);
    }

    public void toggleFavorite(QuickCraft quickCraft) {
        QuickCraftConfig config = getConfig();
        if (config.isFavorite(quickCraft))
            config.removeQuickCraft(quickCraft);
        else
            config.addQuickCraft(quickCraft);
    }

    private QuickCraftConfig getConfig() {
        return HypixelUtilities.QUICK_CRAFT_CONFIG;
    }
}
