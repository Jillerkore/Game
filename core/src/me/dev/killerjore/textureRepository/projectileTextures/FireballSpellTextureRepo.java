package me.dev.killerjore.textureRepository.projectileTextures;

import me.dev.killerjore.textureRepository.TextureRepo;

public class FireballSpellTextureRepo extends TextureRepo {

    private static FireballSpellTextureRepo instance;

    public static FireballSpellTextureRepo getInstance() {
        if (instance == null) instance = new FireballSpellTextureRepo();
        return instance;
    }

    private FireballSpellTextureRepo() {
        super("sprites/projectiles/spells/fireballEffect.png", 64, 64 + 16);
    }
}
