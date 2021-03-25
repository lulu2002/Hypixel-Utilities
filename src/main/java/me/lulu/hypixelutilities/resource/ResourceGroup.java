package me.lulu.hypixelutilities.resource;

import com.google.common.collect.Lists;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class ResourceGroup implements Resource {

    private String name;
    private List<Resource> resources;

    public ResourceGroup(String name, Resource... resources) {
        this.name = name;
        this.resources = Lists.newArrayList(resources);
    }

    @Override
    public boolean hasEnough() {

        for (Resource resource : resources) {
            if (resource.hasEnough())
                return true;
        }

        return false;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public List<ItemStack> getRequire() {
        List<ItemStack> all = new ArrayList<>();

        for (Resource resource : resources) {
            all.addAll(resource.getRequire());
        }

        return all;
    }


}
