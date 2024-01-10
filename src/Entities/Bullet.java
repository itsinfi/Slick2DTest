package src.Entities;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Vector2f;

public class Bullet {
    
    private float xPos;
    private float yPos;
    boolean isShooting = false;
    private Vector2f bulletDirection;
    private LivingEntity shootingEntity;

    public Bullet(Vector2f bulletDirection, float xPos, float yPos, LivingEntity shootingEntity) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.bulletDirection = bulletDirection;
        this.shootingEntity = shootingEntity;
        isShooting = true;
    }

    public void updateBullet(GameContainer container, float bulletSpeed, int delta) {

        if (isShooting) {
            xPos += bulletDirection.getX() * bulletSpeed * delta;
            yPos += bulletDirection.getY() * bulletSpeed * delta;

            // Check for bullet collision with the screen boundaries
            if (xPos < 0 || xPos > container.getWidth() || yPos < 0 || yPos > container.getHeight()) {
                isShooting = false;
            }
        }

    }
    
    public boolean getIsShooting() {
        return this.isShooting;
    }
    
    public void drawBullet(Graphics g) {
        g.fillOval(xPos, yPos, 5, 5);
    }

}
