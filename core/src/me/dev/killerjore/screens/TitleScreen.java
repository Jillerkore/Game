package me.dev.killerjore.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class TitleScreen implements Screen {

    private Texture titleScreenTexture;
    private SpriteBatch batch;
    private Music theme;

    public TitleScreen() {
        titleScreenTexture = new Texture("sprites/ui/titleScreen.png");
        batch = new SpriteBatch();

        theme = Gdx.audio.newMusic(Gdx.files.internal("audio/titleScreen.mp3"));

        theme.setLooping(true);
        theme.play();
    }

    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {
        batch.begin();
        batch.draw(titleScreenTexture, 0, 0);
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
        titleScreenTexture.dispose();
        if (!theme.isPlaying()) theme.dispose();
    }
}
