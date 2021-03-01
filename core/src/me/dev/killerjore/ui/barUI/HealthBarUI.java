package me.dev.killerjore.ui.barUI;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import me.dev.killerjore.entities.EntityManager;
import me.dev.killerjore.entities.creature.attacker.movable.Player;

public class HealthBarUI extends BarUI{

    public HealthBarUI() {
        super(5, Gdx.graphics.getHeight() - 35, 5 + 15, Gdx.graphics.getHeight() - 35 + 6, new Texture("sprites/ui/middleHealthBox.png"), new Texture("sprites/ui/emptyBar.png"));
    }

    @Override
    public void render(SpriteBatch batch) {

        Player player = EntityManager.getInstance().getPlayer();

        batch.draw(emptyBar, x, y);

        float x = this.barPosX;

        float healthToPercent = (float) player.getHealth() / player.getMaxHealth() * 100;
        int divideTo20 = Math.round(healthToPercent / 5);

        for (int i = 0; i < divideTo20; i++) {
            batch.draw(fillerBar, x, barPosY);
            x+= fillerBarWidth;
        }

        font.draw(batch, "Health: " + (int) healthToPercent + "%", barPosX + 2, barPosY + 18);
    }
}
