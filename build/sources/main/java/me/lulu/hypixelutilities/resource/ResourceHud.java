package me.lulu.hypixelutilities.resource;

import com.google.common.collect.Lists;
import me.lulu.hypixelutilities.hud.ListStringHud;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ResourceHud extends ListStringHud {

    private List<Resource> resource;

    public ResourceHud(Resource... resource) {
        super(5, 5);
        this.resource = Lists.newArrayList(resource);
    }

    @Override
    protected List<String> getList() {
        List<String> list = new ArrayList<>();

        for (Resource resource : resource) {
            String str = getColor(resource) + resource.getName();

            if (!resource.hasEnough())
                str = str.concat("(缺 " + requireStr(resource.getRequire()) + ")");

            list.add(str);
        }

        return list;
    }

    private String requireStr(List<ItemStack> require) {
        return require.stream()
                .filter(itemStack -> itemStack.getItem() != Item.getItemFromBlock(Blocks.air))
                .filter(itemStack -> itemStack.stackSize > 0)
                .map(itemStack -> itemStack.stackSize + "x " + itemStack.getDisplayName())
                .collect(Collectors.joining(" 或 "));
    }

    private EnumChatFormatting getColor(Resource resource) {
        if (resource.hasEnough())
            return EnumChatFormatting.GREEN;
        else
            return EnumChatFormatting.GRAY;
    }
}
