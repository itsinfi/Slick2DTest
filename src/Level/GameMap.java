package src.Level;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class GameMap {

    private  Image mapAsset;


    public GameMap(String imagePath) throws SlickException{
        mapAsset = new Image(imagePath);
    }

    public void drawMap(Graphics g) throws SlickException {
        mapAsset.draw(0, 0);
    }
    
}
