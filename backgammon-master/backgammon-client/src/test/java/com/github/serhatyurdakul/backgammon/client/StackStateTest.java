package com.github.serhatyurdakul.backgammon.client;

import GState.StackColor;
import GState.StackState;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StackStateTest {
    private static final int RANDOM_NUMBER_OF_CHECKERS = 5;
    private static final int ONE_CHECKER = 1;
    private static final int MORE_THAN_ONE_CHECKER = 2;

    @Test
    public void numberOfCheckersShouldDecreaseWhenWePop() throws Exception {
        // given
        StackState stackState = new StackState(StackColor.BLACK, RANDOM_NUMBER_OF_CHECKERS);

        // when
        stackState.pop();

        // then
        assertEquals(RANDOM_NUMBER_OF_CHECKERS - 1, stackState.getNumberOfCheckers());
    }

    @Test
    public void colorOfPointShouldNotChangeWhenWePopAndAtLeastOneCheckerLeft() throws Exception {
        // given
        StackColor initialStackColor = StackColor.BLACK;
        StackState stackState = new StackState(initialStackColor, MORE_THAN_ONE_CHECKER);

        // when
        stackState.pop();

        // then
        assertEquals(initialStackColor, stackState.getStackColor());
    }

    @Test
    public void pointShouldBeEmptyAfterPoppingLastChecker() throws Exception {
        // given
        StackState stackState = new StackState(StackColor.WHITE, ONE_CHECKER);

        // when
        stackState.pop();

        // then
        assertEquals(StackColor.EMPTY, stackState.getStackColor());
    }

    @Test
    public void numberOfCheckersShouldIncreaseWhenWePush() throws Exception {
        // given
        StackState stackState = new StackState(StackColor.BLACK, RANDOM_NUMBER_OF_CHECKERS);

        // when
        stackState.push(StackColor.BLACK);

        // then
        assertEquals(RANDOM_NUMBER_OF_CHECKERS + 1, stackState.getNumberOfCheckers());
    }

    @Test
    public void pointShouldBeColouredWhiteWhenWePushFirstWhiteChecker() throws Exception {
        // given
        StackState stackState = new StackState();

        // when
        stackState.push(StackColor.WHITE);

        // then
        assertEquals(StackColor.WHITE, stackState.getStackColor());
    }

    @Test
    public void pointShouldBeColouredBlackWhenWePushFirstBlackChecker() throws Exception {
        // given
        StackState stackState = new StackState();

        // when
        stackState.push(StackColor.BLACK);

        // then
        assertEquals(StackColor.BLACK, stackState.getStackColor());
    }

//    @Test(expected = IllegalArgumentException.class)
//    public void shouldThrowExceptionWhenWePushWhiteCheckerOnBlackPoint() throws Exception {
//        // given
//        StackState stackState = new StackState(StackColor.BLACK, RANDOM_NUMBER_OF_CHECKERS);
//
//        // when
//        stackState.push(StackColor.WHITE);
//    }
}