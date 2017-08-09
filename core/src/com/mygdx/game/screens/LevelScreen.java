package com.mygdx.game.screens;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.Const;
import com.mygdx.game.audio.Audio;
import com.mygdx.game.generator.LevelGenerator;
import com.mygdx.game.interfaces.IAction;
import com.mygdx.game.itemScreen.Apple;
import com.mygdx.game.itemScreen.Number;
import com.mygdx.game.itemScreen.Star;
import com.mygdx.game.progress.Progress;

/**
 * Created by Kate on 18.04.2017.
 */

public class LevelScreen extends State {


    IAction action;
    Texture background,  back;
    Rectangle backrec;
    Texture star;
    private Array<Apple> apples;
    private Array<Number> numbers;
    int count;
    int countStars;
    private LevelGenerator generator;

    public LevelScreen(ScreenManager manager, Array<Apple> apples, Array<Number> numbers, LevelGenerator generator, int countStars ) {
        super(manager);
        background = new Texture("LevelBackground.jpg");
        back = new Texture("back_1.png");
        this.apples = apples;
        this.numbers = numbers;
        backrec = new Rectangle(Const.RECTANGLE_BACK_X,Const.RECTANGLE_BACK_Y, Const.RECTANGLE_BACK_WIDTH,Const.RECTANGLE_BACK_HEIGHT);
        count = 0;
        this.countStars = countStars;
        this.generator = generator;
        Audio.setVolume_background(Const.VOLUME_LEVEL);
        if(countStars==0)
            Audio.play_task1();
        star = new Texture("star.png");



    }

    public void setApples(Array<Apple> apples) {
        this.apples = apples;
    }

    public void setNumbers(Array<Number> numbers) {
        this.numbers = numbers;
    }

    @Override
    public void handleInput(int x, int y) {

            if (backrec.contains(x, Const.SCREEN_HEIGHT - y)) {
                manager.pop();
                Audio.setVolume_background(Const.VOLUME_MAIN);
                Audio.stopSound();
            }
        if(apples!=null)
            for (Apple apple : apples
                    ) {
                if(apple.setChecked(x, Const.SCREEN_HEIGHT - y)){
                    if(++count<=Const.COUNT_OF_APPLES) Audio.playNumber(count);
                }
            }
        if(numbers!=null)
        for (Number number : numbers
                ) {
            number.isAnswer(x, Const.SCREEN_HEIGHT - y, new IAction() {
                @Override
                public void actionAnswer() {
                    Audio.playGoodEmotion(MathUtils.random(1,Const.COUNT_OF_GOOD_EMOTION));
                    if(++countStars >= Const.COUNT_OF_STARS)
                    {
                       Progress.addProgress();
                        manager.set(generator.generateGladeScreen(manager));
                    }
                    else
                        manager.set(generator.generateLevelScreen(manager, countStars));
      //              Audio.stopSound();

                }

                @Override
                public void actionNotAnswer() {
                    Audio.playBadEmotion(MathUtils.random(1,Const.COUNT_OF_BAD_EMOTION));
                }
            });
        }

    }

    @Override
    public void update(float dt) {

    }

    @Override
    public void render(SpriteBatch spriteBatch) {
        spriteBatch.begin();
        spriteBatch.draw(background,0,0);
        spriteBatch.draw(back,backrec.getX(),backrec.getY());
        if(apples!=null)
        for (Apple apple: apples
                ) {
            spriteBatch.draw(apple.getTexture(), apple.getRectangle().getX(), apple.getRectangle().getY());
        }
        if(numbers!=null)
        for (Number number: numbers
                ) {
            spriteBatch.draw(number.getTexture(), number.getRectangle().getX(), number.getRectangle().getY());
        }
        for(int i = 0; i<countStars; i++){
            spriteBatch.draw(star, Const.STARS_X+star.getWidth()*i,Const.STARS_Y);
        }
        spriteBatch.end();
    }




    @Override
    public void dispose() {
        back.dispose();
        background.dispose();
    }
}
