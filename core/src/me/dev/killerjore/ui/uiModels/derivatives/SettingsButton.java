package me.dev.killerjore.ui.uiModels.derivatives;

import me.dev.killerjore.textureRepository.TextureManager;
import me.dev.killerjore.ui.uiModels.UIButton;

public class SettingsButton extends UIButton {

    private boolean clicked = false;

    public SettingsButton(int x, int y, int width, int height) {
        super(x, y, width, height, TextureManager.getInstance().uiTextureRepo.settingsClicked, TextureManager.getInstance().uiTextureRepo.settingsUnclicked);
    }

    @Override
    public void onClickEvent(int mx, int my) {
        if (isHovering(mx, my)) {
            textureToRender = this.clickedTexture;
            clicked = true;
        }
    }

    @Override
    public void onUnclickEvent(int mx, int my) {
        if (isHovering(mx, my) || clicked)
            textureToRender = unclickedTexture;
    }
}
