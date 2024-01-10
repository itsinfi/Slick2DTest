package src.Entities;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

public class LivingEntity {
    
    private Shape shape;

    public Shape getShape() {
        return shape;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }

    private Image image;

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;

    }

    
    public LivingEntity(String imageAsset, float x, float y, float width, float height) throws SlickException {
        this.image = new Image(imageAsset);
        this.shape = new Rectangle(x, y, width, height);
    }

    
}