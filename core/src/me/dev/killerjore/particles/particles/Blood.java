package me.dev.killerjore.particles.particles;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import me.dev.killerjore.particles.Particle;
import me.dev.killerjore.textureRepository.particleTextureRepo.ParticleTextureRepo;

public class Blood extends Particle {


    public Blood(float x, float y, int width, int height) {
        super(x, y, width, height);
    }

    @Override
    public void initializeComponents() {
        frames = new TextureRegion[12];

        int index = 0;
        int index1 = 0;

        System.out.println(ParticleTextureRepo.getInstance().getTextures().length);
        for (int i = 0; i < 12; i++) {
            frames[i] = ParticleTextureRepo.getInstance().getTextures()[index][index1];

            if (index == 3) {
                index = 0;
                index1++;
            }
            index++;
        }
    }
}
