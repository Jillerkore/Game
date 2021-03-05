package me.dev.killerjore.animations.spellAnimation;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import me.dev.killerjore.textureRepository.TextureManager;
import me.dev.killerjore.textureRepository.projectileTextures.FireballTextureRepo;

public class SpellAnimation {

    private Animation<TextureRegion> up;
    private Animation<TextureRegion> down;
    private Animation<TextureRegion> left;
    private Animation<TextureRegion> right;

    public Animation<TextureRegion> getUpAnimation() {
        return up;
    }

    public Animation<TextureRegion> getDownAnimation() {
        return down;
    }

    public Animation<TextureRegion> getLeftAnimation() {
        return left;
    }

    public Animation<TextureRegion> getRightAnimation() {
        return right;
    }

    private final float frameDuration = 1/32f;

    public SpellAnimation() {

        TextureRegion[] upFrame, downFrame, leftFrame, rightFrame;

        FireballTextureRepo manager = TextureManager.getInstance().fireballTextureRepo;

        upFrame = new TextureRegion[9];
        downFrame = new TextureRegion[9];
        leftFrame = new TextureRegion[9];
        rightFrame = new TextureRegion[9];

        for (int i = 0; i < 9; i++) {
            leftFrame[i] = manager.getFireballHorizontalFrame()[1][i];
            rightFrame[i] = manager.getFireballHorizontalFrame()[0][i];
            upFrame[i] = manager.getFireballVerticalFrame()[i][1];
            downFrame[i] = manager.getFireballVerticalFrame()[i][0];
        }

        left = new Animation<>(frameDuration, leftFrame);
        right = new Animation<>(frameDuration, rightFrame);
        up = new Animation<>(frameDuration, upFrame);
        down = new Animation<>(frameDuration, downFrame);

    }

}
