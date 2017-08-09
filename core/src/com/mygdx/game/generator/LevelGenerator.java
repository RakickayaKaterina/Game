package com.mygdx.game.generator;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.Const;
import com.mygdx.game.itemScreen.Apple;
import com.mygdx.game.itemScreen.Container;
import com.mygdx.game.itemScreen.Number;
import com.mygdx.game.itemScreen.StoreTexture;
import com.mygdx.game.screens.GladeScreen;
import com.mygdx.game.screens.Level1Screen;
import com.mygdx.game.screens.Level2Screen;
import com.mygdx.game.screens.LevelScreen;
import com.mygdx.game.screens.ScreenManager;

/**
 * Created by Kate on 27.04.2017.
 */

public class LevelGenerator {
    private StoreTexture storeTexture;
    public LevelGenerator(StoreTexture storeTexture) {
       this.storeTexture = storeTexture;

    }
    public LevelScreen generateLevelScreen(ScreenManager scr, int countStar){
        int count = MathUtils.random(1,10);
        Array<Apple> apples = addApples(count);
        Array<Number> numbers = getNumbers(count);
        return new LevelScreen(scr, apples, numbers,this, countStar);
    }
    public Level2Screen generateLevel2Screen(ScreenManager scr, int countStar){
        int count_1 = MathUtils.random(2,10);
        int count_2 = MathUtils.random(1,count_1-1);
        Array<Container> example = getExample(count_1, count_2, false);
        Array<Apple> greenApples = addApples2(count_1);
        Array<Number> numbers = getNumbers(count_1-count_2);
        return new Level2Screen(scr, greenApples, numbers,example,this, countStar, count_2);
    }
    public Level1Screen generateLevel1Screen(ScreenManager scr, int countStar){
        int count_1 = MathUtils.random(1,9);
        int count_2 = MathUtils.random(1,10-count_1);
        Array<Container> example = getExample(count_1, count_2, true);
        Array<Apple> greenApples = getFirstHeap(count_1);
        Array<Apple> redApples = getSecondHeap(count_2);
        Array<Number> numbers = getNumbers(count_1+count_2);
        return new Level1Screen(scr, greenApples,redApples, numbers,example,this, countStar);
    }
    public Array<Container> getExample(int op1, int op2, boolean isAdd ){
        Array<Container> container = new Array<Container>();

        //Первая цифра
        Texture texture_op1 = storeTexture.getTextureNum1(op1);
        Rectangle rectangle_op1 = new Rectangle(Const.OP_1_X, Const.OP_1_Y, texture_op1.getWidth(), texture_op1.getHeight());
        //Знак
        Texture sign = null;
        Rectangle rectangle_sign = null;
        container.add(new Container(texture_op1, rectangle_op1));
        if(isAdd){
            sign = new Texture("plus.png");
            rectangle_sign = new Rectangle(Const.PLUS_X, Const.PLUS_Y, sign.getWidth(), sign.getHeight());

        }
        else {
            sign = new Texture("minus.png");
            rectangle_sign = new Rectangle(Const.MINUS_X, Const.MINYS_Y, sign.getWidth(), sign.getHeight());
        }
        container.add(new Container(sign, rectangle_sign));
        //Вторая цифра
        Texture texture_op2 = storeTexture.getTextureNum1(op2);
        Rectangle rectangle_op2 = new Rectangle(Const.OP_2_X, Const.OP_2_Y, texture_op2.getWidth(), texture_op2.getHeight());
        container.add(new Container(texture_op2, rectangle_op2));

        //Равно
        Texture equ = new Texture("equals.png");
        Rectangle rectangle_equ = new Rectangle(Const.EGUALS_X, Const.EQUALS_Y, equ.getWidth(), equ.getHeight());
        container.add(new Container(equ, rectangle_equ));

        //Вопрос
        Texture quest = new Texture("question.png");
        Rectangle quest_rec = new Rectangle(Const.QUESTION_X, Const.QUESTION_Y, quest.getWidth(), quest.getHeight());
        container.add(new Container(quest, quest_rec));

        return container;
    }
    public GladeScreen generateGladeScreen(ScreenManager scr){
        Array<Container> array = new Array<Container>();

        Texture gobber = storeTexture.gobber;
        Rectangle gobberRec = new Rectangle(70, 90, gobber.getWidth(), gobber.getHeight());
        array.add(new Container(gobber, gobberRec));

        Texture chiken = storeTexture.chiken;
        Rectangle chikenRec = new Rectangle(500, 20, chiken.getWidth(), chiken.getHeight());
        array.add(new Container(chiken, chikenRec));

        Texture small_chiken = storeTexture.small_chicken;
        Rectangle small_chikenRec = new Rectangle(420, 20, small_chiken.getWidth(), small_chiken.getHeight());
        array.add(new Container(small_chiken, small_chikenRec));

        Texture cock = storeTexture.cock;
        Rectangle cock_small_chikenRec = new Rectangle(220, 20, small_chiken.getWidth(), small_chiken.getHeight());
        array.add(new Container(cock, cock_small_chikenRec));

        Texture dog = storeTexture.dog;
        Rectangle dog_Rec = new Rectangle(900, 380, dog.getWidth(), dog.getHeight());
        array.add(new Container(dog, dog_Rec));

        Texture cow = storeTexture.cow;
        Rectangle cow_Rec = new Rectangle(10, 350, cow.getWidth(), cow.getHeight());
        array.add(new Container(cow, cow_Rec));

        Texture horse = storeTexture.horse;
        Rectangle horse_Rec = new Rectangle(250, 340, horse.getWidth(), horse.getHeight());
        array.add(new Container(horse, horse_Rec));

        Texture goose = storeTexture.goose;
        Rectangle goose_Rec = new Rectangle(800, 20, goose.getWidth(), goose.getHeight());
        array.add(new Container(goose, goose_Rec));

        Texture small_goose = storeTexture.small_goose;
        Rectangle small_goose_Rec = new Rectangle(1000, 20, goose.getWidth(), goose.getHeight());
        array.add(new Container(small_goose, small_goose_Rec));

        Texture sheep = storeTexture.sheep;
        Rectangle sheep_Rec = new Rectangle(800, 210, sheep.getWidth(), sheep.getHeight());
        array.add(new Container(sheep,sheep_Rec));

        Texture small_sheep = storeTexture.small_sheep;
        Rectangle small_sheep_rec = new Rectangle(710, 210, small_sheep.getWidth(), small_sheep.getHeight());
        array.add(new Container(small_sheep,small_sheep_rec));

        Texture pig = storeTexture.pig;
        Rectangle pig_rec = new Rectangle(350, 200, pig.getWidth(), pig.getHeight());
        array.add(new Container(pig,pig_rec));

        return new GladeScreen(array, scr,this);
    }
    private Array<Apple> addApples(int count){
        Array<Apple> apples = new Array<Apple>();
            for (int i = 0; i < count && i < 10; i++) {
                Rectangle rec = new Rectangle(100 * i + 60, 375, 98, 115);
                Apple e = new Apple(storeTexture.greenApple, storeTexture.redApple, rec);
                apples.add(e);
            }

        return apples;
    }
    private int[] nix(int[] array) {
        int count = MathUtils.random(10, 10000);
        for (int i = 0; i<count; i++){
            int index1 = MathUtils.random(0, array.length - 1);
            int index2 = MathUtils.random(0,array.length - 1);
            int temp = array[index1];
            array[index1] = array[index2];
            array[index2] = temp;
        }
        return  array;
    }
    private Array<Number> getNumbers(int count){
        Array<Number> numbers = new Array<Number>();
        int[] array = new int[Const.COUNT_OF_NUMBERS_ON_LEVEL];
        switch (count) {
            case 1: array[0] = 1; array[1] = 2; array[2]=3; array[3] = 4; break;
            case 10: array[0] = 7; array[1] = 8; array[2]=9; array[3] = 10; break;
            default:
                array[0] = count-1; array[1] = count; array[2]=count+1;
                array[3] = (count - 2) > 0 ? count - 2: count + 2;
        }
        array = nix(array);
        for(int i = 0; i<array.length; i++){
            boolean pl = count == array[i];
            Texture texture = texture(array[i]);
            Rectangle rectangle = new Rectangle(200 + i*250, 30, texture.getWidth() , texture.getHeight());
            Number number = new Number(texture, pl, rectangle);
            numbers.add(number);

        }
        return numbers;

        // x = 90 y= 20 x =  y =

    }
    private Texture texture(int number){
        switch (number){
            case 1: return storeTexture.one;
            case 2: return storeTexture.two;
            case 3: return storeTexture.three;
            case 4: return storeTexture.four;
            case 5: return storeTexture.five;
            case 6: return storeTexture.six;
            case 7: return storeTexture.seven;
            case 8: return storeTexture.eight;
            case 9: return storeTexture.nine;
            case 10: return storeTexture.ten;
        }
        return null;
    }

