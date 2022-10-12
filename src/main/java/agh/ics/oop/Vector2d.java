package agh.ics.oop;

public class Vector2d {
    public final int x;
    public final int y;

    public Vector2d(int x, int y){
        this.x = x;
        this.y = y;
    }

    public String toString(){
        return ("("+ Integer.toString(x) + ","+ Integer.toString(y) + ")");
    }

    public boolean precedes(Vector2d v){
        return (this.x <= v.x && this.y <= v.y);
    }
}
