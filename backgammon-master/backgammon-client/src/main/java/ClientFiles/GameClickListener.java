package ClientFiles;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GameClickListener extends MouseAdapter {
    private Point mouseLocation;

    public void setMouseLocation(MouseEvent e) {
        mouseLocation = e.getPoint();
    }

    public boolean isOnRollDiceButton() {
        if (mouseLocation.getX() >= 90
                && mouseLocation.getX() <= 240
                && mouseLocation.getY() >= 241
                && mouseLocation.getY() <= 281)
            return true;
        return false;
    }

    public int getClickedStack() {
        int x = (int) mouseLocation.getX();
        int y = (int) mouseLocation.getY();
        boolean isInUpperRow;

        if (y > 15 && y < 235)
            isInUpperRow = true;
        else if (y < 507 && y > 287)
            isInUpperRow = false;
        else
            return -1;

        if (x > 15 && x < 65) {
            if (isInUpperRow) return 13;
            return 12;
        }
        if (x > 65 && x < 115) {
            if (isInUpperRow) return 14;
            return 11;
        }
        if (x > 115 && x < 165) {
            if (isInUpperRow) return 15;
            return 10;
        }
        if (x > 165 && x < 215) {
            if (isInUpperRow) return 16;
            return 9;
        }
        if (x > 215 && x < 265) {
            if (isInUpperRow) return 17;
            return 8;
        }
        if (x > 265 && x < 315) {
            if (isInUpperRow) return 18;
            return 7;
        }
        if (x > 365 && x < 415) {
            if (isInUpperRow) return 19;
            return 6;
        }
        if (x > 415 && x < 465) {
            if (isInUpperRow) return 20;
            return 5;
        }
        if (x > 465 && x < 515) {
            if (isInUpperRow) return 21;
            return 4;
        }
        if (x > 515 && x < 565) {
            if (isInUpperRow) return 22;
            return 3;
        }
        if (x > 565 && x < 615) {
            if (isInUpperRow) return 23;
            return 2;
        }
        if (x > 615 && x < 665) {
            if (isInUpperRow) return 24;
            return 1;
        }
        if (x > 665 && x < 735) {
            if (isInUpperRow) return 25;
            return 0;
        }

        return -1;
    }

}
