package com.mygdx.game.screens;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.interfaces.IExit;
import com.mygdx.game.progress.Progress;

import java.util.Stack;

/**
 * Created by Kate on 26.04.2017.
 */

public class ScreenManager {
    private Stack<State> manager;
    private IExit game;

    public  ScreenManager(IExit game){
        this.game = game;
        manager = new Stack<State>();
    }
    public boolean isReady(){
        return !manager.empty();
    }
    public void push(State state){
        manager.push(state);
    }
    public void pop(){
        manager.pop().dispose();
        if(manager.empty()) {
            Progress.save();
            game.exit();
        }
    }
    public void set(State state){
        manager.pop().dispose();
        this.push(state);
    }
    public void update(float dt){
        manager.peek().update(dt);
    }
    public void render(SpriteBatch sb){


        manager.peek().render(sb);
    }
    public void eventTouch(int x, int y){
        manager.peek().handleInput(x, y);
    }
}
