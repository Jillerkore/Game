package me.dev.killerjore.textureRepository.particleTextureRepo;

import me.dev.killerjore.textureRepository.TextureRepo;

public class ParticleTextureRepo extends TextureRepo {

    private static ParticleTextureRepo instance;

    public static ParticleTextureRepo getInstance() {
        if (instance == null) instance = new ParticleTextureRepo();
        return instance;
    }

    private ParticleTextureRepo() {
        super("sprites/particles/bloodParticle1.png", 512, 512);
    }
}
