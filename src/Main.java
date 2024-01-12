package src;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

import src.Controllers.BulletController;
import src.Controllers.PlayerMovementController;
import src.Entities.LivingEntity;
import src.Entities.Player;
import src.Level.GameMap;
import src.Weapons.Weapon;

import java.util.HashMap;
import java.util.HashSet;


public class Main extends BasicGame {
    private Player player;
    private HashSet<LivingEntity> livingEntities = new HashSet<LivingEntity>();
    private float playerSpeed = 0.27f;
    private float bulletSpeed = 0.69f;
    private GameMap mapAsset;
    private PlayerMovementController playerMovementController;
    BulletController bulletController;

    public Main(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer container) throws SlickException {
        player = new Player("assets/playertest.png", container);
        mapAsset = new GameMap("assets/mapTest1.png");
        playerMovementController = new PlayerMovementController(player);
        livingEntities.add(player);
        bulletController = new BulletController(livingEntities);

        Weapon primary = new Weapon(false, (short) 30, "PRIMARY", (short) 2000, 0.0, (short) 200, (short) 30,
                (short) 30, (short) 120);
        Weapon secondary = new Weapon(true, (short) 30, "PRIMARY", (short) 2000, 0.0, (short) 200, (short) 30,
                (short) 30, (short) 1000);
        player.setPrimary(primary);
        player.setEquipped(true);
        player.setSecondary(secondary);
        HashMap<String, Short> ammo = new HashMap<String, Short>();
        ammo.put("PRIMARY", (short) 200);
        player.setAmmo(ammo);
    }

    @Override
    public void update(GameContainer container, int delta) throws SlickException {
        Input input = container.getInput();

        //update player movement
        playerMovementController.updateMovement(input, playerSpeed, delta, container, bulletController);

        //update bullets
        bulletController.updateBullets(input, bulletSpeed, delta, container, player);
    }

    @Override
    public void render(GameContainer container, Graphics g) throws SlickException {

        //Map rendern
        mapAsset.drawMap(g);

        //Bullets rendern
        bulletController.drawBullets(g);

        //Player rendern
        player.draw(g);


        //Draw HUD
        g.setColor(Color.orange);
        g.drawString("Current Ammo: " + player.getEquipped().getBullets(), 10, container.getHeight() - 20);
        g.drawString("Ammo in Inventory: " + player.getAmmo().get(player.getEquipped().getAmmoType()), 10, container.getHeight() - 40);
        g.drawString("HP: " + player.getHitpoints(), 10, container.getHeight() - 60);
    }
    

    public static void main(String[] args) {
        try {
            AppGameContainer app = new AppGameContainer(
                    new Main("ayo voll krasses game alter check this out!"));
            app.setIcons(new String[]{"assets/appIcon.png"});
            app.setDisplayMode(800, 600, false);
            app.setTargetFrameRate(60);
            app.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}