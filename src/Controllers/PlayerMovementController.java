package src.Controllers;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;

import src.Entities.Player;

public class PlayerMovementController {

    private Player player;

    public Player getPlayer() {
        return player;
    }

    public PlayerMovementController(Player player) {
        this.player = player;
    }

    public void updateMovement(Input input, float playerSpeed, int delta, GameContainer container, BulletController bulletController) {
        // Move player based on keyboard input
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
        

        // Shoot bullet on mouse click
        if (input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
            bulletController.shoot(input, this.getPlayer());
        }
    }
    
}
