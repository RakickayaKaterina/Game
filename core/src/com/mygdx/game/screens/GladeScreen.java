package com.mygdx.game.screens;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.Const;
import com.mygdx.game.audio.Audio;
import com.mygdx.game.generator.LevelGenerator;
import com.mygdx.game.itemScreen.Container;
import com.mygdx.game.progress.Progress;

/**
 * Created by Kate on 31.04.2017.
 */

public class GladeScreen extends State{

    Texture glade_background,back;
    Rectangle backrec;
    LevelGenerator generator;
    Array<Container> containers;
    public  GladeScreen(Array<Container> containers, ScreenManager manager, LevelGenerator generator){
        super(manager);
        this.generator = generator;
        glade_background = new Texture("gladeBackground.png");
        back = new Texture("back_1.png");
        backrec = new Rectangle(Const.RECTANGLE_BACK_X,Const.RECTANGLE_BACK_Y,Const.RECTANGLE_BACK_WIDTH,Const.RECTANGLE_BACK_HEIGHT);
        this.containers = containers;
    }
    @Override
    public void handleInput(int x, int y) {
        if (backrec.contains(x, Const.SCREEN_HEIGHT - y)) {
            manager.pop();
            Audio.setVolume_background(Const.VOLUME_MAIN);
            Audio.stopSound();
        }
    }

    @Override
    public void update(float dt) {

    }

    @Override
    public void render(SpriteBatch spriteBatch) {
        spriteBatch.begin();
        spriteBatch.draw(glade_background,0,0);
        spriteBatch.draw(back,backrec.getX(),backrec.getY());
        for(int i = 0; i<Progress.item.length; i++){
            if(Progress.item[i]){
                Container a = containers.get(i);
                Texture texture = a.getTexture();
                Rectangle rectangle = a.getRectangle();
                spriteBatch.draw(texture, rectangle.getX(), rectangle.getY(), texture.getWidth(), texture.getWidth());
            }
        }
        spriteBatch.end();


    }

    @Override
    public void dispose() {
        glade_background.dispose();
        back.dispose();
    }
}
