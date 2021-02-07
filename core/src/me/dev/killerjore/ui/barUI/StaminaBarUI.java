package me.dev.killerjore.ui.barUI;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import me.dev.killerjore.entities.EntityManager;
import me.dev.killerjore.entities.creature.creatures.Player;

public class StaminaBarUI extends BarUI{

    public StaminaBarUI() {
        super(5, Gdx.graphics.getHeight() - 40 - 30, 5 + 15, Gdx.graphics.getHeight() - 40 - 20 - 6, new Texture("sprites/ui/middleStaminaBox.png"), new Texture("sprites/ui/emptyBar.png"));
    }

    @Override
    public void render(SpriteBatch batch) {

        Player player = EntityManager.getInstance().getPlayer();

        batch.draw(emptyBar, x, y);

        float x = this.barPosX;

        float staminaToPercent = (float) player.getProperties().getStamina() / player.getProperties().getMaxStamina() * 100;
        int divideTo20 = Math.round(staminaToPercent / 5);

        for (int i = 0; i < divideTo20; i++) {
            batch.draw(fillerBar, x, barPosY);
            x+= fillerBarWidth;
        }
        font.draw(batch, "Stamina: " + (int) staminaToPercent + "%", barPosX + 1, barPosY + 18);
    }

}
