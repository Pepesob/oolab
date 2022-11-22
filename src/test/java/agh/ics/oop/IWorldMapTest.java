package agh.ics.oop;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class IWorldMapTest {

    IWorldMap rm = new RectangularMap(10,10);
    IWorldMap gf = new GrassField(10);
    Vector2d initPos = new Vector2d(4,5);
    Animal creaturerm = new Animal(rm, initPos);
    Animal creaturegf = new Animal(gf, initPos);


    private void resetVariables(){
        rm = new RectangularMap(10,10);
        gf = new GrassField(10);
        initPos = new Vector2d(4,5);
        creaturerm = new Animal(rm, initPos);
        creaturegf = new Animal(gf, initPos);
    }


    @Test
    void assertPlace(){
        resetVariables();
        Assertions.assertTrue(rm.place(creaturerm));
        Assertions.assertFalse(rm.place(new Animal(rm, initPos)));
        Assertions.assertTrue(gf.place(creaturegf));
        Assertions.assertFalse(gf.place(new Animal(gf, initPos)));
    }

    @Test
    void assertCanMoveTo(){
        resetVariables();
        rm.place(creaturerm);
        Assertions.assertFalse(rm.canMoveTo(initPos));
        Assertions.assertTrue(rm.canMoveTo(new Vector2d(1,1)));
        gf.place(creaturegf);
        Assertions.assertFalse(gf.canMoveTo(initPos));
        Assertions.assertTrue(gf.canMoveTo(new Vector2d(1,1)));
    }


    @Test
    void assertIsOccupied(){
        resetVariables();
        rm.place(creaturerm);
        gf.place(creaturegf);
        Assertions.assertTrue(rm.isOccupied(initPos));
        Assertions.assertFalse(rm.isOccupied(new Vector2d(1,1)));

        Assertions.assertTrue(gf.isOccupied(initPos));
    }

    //Assertions.assertFalse(gf.isOccupied(new Vector2d(1,1)));
    @Test
    void assertObjectAt(){
        resetVariables();
        rm.place(creaturerm);
        gf.place(creaturegf);
        Assertions.assertSame(creaturerm, rm.objectAt(initPos));
        Assertions.assertNotSame(creaturerm, rm.objectAt(new Vector2d(1,1)));
        Assertions.assertSame(creaturegf, gf.objectAt(initPos));
        Assertions.assertNotSame(creaturegf, gf.objectAt(new Vector2d(1,1)));
    }
}
