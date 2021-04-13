package me.dev.killerjore.input;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector3;
import me.dev.killerjore.entities.EntityManager;
import me.dev.killerjore.save.Save;
import me.dev.killerjore.screens.GameScreen;
import me.dev.killerjore.ui.UIManager;
import me.dev.killerjore.ui.inventory.Inventory;

import java.io.IOException;

public class InputHandler implements InputProcessor {

    private EntityManager entities;
    private GameScreen screen;
    private Vector3 screenCoords;

    public InputHandler(GameScreen screen) {
        entities = EntityManager.getInstance();
        screenCoords = new Vector3();
        this.screen = screen;
    }

    @Override
    public boolean keyDown(int keycode) {
        if (Input.Keys.F5 == keycode) {
            try {
                Save.getInstance().save();
            } catch (IOException e) {
                e.printStackTrace();
                Gdx.app.exit();
            }
        }
        if (Input.Keys.SHIFT_LEFT == keycode) {
            entities.getPlayer().togglePicking();
        }
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
        if (keycode == Input.Keys.SHIFT_LEFT)
            entities.getPlayer().togglePicking();
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
        screenCoords.set(screenX, screenY, 0);
        screenCoords = screen.getUiCamera().unproject(screenCoords);
        UIManager.getInstance().clickEvent((int)screenCoords.x, (int)screenCoords.y, button);
        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        screenCoords.set(screenX, screenY, 0);
        screenCoords = screen.getUiCamera().unproject(screenCoords);
        UIManager.getInstance().unClickEvent((int)screenCoords.x, (int)screenCoords.y, button);
        return true;
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
