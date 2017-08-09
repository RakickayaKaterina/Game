package com.mygdx.game;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;

/**
 * Created by Kate on 27.04.2017.
 */

public class HandlerInput implements InputProcessor {
// I/View: Key down dispatch to com.badlogic.gdx.backends.android.surfaceview.GLSurfaceView20{42374808 VFE..... .F...... 0,0-1280,720}, event = KeyEvent { action=ACTION_DOWN, keyCode=KEYCODE_BACK, scanCode=0, metaState=0, flags=0x48, repeatCount=0, eventTime=152985379, downTime=152985379, deviceId=-1, source=0x101 }
    com.mygdx.game.screens.ScreenManager screenManager;
    public HandlerInput(com.mygdx.game.screens.ScreenManager screenManager){
        this.screenManager = screenManager;

    }
    @Override
    public boolean keyDown(int keycode) {
        if(keycode == Input.Keys.BACK) {
            screenManager.pop();
            return true;
        }
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        screenManager.eventTouch(screenX, screenY);
        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
