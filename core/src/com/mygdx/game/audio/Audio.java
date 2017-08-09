package com.mygdx.game.audio;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.files.FileHandle;


/**
 * Created by Kate on 28.04.2017.
 */

public class Audio {
    private static Sound one = Gdx.audio.newSound(Gdx.files.internal("audio/1.mp3"));
    private static Sound two = Gdx.audio.newSound(Gdx.files.internal("audio/2.mp3"));
    private static Sound three = Gdx.audio.newSound(Gdx.files.internal("audio/3.mp3"));
    private static Sound four = Gdx.audio.newSound(Gdx.files.internal("audio/4.mp3"));
    private static Sound five = Gdx.audio.newSound(Gdx.files.internal("audio/5.mp3"));
    private static Sound six = Gdx.audio.newSound(Gdx.files.internal("audio/6.mp3"));
    private static Sound seven = Gdx.audio.newSound(Gdx.files.internal("audio/7.mp3"));
    private static Sound eight = Gdx.audio.newSound(Gdx.files.internal("audio/8.mp3"));
    private static Sound nine = Gdx.audio.newSound(Gdx.files.internal("audio/9.mp3"));
    private static Sound ten = Gdx.audio.newSound(Gdx.files.internal("audio/10.mp3"));
    private static Music eat_apple = Gdx.audio.newMusic(Gdx.files.internal("audio/eat_apple.mp3"));
    private static Sound prev = null;

    private static Music main_sound = Gdx.audio.newMusic(Gdx.files.internal("audio/main_sound.mp3"));

    private  static  Sound good_emotion1 = Gdx.audio.newSound(Gdx.files.internal("audio/великолепно.mp3"));
    private  static  Sound good_emotion2 = Gdx.audio.newSound(Gdx.files.internal("audio/замечательно.mp3"));
    private  static  Sound good_emotion3 = Gdx.audio.newSound(Gdx.files.internal("audio/правильно1.mp3"));
    private  static  Sound good_emotion4 = Gdx.audio.newSound(Gdx.files.internal("audio/у_тебя_получилось.mp3"));

    private  static  Sound bad_emotion1 = Gdx.audio.newSound(Gdx.files.internal("audio/нет1.mp3"));
    private  static  Sound bad_emotion2 = Gdx.audio.newSound(Gdx.files.internal("audio/повтори_снова1.mp3"));
    private  static  Sound bad_emotion3 = Gdx.audio.newSound(Gdx.files.internal("audio/попробуй_ещё1.mp3"));

    private  static  Sound task1 = Gdx.audio.newSound(Gdx.files.internal("audio/сосчитай_яблоки.mp3"));
    private  static  Sound task2 = Gdx.audio.newSound(Gdx.files.internal("audio/реши_пример.mp3"));

    public static void playNumber(int number){
        stopSound();
        switch (number){
            case 2: prev =  two;    break;
            case 1: prev =  one  ;  break;
            case 3: prev =  three;  break;
            case 4: prev =  four ;  break;
            case 5: prev =  five ;  break;
            case 6: prev =  six  ;  break;
            case 7: prev =  seven;  break;
            case 8: prev =  eight;  break;
            case 9: prev =  nine ;  break;
            case 10:prev =   ten ;  break;
        }
        prev.play();
    }
    public static  void playBadEmotion(int number){
        prev.stop();
        switch (number){
            case 1: prev = bad_emotion1; break;
            case 2: prev = bad_emotion2; break;
            case 3: prev = bad_emotion3; break;
        }
        prev.play();
    }
    public static  void playGoodEmotion(int number){
        prev.stop();
        switch (number){
            case 1: prev = good_emotion1; break;
            case 2: prev = good_emotion2; break;
            case 3: prev = good_emotion3; break;
            case 4: prev = good_emotion4; break;
        }
        prev.play();
    }

    public static void stopSound(){
        if(prev!=null) prev.stop();

    }
    public static void play_background(){
        main_sound.setLooping(true);
        main_sound.play();

    }
    public static void stop_background(){
        main_sound.stop();
    }
    public static void setVolume_background(float volume){
        main_sound.setVolume(volume);
    }
    public  static void play_task1(){
        task1.play();
        prev = task1;
    }
    public static void play_eat(){
        stopSound();
        eat_apple.setVolume(0.2f);
        eat_apple.play();
    }
    public static void play_task2(){
        task2.play();
        prev = task2;
    }
    public static void dispose(){
        two.dispose();
        one.dispose();
        three.dispose();
        four.dispose();
        five.dispose();
        six.dispose();
        seven.dispose();
        eight.dispose();
        nine.dispose();
        ten.dispose();
        main_sound.dispose();
        good_emotion1.dispose();
        good_emotion2.dispose();
        good_emotion3.dispose();
        good_emotion4.dispose();
        bad_emotion1.dispose();
        bad_emotion2.dispose();
        bad_emotion3.dispose();
        task1.dispose();
        task2.dispose();
    }
}
