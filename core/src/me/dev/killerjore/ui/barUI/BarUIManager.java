package me.dev.killerjore.ui.barUI;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class BarUIManager {

    private HealthBarUI healthBarUI;
    private StaminaBarUI staminaBarUI;

    public BarUIManager() {
        healthBarUI = new HealthBarUI();
        staminaBarUI = new StaminaBarUI();
    }

    public void renderBarUI(SpriteBatch batch) {
        healthBarUI.render(batch);
        staminaBarUI.render(batch);
    }

    public void dispose() {
        healthBarUI.dispose();
        staminaBarUI.dispose();
    }
}
