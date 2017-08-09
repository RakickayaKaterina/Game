package com.mygdx.game.progress;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.ByteArray;
import com.badlogic.gdx.utils.StringBuilder;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by Kate on 31.05.2017.
 */

public class Progress {
    static Preferences prefs = Gdx.app.getPreferences("My Preferences");
    public static boolean[] item = new boolean[12];

    public static void addProgress(){
        for(int i = 0; i< item.length; i++){
            if(!item[i]){
                item[i]=true;
                break;
            }
        }
    }
    public static void save(){
        StringBuilder file = new StringBuilder();
        for(int i = 0; i< item.length; i++){
            if(item[i]){
               file.append(1);
            }
            else file.append(0);
        }
            prefs.putString("saved",file.toString());
            prefs.flush();

    }
    public static void load(){

        String s = prefs.getString("saved");
        for(int i = 0; i< s.length(); i++){
            if(s.charAt(i) == '1'){
                item[i] = true;
            }
            else item[i] = false;
        }
    }

}
