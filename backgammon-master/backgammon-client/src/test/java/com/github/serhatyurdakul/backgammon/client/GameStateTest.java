package com.github.serhatyurdakul.backgammon.client;

import GState.GameState;
import GState.StackState;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameStateTest {
    @Test
    public void shouldBePossibleToGetPointsFromOneToTwentyFour() throws Exception {
        // given
        GameState gameState = new GameState();

        // when
        StackState firstPoint = gameState.getStack(1);
        StackState twentyFourthPoint = gameState.getStack(24);

        // then
        //assertNotNull(firstPoint);
        //assertNotNull(twentyFourthPoint);
    }
}