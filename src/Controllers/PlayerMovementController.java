package src.Controllers;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;

import src.Entities.Player;

public class PlayerMovementController {

    
    //Attribute

    private Player player;
    private int reloadTimer = 0;//TODO: im WeaponController implementieren


    //Konstruktoren

    public PlayerMovementController(Player player) {
        this.player = player;
    }


    //Getter

    public Player getPlayer() {
        return player;
    }


    //Methoden

    public void updateMovement(Input input, float playerSpeed, int delta, GameContainer container,
            BulletController bulletController) {
        
        // Timervariablen
        if (reloadTimer > 0) {
            reloadTimer--;//TODO: im WeaponController implementieren
        }
        
        
        // Spielerbewegung
        if (input.isKeyDown(Input.KEY_W) && player.getShape().getY() > 0) {
            player.setY(player.getShape().getY() - playerSpeed * delta);
        }
        if (input.isKeyDown(Input.KEY_S) && player.getShape().getY() < container.getHeight() - player.getShape().getHeight()) {
            player.setY(player.getShape().getY() + playerSpeed * delta);
        }
        if (input.isKeyDown(Input.KEY_A) && player.getShape().getX() > 0) {
            player.setX(player.getShape().getX() - playerSpeed * delta);
        }
        if (input.isKeyDown(Input.KEY_D)
                && player.getShape().getX() < container.getWidth() - player.getShape().getWidth()) {
            player.setX(player.getShape().getX() + playerSpeed * delta);
        }

        // Weapon Slot wechseln
        if (input.isKeyDown(Input.KEY_1)) {
            player.setEquipped(true);
        }
        if (input.isKeyDown(Input.KEY_2)) {
            player.setEquipped(false);
        }
        

        // Kugeln schießen
        if (input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
            player.getEquipped().attack();
            if (player.getEquipped().getBullets() > 0) {
                bulletController.shoot(input, this.getPlayer());
            }
        }

        // Waffe nachladen
        if (input.isKeyDown(Input.KEY_R) && reloadTimer == 0) {
            player.getEquipped().reload(player);
            reloadTimer = player.getEquipped().getReloadRate();//TODO: im WeaponController implementieren
        }

    }
    
}
