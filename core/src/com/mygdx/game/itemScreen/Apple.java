package com.mygdx.game.itemScreen;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

/**
 * Created by Kate on 18.04.2017.
 */

public class Apple {
    private Texture greenApple;
    private Texture redApple;
    private Rectangle rectangle;
    private boolean isChecked;
    public Apple(Texture a, Texture b, Rectangle rectangle){
        greenApple = a;//;new Texture("mqdefault.jpg");
        redApple = b;//;new Texture("mqdefault.jpg");new Texture("ogryzok2.jpg");
        this.rectangle = rectangle;
        isChecked = false;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public Texture getTexture(){
        if(!isChecked) return greenApple;
        return redApple;
    }
    public  boolean setChecked(float x, float y){
        if(!isChecked) {
            isChecked = rectangle.contains(x, y);
            return isChecked;
        }
        return false;
    }

    public  boolean setChecked(){
        if(!isChecked) {
            isChecked = true;
            return isChecked;
        }
        return false;
    }
    public void dispose(){
        greenApple.dispose();
        redApple.dispose();
    }
}
