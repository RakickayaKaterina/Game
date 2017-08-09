package com.mygdx.game.screens;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.Const;
import com.mygdx.game.audio.Audio;
import com.mygdx.game.generator.LevelGenerator;
import com.mygdx.game.itemScreen.StoreTexture;
import com.mygdx.game.progress.Progress;

/**
 * Created by Kate on 18.04.2017.
 */

public class SecondMenuScreen extends State {
    Texture backgroundTexture, back, glade;
    Texture iconTexture1;
    Texture iconTexture2;
    Texture iconTexture3;
    Texture text1, text2,text3;
    private LevelGenerator generator;

    //Array<Rectangle> icons;
    Rectangle icon1, icon2, icon3, backrec, gladeRect;
    OrthographicCamera camera;
    public SecondMenuScreen(ScreenManager manager) {
        super(manager);
        create();
        generator = new LevelGenerator(new StoreTexture());
    }

    private  void  create(){
        Progress.load();
        backgroundTexture = new Texture("mainmenu2.png");
        back = new Texture("back_1.png");
        glade = new Texture("glade.png");
        iconTexture1 = new Texture("icon1.png");
        iconTexture2 = new Texture("icon2.png");
        iconTexture3 = new Texture("icon3.png");
        icon1 = new Rectangle(Const.ICON1_X,Const.ICON1_Y,iconTexture1.getWidth(),iconTexture1.getHeight());
        icon2 = new Rectangle(Const.ICON2_X,Const.ICON2_Y,iconTexture2.getWidth(),iconTexture2.getHeight());
        icon3 = new Rectangle(Const.ICON3_X,Const.ICON3_Y,iconTexture3.getWidth(),iconTexture3.getHeight());

        backrec = new Rectangle(Const.RECTANGLE_BACK_X,Const.RECTANGLE_BACK_Y,Const.RECTANGLE_BACK_WIDTH,Const.RECTANGLE_BACK_HEIGHT);

        gladeRect = new Rectangle(Const.RECTANGLE_GLADE_X,Const.RECTANGLE_GLADE_Y,Const.RECTANGLE_GLADE_WIDTH,Const.RECTANGLE_GLADE_HEIGHT);

        text1 = new Texture("text1.png");
        text2 = new Texture("text2.png");
        text3 = new Texture("text3.png");


        camera = new OrthographicCamera();
        camera.setToOrtho(false, Const.SCREEN_WIDTH, Const.SCREEN_HEIGHT);


    }

    @Override
    public void handleInput(int x, int y) {

            if (backrec.contains(x, Const.SCREEN_HEIGHT - y)) manager.pop();
            if (icon1.contains(x, Const.SCREEN_HEIGHT - y)){
                LevelScreen screen = generator.generateLevelScreen(manager, 0);
                manager.push(screen);
            }

             if (icon2.contains(x, Const.SCREEN_HEIGHT - y)){
            Level1Screen screen = generator.generateLevel1Screen(manager, 0);
            manager.push(screen);
            }
            if(icon3.contains(x, Const.SCREEN_HEIGHT-y)){
                Level2Screen screen = generator.generateLevel2Screen(manager, 0);
                manager.push(screen);
            }
             if (gladeRect.contains(x, Const.SCREEN_HEIGHT - y)){
            GladeScreen screen = generator.generateGladeScreen(manager);
            manager.push(screen);
              }

    }
    Object obj;
    @Override
    public void update(float dt) {


    }

    @Override
    public void render(SpriteBatch spriteBatch) {
        spriteBatch.begin();
        spriteBatch.draw(backgroundTexture, 0, 0);

        spriteBatch.draw(back,backrec.getX(),backrec.getY());
        spriteBatch.draw(glade,gladeRect.getX(),gladeRect.getY());
        spriteBatch.draw(text1,Const.TEXT1_X,Const.TEXT1_Y);
        spriteBatch.draw(text2,Const.TEXT2_X,Const.TEXT2_Y);
        spriteBatch.draw(text3,Const.TEXT3_X,Const.TEXT3_Y);

        spriteBatch.draw(iconTexture1, icon1.getX(), icon1.getY());
        spriteBatch.draw(iconTexture2, icon2.getX(), icon2.getY());
        spriteBatch.draw(iconTexture3, icon3.getX(), icon3.getY());
        spriteBatch.end();
    }

    @Override
    public void dispose() {
        glade.dispose();
        backgroundTexture.dispose();
        iconTexture1.dispose();
        iconTexture2.dispose();
        iconTexture3.dispose();
        text1.dispose();
        text2.dispose();
        text3.dispose();
        back.dispose();
    }
}
