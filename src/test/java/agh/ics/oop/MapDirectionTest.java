package agh.ics.oop;
import org.junit.jupiter.api.Test;


public class MapDirectionTest {

    public static void main(String[] args){
        testNext();
    }

    @Test
    public static void testNext(){
        boolean flag = true;
        for (MapDirection direction: MapDirection.values()){
            if (!flag){
                throw new AssertionError();
            }
            flag = switch (direction) {
                case EAST -> direction.next() == MapDirection.SOUTH;
                case WEST -> direction.next() == MapDirection.NORTH;
                case NORTH -> direction.next() == MapDirection.EAST;
                case SOUTH -> direction.next() == MapDirection.WEST;
            };
        }
    }

    @Test
    public static void testPrevious(){
        boolean flag = true;
        for (MapDirection direction: MapDirection.values()){
            if (!flag){
                throw new AssertionError();
            }
            flag = switch (direction) {
                case EAST -> direction.next() == MapDirection.NORTH;
                case WEST -> direction.next() == MapDirection.SOUTH;
                case NORTH -> direction.next() == MapDirection.WEST;
                case SOUTH -> direction.next() == MapDirection.EAST;
            };
        }
    }
}
