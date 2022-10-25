package agh.ics.oop;
import org.junit.jupiter.api.Test;


public class MapDirectionTest {

    public static void main(String[] args){
        testNext();
        System.out.println("Test 1 passed");
        testPrevious();
        System.out.println("Test 2 passed");
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
                case EAST -> direction.previous() == MapDirection.NORTH;
                case WEST -> direction.previous() == MapDirection.SOUTH;
                case NORTH -> direction.previous() == MapDirection.WEST;
                case SOUTH -> direction.previous() == MapDirection.EAST;
            };
        }
    }
}
