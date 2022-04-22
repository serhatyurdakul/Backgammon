package ClientDrawings;

import GState.GameState;
import GState.StackColor;
import GState.StackState;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.ImageObserver;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
public class BoardDrawer {
    private static final ImageObserver NO_IMAGE_OBSERVER = null;
    private static final int MAX_NUMBER_OF_STACKS = 24;
    private static final int NUMBER_OF_FIRST_STACK_IN_UPPER_ROW = 13;
    public static final int STACK_WIDTH = 50;
    public static final int CHECKER_HEIGHT = 41;
    public static final int CHECKER_SIDE_HEIGHT = 13;
    public static final int SIDE_PADDING_WIDTH = 15;
    public static final int RIGHT_BAND_X_LOCATION = 665;
    public static final int CENTER_PADDING_WIDTH = 50;
    public static final int HEIGHT = 522;
    public static final int WIDTH = 735;
    public static final int BORN_OFF_X_LOCATION = 681;
    private Graphics2D canvas;
    private GameState gameState;
    private ImageService imageService;

    public void drawBoard() {
        drawBackground();
        if (gameState.isTimeToRollDice())
            drawRollDiceButton();
        else
            drawDice(gameState.getDice());
        drawCheckersOnStacks();
        drawBeatenCheckers();
        drawBornOffCheckers();
    }

    /*
    Methods used to draw the dice or the button.
     */

    public void drawDice(List<Integer> dice) {
        drawDiceImage(dice.get(0), 1);
        drawDiceImage(dice.get(1), 2);

        if (dice.get(0).equals(dice.get(1))) {
            drawDiceImage(dice.get(2), 3);
            drawDiceImage(dice.get(3), 4);
        }
    }

    private void drawDiceImage(int numberOnDice, int diceNumber) {
        canvas.drawImage(
                imageService.getDiceImage(numberOnDice),
                (int) getDiceLocation(diceNumber).getX(),
                (int) getDiceLocation(diceNumber).getY(),
                NO_IMAGE_OBSERVER);
    }

    public void drawRollDiceButton() {
        canvas.drawImage(
                imageService.getRollDiceImage(),
                90, 241,
                NO_IMAGE_OBSERVER);
    }

    private Point getDiceLocation(int diceNumber) {
        Point diceLocation = new Point();
        if (diceNumber == 1)
            diceLocation.setLocation(445, 226);
        else if (diceNumber == 2)
            diceLocation.setLocation(525, 226);
        else if (diceNumber == 3)
            diceLocation.setLocation(365, 226);
        else
            diceLocation.setLocation(605, 226);
        return diceLocation;
    }

    /*
    Methods used to draw the checkers.
     */

    private void drawCheckersOnStacks() {
        for (int stackNumber = 1; stackNumber <= MAX_NUMBER_OF_STACKS; stackNumber++) {
            drawCheckersOnStack(gameState.getStack(stackNumber), stackNumber);
        }
    }

    private void drawCheckersOnStack(StackState stack, int stackNumber) {
        Point pointLocation = getStackLocation(stackNumber, stack.getNumberOfCheckers());

        for (int checkerNumber = 1; checkerNumber <= stack.getNumberOfCheckers(); checkerNumber++) {
            drawChecker(
                    pointLocation,
                    stack.getStackColor());
            if (isPointInTopRow(stackNumber))
                pointLocation.setLocation(pointLocation.getX(), pointLocation.getY() - CHECKER_HEIGHT);
            else
                pointLocation.setLocation(pointLocation.getX(), pointLocation.getY() + CHECKER_HEIGHT);
        }
    }

    private void drawChecker(Point checkerLocation, StackColor stackColor) {
        canvas.drawImage(
                imageService.getCheckerImage(stackColor),
                (int) checkerLocation.getX(),
                (int) checkerLocation.getY(),
                NO_IMAGE_OBSERVER);
    }

