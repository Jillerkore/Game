package me.dev.killerjore.entities.item;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import me.dev.killerjore.entities.Entity;
import me.dev.killerjore.entities.EntityManager;
import me.dev.killerjore.ui.inventory.Inventory;
import me.dev.killerjore.utils.Coordinate;

public abstract class Item extends Entity {

    private ItemState state;
    protected TextureRegion texture;

    public ItemState getState() { return state; }
    public void setState(ItemState state) { this.state = state; }

    public Coordinate coordinate;

    public TextureRegion getTexture() { return texture; }

    public Item(float x, float y, int width, int height, int collisionWidth, int collisionHeight) {
        super(x, y, width, height, collisionWidth, collisionHeight);
        initializeTexture();
        updateCollisionBox();
        updatePos();

        coordinate = new Coordinate(0, 0);
    }

    public abstract void initializeTexture();

    public void tick() {
        updateCollisionBox();
        updatePos();

        if (EntityManager.getInstance().getPlayer().getCollisionBox().intersects(getCollisionBox())
                && state != ItemState.PICKED_UP
                && !Inventory.getInstance().isInventoryFull()) {
            state = ItemState.PICKED_UP;
            Inventory.getInstance().addItem(this, 1);
            EntityManager.getInstance().removeEntity(this);
        }
    }

    public void render(Batch batch) {
        tick();
        if (state == ItemState.PICKED_UP) return;
        batch.draw(texture, getX(), getY());
    }
    public void render(SpriteBatch batch) {
        tick();
        if (state == ItemState.IN_WORLD) {
            EntityManager.getInstance().addEntity(this);
            Inventory.getInstance().removeItem(this, 1);
        }
    }

    private void updatePos() {
        setX(getOffsetX());
        setY(getOffsetY());
    }
}
