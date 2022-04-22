/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ClientDrawings;

import GState.StackColor;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

/**
 *
 * @author serhat
 */
public class ImageService {
    private static final String BACKGROUND_IMAGE_LOCATION = "board.png";
    private static final String BLACK_CHECKER_IMAGE_LOCATION = "black_checker.png";
    private static final String WHITE_CHECKER_IMAGE_LOCATION = "white_checker.png";
    private static final String WHITE_CHECKER_SIDE_IMAGE_LOCATION = "white_checker_side.png";
    private static final String BLACK_CHECKER_SIDE_IMAGE_LOCATION = "black_checker_side.png";
    private static final String DICE1_IMAGE_LOCATION = "dice1.png";
    private static final String DICE2_IMAGE_LOCATION = "dice2.png";
    private static final String DICE3_IMAGE_LOCATION = "dice3.png";
    private static final String DICE4_IMAGE_LOCATION = "dice4.png";
    private static final String DICE5_IMAGE_LOCATION = "dice5.png";
    private static final String DICE6_IMAGE_LOCATION = "dice6.png";
    private static final String ROLL_DICE_IMAGE_LOCATION = "rollDice.png";
    private BufferedImage backgroundImage;
    private BufferedImage blackChecker;
    private BufferedImage whiteChecker;
    private BufferedImage blackCheckerSide;
    private BufferedImage whiteCheckerSide;
    private BufferedImage dice1;
    private BufferedImage dice2;
    private BufferedImage dice3;
    private BufferedImage dice4;
    private BufferedImage dice5;
    private BufferedImage dice6;
    private BufferedImage rollDice;

    public ImageService() {
    }

    public BufferedImage getBackgroundImage() {
        if (backgroundImage == null) {
            backgroundImage = loadImage(BACKGROUND_IMAGE_LOCATION);
        }
        return backgroundImage;
    }

    public BufferedImage getCheckerImage(StackColor stackColor) {
        if (stackColor == StackColor.BLACK) {
            return getBlackCheckerImage();
        }
        return getWhiteCheckerImage();
    }

    public BufferedImage getCheckerSideImage(StackColor stackColor) {
        if (stackColor == StackColor.BLACK) {
            return getBlackCheckerSideImage();
        }
        return getWhiteCheckerSideImage();
    }

    public BufferedImage getDiceImage (int numberOnDice) {
        if (numberOnDice == 1) return getDice1Image();
        else if (numberOnDice == 2) return getDice2Image();
        else if (numberOnDice == 3) return getDice3Image();
        else if (numberOnDice == 4) return getDice4Image();
        else if (numberOnDice == 5) return getDice5Image();
        else return getDice6Image();
    }

    private BufferedImage getBlackCheckerImage() {
        if (blackChecker == null) {
            blackChecker = loadImage(BLACK_CHECKER_IMAGE_LOCATION);
        }
        return blackChecker;
    }

    private BufferedImage getWhiteCheckerImage() {
        if (whiteChecker == null) {
            whiteChecker = loadImage(WHITE_CHECKER_IMAGE_LOCATION);
        }
        return whiteChecker;
    }

    private BufferedImage getBlackCheckerSideImage() {
        if (blackCheckerSide == null) {
            blackCheckerSide = loadImage(BLACK_CHECKER_SIDE_IMAGE_LOCATION);
        }
        return blackCheckerSide;
    }

    private BufferedImage getWhiteCheckerSideImage() {
        if (whiteCheckerSide == null) {
            whiteCheckerSide = loadImage(WHITE_CHECKER_SIDE_IMAGE_LOCATION);
        }
        return whiteCheckerSide;
    }

    private BufferedImage getDice1Image() {
        if (dice1 == null) {
            dice1 = loadImage(DICE1_IMAGE_LOCATION);
        }
        return dice1;
    }

    private BufferedImage getDice2Image() {
        if (dice2 == null) {
            dice2 = loadImage(DICE2_IMAGE_LOCATION);
        }
        return dice2;
    }

    private BufferedImage getDice3Image() {
        if (dice3 == null) {
            dice3 = loadImage(DICE3_IMAGE_LOCATION);
        }
        return dice3;
    }

    private BufferedImage getDice4Image() {
        if (dice4 == null) {
            dice4 = loadImage(DICE4_IMAGE_LOCATION);
        }
        return dice4;
    }

    private BufferedImage getDice5Image() {
        if (dice5 == null) {
            dice5 = loadImage(DICE5_IMAGE_LOCATION);
        }
        return dice5;
    }

    private BufferedImage getDice6Image() {
        if (dice6 == null) {
            dice6 = loadImage(DICE6_IMAGE_LOCATION);
        }
        return dice6;
    }

    public BufferedImage getRollDiceImage() {
        if (rollDice == null) {
            rollDice = loadImage(ROLL_DICE_IMAGE_LOCATION);
        }
        return rollDice;
    }

    private BufferedImage loadImage(String location) {
        try {
            return ImageIO.read(getResourceLocation(location));
        } catch (IOException e) {
            throw new RuntimeException("Error while reading image from " + location);
        }
    }

    private URL getResourceLocation(String location) {
        return getClass().getClassLoader().getResource(location);
    }
}
