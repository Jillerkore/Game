package me.dev.killerjore.animations.bigCreaturesAnimation;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import me.dev.killerjore.textureRepository.TextureRepo;

public class BigCreatureAnimation {

    TextureRegion[][] textures;

    private TextureRegion[] upFrame, leftFrame, downFrame, rightFrame;
    private TextureRegion[] upAttackFrame, leftAttackFrame, downAttackFrame, rightAttackFrame;

    private TextureRegion[] deathFrame;

    private Animation<TextureRegion> upAnimation, downAnimation, leftAnimation, rightAnimation;
    private Animation<TextureRegion> upAttackAnimation, downAttackAnimation, leftAttackAnimation, rightAttackAnimation;
    private Animation<TextureRegion> deathAnimation;

    private TextureRegion currentFrame;

    private static final float frameDurationWalk = 1/7f;
    private static final float frameDurationAttack = 1/7f;
    private static final float frameDurationDeath = 1;

    private boolean playedDeathAnimationOnce = false;

    public BigCreatureAnimation(TextureRepo repo) {
        textures = repo.getTextures();
        init();
    }

    private void init() {

        upFrame = new TextureRegion[8];
        downFrame = new TextureRegion[8];
        leftFrame = new TextureRegion[8];
        rightFrame = new TextureRegion[8];

        upAttackFrame = new TextureRegion[6];
        downAttackFrame = new TextureRegion[6];
        leftAttackFrame = new TextureRegion[6];
        rightAttackFrame = new TextureRegion[6];

        deathFrame = new TextureRegion[6];

        for (int i = 1; i < 9; i++) {

            upFrame[i-1] = textures[8][i];
            leftFrame[i-1] = textures[9][i];
            downFrame[i-1] = textures[10][i];
            rightFrame[i-1] = textures[11][i];

        }

        for (int i = 0; i < 6; i++) {
            upAttackFrame[i] = textures[12][i];
            leftAttackFrame[i] = textures[13][i];
            downAttackFrame[i] = textures[14][i];
            rightAttackFrame[i] = textures[15][i];

            deathFrame[i] = textures[20][i];
        }

        upAnimation = new Animation<>(frameDurationWalk, upFrame);
        downAnimation = new Animation<>(frameDurationWalk, downFrame);
        leftAnimation = new Animation<>(frameDurationWalk, leftFrame);
        rightAnimation = new Animation<>(frameDurationWalk, rightFrame);

        upAttackAnimation = new Animation<>(frameDurationAttack, upAttackFrame);
        downAttackAnimation = new Animation<>(frameDurationAttack, downAttackFrame);
        leftAttackAnimation = new Animation<>(frameDurationAttack, leftAttackFrame);
        rightAttackAnimation = new Animation<>(frameDurationAttack, rightAttackFrame);

        deathAnimation = new Animation<>(frameDurationDeath, deathFrame);
    }

    public Animation<TextureRegion> getUpAnimation() {
        return upAnimation;
    }
    public Animation<TextureRegion> getDownAnimation() {
        return downAnimation;
    }
    public Animation<TextureRegion> getLeftAnimation() {
        return leftAnimation;
    }
    public Animation<TextureRegion> getRightAnimation() {
        return rightAnimation;
    }

    public Animation<TextureRegion> getUpAttackAnimation() { return upAttackAnimation; }
    public Animation<TextureRegion> getDownAttackAnimation() { return downAttackAnimation; }
    public Animation<TextureRegion> getLeftAttackAnimation() { return leftAttackAnimation; }
    public Animation<TextureRegion> getRightAttackAnimation() { return rightAttackAnimation; }

    public Animation<TextureRegion> getDeathAnimation() { return deathAnimation; }

    public void setCurrentFrame(TextureRegion frame) {
        this.currentFrame = frame;
    }
    public TextureRegion getCurrentFrame() {
        return currentFrame;
    }


}
