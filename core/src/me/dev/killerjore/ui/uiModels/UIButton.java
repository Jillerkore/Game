package me.dev.killerjore.ui.uiModels;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public abstract class UIButton {

    protected final int width;
    protected final int height;
    protected final int x;
    protected final int y;

    protected final TextureRegion clickedTexture, unclickedTexture;

    protected TextureRegion textureToRender;

    public UIButton(int x, int y, int width, int height, TextureRegion clicked, TextureRegion unclicked) {
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
        this.clickedTexture = clicked;
        this.unclickedTexture = unclicked;

        textureToRender = unclickedTexture;
    }

    public boolean isHovering(int mx, int my) {
        return mx > x && mx < x + width && my > y && my < y + width;
    }

    public void render(SpriteBatch batch) {
        batch.draw(textureToRender, x, y, width, height);
    }

    public abstract void onClickEvent(int mx, int my);
    public abstract void onUnclickEvent(int mx, int my);

    public void dispose() {
        clickedTexture.getTexture().dispose();
        unclickedTexture.getTexture().dispose();
        textureToRender.getTexture().dispose();
    }
}
