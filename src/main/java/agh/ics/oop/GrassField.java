package agh.ics.oop;

import java.util.*;

public class GrassField extends AbstractWorldMap {

    int n;
    Map<Vector2d, Grass> grass = new HashMap<>();

    public GrassField(int n){
        this.n = n;
        for (int i = 0; i < n; i++){
            addGrass();
        }
    }

    private void addGrass(){
        Random r = new Random();
        Vector2d v = new Vector2d(r.nextInt(0,(int) Math.sqrt(n*10)),r.nextInt(0,(int) Math.sqrt(n*10)));
        while (isOccupied(v)){
            v = new Vector2d(r.nextInt(0,(int) Math.sqrt(n*10)),r.nextInt(0,(int) Math.sqrt(n*10)));
        }
        grass.put(v,new Grass(v));
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        if (objectAt(position) instanceof Animal){
            return false;
        }
        if (objectAt(position) instanceof Grass){
            grass.remove(position);
            addGrass();
        }
        return true;
    }

    @Override
    public Object returnObject(Vector2d position){
        if (animals.get(position) != null){
            return animals.get(position);
        }
        return grass.get(position);
    }

    @Override
    public Vector2d lowerLeft(){
        Vector2d v = new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE);
        for (Animal animal: this.animals.values()){
            v = v.lowerLeft(animal.getPosition());
        }
        for (Grass grass1: this.grass.values()){
            v = v.lowerLeft(grass1.getPosition());
        }
        return v;
    }

    @Override
    public Vector2d upperRight(){
        Vector2d v = new Vector2d(Integer.MIN_VALUE, Integer.MIN_VALUE);
        for (Animal animal: this.animals.values()){
            v = v.upperRight(animal.getPosition());
        }
        for (Grass grass1: this.grass.values()){
            v = v.upperRight(grass1.getPosition());
        }
        return v;
    }

}
