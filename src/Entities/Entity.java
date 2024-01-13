package Entities;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

/**
 * Diese Klasse stellt alle Entitäten im Game dar, sprich alle sichtbaren Objekte, die auf den Spieler-Input reagieren
 * 
 * @author Sascha Angermann
 */
public abstract class Entity {


    //Attribute
    
    protected Image sprite;
    protected Shape shape;
    protected float direction;


    //Konstruktoren

    /**
     * Diese Methode erstellt ein Entity-Objekt und initialisiert dessen Attribute.
     * 
     * Die Attribute x, y, width und height werden hierbei verwendet, um ein Shape-Objekt zu erzeugen.
     * 
     * @param spriteAsset Pfad zum Image-Asset zur Darstellung der Entität
     * @param x x-Koordinate der Position der Entität
     * @param y y-Koordinate der Position der Entität
     * @param width Räumliche Breite der Entität
     * @param height Räumliche Höhe der Entität
     * @param direction Blickrichtung der Entität (in Grad)
     * @throws SlickException falls etwas bei der Erstellung des Sprites oder Shapes nicht klappt.
     */
    public Entity(String spriteAsset, float x, float y, float width, float height, float direction) throws SlickException {
        this.sprite = new Image(spriteAsset);
        this.shape = new Rectangle(x, y, width, height);
        this.direction = direction;
    }

    
    //Getters
    
    /**
     * Diese Methode gibt den Sprite der Entität zurück.
     * 
     * @return Image-Asset zur Darstellung der Entität
     */
    public Image getSprite() {
        return sprite;
    }

    /**
     * Diese Methode gibt die Position und Fläche der Entität zurück.
     * 
     * @return Koordinaten und eingenommene Fläche im GameContainer
     */
    public Shape getShape() {
        return shape;
    }
    
    /**
     * Diese Methode gibt die Blickrichtung der Entität zurück.
     * 
     * @return Blickrichtung der Entität (in Grad)
     */
    public float getDirection() {
        return direction;
    }


    //Setters

    /**
     * Diese Methode legt das Image-Asset zur Darstellung der Entität fest.
     * 
     * @param spriteAsset Asset-File zur Verwendung des Sprites
     */
    public void setSprite(String spriteAsset) throws SlickException {
        this.sprite = new Image(spriteAsset);
    }

    /**
     * Diese Methode legt die geometrische Form und Position der Entität fest.
     * 
     * @param shape Koordinaten und eingenommene Fläche im GameContainer
     */
    public void setShape(Shape shape) {
        this.shape = shape;
    }

    /**
     * Diese Methode legt die Blickrichtung der Entität fest.
     * 
     * @param direction Blickrichtung der Entität (in Grad)
     */
    public void setDirection(float direction) {
        this.direction = direction;
    }

    /**
     * Diese Methode setzt die y-Koordinate des shape-Attributs der Entität auf einen neuen Wert.
     * 
     * @param y y-Koordinate der neuen Position
     */
    public void setY(float y) {
        this.getShape().setY(y);
    }

    /**
     * Diese Methode setzt die y-Koordinate des shape-Attributs der Entität auf einen neuen Wert.
     * 
     * @param x x-Koordinate der neuen Position
     */
    public void setX(float x) {
        this.getShape().setX(x);
    }


    //Methoden

    /**
     * Diese Methode stellt die Entität visuell dar.
     * 
     * @param g Grafische Darstellung des Spiels durch die Slick2D-Library
     */
    public abstract void render(Graphics g);

}
