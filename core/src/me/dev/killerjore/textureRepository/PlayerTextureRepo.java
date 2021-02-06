package me.dev.killerjore.textureRepository;

public class PlayerTextureRepo extends TextureRepo{

    private static PlayerTextureRepo repo;
    public static PlayerTextureRepo getInstance() { if (repo == null) repo = new PlayerTextureRepo(); return repo; }

    private PlayerTextureRepo() {
        super("sprites/spriteSheets/characterSheet.png", 64, 64);
    }

}
