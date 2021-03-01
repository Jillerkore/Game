package me.dev.killerjore.animations.bigCreaturesAnimation;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import me.dev.killerjore.textureRepository.TextureRepo;

public class BigCreatureAnimation {

    TextureRegion[][] textures;

    private TextureRegion[] upFrame, leftFrame, downFrame, rightFrame;
    private TextureRegion[] upAttackFrame, leftAttackFrame, downAttackFrame, rightAttackFrame;
    private TextureRegion[] upCastFrame, downCastFrame, leftCastFrame, rightCastFrame;

    private TextureRegion[] deathFrame;

    private Animation<TextureRegion> upAnimation, downAnimation, leftAnimation, rightAnimation;
    private Animation<TextureRegion> upAttackAnimation, downAttackAnimation, leftAttackAnimation, rightAttackAnimation;
    private Animation<TextureRegion> upCastAnimation, downCastAnimation, leftCastAnimation, rightCastAnimation;
    private Animation<TextureRegion> deathAnimation;

    private Animation<TextureRegion> currentAttackAnimation;
    private Animation<TextureRegion> currentCastAnimation;
    private TextureRegion currentFrame;

    private static final float frameDurationWalk = 1/7f;
    private static final float frameDurationAttack = 1/15f;
    private static final float frameDurationDeath = 1/2f;
    private static final float frameDurationCast = 1/3;

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

        upCastFrame = new TextureRegion[7];
        leftCastFrame = new TextureRegion[7];
        downCastFrame = new TextureRegion[7];
        rightCastFrame = new TextureRegion[7];

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

        for (int i = 0; i < 7; i++) {
            upCastFrame[i] = textures[0][i];
            leftCastFrame[i] = textures[1][i];
            downCastFrame[i] = textures[2][i];
            rightCastFrame[i] = textures[3][i];
        }

        upAnimation = new Animation<>(frameDurationWalk, upFrame);
        downAnimation = new Animation<>(frameDurationWalk, downFrame);
        leftAnimation = new Animation<>(frameDurationWalk, leftFrame);
        rightAnimation = new Animation<>(frameDurationWalk, rightFrame);

        upAttackAnimation = new Animation<>(frameDurationAttack, upAttackFrame);
        downAttackAnimation = new Animation<>(frameDurationAttack, downAttackFrame);
        leftAttackAnimation = new Animation<>(frameDurationAttack, leftAttackFrame);
        rightAttackAnimation = new Animation<>(frameDurationAttack, rightAttackFrame);

        upCastAnimation = new Animation<>(frameDurationCast, upCastFrame);
        downCastAnimation = new Animation<>(frameDurationAttack, downCastFrame);
        leftCastAnimation = new Animation<>(frameDurationAttack, leftCastFrame);
        rightCastAnimation = new Animation<>(frameDurationAttack, rightCastFrame);

        deathAnimation = new Animation<>(frameDurationDeath, deathFrame);
    }

    public Animation<TextureRegion> getUpAnimation() { return upAnimation; }
    public Animation<TextureRegion> getDownAnimation() {
        return downAnimation;
    }
    public Animation<TextureRegion> getLeftAnimation() {
        return leftAnimation;
    }
    public Animation<TextureRegion> getRightAnimation() {
        return rightAnimation;
    }
    public Animation<TextureRegion> getUpAttackAnimation() {
        return upAttackAnimation;
    }
    public Animation<TextureRegion> getDownAttackAnimation() {
        return downAttackAnimation;
    }
    public Animation<TextureRegion> getLeftAttackAnimation() { return leftAttackAnimation; }
    public Animation<TextureRegion> getRightAttackAnimation() { return rightAttackAnimation; }
    public Animation<TextureRegion> getUpCastAnimation() { return upCastAnimation; }
    public Animation<TextureRegion> getDownCastAnimation() { return downCastAnimation; }
    public Animation<TextureRegion> getLeftCastAnimation() { return leftCastAnimation; }
    public Animation<TextureRegion> getRightCastAnimation() { return rightCastAnimation; }
    public Animation<TextureRegion> getDeathAnimation() { return deathAnimation; }


    public Animation<TextureRegion> getCurrentAttackAnimation() { return currentAttackAnimation; }
    public void setCurrentAttackAnimation(Animation<TextureRegion> currentAttackAnimation) { this.currentAttackAnimation = currentAttackAnimation; }
    public TextureRegion getCurrentFrame() { return currentFrame; }
    public Animation<TextureRegion> getCurrentCastAnimation() { return currentCastAnimation; }
    public void setCurrentCastAnimation(Animation<TextureRegion> currentCastAnimation) { this.currentCastAnimation = currentCastAnimation; }
    public void setCurrentFrame(TextureRegion currentFrame) { this.currentFrame = currentFrame; }
}
