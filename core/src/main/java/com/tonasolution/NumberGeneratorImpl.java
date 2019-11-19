package com.tonasolution;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;


public class NumberGeneratorImpl implements NumberGenerator {
    // == fields ==
    private final Random random = new Random();

    @Autowired
    @MaxNumber
    private int maxNumber;

    @Autowired
    @MinNumber
    private int minNumber;

    // == public methods ==

    @Override
    public int next() {
        if (minNumber > maxNumber ) throw new IllegalArgumentException("MinNumber has to be less than MaxNumber");
        return random.nextInt(maxNumber - minNumber ) + minNumber;
    }

    @Override
    public int getMaxNumber() {
        return maxNumber;
    }

    @Override
    public int getMinNumber() {
        return minNumber;
    }
}
