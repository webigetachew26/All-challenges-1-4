
package appletdemo;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;

    public class BouncingTextApplet extends Applet implements Runnable {

        private Thread thread;
        private int x = 0;                    // x-position of the text
        private String name = "Webi Getachew";     // Replace with your actual name
        private int step = 5;                 // Movement step in pixels
        private boolean running = false;

        public void init() {
            setSize(400, 200);                // Applet size
            setBackground(Color.BLACK);       // Background color
        }

        public void start() {
            if (thread == null) {
                running = true;
                thread = new Thread(this);
                thread.start();               // Start the animation thread
            }
        }

        public void stop() {
            running = false;
            thread = null;                    // Stop the thread when applet stops
        }

        public void run() {
            while (running) {
                x += step;
                if (x > getWidth()) {
                    x = 0;                    // Reset to start
                }
                repaint();                    // Redraw screen
                try {
                    Thread.sleep(100);        // Delay for 100 ms
                } catch (InterruptedException e) {
                    // Ignore interruption
                }
            }
        }

        public void paint(Graphics g) {
            g.setColor(Color.GREEN);          // Text color
            g.drawString(name, x, getHeight() / 2); // Draw text
        }
    }



