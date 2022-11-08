package agh.ics.oop;

import java.util.LinkedList;
import java.util.List;

public class RectangularMap implements IWorldMap{

    final int width;
    final int height;
    List<Animal> animals = new LinkedList<>();
    final MapVisualizer visualiser;


    public RectangularMap(int width, int height){
        this.width = width;
        this.height = height;
        visualiser = new MapVisualizer(this);
    }
    @Override
    public boolean canMoveTo(Vector2d position) {
        if (!(position.x >= 0 && position.x <= width && position.y >= 0 && position.y <= height)){
            return false;
        }
        for (Animal creature: this.animals) {
            if (position.equals(creature.getPosition())){
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean place(Animal animal) {
        if (animal.world.canMoveTo(animal.getPosition())){
            animals.add(animal);
            return true;
        }
        return false;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        for (Animal creature: this.animals) {
            if (position.equals(creature.getPosition())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
        for (Animal creature: this.animals) {
            if (position.equals(creature.getPosition())) {
                return creature;
            }
        }
        return null;
    }

    public String toString(){
        return visualiser.draw(new Vector2d(0,0), new Vector2d(this.width,this.height));
    }
}
