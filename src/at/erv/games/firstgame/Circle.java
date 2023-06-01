package at.erv.games.firstgame;

import org.newdawn.slick.Graphics;

import java.util.Random;

public class Circle implements Actor{
    private float x,y;
    private float speed;
    private int diameter;
    private float growthRate;

    public Circle() {
        Random random = new Random();
        this.x = random.nextInt(800);
        this.y = random.nextInt(600);
        this.speed = random.nextInt(40) + 10;
        this.diameter = random.nextInt(20) + 20;
        this.growthRate = random.nextFloat() * 0.9f + 0.4f;
    }

    public void render(Graphics graphics) {
        graphics.drawOval(this.x, this.y,this.diameter,this.diameter);
    }

    public void update(int delta){
        this.y += (float) delta / speed;
        if(this.y>600){
            this.y = 0;
        }

        this.diameter += growthRate;
    }
}
