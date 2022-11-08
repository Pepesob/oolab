package agh.ics.oop;

import java.util.LinkedList;
import java.util.List;

public class SimulationEngine implements IEngine{

    MoveDirection[] directions;
    IWorldMap world;
    Vector2d[] positions;
    List<Animal> animals = new LinkedList<>();

    public SimulationEngine(MoveDirection[] directions, IWorldMap world, Vector2d[] positions){
        for (Vector2d position : positions) {
            Animal animal = new Animal(world, position);
            if (world.place(animal)){
                animals.add(animal);
            }
        }
        this.directions = directions;
        this.world = world;
        this.positions = positions;

    }

    @Override
    public void run() {
        for (int i = 0; i < directions.length; i++){
            animals.get(i%animals.size()).move(directions[i]);
        }
    }
}
