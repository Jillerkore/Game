package me.dev.killerjore.textureRepository.uiTextureRepo;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import me.dev.killerjore.textureRepository.TextureRepo;

public class UITextureRepo  extends TextureRepo {

    public final TextureRegion settingsClicked, settingsUnclicked, journalClicked, journalUnclicked;

    public UITextureRepo() {
        super("sprites/ui/settingsJournalAsset.png", 46, 46);
        settingsClicked = getTextures()[1][0];
        settingsUnclicked = getTextures()[0][0];
        journalClicked = getTextures()[1][1];
        journalUnclicked = getTextures()[0][1];
    }

    @Override
    public void dispose() {
        settingsClicked.getTexture().dispose();
    }
}
