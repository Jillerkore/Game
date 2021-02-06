package me.dev.killerjore.animations.bigCreaturesAnimation.animations;

import me.dev.killerjore.animations.bigCreaturesAnimation.BigCreatureAnimation;
import me.dev.killerjore.textureRepository.PlayerTextureRepo;

public class PlayerAnimation extends BigCreatureAnimation {

    public PlayerAnimation() {
        super(PlayerTextureRepo.getInstance());
    }
}
