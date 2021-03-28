package me.dev.killerjore.ui.buttonsUI;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import me.dev.killerjore.ui.uiModels.derivatives.SettingsButton;

public class ButtonsUI {

    private final SettingsButton button;

    public ButtonsUI() {
        button = new SettingsButton(5, 5, 46, 46);
    }

    public void onClick(int mx, int my) {
        button.onClickEvent(mx, my);
    }
    public void onUnclick(int mx, int my) {
        button.onUnclickEvent(mx, my);
    }

    public void render(SpriteBatch batch) {
        button.render(batch);
    }

    public void click(int transMx, int transMy, int button) {
        if (button == Input.Buttons.LEFT) {
            onClick(transMx, transMy);
        }
    }
    public void unClick(int transX, int transY, int button) {
        if (button == Input.Buttons.LEFT) {
            onUnclick(transX, transY);
        }
    }
}
