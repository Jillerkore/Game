package me.dev.killerjore.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import me.dev.killerjore.Main;
import me.dev.killerjore.ui.UIManager;
import me.dev.killerjore.entities.EntityManager;
import me.dev.killerjore.entities.creature.creatures.Player;
import me.dev.killerjore.entities.creature.creatures.Skeleton;
import me.dev.killerjore.input.InputHandler;
import me.dev.killerjore.world.WorldManager;

import java.util.ConcurrentModificationException;

public class GameScreen implements Screen {

    private Main main;

    private OrthographicCamera camera;
    private SpriteBatch uiSpriteBatch;

    public GameScreen(Main main) {

        uiSpriteBatch = new SpriteBatch();

        Gdx.graphics.setWindowedMode(32 * 21, 32 * 13);

        this.main = main;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 32 * 21, 32 * 13);
        camera.position.set(0, 0, 0);
        camera.update();

        // Temp player and skeleton objects, going to make their values parsed from files later and a saving system aswell :D
        Player player = new Player(23 * 32, 23 * 32, 64, 64, 25, 25, 20, 20, 20, 20, camera);
        Skeleton skeleton = new Skeleton(22 * 32, 19 * 32, 64, 64, 25, 25,20, 20, 20, 20, 70);
        EntityManager.getInstance().getStarterWorldEntityList().add(skeleton);
        EntityManager.getInstance().getStarterWorldEntityList().add(player);
        new InputHandler();
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);
        WorldManager.getInstance().getCurrentWorld().render(delta, camera);
        uiSpriteBatch.begin();
        UIManager.getInstance().render(uiSpriteBatch);
        uiSpriteBatch.end();

        EntityManager.getInstance().dispose();

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
        WorldManager.getInstance().getCurrentWorld().dispose();
        uiSpriteBatch.dispose();
        UIManager.getInstance().dispose();
    }
}
