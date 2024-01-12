package src.Entities;

import java.util.HashMap;

import org.newdawn.slick.SlickException;

import src.Weapons.Weapon;

public class Enemy extends LivingEntity{

    public Enemy(String imageAsset, float x, float y, float width, float height) throws SlickException {
        super(imageAsset, x, y, width, height);
        //TODO Auto-generated constructor stub
    }

    private Weapon weapon;

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }
    
    private HashMap<String, Double> loot;

    public HashMap<String, Double> getLoot() {
        return loot;
    }

    public void setLoot(HashMap<String, Double> loot) {
        this.loot = loot;
    }
    

    @Override
    public void die() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'die'");
    }
    
}
