package me.dev.killerjore.ui.save;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class SaveText {

    private static SaveText instance;
    public static SaveText getInstance() { if (instance == null) instance = new SaveText(); return instance; }

    private final BitmapFont textRender;

    private int renderDurInFrames = 0;

    public void setRender(int duration) {
        this.renderDurInFrames = duration;
    }

    private SaveText() {
        textRender = new BitmapFont();
        textRender.getData().setScale(1, 1);
    }

    public void render(SpriteBatch batch) {
        if (renderDurInFrames >= 0) {
            textRender.draw(batch, "Saved...", 5, 20);
            renderDurInFrames--;
        }
    }

    public void dispose() {
        textRender.dispose();
    }

}
