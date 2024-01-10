package src.Entities;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class Player extends LivingEntity {


    public Player(String playerAsset, GameContainer container) throws SlickException {
        super(playerAsset, container.getWidth() / 2 - 16, container.getHeight() / 2 - 16, 32, 32);
    }


    public void setY(float f) {
        this.getShape().setY(f);
    }


    public void setX(float f) {
        this.getShape().setX(f);
    }

    public void draw(Graphics g) {
        this.getImage().draw(this.getShape().getCenterX(), this.getShape().getY());
    }

    
}
