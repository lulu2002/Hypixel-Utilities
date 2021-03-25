package me.lulu.hypixelutilities.craft;

import com.google.common.collect.Lists;
import net.minecraft.client.Minecraft;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

import java.io.File;
import java.util.List;

public class QuickCraftConfig {

    private Configuration config;

    private List<String> quickCrafts;

    public QuickCraftConfig() {
        config = new Configuration(new File("config/hypixel-utilities.cfg"));
        config.load();
        load();
    }

    private void load() {
        this.quickCrafts = Lists.newArrayList(getQuickCrafts().getStringList());
    }

    private void save() {
        getQuickCrafts().set(quickCrafts.toArray(new String[0]));
        config.save();
    }

    public void addQuickCraft(QuickCraft quickCraft) {
        this.quickCrafts.add(quickCraft.name());
        save();
    }

    public boolean isFavorite(QuickCraft quickCraft) {
        return this.quickCrafts.contains(quickCraft.name());
    }

    public void removeQuickCraft(QuickCraft quickCraft) {
        this.quickCrafts.remove(quickCraft.name());
        save();
    }

    private Property getQuickCrafts() {
        return config.get(Configuration.CATEGORY_GENERAL, "Quick_Crafts", new String[0], "儲存優先顯示的快速合成");
    }
}
