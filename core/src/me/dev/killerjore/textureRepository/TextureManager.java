package me.dev.killerjore.textureRepository;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import me.dev.killerjore.textureRepository.entityTextures.PlayerTextureRepo;
import me.dev.killerjore.textureRepository.entityTextures.SkeletonTextureRepo;
import me.dev.killerjore.textureRepository.particleTextureRepo.BloodParticleTextureRepo;
import me.dev.killerjore.textureRepository.projectileTextures.FireballTextureRepo;

public class TextureManager {

    private static TextureManager instance;

    public TextureRepo playerTextureRepo;
    public TextureRepo skeletonTextureRepo;
    public TextureRepo particleTextureRepo;
    public FireballTextureRepo fireballTextureRepo;

    public static TextureManager getInstance() {
        if (instance == null) instance = new TextureManager();
        return instance;
    }

    private AssetManager assetManager;

    public AssetManager getAssetManager() { return assetManager; }

    private TextureManager() {

        System.out.println("Asset manager");
        assetManager = new AssetManager();

        assetManager.load("sprites/particles/bloodParticle1.png", Texture.class);
        assetManager.load("sprites/particles/bloodParticle2.png", Texture.class);
        assetManager.load("sprites/particles/bloodParticle3.png", Texture.class);

        assetManager.load("sprites/spriteSheets/characterSheet.png", Texture.class);
        assetManager.load("sprites/spriteSheets/skeletonSheet.png", Texture.class);

        assetManager.load("sprites/ui/emptyBar.png", Texture.class);
        assetManager.load("sprites/ui/hotBar.png", Texture.class);
        assetManager.load("sprites/ui/middleHealthBox.png", Texture.class);
        assetManager.load("sprites/ui/middleStaminaBox.png", Texture.class);
        assetManager.load("sprites/ui/titleScreen.png", Texture.class);
        assetManager.load("sprites/ui/inventorySlots.png", Texture.class);

        assetManager.load("sprites/projectiles/spells/fireballDownUp.png", Texture.class);
        assetManager.load("sprites/projectiles/spells/fireballLeftRight.png", Texture.class);



        System.out.println("Finish loading");
        assetManager.finishLoading();
    }

    public void initTextureRepos() {
        playerTextureRepo = new PlayerTextureRepo();
        skeletonTextureRepo = new SkeletonTextureRepo();
        particleTextureRepo = new BloodParticleTextureRepo();
        fireballTextureRepo = new FireballTextureRepo();
    }

    public void dispose() {
        playerTextureRepo.dispose();
        skeletonTextureRepo.dispose();
        particleTextureRepo.dispose();
        assetManager.dispose();
    }

}
