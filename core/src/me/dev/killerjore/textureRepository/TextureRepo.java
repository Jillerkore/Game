package me.dev.killerjore.textureRepository;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import lombok.Getter;

import java.util.Arrays;

public class TextureRepo {

    private TextureRegion[][] textures;

    public TextureRepo(String path, int spriteWidth, int spriteHeight) {
        textures = TextureRegion.split(TextureManager.getInstance().getAssetManager().get(path, Texture.class), spriteWidth, spriteHeight);
    }

    public TextureRegion[][] getTextures() {
        return textures;
    }

    public void dispose() {
        textures = null;
    }
}
