package agh.ics.oop;

import java.util.Map;

public class Animal {
    private Vector2d position;
    private MapDirection face = MapDirection.NORTH;

    public IWorldMap world;

    public Animal(){
        this.position = new Vector2d(2,2);
    }

    public Animal(IWorldMap map){
        this.world = map;
        this.position = new Vector2d(2,2);
    }

    public Animal(IWorldMap map, Vector2d initialPosition){
        this.world = map;
        this.position = initialPosition;
    }

    public String toString(){
        return face.simplifiedString();
    }

    public boolean isAt(Vector2d pos){
        return this.position.equals(pos);
    }

    public void move(MoveDirection direction){
        switch (direction) {
            case LEFT -> this.face = face.previous();
            case RIGHT -> this.face = face.next();
            case FORWARD -> {
                Vector2d move_f = this.position.add(this.face.toUnitVector());
                if (this.world.canMoveTo(move_f)) {
                    this.position = move_f;
                }
            }
            case BACKWARD -> {
                Vector2d move_b = this.position.add(this.face.toUnitVector().opposite());
                if (this.world.canMoveTo(move_b)) {
                    this.position = move_b;
                }
            }
        }
    }

    public Vector2d getPosition() {return position;}

    public MapDirection getFace() {return face;}

}
