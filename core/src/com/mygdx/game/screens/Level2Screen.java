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
import com.mygdx.game.itemScreen.Container;
import com.mygdx.game.itemScreen.Number;
import com.mygdx.game.progress.Progress;

/**
 * Created by Kate on 31.04.2017.
 */

public class Level2Screen extends State {

    Texture background,  back;
    Rectangle backrec;
    private Array<Apple> greenApples;
    private Array<Number> numbers;
    Array<Container> example;
    int count;
    int needEat;
    Texture star;
    int countStars;
    private LevelGenerator generator;
    boolean pl;
    float time;



    public Level2Screen(ScreenManager manager, Array<Apple> greenApples, Array<Number> numbers, Array<Container> example,   LevelGenerator generator, int countStars, int needEat) {
        super(manager);
        background = new Texture("LevelBackground.jpg");
        back = new Texture("back_1.png");
        this.greenApples = greenApples;
        this.numbers = numbers;
        backrec = new Rectangle(Const.RECTANGLE_BACK_X,Const.RECTANGLE_BACK_Y, Const.RECTANGLE_BACK_WIDTH,Const.RECTANGLE_BACK_HEIGHT);
        this.generator = generator;
        this.example = example;
        this.countStars = countStars;
        star = new Texture("star.png");
        Audio.setVolume_background(Const.VOLUME_LEVEL);
        if(countStars==0)
            Audio.play_task2();
        pl = false;
        time = 0;
        this.needEat = needEat;
    }

    public Array<Apple> getGreenApples() {
        return greenApples;
    }


    public Array<Number> getNumbers() {
        return numbers;
    }





    @Override
    public void handleInput(int x, int y) {

        if (backrec.contains(x, Const.SCREEN_HEIGHT - y)) {
            manager.pop();
            Audio.setVolume_background(Const.VOLUME_MAIN);
            Audio.stopSound();
        }
        if (numbers != null)
            for (Number number : numbers
                    ) {
                number.isAnswer(x, Const.SCREEN_HEIGHT - y, new IAction() {
                    @Override
                    public void actionAnswer() {
                        Audio.playGoodEmotion(MathUtils.random(1, Const.COUNT_OF_GOOD_EMOTION));
                        if (++countStars >= Const.COUNT_OF_STARS) {
                            Progress.addProgress();
                            manager.set(generator.generateGladeScreen(manager));
                        } else
                            manager.set(generator.generateLevel2Screen(manager, countStars));
                     //   Audio.stopSound();
                    }

                    @Override
                    public void actionNotAnswer() {
                        Audio.playBadEmotion(MathUtils.random(1, Const.COUNT_OF_BAD_EMOTION));
                    }
                });

            }
        pl = true;
    }

    @Override
    public void update(float dt) {
        if(pl ) {
            time+=dt;
            if(time>1) {
                for (int i = 0; i < greenApples.size && i<needEat; i++) {
                    if (!greenApples.get(i).setChecked()) continue;
                    else {
                        Audio.play_eat();
                        break;
                    }
                }
                time = 0;
            }
        }



    }

    @Override
    public void render(SpriteBatch spriteBatch) {
        spriteBatch.begin();
        spriteBatch.draw(background,0,0);
        spriteBatch.draw(back,backrec.getX(),backrec.getY());
        if(example!=null){
            for (Container cont: example
                    ) {
                spriteBatch.draw(cont.getTexture(), cont.getRectangle().getX(), cont.getRectangle().getY());
            }
        }
        if(greenApples!=null)
            for (Apple apple: greenApples
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
