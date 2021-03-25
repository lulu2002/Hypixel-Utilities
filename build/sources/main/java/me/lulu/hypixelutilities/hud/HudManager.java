package me.lulu.hypixelutilities.hud;

import com.google.common.collect.Lists;
import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.List;

@UtilityClass
public class HudManager {
    private List<Hud> huds = new ArrayList<Hud>();

    public void addHud(Hud hud) {
        huds.add(hud);
    }

    public void clearHuds() {
        huds.clear();
    }

    public void removeHud(Hud hud) {
        huds.remove(hud);
    }

    public List<Hud> getHuds() {
        return Lists.newArrayList(huds);
    }
}
