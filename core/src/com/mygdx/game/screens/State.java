package com.mygdx.game.screens;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Disposable;
import com.mygdx.game.progress.Progress;

/**
 * Created by Kate on 26.04.2017.
 */

public abstract class State implements Disposable {
    protected ScreenManager manager;
    public State(ScreenManager manager){
        this.manager = manager;
    }
    public abstract void handleInput(int x, int y);
    public abstract void update(float dt);
    public abstract void render(SpriteBatch spriteBatch);
    public abstract void dispose();
}
