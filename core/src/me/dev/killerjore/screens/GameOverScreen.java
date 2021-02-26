package me.dev.killerjore.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameOverScreen implements Screen {

    private BitmapFont font;
    private Batch batch;

    public GameOverScreen() {
        font = new BitmapFont();
        font.setColor(Color.WHITE);
        batch = new SpriteBatch();
        font.getData().setScale(5, 5);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);
        batch.begin();
        font.draw(batch, "Game Over", 450, Gdx.graphics.getHeight() / 2);
        batch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        batch.dispose();
        font.dispose();
    }
}
