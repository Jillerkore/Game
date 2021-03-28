package me.dev.killerjore.ui;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import me.dev.killerjore.ui.barUI.BarUIManager;
import me.dev.killerjore.ui.buttonsUI.ButtonsUI;
import me.dev.killerjore.ui.inventory.Inventory;
import me.dev.killerjore.ui.save.SaveText;

public class UIManager {

    private static UIManager instance;

    public static UIManager getInstance() { if (instance == null) instance = new UIManager(); return instance;}

    private BarUIManager barUIManager;
    private ButtonsUI buttonsUIManager;

    public UIManager() {
        barUIManager = new BarUIManager();
        buttonsUIManager = new ButtonsUI();
    }

    public void render(SpriteBatch batch) {
        buttonsUIManager.render(batch);
        barUIManager.renderBarUI(batch);
        Inventory.getInstance().render(batch);
        SaveText.getInstance().render(batch);
    }

    public void clickEvent(int transMx, int transMy, int button) {
        Inventory.getInstance().handleMouseInput(transMx, transMy, button);
        buttonsUIManager.click( transMx,  transMy,  button);
    }
    public void unClickEvent(int transMx, int transMy, int button) {
        buttonsUIManager.unClick(transMx, transMy, button);
    }

    public void dispose() {
        barUIManager.dispose();
        Inventory.getInstance().dispose();
        SaveText.getInstance().dispose();
    }

}
