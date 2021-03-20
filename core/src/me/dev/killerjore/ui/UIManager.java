package me.dev.killerjore.ui;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import me.dev.killerjore.ui.barUI.BarUIManager;
import me.dev.killerjore.ui.inventory.Inventory;

public class UIManager {

    private static UIManager instance;

    public static UIManager getInstance() { if (instance == null) instance = new UIManager(); return instance;}

    private BarUIManager barUIManager;

    public UIManager() {
        barUIManager = new BarUIManager();
    }

    public void render(SpriteBatch batch) {
        barUIManager.renderBarUI(batch);
        Inventory.getInstance().render(batch);
    }

    public void dispose() {
        barUIManager.dispose();
    }

}
