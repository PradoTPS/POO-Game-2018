package jogopoo;

import java.awt.*;

public interface Collider {
    boolean isColliding(Rectangle rectangle);
    Rectangle getBoundingBox();
}