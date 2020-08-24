package Game;

import java.awt.*;

public class Food {
    private int x;
    private int y;

    /**
     * Generates food randomly in the window.
     */
    public Food(Snake player) {
        this.randomSpawn(player);
    }

    //make sure thart this random location in not snake itself
    public void randomSpawn(Snake player) {
        boolean onSnake = true;
        while (onSnake) {
            onSnake = false;

            x = (int) (Math.random() * Game.width - 1);
            y = (int) (Math.random() * Game.height - 1);

            for (Rectangle r : player.getBody()) {
                if (r.x == x && r.y == y) {
                    onSnake = true;
                }
            }
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
