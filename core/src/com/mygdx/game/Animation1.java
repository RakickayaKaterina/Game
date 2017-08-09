package com.mygdx.game;


import com.badlogic.gdx.graphics.g2d.TextureRegion;
import  com.badlogic.gdx.utils.Array;

/**
 * Created by Kate on 18.04.2017.
 */

public class Animation1 {
    private Array<TextureRegion> frames;
    private float maxFrameTime;
    private  float currentFrameTime;
    private  int frameCount;
    private int frame;
    public Animation1(TextureRegion region, int frameCount, float cycleTime){
        frames = new Array<TextureRegion>();
        int frameWidth = region.getRegionWidth() / frameCount;
        for(int i=0;i<frameCount;i++){
            frames.add(new TextureRegion(region,i*frameWidth,0,frameWidth,region.getRegionHeight()));
        }
        this.frameCount = frameCount;
        maxFrameTime = cycleTime / frameCount;
        frame = 0;

    }
    public  void update(float dt){
        currentFrameTime +=dt;
        if(currentFrameTime > maxFrameTime){
            frame++;
            currentFrameTime = 0;
        }
        if(frame >= frameCount){
            frame = 0;

        }

    }
    public  TextureRegion getFrame(){
        return  frames.get(frame);
    }
}
