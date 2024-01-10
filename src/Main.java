package src;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

import src.Controllers.BulletController;
import src.Controllers.PlayerMovementController;
import src.Entities.LivingEntity;
import src.Entities.Player;
import src.Level.GameMap;

import java.util.HashSet;


public class Main extends BasicGame {
    private Player player;
    private HashSet<LivingEntity> livingEntities = new HashSet<LivingEntity>();
    private float playerSpeed = 0.2f;
    private float bulletSpeed = 0.5f;
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
        //TODO: Gliedern in RenderController & UpdateController????

        mapAsset.drawMap(g);
        //TODO: Hier mehr reinbringen!!!

        // Draw player
        player.draw(g);
        //TODO: Entities, EntityController
        //TODO: Player Animations, AnimationController
        //TODO: Enemies, Damage etc
        

        // Draw bullet if shooting
        bulletController.drawBullets(g);
        //TODO: Weapons
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