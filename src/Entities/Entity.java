package src.Entities;

import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Shape;

public class Entity {
    
    protected float direction;
    public float getDirection() {
        return direction;
    }

    public void setDirection(float direction) {
        this.direction = direction;
    }
    
    protected Shape shape;

    public Shape getShape() {
        return shape;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }

    protected Image image;

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;

    }
    
}
