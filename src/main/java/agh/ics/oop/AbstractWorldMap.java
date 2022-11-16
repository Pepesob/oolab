package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractWorldMap implements IWorldMap {

    protected List<Animal> animals = new ArrayList<>();

    final MapVisualizer visualiser = new MapVisualizer(this);


    public abstract boolean canMoveTo(Vector2d position);

    @Override
    public boolean place(Animal animal) {
        if (canMoveTo(animal.getPosition())){
            this.animals.add(animal);
            return true;
        }
        return false;
    }


    abstract Object returnObject(Vector2d position);

    @Override
    public boolean isOccupied(Vector2d position) {
        return returnObject(position) != null;
    }

    @Override
    public Object objectAt(Vector2d position) {
        return returnObject(position);
    }

    abstract Vector2d lowerLeft();

    abstract Vector2d upperRight();

    @Override
    public String toString() {
        return visualiser.draw(lowerLeft(),upperRight());
    }
}
