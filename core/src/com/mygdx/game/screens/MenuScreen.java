package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.*;
import com.mygdx.game.audio.Audio;
import com.mygdx.game.progress.Progress;

/**
 * Created by Kate on 18.04.2017.
 */

public class MenuScreen extends State {
    private Animation1 buttonAnimation;
    Rectangle buttonStart,offButton;
    Texture mainmenu, welcomeTexture,clicktheButtonTexture,toContinueTexture, animation, off;


    OrthographicCamera camera;


    public MenuScreen(ScreenManager manager  ) {
        super(manager);
        create();
    }
    private void create(){

        buttonStart = new Rectangle(Const.MAIN_BUTTON_X,Const.MAIN_BUTTON_Y,Const.MAIN_BUTTON_WIDTH,Const.MAIN_BUTTON_HEIGHT);

        mainmenu = new Texture("mainmenu1.jpg");

        welcomeTexture = new Texture("welc.png");
        clicktheButtonTexture = new Texture("click.png");
        toContinueTexture = new Texture("continue.png");

        animation = new Texture("list1_startButton1.png");
        buttonAnimation = new Animation1(new TextureRegion(animation),Const.COUNT_TEXTURE_IN_ANIMATION,Const.ANIMATION_TIME);

        off = new Texture("off.png");
        offButton = new Rectangle(Const.OFF_BUTTON_X,Const.OFF_BUTTON_Y,off.getWidth(),off.getHeight());
        camera = new OrthographicCamera();
        camera.setToOrtho(false, Const.SCREEN_WIDTH, Const.SCREEN_HEIGHT);
        Audio.setVolume_background(Const.VOLUME_MAIN);

        Audio.play_background();

    }

    @Override
    public void handleInput(int x, int y) {

            if (buttonStart.contains(x, Const.SCREEN_HEIGHT - y)) {
                manager.push(new SecondMenuScreen(manager));
            }
            if (offButton.contains(x,Const.SCREEN_HEIGHT - y)) {
                manager.pop();
            }
        }


    @Override
    public void update(float dt) {
        buttonAnimation.update(dt);
    }

    @Override
    public void render(SpriteBatch spriteBatch) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        // camera.update();
        spriteBatch.begin();
        spriteBatch.draw(mainmenu, 0, 0);
        spriteBatch.draw(welcomeTexture,Const.WELCOME_TEXT_X,Const.WELCOME_TEXT_Y);
        spriteBatch.draw(clicktheButtonTexture,Const.CLICK_TEXT_X,Const.CLICK_TEXT_Y);
        spriteBatch.draw(toContinueTexture,Const.TO_CONTINUE_TEXT_X,Const.TO_CONTINUE_TEXT_Y);
        spriteBatch.draw(buttonAnimation.getFrame(), buttonStart.getX(), buttonStart.getY());
        spriteBatch.draw(off,offButton.getX(),offButton.getY());
        spriteBatch.end();
    }

    @Override
    public void dispose() {
        welcomeTexture.dispose();
        clicktheButtonTexture.dispose();
        toContinueTexture.dispose();
        animation.dispose();
        mainmenu.dispose();
        off.dispose();
    }
}
