package com.unongmilk.crafting.random;

import java.util.Random;

public class Rd {
    public static int roll(int min, int max) {
        return new Random().nextInt(max - min) + min;
    }
}
