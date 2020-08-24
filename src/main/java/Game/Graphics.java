package Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Graphics extends JPanel implements ActionListener {

    /**
     * This class draws the background for the game
     * by calling acctionPerfomed() that calls paintComponent().
     * Also it adds game states (start, end).
     */
    //evey 100 millisecond it will re-draw the background
    private Timer t = new Timer(100,this);
    public String state;

    private Snake s;
    private Food f;
    private Game game;

    public Graphics(Game g) {
        t.start();
        state = "START";

        game = g;
        s = g.getPlayer();
        f = g.getFood();

        //add a keyListener
        this.addKeyListener(g);
        this.setFocusable(true);
        this.setFocusTraversalKeysEnabled(false);
    }

    //we need JPanel to draw
    public void paintComponent(java.awt.Graphics g) {
        super.paintComponent(g);

        //casting to 2D
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.black);
        g2d.fillRect(0, 0, Game.width * Game.dimension, Game.height * Game.dimension);

        if(state == "START") {
            g2d.setColor(Color.white);
            g2d.drawString("Press any key to start",
                    Game.width / 2 * Game.dimension -40, Game.height/2 * Game.dimension - 20);
        }
        else if(state == "RUNNING") {
            g2d.setColor(Color.red);
            g2d.fillRect(f.getX() * Game.dimension, f.getY() * Game.dimension, Game.dimension, Game.dimension);
            g2d.setColor(Color.green);
            for (Rectangle r : s.getBody()) {
                g2d.fill(r);
            }
        }
        else {
            g2d.setColor(Color.white);
            g2d.drawString("Your score: " + (s.getBody().size() - 3),
                    Game.width / 2 * Game.dimension -40, Game.height/2 * Game.dimension - 20);
        }
        //-3 -> because we start with 3 rectangles
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
        game.update();
    }

}
