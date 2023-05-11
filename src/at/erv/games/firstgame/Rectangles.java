package at.erv.games.firstgame;

import org.newdawn.slick.*;
import org.newdawn.slick.tests.AnimationTest;


public class Rectangles extends BasicGame {
    private float x;
    private float y;
    private float speed;
    private Direction direction = Direction.RIGHT;

    private enum Direction{RIGHT, DOWN, LEFT, UP};


    public Rectangles(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        this.x = 100;
        this.y = 100;
        this.speed = 2.0f;
    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {
        if (direction == Direction.RIGHT) {
            this.x += (float) delta / this.speed;
            if (this.x > 600) {
                direction = Direction.DOWN;
            }
        }

        if (direction == Direction.DOWN){
            this.y += (float) delta / this.speed;
            if (this.y > 400){
                direction = Direction.LEFT;
            }
        }

        if (direction == Direction.LEFT){
            this.x -= (float) delta / this.speed;
            if (this.x < 100){
                direction = Direction.UP;
            }
        }

        if (direction == Direction.UP){
            this.y -= (float) delta / this.speed;
            if (this.y < 100){
                direction = Direction.RIGHT;
            }
        }

        System.out.println("x<:" + this.x + " y:" + this.y);
    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        graphics.drawRect(this.x,this.y,100,100);
        graphics.drawString("Hello babygirl!",50,50);
    }

    public static void main(String[] argv) {
        try {
            AppGameContainer container = new AppGameContainer(new Rectangles("Rectangles"));
            container.setDisplayMode(800,600,false);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}
