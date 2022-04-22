package GState;

import java.io.Serializable;

public class StackState implements Serializable{
    private StackColor stackColor;
    private int numberOfCheckers;

    public StackState(StackColor stackColor, int numberOfCheckers) {
        this.stackColor = stackColor;
        this.numberOfCheckers = numberOfCheckers;
    }

    public StackState() {
        this.stackColor = StackColor.EMPTY;
        this.numberOfCheckers = 0;
    }

    public StackColor getStackColor() {
        return stackColor;
    }

    public void setStackColor(StackColor stackColor) {
        this.stackColor = stackColor;
    }

    public int getNumberOfCheckers() {
        return numberOfCheckers;
    }

    public void setNumberOfCheckers(int numberOfCheckers) {
        this.numberOfCheckers = numberOfCheckers;
    }

    public void pop() {
        numberOfCheckers--;
        if (numberOfCheckers == 0) {
            stackColor = StackColor.EMPTY;
        }
    }

    public void push(StackColor checkersStackColor) {
        numberOfCheckers++;
        stackColor = checkersStackColor;
    }
}
