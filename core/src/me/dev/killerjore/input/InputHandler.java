package me.dev.killerjore.input;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import me.dev.killerjore.entities.EntityManager;
import me.dev.killerjore.ui.inventory.Inventory;
import me.dev.killerjore.screens.GameScreen;

public class InputHandler implements InputProcessor {

    private EntityManager entities;
    private GameScreen screen;

    public InputHandler(GameScreen screen) {
        entities = EntityManager.getInstance();
        Gdx.input.setInputProcessor(this);
        this.screen = screen;
    }

    @Override
    public boolean keyDown(int keycode) {
        if (Input.Keys.Y == keycode) {
            entities.getPlayer().toggleCameraUpdate();
        }
        if (Input.Keys.E == keycode) {
            Inventory.getInstance().toggleInventory();
        }
        if (Input.Keys.C == keycode) {
            entities.getPlayer().setCasting(true);
        }
        else if (Input.Keys.SPACE == keycode) {
            entities.getPlayer().setAttacking(true);
        }

        if (Input.Keys.W == keycode) {
            entities.getPlayer().walkingUp = true;
        } else if (Input.Keys.A == keycode) {
            entities.getPlayer().walkingLeft = true;
        } else if (Input.Keys.S == keycode) {
            entities.getPlayer().walkingDown = true;
        } else if (Input.Keys.D == keycode) {
            entities.getPlayer().walkingRight = true;
        }
        return true;
    }
    @Override
    public boolean keyUp (int keycode){
        if (keycode == Input.Keys.W)
            entities.getPlayer().walkingUp = false;
        if (keycode == Input.Keys.A)
            entities.getPlayer().walkingLeft = false;
        if (keycode == Input.Keys.S)
            entities.getPlayer().walkingDown = false;
        if (keycode == Input.Keys.D)
            entities.getPlayer().walkingRight = false;

        return true;
    }
    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        if (button == Input.Buttons.LEFT) {
            Inventory.getInstance().isLeftClicking = true;
        }
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
