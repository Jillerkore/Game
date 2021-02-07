package me.dev.killerjore.ui.hotbarUI;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class HotbarUI {

    private float x, y;
    private int width, height;

    private Texture hotbarTexture;

    public HotbarUI() {
        this.x = 100;
        this.y = 15;

        this.width = 400;
        this.height = 42;

        hotbarTexture = new Texture("sprites/ui/hotBar.png");
    }

    public void render(SpriteBatch batch) {
        batch.draw(hotbarTexture, x, y, width,height);
    }

    public void dispose() {
        hotbarTexture.dispose();
    }
}
