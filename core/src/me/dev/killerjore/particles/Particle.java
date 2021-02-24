package me.dev.killerjore.particles;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public abstract class Particle extends ParticleAbstract {

    private float elapsedTime;

    private boolean isActive;

    public boolean isActive() { return isActive; }

    protected Animation<TextureRegion> particleAnimation;
    protected TextureRegion[] frames;

    public Particle(float x, float y, int width, int height) {
        super(x, y, width, height);

        initializeComponents();

        particleAnimation = new Animation<>(1/70f, frames);

        ParticleManager.getInstance().getParticles().add(this);

        isActive = true;

    }

    public abstract void initializeComponents();

    public void render(Batch batch) {
        if (!isActive) return;
        elapsedTime += Gdx.graphics.getDeltaTime();
        if (particleAnimation.isAnimationFinished(elapsedTime)) {
            isActive = false;
        }
        batch.draw(particleAnimation.getKeyFrame(elapsedTime, true), getX(), getY(), getWidth(), getHeight());
    }

}
