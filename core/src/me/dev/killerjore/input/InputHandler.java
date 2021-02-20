package me.dev.killerjore.input;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import me.dev.killerjore.entities.EntityManager;
import me.dev.killerjore.utils.Direction;

public class InputHandler implements InputProcessor {

    private EntityManager entities;

    public InputHandler() {
        entities = EntityManager.getInstance();
        Gdx.input.setInputProcessor(this);
    }

    @Override
    public boolean keyDown(int keycode) {

        if (Input.Keys.Y == keycode) {
            entities.getPlayer().toggleCameraUpdate();
        }
        if (Input.Keys.SPACE == keycode) {
            entities.getPlayer().setAttacking(true);
        }else if (Input.Keys.W == keycode) {
            entities.getPlayer().setDirection(Direction.NORTH);
            entities.getPlayer().setWalking(true);
        } else if (Input.Keys.A == keycode) {
            entities.getPlayer().setDirection(Direction.WEST);
            entities.getPlayer().setWalking(true);
        } else if (Input.Keys.S == keycode) {
            entities.getPlayer().setDirection(Direction.SOUTH);
            entities.getPlayer().setWalking(true);
        } else if (Input.Keys.D == keycode) {
            entities.getPlayer().setDirection(Direction.EAST);
            entities.getPlayer().setWalking(true);
        }
        return true;
    }
    @Override
    public boolean keyUp ( int keycode){
        if (keycode == Input.Keys.W) entities.getPlayer().setWalking(false);
        if (keycode == Input.Keys.A) entities.getPlayer().setWalking(false);
        if (keycode == Input.Keys.S) entities.getPlayer().setWalking(false);
        if (keycode == Input.Keys.D) entities.getPlayer().setWalking(false);
        return true;
    }
    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        return false;
    }
}
