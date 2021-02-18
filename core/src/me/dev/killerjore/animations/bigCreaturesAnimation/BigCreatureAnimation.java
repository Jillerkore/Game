package me.dev.killerjore.animations.bigCreaturesAnimation;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import lombok.*;
import me.dev.killerjore.textureRepository.TextureRepo;

public class BigCreatureAnimation {

    TextureRegion[][] textures;

    private TextureRegion[] upFrame, leftFrame, downFrame, rightFrame;
    private TextureRegion[] upAttackFrame, leftAttackFrame, downAttackFrame, rightAttackFrame;

    private TextureRegion[] deathFrame;

    private Animation<TextureRegion> upAnimation, downAnimation, leftAnimation, rightAnimation;
    private Animation<TextureRegion> upAttackAnimation, downAttackAnimation, leftAttackAnimation, rightAttackAnimation;
    private Animation<TextureRegion> deathAnimation;

    private Animation<TextureRegion> currentAttackAnimation;
    private TextureRegion currentFrame;

    private static final float frameDurationWalk = 1/7f;
    private static final float frameDurationAttack = 1/11f;
    private static final float frameDurationDeath = 20;

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

            upFrame[i - 1] = textures[8][i];
            leftFrame[i - 1] = textures[9][i];
            downFrame[i - 1] = textures[10][i];
            rightFrame[i - 1] = textures[11][i];

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

    public void setUpAnimation(Animation<TextureRegion> upAnimation) {
        this.upAnimation = upAnimation;
    }

    public Animation<TextureRegion> getDownAnimation() {
        return downAnimation;
    }

    public void setDownAnimation(Animation<TextureRegion> downAnimation) {
        this.downAnimation = downAnimation;
    }

    public Animation<TextureRegion> getLeftAnimation() {
        return leftAnimation;
    }

    public void setLeftAnimation(Animation<TextureRegion> leftAnimation) {
        this.leftAnimation = leftAnimation;
    }

    public Animation<TextureRegion> getRightAnimation() {
        return rightAnimation;
    }

    public void setRightAnimation(Animation<TextureRegion> rightAnimation) {
        this.rightAnimation = rightAnimation;
    }

    public Animation<TextureRegion> getUpAttackAnimation() {
        return upAttackAnimation;
    }

    public void setUpAttackAnimation(Animation<TextureRegion> upAttackAnimation) {
        this.upAttackAnimation = upAttackAnimation;
    }

    public Animation<TextureRegion> getDownAttackAnimation() {
        return downAttackAnimation;
    }

    public void setDownAttackAnimation(Animation<TextureRegion> downAttackAnimation) {
        this.downAttackAnimation = downAttackAnimation;
    }

    public Animation<TextureRegion> getLeftAttackAnimation() {
        return leftAttackAnimation;
    }

    public void setLeftAttackAnimation(Animation<TextureRegion> leftAttackAnimation) {
        this.leftAttackAnimation = leftAttackAnimation;
    }

    public Animation<TextureRegion> getRightAttackAnimation() {
        return rightAttackAnimation;
    }

    public void setRightAttackAnimation(Animation<TextureRegion> rightAttackAnimation) {
        this.rightAttackAnimation = rightAttackAnimation;
    }

    public Animation<TextureRegion> getDeathAnimation() {
        return deathAnimation;
    }

    public void setDeathAnimation(Animation<TextureRegion> deathAnimation) {
        this.deathAnimation = deathAnimation;
    }

    public Animation<TextureRegion> getCurrentAttackAnimation() {
        return currentAttackAnimation;
    }

    public void setCurrentAttackAnimation(Animation<TextureRegion> currentAttackAnimation) {
        this.currentAttackAnimation = currentAttackAnimation;
    }

    public TextureRegion getCurrentFrame() {
        return currentFrame;
    }

    public void setCurrentFrame(TextureRegion currentFrame) {
        this.currentFrame = currentFrame;
    }
}
