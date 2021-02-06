package me.dev.killerjore.ui.hotbarUI;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class HotbarUI {

    private float x, y;
    private int width, height;

    private Texture hotbarTexture;

    public HotbarUI() {
        this.x = 20;
        this.y = 25;

        hotbarTexture = new Texture("sprites/ui/hotBar.png");
    }

    public void render(SpriteBatch batch) {
        batch.draw(hotbarTexture, x, y);
    }

    public void dispose() {
        hotbarTexture.dispose();
    }
}
