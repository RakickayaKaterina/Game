package com.mygdx.game.itemScreen;

import com.badlogic.gdx.graphics.Texture;

/**
 * Created by Kate on 27.04.2017.
 */

public class StoreTexture {
   public Texture greenApple, redApple; // apples
   public Texture one, two, three, four, five, six, seven, eight, nine, ten;
    public Texture one1, two1, three1, four1, five1, six1, seven1, eight1, nine1, ten1;

    public Texture chiken, cock, small_chicken;
    public Texture sheep, small_sheep;

    public Texture goose, small_goose;

    public Texture cow, horse, dog, gobber, pig;

    public Texture caterpillar;
    public StoreTexture(){
        chiken        = new Texture("zoo/chiken.png");
        cock          = new Texture("zoo/cock.png");
        small_chicken = new Texture("zoo/small_chiken.png");

        sheep         = new Texture("zoo/sheep.png");
        small_sheep   = new Texture("zoo/small_sheep.png");

        goose         = new Texture("zoo/goose.png");
        small_goose   = new Texture("zoo/small_goose.png");

        cow           = new Texture("zoo/cow.png");
        horse         = new Texture("zoo/horse.png");
        dog           = new Texture("zoo/dog.png");
        gobber        = new Texture("zoo/gobbler.png");
        pig           = new Texture("zoo/pig.png");

        caterpillar = new Texture("caterpillar.png");
        greenApple = new Texture("a1small.png");
        redApple = new Texture("a2small.png");
        one = new Texture("1.png");
        two= new Texture("2.png");
        three = new Texture("3.png");
        four = new Texture("4.png");
        five = new Texture("5.png");
        six = new Texture("6.png");
        seven = new Texture("7.png");
        eight = new Texture("8.png");
        nine = new Texture("9.png");
        ten = new Texture("10.png");

        one1 = new Texture("1s.png");
        two1= new Texture("2s.png");
        three1 = new Texture("3s.png");
        four1 = new Texture("4s.png");
        five1 = new Texture("5s.png");
        six1 = new Texture("6s.png");
        seven1 = new Texture("7s.png");
        eight1 = new Texture("8s.png");
        nine1 = new Texture("9s.png");
        ten1 = new Texture("10s.png");
    }
    public Texture getTextureNum(int num){
        switch (num){
            case 1: return one;
            case 2: return two;
            case 3: return three;
            case 4: return four;
            case 5: return five;
            case 6: return six;
            case 7: return seven;
            case 8: return eight;
            case 9: return nine;
            case 10:return ten;
        }
        return  null;
    }
    public Texture getTextureNum1(int num){
        switch (num){
            case 1: return one1;
            case 2: return two1;
            case 3: return three1;
            case 4: return four1;
            case 5: return five1;
            case 6: return six1;
            case 7: return seven1;
            case 8: return eight1;
            case 9: return nine1;
            case 10:return ten1;

        }
        return  null;
    }
    public void dispose(){
        greenApple.dispose();
        redApple.dispose();
        one.dispose();
        two.dispose();
        three.dispose();
        four.dispose();
        five.dispose();
        six.dispose();
        seven.dispose();
        eight.dispose();
        nine.dispose();
        ten.dispose();
        one1.dispose();
        two1.dispose();
        three1.dispose();
        four1.dispose();
        five1.dispose();
        six1.dispose();
        seven1.dispose();
        eight1.dispose();
        nine1.dispose();
        ten1.dispose();
        chiken .dispose();
        cock.dispose();
        small_chicken.dispose();
        sheep.dispose();
        small_sheep.dispose();
        goose.dispose();
        small_goose.dispose();
        cow.dispose();
        horse.dispose();
        dog.dispose();
        gobber.dispose();
        pig.dispose();
    }

}
