package agh.ics.oop;

public class Animal {
    private Vector2d position = new Vector2d(2,2);
    private MapDirection face = MapDirection.NORTH;

    public String toString(){
        return ("Position: " + position.toString() + "\nDirection: " + face.toString());
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
                if (0 <= move_f.x && move_f.x <= 4 && 0 <= move_f.y && move_f.y <= 4) {
                    this.position = move_f;
                }
            }
            case BACKWARD -> {
                Vector2d move_b = this.position.add(this.face.toUnitVector().opposite());
                if (0 <= move_b.x && move_b.x <= 4 && 0 <= move_b.y && move_b.y <= 4) {
                    this.position = move_b;
                }
            }
        }
    }
}
