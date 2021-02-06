package me.dev.killerjore.ui.barUI;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class BarUI {

    protected int x;
    protected int y;
    protected int barPosX;
    protected int barPosY;

    protected Texture fillerBar;
    protected Texture emptyBar;

    protected BitmapFont font;

    protected final int fillerBarWidth = 6;
    protected final int fillerBarHeight = 23;

    public BarUI(int x, int y, int barPosX, int barPosY, Texture fillerBar, Texture emptyBar) {
        this.x = x;
        this.y = y;
        this.barPosX = barPosX;
        this.barPosY = barPosY;

        this.fillerBar = fillerBar;
        this.emptyBar = emptyBar;

        this.font = new BitmapFont();
    }

    public abstract void render(SpriteBatch batch);

    public void dispose() {
        fillerBar.dispose();
        emptyBar.dispose();
    }
}
