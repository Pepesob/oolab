package agh.ics.oop;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class IWorldMapTest {


    @Test
    void assertPlace(){
        IWorldMap rm = new RectangularMap(10,10);
        IWorldMap gf = new GrassField(10);
        Vector2d initPos = new Vector2d(4,5);
        Animal creaturerm = new Animal(rm, initPos);
        Animal creaturegf = new Animal(gf, initPos);
        Assertions.assertTrue(rm.place(creaturerm));
        Assertions.assertFalse(rm.place(new Animal(rm, initPos)));
        Assertions.assertTrue(gf.place(creaturerm));
        Assertions.assertFalse(gf.place(new Animal(gf, initPos)));
    }

    @Test
    void assertCanMoveTo(){
        IWorldMap rm = new RectangularMap(10,10);
        IWorldMap gf = new GrassField(10);
        Vector2d initPos = new Vector2d(4,5);
        Animal creaturerm = new Animal(rm, initPos);
        Animal creaturegf = new Animal(gf, initPos);
        rm.place(creaturerm);
        Assertions.assertTrue(rm.canMoveTo(initPos));
        Assertions.assertFalse(rm.canMoveTo(new Vector2d(1,1)));
        gf.place(creaturegf);
        Assertions.assertTrue(gf.canMoveTo(initPos));
        Assertions.assertFalse(gf.canMoveTo(new Vector2d(1,1)));
    }


    @Test
    void assertIsOccupied(){
        IWorldMap rm = new RectangularMap(10,10);
        IWorldMap gf = new GrassField(10);
        Vector2d initPos = new Vector2d(4,5);
        Animal creaturerm = new Animal(rm, initPos);
        Animal creaturegf = new Animal(gf, initPos);
        rm.place(creaturerm);
        gf.place(creaturegf);
        Assertions.assertTrue(rm.isOccupied(initPos));
        Assertions.assertFalse(rm.isOccupied(new Vector2d(1,1)));
        Assertions.assertTrue(gf.isOccupied(initPos));
        Assertions.assertFalse(gf.isOccupied(new Vector2d(1,1)));
    }

    @Test
    void assertObjectAt(){
        IWorldMap rm = new RectangularMap(10,10);
        IWorldMap gf = new GrassField(10);
        Vector2d initPos = new Vector2d(4,5);
        Animal creaturerm = new Animal(rm, initPos);
        Animal creaturegf = new Animal(gf, initPos);
        rm.place(creaturerm);
        gf.place(creaturegf);
        Assertions.assertSame(creaturerm, rm.objectAt(initPos));
        Assertions.assertNotSame(creaturerm, rm.objectAt(new Vector2d(1,1)));
        Assertions.assertSame(creaturegf, gf.objectAt(initPos));
        Assertions.assertNotSame(creaturegf, gf.objectAt(new Vector2d(1,1)));
    }
}
