package me.dev.killerjore.textureRepository.entityTextures;

import me.dev.killerjore.textureRepository.TextureRepo;

public class SkeletonTextureRepo extends TextureRepo {

    private static SkeletonTextureRepo repo;
    public static SkeletonTextureRepo getInstance() { if (repo == null) repo = new SkeletonTextureRepo(); return repo; }

    private SkeletonTextureRepo() {
        super("sprites/spriteSheets/skeletonSheet.png", 64, 64);
    }
}
