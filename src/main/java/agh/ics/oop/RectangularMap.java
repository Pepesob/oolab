package agh.ics.oop;

import java.util.LinkedList;
import java.util.List;

public class RectangularMap extends AbstractWorldMap{

    final int width;
    final int height;


    public RectangularMap(int width, int height){
        this.width = width;
        this.height = height;
    }
    @Override
    public boolean canMoveTo(Vector2d position) {
        if (!(position.x >= 0 && position.x <= width && position.y >= 0 && position.y <= height)){
            return false;
        }
        return animals.get(position) == null;
    }

    @Override
    public Object returnObject(Vector2d position){
        return animals.get(position);
    }

    @Override
    Vector2d lowerLeft() {
        return new Vector2d(0,0);
    }

    @Override
    Vector2d upperRight() {
        return new Vector2d(this.width, this.height);
    }
}
