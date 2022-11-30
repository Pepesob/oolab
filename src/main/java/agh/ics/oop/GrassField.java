package agh.ics.oop;

import java.util.*;

public class GrassField extends AbstractWorldMap {

    int n;
    public Map<Vector2d, Grass> grass = new HashMap<>();

    public GrassField(int n){
        this.mapBoundary = new MapBoundary();
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
        mapBoundary.add(v);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        if (objectAt(position) instanceof Animal){
            return false;
        }
        if (objectAt(position) instanceof Grass){
            grass.remove(position);
            mapBoundary.remove(position);
            addGrass();
        }
        return true;
    }

    @Override
    public Object returnObject(Vector2d position) {
        if (animals.get(position) != null) {
            return animals.get(position);
        }
        return grass.get(position);
    }

}