    private Array<Apple> getFirstHeap(int count){

        Array<Apple> apples = new Array<Apple>();
        int i = 0;
        int j = 0;
        for (; i < count && i<5; i++) {
            Rectangle rec1 = new Rectangle(90 * i  + 200, 255, 74, 86);
            //Rectangle rec2 = new Rectangle(130 * j + 10, 305, 98, 115);
            Apple ap1 = new Apple(storeTexture.greenApple, storeTexture.redApple, rec1);
           // Apple ap2 = new Apple(storeTexture.greenApple, storeTexture.redApple, rec2);
            apples.add(ap1);
            //apples.add(ap2);
        }
        count -= i;
        for (i = 0; i < count; i++) {
            Rectangle rec1 = new Rectangle(90 * i  + 200, 375, 74, 86);
            //Rectangle rec2 = new Rectangle(130 * j + 10, 305, 98, 115);
            Apple ap1 = new Apple(storeTexture.greenApple, storeTexture.redApple, rec1);
            // Apple ap2 = new Apple(storeTexture.greenApple, storeTexture.redApple, rec2);
            apples.add(ap1);
            //apples.add(ap2);
        }
        return apples;
    }

    private  Array<Apple> getSecondHeap(int count){

            Array<Apple> apples = new Array<Apple>();
            int i = 0;
            int j = 0;
            for (; i < count && i<5; i++) {
                Rectangle rec1 = new Rectangle(90 * (-i)  + 1000, 255, 74, 86);
                //Rectangle rec2 = new Rectangle(130 * j + 10, 305, 98, 115);
                Apple ap1 = new Apple(storeTexture.redApple,storeTexture.greenApple ,rec1);
                // Apple ap2 = new Apple(storeTexture.greenApple, storeTexture.redApple, rec2);
                apples.add(ap1);
                //apples.add(ap2);
            }
            count -= i;
            for (i = 0; i < count; i++) {
                Rectangle rec1 = new Rectangle(90 * (-i) + 1000, 375, 74, 86);
                //Rectangle rec2 = new Rectangle(130 * j + 10, 305, 98, 115);
                Apple ap1 = new Apple(storeTexture.redApple,storeTexture.greenApple ,rec1);
                // Apple ap2 = new Apple(storeTexture.greenApple, storeTexture.redApple, rec2);
                apples.add(ap1);
                //apples.add(ap2);
            }
            return apples;
    }

    private Array<Apple> addApples2(int count){
        Array<Apple> apples = new Array<Apple>();
        for (int i = 0; i < count && i < 10; i++) {
            Rectangle rec = new Rectangle(100 * i + 60, 325, 98, 115);
            Apple e = new Apple(storeTexture.redApple, storeTexture.caterpillar, rec);
            apples.add(e);
        }

        return apples;
    }


    @Override
    protected void finalize() throws Throwable {
        storeTexture.dispose();
        super.finalize();

    }
}
