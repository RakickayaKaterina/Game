package com.mygdx.game.itemScreen;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.interfaces.IAction;

/**
 * Created by Kate on 27.04.2017.
 */

public class Number {
    private Texture texture;
    private boolean isAnswer;
    private Rectangle rectangle;

    public Number(Texture texture, boolean isAnswer, Rectangle rectangle) {
        this.texture = texture;
        this.isAnswer = isAnswer;
        this.rectangle = rectangle;
    }

    public void isAnswer(int x, int y, IAction action) {
        if(rectangle.contains(x,y)){
            if(isAnswer) action.actionAnswer();
            else action.actionNotAnswer();
        }
    }
    public Texture getTexture() {
        return texture;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }
}
