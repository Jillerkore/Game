package me.dev.killerjore.ui;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import me.dev.killerjore.ui.barUI.BarUIManager;
import me.dev.killerjore.ui.hotbarUI.HotbarUIManager;

public class UIManager {

    private static UIManager instance;

    public static UIManager getInstance() { if (instance == null) instance = new UIManager(); return instance;}

    private BarUIManager barUIManager;
    private HotbarUIManager hotBarUIManager;

    public UIManager() {
        barUIManager = new BarUIManager();
        hotBarUIManager = new HotbarUIManager();
    }

    public void render(SpriteBatch batch) {
        barUIManager.renderBarUI(batch);
        hotBarUIManager.render(batch);
    }

    public void dispose() {
        barUIManager.dispose();
        hotBarUIManager.dispose();
    }

}
