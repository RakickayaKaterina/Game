package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.audio.Audio;
import com.mygdx.game.interfaces.IExit;
import com.mygdx.game.progress.Progress;
import com.mygdx.game.screens.MenuScreen;
import com.mygdx.game.screens.ScreenManager;

public class MyGdxGame extends ApplicationAdapter implements IExit {
	private SpriteBatch batch;
	private ScreenManager screenManager;
	 //Texture img;
	private BitmapFont font;
	private HandlerInput hanler;
	Progress progress;


	@Override
	public void create () {
		batch = new SpriteBatch();
		//this.setScreen(new MenuScreen(this));
		font = new BitmapFont();
		screenManager = new ScreenManager(this);
		hanler = new HandlerInput(screenManager);
		screenManager.push(new MenuScreen(screenManager));
		Gdx.input.setInputProcessor(hanler);
		Gdx.input.setCatchBackKey(true);

	}

	@Override
	public void render () {
		super.render();
		if(screenManager.isReady()) {
			Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
			screenManager.update(Gdx.graphics.getDeltaTime());
			screenManager.render(batch);
		}
	}
	public void exit(){
		Audio.stop_background();
		//Audio.dispose();
		Progress.save();
		Gdx.app.exit();
	}
	@Override
	public void dispose () {
		batch.dispose();
		Audio.dispose();
	//	img.dispose();
	}

	@Override
	public void pause() {
		super.pause();
		Progress.save();
	}

	@Override
	public void resume() {
		super.resume();
		Progress.load();
	}
}
