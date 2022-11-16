package agh.ics.oop;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class GrassField extends AbstractWorldMap{

    int n;
    List<Grass> grass = new LinkedList<>();

    public GrassField(int n){
        this.n = n;
        Random r = new Random();
        Vector2d v;
        for (int i = 0; i < n; i++){
            v = new Vector2d(r.nextInt(0,(int) Math.sqrt(n*10)),r.nextInt(0,(int) Math.sqrt(n*10)));
            while (isOccupied(v)){
                v = new Vector2d(r.nextInt(0,(int) Math.sqrt(n*10)),r.nextInt(0,(int) Math.sqrt(n*10)));
            }
            grass.add(new Grass(v));
        }
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return !(objectAt(position) instanceof Animal);
    }

    @Override
    public Object returnObject(Vector2d position){
        for (Animal creature: this.animals) {
            if (creature.isAt(position)) {
                return creature;
            }
        }
        for (Grass grass1: this.grass){
            if (grass1.getPosition().equals(position)){
                return grass1;
            }
        }
        return null;
    }

    @Override
    public Vector2d lowerLeft(){
        Vector2d v = this.animals.get(0).getPosition();
        for (Animal animal: this.animals){
            v = v.lowerLeft(animal.getPosition());
        }
        for (Grass grass1: this.grass){
            v = v.lowerLeft(grass1.getPosition());
        }
        return v;
    }

    @Override
    public Vector2d upperRight(){
        Vector2d v = this.animals.get(0).getPosition();
        for (Animal animal: this.animals){
            v = v.upperRight(animal.getPosition());
        }
        for (Grass grass1: this.grass){
            v = v.upperRight(grass1.getPosition());
        }
        return v;
    }
}
