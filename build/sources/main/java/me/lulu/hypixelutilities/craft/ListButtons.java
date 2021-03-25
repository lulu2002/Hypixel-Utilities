package me.lulu.hypixelutilities.craft;

import net.minecraft.client.gui.GuiButton;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public abstract class ListButtons<E> {

    private int buttonWidth, buttonHeight;
    private int guiWidth, guiHeight;
    private int buttonsPerRow;


    public ListButtons(int buttonWidth, int buttonHeight, int guiWidth, int guiHeight, int buttonsPerRow) {
        this.buttonWidth = buttonWidth;
        this.buttonHeight = buttonHeight;
        this.guiWidth = guiWidth;
        this.guiHeight = guiHeight;
        this.buttonsPerRow = buttonsPerRow;
    }

    public List<GuiButton> generateButtons(Collection<E> eList) {
        ButtonDrawer drawer = new ButtonDrawerCenterAlign(buttonWidth, buttonHeight, buttonsPerRow, guiWidth, guiHeight);

        return eList.stream()
                .map(e -> {
                    GuiButton button = toButton(e);
                    drawer.draw(button);
                    return button;
                })
                .collect(Collectors.toList());
    }

    protected abstract GuiButton toButton(E e);

}
