package src.Entities;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import src.Weapons.Weapon;

public class Player extends LivingEntity {


    public void setEquipped(boolean isPrimary) {
        this.equipped = isPrimary? this.primary : this.secondary;
    }


    private Weapon primary;
    public Weapon getPrimary() {
        return primary;
    }


    public void setPrimary(Weapon primary) {
        this.primary = primary;
    }


    private Weapon secondary;
    public Weapon getSecondary() {
        return secondary;
    }


    public void setSecondary(Weapon secondary) {
        this.secondary = secondary;
    }


    private HashMap<String, Short> ammo;


    public HashMap<String, Short> getAmmo() {
        return ammo;
    }


    public void setAmmo(HashMap<String, Short> ammo) {
        this.ammo = ammo;
    }


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
        this.getImage().draw(this.getShape().getCenterX(), this.getShape().getCenterY());
    }

    public Map.Entry<String,Short> findAmmo(String key) {
        Iterator<Entry<String, Short>> it = this.ammo.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Short> entry = it.next();
            if (entry.getKey().equals(key)) {
                return entry;
            }
        }
        return null;
    }


    @Override
    public void die() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'die'");
    }

    // public void suicide() {
    //     die();
    // }
}
