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
		//Gdx.gl.glClearColor(1, 0, 0, 1);
		//Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		super.render();
	}
	
	@Override
	public void dispose () {
		super.dispose();
	}
}
