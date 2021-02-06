package me.dev.killerjore.ui.hotbarUI;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class HotbarUIManager {

    private HotbarUI hotbarUI;

    public HotbarUIManager() {
        hotbarUI = new HotbarUI();
    }

    public void render(SpriteBatch batch) {
        hotbarUI.render(batch);
    }

    public void dispose() {
        hotbarUI.dispose();
    }
}
