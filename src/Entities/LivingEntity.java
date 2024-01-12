package src.Entities;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

import src.Weapons.Weapon;

public abstract class LivingEntity extends Entity {

    protected Weapon equipped;

    public Weapon getEquipped() {
        return equipped;
    }

    protected short hitpoints;
    public short getHitpoints() {
        return hitpoints;
    }

    public void setHitpoints(short hitpoints) {
        this.hitpoints = hitpoints;
    }

    protected short invincibilityTime;
    
    public short getInvincibilityTime() {
        return invincibilityTime;
    }

    public void setInvincibilityTime(short invincibilityTime) {
        this.invincibilityTime = invincibilityTime;
    }

    public LivingEntity(String imageAsset, float x, float y, float width, float height) throws SlickException {
        this.image = new Image(imageAsset);
        this.shape = new Rectangle(x, y, width, height);
        this.hitpoints = 100; //TODO: make dynamic
    }

    public abstract void die();

}