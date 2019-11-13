package com.tonasolution;

public interface Game {
    int getNumber();

    int getGuess(int guess);

    int getSmallTest();

    int getBiggest();

    int getRemainingGuesses();

    void reset();

    void check();

    boolean isValidNumberRange();

    boolean isGameWon();

    boolean isGameLost();
}
