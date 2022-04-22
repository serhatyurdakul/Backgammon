package GState;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameState implements Serializable {
    private StackState[] stacks;
    private StackState bornOffWhite, bornOffBlack;
    private boolean isTimeToRollDice;
    private List<Integer> dice;
    private List<Boolean> isDiceUsed;
    private int beatenBlackCheckers;
    private int beatenWhiteCheckers;
    private int numberOfConnectedUsers;
    private StackColor winner = StackColor.EMPTY;

    public GameState() {
        stacks = new StackState[24];
        for (int i = 0; i < 24; i++) {
            stacks[i] = new StackState();
        }
        bornOffWhite = new StackState(StackColor.WHITE, 0);
        bornOffBlack = new StackState(StackColor.BLACK, 0);
        setNewGameState();
        isTimeToRollDice = true;
        dice = new ArrayList<>();
        isDiceUsed = new ArrayList<>();
        beatenBlackCheckers = 0;
        beatenWhiteCheckers = 0;
        numberOfConnectedUsers = 0;
    }

    public void rollDice() {
        dice.clear();
        isDiceUsed.clear();
        Random generator = new Random();
        dice.add(generator.nextInt(6) + 1);
        dice.add(generator.nextInt(6) + 1);
        isDiceUsed.add(false);
        isDiceUsed.add(false);
        if (dice.get(0) == dice.get(1)) {
            dice.add(dice.get(0));
            dice.add(dice.get(0));
            isDiceUsed.add(false);
            isDiceUsed.add(false);
        } else {
            dice.add(0);
            dice.add(0);
            isDiceUsed.add(true);
            isDiceUsed.add(true);
        }
    }

    public List<Integer> getDice() {
        return dice;
    }

    public List<Boolean> getIsDiceUsed() {
        return isDiceUsed;
    }

    public void setIsDiceUsed(int diceIndex) {
        isDiceUsed.set(diceIndex, true);
    }

    public void setNewGameState() {
        stacks[0].setStackColor(StackColor.WHITE);
        stacks[0].setNumberOfCheckers(2);
        stacks[5].setStackColor(StackColor.BLACK);
        stacks[5].setNumberOfCheckers(5);
        stacks[7].setStackColor(StackColor.BLACK);
        stacks[7].setNumberOfCheckers(3);
        stacks[11].setStackColor(StackColor.WHITE);
        stacks[11].setNumberOfCheckers(5);
        stacks[12].setStackColor(StackColor.BLACK);
        stacks[12].setNumberOfCheckers(5);
        stacks[16].setStackColor(StackColor.WHITE);
        stacks[16].setNumberOfCheckers(3);
        stacks[18].setStackColor(StackColor.WHITE);
        stacks[18].setNumberOfCheckers(5);
        stacks[23].setStackColor(StackColor.BLACK);
        stacks[23].setNumberOfCheckers(2);
    }

    public boolean isTimeToRollDice() {
        return isTimeToRollDice;
    }

    public void setTimeToRollDice(boolean timeToRollDice) {
        isTimeToRollDice = timeToRollDice;
    }

    public StackState getStack(int numberOfStack) {
        return stacks[numberOfStack - 1];
    }

    public void popStack(int numberOfStack) {
        stacks[numberOfStack - 1]
                .setNumberOfCheckers(stacks[numberOfStack - 1].getNumberOfCheckers() - 1);
        if (stacks[numberOfStack - 1].getNumberOfCheckers() == 0)
            stacks[numberOfStack - 1].setStackColor(StackColor.EMPTY);
    }

    public void pushStack(int numberOfStack, StackColor stackColor) {
        stacks[numberOfStack - 1]
                .setNumberOfCheckers(stacks[numberOfStack - 1].getNumberOfCheckers() + 1);
        stacks[numberOfStack - 1].setStackColor(stackColor);
    }

    public int getBeatenBlackCheckers() {
        return beatenBlackCheckers;
    }

    public int getBeatenWhiteCheckers() {
        return beatenWhiteCheckers;
    }

    public void addBeatenBlackCheckers() {
        beatenBlackCheckers++;
    }

    public void addBeatenWhiteCheckers() {
        beatenWhiteCheckers++;
    }

    public void removeBeatenBlackChecker() {
        beatenBlackCheckers--;
    }

    public void removeBeatenWhiteChecker() {
        beatenWhiteCheckers--;
    }

    public StackState getBornOffWhite() {
        return bornOffWhite;
    }

    public void addBornOffWhite() {
        bornOffWhite.setNumberOfCheckers(bornOffWhite.getNumberOfCheckers() + 1);
    }

    public StackState getBornOffBlack() {
        return bornOffBlack;
    }

    public void addBornOffBlack() {
        bornOffBlack.setNumberOfCheckers(bornOffBlack.getNumberOfCheckers() + 1);
    }

    public StackColor getWinner() {
        return winner;
    }

    public void setWinner(StackColor winner) {
        this.winner = winner;
    }

}

