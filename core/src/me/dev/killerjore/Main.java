package me.dev.killerjore;

import com.badlogic.gdx.Game;
import me.dev.killerjore.screens.GameScreen;

public class Main extends Game {

	@Override
	public void create () {
		setScreen(new GameScreen(this));
	}

	@Override
	public void render () {
		super.render();
	}
	
	@Override
	public void dispose () {
		super.dispose();
	}
}
