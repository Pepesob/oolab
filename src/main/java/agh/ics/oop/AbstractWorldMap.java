package agh.ics.oop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver{

    public Map<Vector2d, Animal> animals = new HashMap<>();

    final MapVisualizer visualiser = new MapVisualizer(this);

    MapBoundary mapBoundary;


    public abstract boolean canMoveTo(Vector2d position);
    @Override
    public boolean place(Animal animal) throws IllegalArgumentException {
        if (canMoveTo(animal.getPosition())){
            this.animals.put(animal.getPosition(),animal);
            mapBoundary.add(animal.getPosition());
            animal.addObserver(this);
            return true;
        }
        else {
            throw new IllegalArgumentException("Position " + animal.getPosition().toString() + " is occupied");
        }
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

    public Vector2d lowerLeft(){
        return mapBoundary.lowerLeft();
    }

    public Vector2d upperRight(){
        return mapBoundary.upperRight();
    }

    @Override
    public String toString() {
        return visualiser.draw(lowerLeft(),upperRight());
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        Animal a = animals.get(oldPosition);
        animals.remove(oldPosition);
        animals.put(newPosition, a);
        mapBoundary.positionChanged(oldPosition, newPosition);
    }
}
