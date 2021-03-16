package me.dev.killerjore.textureRepository.projectileTextures;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import me.dev.killerjore.textureRepository.TextureManager;

import java.util.Arrays;

public class FireballTextureRepo {

    private TextureRegion[][] fireBallUpDown;
    private  TextureRegion[][] fireballLeftRight;

    public TextureRegion[][] getFireballVerticalFrame() {
        return fireBallUpDown;
    }

    public TextureRegion[][] getFireballHorizontalFrame() {
        return fireballLeftRight;
    }

    public FireballTextureRepo() {
        init();
    }

    private void init() {
        fireBallUpDown = TextureRegion.split(TextureManager.getInstance().getAssetManager().get("sprites/projectiles/spells/fireballDownUp.png"), 32, 64);
        fireballLeftRight = TextureRegion.split(TextureManager.getInstance().getAssetManager().get("sprites/projectiles/spells/fireballLeftRight.png"), 64, 32);
    }

    public void dispose() {
        for (TextureRegion[] textureRegions : fireBallUpDown) {
            for (TextureRegion tr : textureRegions) {
                tr.getTexture().dispose();
            }
        }
        Arrays.stream(fireballLeftRight)
                .forEach(trArray -> Arrays.stream(trArray)
                        .forEach(tr -> tr
                                .getTexture().dispose()));
    }
}
