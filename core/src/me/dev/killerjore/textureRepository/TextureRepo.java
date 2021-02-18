package me.dev.killerjore.textureRepository;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import lombok.Getter;

public class TextureRepo {

    private final TextureRegion[][] textures;

    public TextureRepo(String path, int spriteWidth, int spriteHeight) {
        textures = TextureRegion.split(new Texture(path), spriteWidth, spriteHeight);
    }

    public TextureRegion[][] getTextures() {
        return textures;
    }
}
