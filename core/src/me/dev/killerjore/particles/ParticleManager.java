package me.dev.killerjore.particles;

import com.badlogic.gdx.graphics.g2d.Batch;

import java.util.ArrayList;

public class ParticleManager {

    private static ParticleManager instance;

    public static ParticleManager getInstance() {
        if (instance == null) instance = new ParticleManager();
        return instance;
    }

    private ArrayList<Particle> particles;

    private ParticleManager() {
        particles = new ArrayList<>();
    }

    private void tick() {
        particles.removeIf(particle -> !particle.isActive());
    }

    public void render(Batch batch) {
        tick();
        particles.forEach((particle) -> particle.render(batch));
    }

    public ArrayList<Particle> getParticles() {
        return particles;
    }

}
