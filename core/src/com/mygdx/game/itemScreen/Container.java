package com.mygdx.game.itemScreen;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

/**
 * Created by Kate on 31.04.2017.
 */

public class Container {
    private Texture texture;
    private Rectangle rectangle;

    public Container(Texture texture, Rectangle rectangle) {
        this.texture = texture;
        this.rectangle = rectangle;
    }

    public Texture getTexture() {
        return texture;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }
}
