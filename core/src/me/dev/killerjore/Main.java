package me.dev.killerjore;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Cursor;
import com.badlogic.gdx.graphics.Pixmap;
import me.dev.killerjore.screens.GameScreen;

public class Main extends Game {

	@Override
	public void create () {

		// Screen initialization
		setScreen(new GameScreen(this));

		// Cursor initialization
		Pixmap map = new Pixmap(Gdx.files.internal("sprites/ui/mousePointer.png"));
		Cursor cursor = Gdx.graphics.newCursor(map, 0,0);
		Gdx.graphics.setCursor(cursor);
		map.dispose();
	}

	@Override
	public void render() {
		super.render();
	}
	
	@Override
	public void dispose () {
		super.dispose();
	}
}
