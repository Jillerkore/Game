package me.dev.killerjore.entities.item.items;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import me.dev.killerjore.entities.item.Item;
import me.dev.killerjore.entities.item.ItemId;
import me.dev.killerjore.entities.item.ItemType;
import me.dev.killerjore.textureRepository.TextureManager;

public class SpellBook extends Item {

    public SpellBook(float x, float y, int width, int height, int collisionWidth, int collisionHeight) {
        super(x, y, width, height, collisionWidth, collisionHeight);
    }

    @Override
    public void render(Batch batch, TiledMap tiledMap) {
        super.render(batch);
    }

    @Override
    public void initializeTexture() {
        texture = TextureManager.getInstance().itemTextureRepo.getTextures()[9][0];
    }

    @Override
    public void initializeId() {
        id = ItemId.SPELL_BOOK;
        itemType = ItemType.MISC;
    }
}
