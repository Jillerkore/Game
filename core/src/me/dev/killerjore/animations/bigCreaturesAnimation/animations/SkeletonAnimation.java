package me.dev.killerjore.animations.bigCreaturesAnimation.animations;

import me.dev.killerjore.animations.bigCreaturesAnimation.BigCreatureAnimation;
import me.dev.killerjore.textureRepository.entityTextures.SkeletonTextureRepo;

public class SkeletonAnimation extends BigCreatureAnimation {

    public SkeletonAnimation() {
        super(SkeletonTextureRepo.getInstance());
    }

}
