package me.dev.killerjore.animations.bigCreaturesAnimation.animations;

import me.dev.killerjore.animations.bigCreaturesAnimation.BigCreatureAnimation;
import me.dev.killerjore.textureRepository.TextureManager;
import me.dev.killerjore.textureRepository.entityTextures.PlayerTextureRepo;

public class PlayerAnimation extends BigCreatureAnimation {

    public PlayerAnimation() {
        super(TextureManager.getInstance().playerTextureRepo);
    }
}
