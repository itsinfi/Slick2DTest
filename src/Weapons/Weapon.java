package src.Weapons;

import java.util.Map;
import src.Entities.Player;

public class Weapon {
    //TODO: später als abstrakte Oberklasse implementieren


    //Attribute

    protected boolean isSecondary;
    protected short damagePerBullet;
    protected String ammoType;
    protected short firerate;
    protected double spread;
    protected short range;
    // pierce
    protected short magazineSize;
    protected short bullets;
    protected short reloadRate;


    //Konstruktoren

    public Weapon(boolean isSecondary, short damagePerBullet, String ammoType, short firerate, double spread,
            short range, short magazineSize, short bullets, short reloadRate) {
        this.isSecondary = isSecondary;
        this.damagePerBullet = damagePerBullet;
        this.ammoType = ammoType;
        this.firerate = firerate;
        this.spread = spread;
        this.range = range;
        this.magazineSize = magazineSize;
        this.bullets = bullets;
        this.reloadRate = reloadRate;
    }


    //Getter

    public boolean isSecondary() {
        return isSecondary;
    }

    public short getDamagePerBullet() {
        return damagePerBullet;
    }

    public String getAmmoType() {
        return ammoType;
    }

    public short getFirerate() {
        return firerate;
    }

    public double getSpread() {
        return spread;
    }

    public short getRange() {
        return range;
    }

    public short getMagazineSize() {
        return magazineSize;
    }

    public short getBullets() {
        return bullets;
    }

    public short getReloadRate() {
        return reloadRate;
    }


    //Setter

    public void setSecondary(boolean isSecondary) {
        this.isSecondary = isSecondary;
    }

    public void setDamagePerBullet(short damagePerBullet) {
        this.damagePerBullet = damagePerBullet;
    }

    public void setAmmoType(String ammoType) {
        this.ammoType = ammoType;
    }

    public void setFirerate(short firerate) {
        this.firerate = firerate;
    }

    public void setSpread(double spread) {
        this.spread = spread;
    }

    public void setRange(short range) {
        this.range = range;
    }

    public void setMagazineSize(short magazineSize) {
        this.magazineSize = magazineSize;
    }

    public void setBullets(short bullets) {
        this.bullets = bullets;
    }

    public void setReloadRate(short reloadRate) {
        this.reloadRate = reloadRate;
    }
    

    //Methoden

    public void reload(Player player) {

        Map.Entry<String, Short> ammo = player.findAmmo(this.ammoType);
        
        if (ammo.getValue() != null) {
            short ammoValue = ammo.getValue();
            short magazineSize = this.getMagazineSize();
            if (ammoValue > magazineSize) {
                ammo.setValue((short) (ammoValue - magazineSize));
                this.setBullets(magazineSize);
            } else if (ammoValue > 0) {
                ammo.setValue((short) 0);
                this.setBullets(ammoValue);
            } else {
                return;
            }
            
        }
    }

    public void attack(/*float xPos, float yPos, float direction*/) {
        if (this.bullets > 0) {
            this.setBullets((short) (bullets - 1));
        }
    }
    
}
