package me.dev.killerjore.entities.item;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import me.dev.killerjore.entities.Entity;
import me.dev.killerjore.entities.EntityManager;
import me.dev.killerjore.entities.item.items.Bone;
import me.dev.killerjore.entities.item.items.Medal;
import me.dev.killerjore.entities.item.items.SpellBook;
import me.dev.killerjore.entities.item.items.Weapon;
import me.dev.killerjore.ui.inventory.Inventory;

public abstract class Item extends Entity {

    private ItemState state;
    protected TextureRegion texture;
    protected int id;

    public ItemState getState() { return state; }
    public void setState(ItemState state) { this.state = state; }
    public int getId() { return id; }

    public TextureRegion getTexture() { return texture; }

    public Item(float x, float y, int width, int height, int collisionWidth, int collisionHeight) {
        super(x, y, width, height, collisionWidth, collisionHeight);
        initializeTexture();
        initializeId();
        updateCollisionBox();
        updatePos();
    }

    public abstract void initializeTexture();
    public abstract void initializeId();

    public void tick() {
        updateCollisionBox();
        updatePos();

        if (EntityManager.getInstance().getPlayer().isPicking() && EntityManager.getInstance().getPlayer().getCollisionBox().intersects(getCollisionBox())
                && state != ItemState.PICKED_UP) {
            EntityManager.getInstance().getPlayer().togglePicking();
            if (!Inventory.getInstance().isHotbarFull()) {
                state = ItemState.PICKED_UP;
                Inventory.getInstance().addItem(this, 2);
                EntityManager.getInstance().removeEntity(this);
            }else if (!Inventory.getInstance().isInventoryFull()) {
                state = ItemState.PICKED_UP;
                Inventory.getInstance().addItem(this, 1);
                EntityManager.getInstance().removeEntity(this);
            }
        }
    }

    public void render(Batch batch) {
        tick();
        if (state == ItemState.PICKED_UP) return;
        batch.draw(texture, getX(), getY());
    }

    private void updatePos() {
        setX(getOffsetX());
        setY(getOffsetY());
    }

    public static Item getItemById(int id, int x, int y) {
        Item item;
        switch (id) {
            case ItemId.BONE:
                item = new Bone(x, y, 32, 32, 32, 32);
                break;
            case ItemId.MEDAL:
                item = new Medal(x, y, 32, 32, 32, 32);
                break;
            case ItemId.SPELL_BOOK:
                item = new SpellBook(x, y, 32, 32, 32, 32);
                break;
            case ItemId.WEAPON:
                item = new Weapon(x, y, 32, 32, 32, 15);
                break;
            default:
                item = null;
        }
        return item;
    }
    public static Item getItemById(int id) {
        return getItemById(id, 0, 0);
    }
}