    private Point getStackLocation(int pointNumber, int numberOfCheckers) {
        return new Point(getStackXLocation(pointNumber), getStackYLocation(pointNumber, numberOfCheckers));
    }

    private int getStackXLocation(int pointNumber) {
        if (isPointInTopRow(pointNumber)) {
            if (pointNumber > 18)
                return SIDE_PADDING_WIDTH
                        + CENTER_PADDING_WIDTH
                        + STACK_WIDTH * (pointNumber - 13);
            return SIDE_PADDING_WIDTH + STACK_WIDTH * (pointNumber - 13);
        }
        if (pointNumber > 6)
            return RIGHT_BAND_X_LOCATION
                    - CENTER_PADDING_WIDTH
                    - (pointNumber * STACK_WIDTH);
        return RIGHT_BAND_X_LOCATION - (pointNumber * STACK_WIDTH);
    }

    private int getStackYLocation(int pointNumber, int numberOfCheckers) {
        if (isPointInTopRow(pointNumber)) {
            return 15 + CHECKER_HEIGHT * (numberOfCheckers - 1);
        }
        return 466 - CHECKER_HEIGHT * (numberOfCheckers - 1);
    }

    private boolean isPointInTopRow(int pointNumber) {
        return pointNumber >= NUMBER_OF_FIRST_STACK_IN_UPPER_ROW;
    }
    /*
    Method used to draw the beaten checkers.
     */

    private void drawBeatenCheckers() {
        for (int i = 0; i < gameState.getBeatenWhiteCheckers(); i++) {
            Point point = new Point(getBeatenXLocation(), getBeatenWhiteYLocation(i));
            drawChecker(point, StackColor.WHITE);
        }

        for (int i = 0; i < gameState.getBeatenBlackCheckers(); i++) {
            Point point = new Point(getBeatenXLocation(), getBeatenBlackYLocation(i));
            drawChecker(point, StackColor.BLACK);
        }
    }

    private int getBeatenXLocation() {
        return 315;
    }

    private int getBeatenBlackYLocation(int numberOfBeaten) {
        return 15 + (numberOfBeaten) * CHECKER_HEIGHT;
    }

    private int getBeatenWhiteYLocation(int numberOfBeaten) {
        return 466 - (numberOfBeaten) * CHECKER_HEIGHT;
    }

    /*
    Methods used to draw born off checkers.
     */

    private void drawBornOffCheckers() {
        for (int i = 0; i < gameState.getBornOffWhite().getNumberOfCheckers(); i++) {
            Point point = new Point(BORN_OFF_X_LOCATION, getBornOffWhiteLocation(i));
            drawCheckerSide(point, StackColor.WHITE);
        }

        for (int i = 0; i < gameState.getBornOffBlack().getNumberOfCheckers(); i++) {
            Point point = new Point(BORN_OFF_X_LOCATION, getBornOffBlackLocation(i));
            drawCheckerSide(point, StackColor.BLACK);
        }
    }

    private void drawCheckerSide(Point checkerSideLocation, StackColor stackColor) {
        canvas.drawImage(
                imageService.getCheckerSideImage(stackColor),
                (int) checkerSideLocation.getX(),
                (int) checkerSideLocation.getY(),
                NO_IMAGE_OBSERVER);
    }

    private int getBornOffWhiteLocation(int checkerNumber) {
        return SIDE_PADDING_WIDTH
                + checkerNumber * CHECKER_SIDE_HEIGHT;
    }

    private int getBornOffBlackLocation(int checkerNumber) {
        return HEIGHT - SIDE_PADDING_WIDTH - CHECKER_SIDE_HEIGHT
                - checkerNumber * CHECKER_SIDE_HEIGHT;
    }

    private void drawBackground() {
        canvas.drawImage(
                imageService.getBackgroundImage(),
                0,
                0,
                NO_IMAGE_OBSERVER);
    }
}
