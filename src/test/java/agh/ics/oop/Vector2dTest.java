package agh.ics.oop;
import org.junit.jupiter.api.Test;

public class Vector2dTest {

    public static void main(String[] args){
        testEquals();
        System.out.println("Test 1 passed");
        testToString();
        System.out.println("Test 2 passed");
        testPrecedes();
        System.out.println("Test 3 passed");
        testFollows();
        System.out.println("Test 4 passed");
        testUpperRight();
        System.out.println("Test 5 passed");
        testLowerLeft();
        System.out.println("Test 6 passed");
        testAdd();
        System.out.println("Test 7 passed");
        testSubtract();
        System.out.println("Test 8 passed");
        testOpposite();
        System.out.println("Test 9 passed");
    }

    @Test
    public static void testEquals(){
        Vector2d v1 = new Vector2d(1,1);
        Vector2d v2 = new Vector2d(1,1);
        Vector2d v3 = new Vector2d(1,3);
        if (!v1.equals(v2)){
            throw new AssertionError();
        }
        if (v2.equals(v3)) {
            throw new AssertionError();
        }
    }

    @Test
    public static void testToString(){
        int x = 4;
        int y = 3;
        Vector2d v1 = new Vector2d(x, y);
        String cords = v1.toString();
        if (!(Integer.parseInt(cords.substring(1, cords.indexOf(","))) == x && Integer.parseInt(cords.substring(cords.indexOf(",")+1,cords.length()-1)) == y)){
            throw new AssertionError();
        }
    }

    @Test
    public static void testPrecedes(){
        Vector2d v1 = new Vector2d(1,2);
        Vector2d v2 = new Vector2d(2,3);
        if (!(v1.precedes(v2))){
            throw new AssertionError();
        }
        if (v2.precedes(v1)){
            throw new AssertionError();
        }
    }

    @Test
    public static void testFollows(){
        Vector2d v1 = new Vector2d(1,2);
        Vector2d v2 = new Vector2d(2,3);
        if (v1.follows(v2)){
            throw new AssertionError();
        }
        if (!(v2.follows(v1))){
            throw new AssertionError();
        }
    }

    @Test
    public static void testUpperRight(){
        Vector2d v1 = new Vector2d(1,2);
        Vector2d v2 = new Vector2d(2,3);
        Vector2d v3 = v1.upperRight(v2);
        if (!(v3.x == 2 && v3.y == 3)){
            throw new AssertionError();
        }
    }

    @Test
    public static void testLowerLeft(){
        Vector2d v1 = new Vector2d(1,2);
        Vector2d v2 = new Vector2d(2,3);
        Vector2d v3 = v1.lowerLeft(v2);
        if (!(v3.x == 1 && v3.y == 2)){
            throw new AssertionError();
        }
    }

    @Test
    public static void testAdd(){
        Vector2d v1 = new Vector2d(1,2);
        Vector2d v2 = new Vector2d(2,3);
        Vector2d v3 = v1.add(v2);
        if (!(v3.x == v1.x + v2.x && v3.y == v1.y + v2.y)){
            throw new AssertionError();
        }
    }

    @Test
    public static void testSubtract(){
        Vector2d v1 = new Vector2d(1,2);
        Vector2d v2 = new Vector2d(2,3);
        Vector2d v3 = v1.subtract(v2);
        if (!(v3.x == v1.x - v2.x && v3.y == v1.y - v2.y)){
            throw new AssertionError();
        }
    }

    @Test
    public static void testOpposite(){
        Vector2d v1 = new Vector2d(2,3);
        Vector2d v2 = v1.opposite();
        if (!(-v1.x == v2.x & -v1.y == v2.y)){
            throw new AssertionError();
        }
    }
}
