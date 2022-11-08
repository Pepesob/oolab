package agh.ics.oop;

import org.junit.jupiter.api.Test;

import java.util.Objects;

public class IntegrationTest {

    public static void main(String[] args) {
        MoveDirection[] directions = OptionParser.parse(args);
        IWorldMap map = new RectangularMap(10, 5);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();

        IWorldMap test_map = new RectangularMap(10, 5);
        assertExpectedPos(makeAnimals(positions, test_map), directions, test_map);

        System.out.println(map);
        System.out.println(test_map);
        System.out.println(map.toString().equals(test_map.toString()));
    }

    private static void assertExpectedPos(Animal[] animals, MoveDirection[] directions, IWorldMap map){
        int animal_index;
        int i = 0;
        for (MoveDirection command: directions){
            animal_index = i%animals.length;
            animals[animal_index].move(command);
            i++;
        }
        for (Animal creature: animals){
            if (!(creature.equals(map.objectAt(creature.getPosition())))){
                throw new AssertionError();
            }
        }
    }

    private static Animal[] makeAnimals(Vector2d[] vectors, IWorldMap map){
        Animal[] animals = new Animal[vectors.length];
        for (int i = 0; i < vectors.length; i++){
            animals[i] = new Animal(map, vectors[i]);
            map.place(animals[i]);
        }
        return animals;
    }
}






//        System.out.println("Start");
//
//        Vector2d expectPos = new Vector2d(2,2);
//        MapDirection expectOrient = MapDirection.NORTH;
//
//        Animal creature = new Animal();
//
//        MoveDirection[] commands = OptionParser.parse(args);
//        assertCommands(args, commands);
//
//        for (MoveDirection command: commands){
//            if (command == null){
//                break;
//            }
//            creature.move(command);
//            expectOrient = changeExpectOrient(command, expectOrient);
//            expectPos = changeExpectPos(command, expectPos, expectOrient);
//            assertWrong(creature, expectPos, expectOrient);
//        }
//        System.out.println("Stop");
//    }
//
//    private static Vector2d changeExpectPos(MoveDirection command, Vector2d expectPos, MapDirection expectOrient){
//        switch (command){
//            case FORWARD -> {expectPos = expectPos.add(expectOrient.toUnitVector());}
//            case BACKWARD -> {expectPos = expectPos.add(expectOrient.toUnitVector().opposite());}
//        }
//        if (expectPos.x > 4){
//            expectPos = new Vector2d(4, expectPos.y);
//        }
//        if (expectPos.x < 0){
//            expectPos = new Vector2d(0, expectPos.y);
//        }
//        if (expectPos.y > 4){
//            expectPos = new Vector2d(expectPos.x, 4);
//        }
//        if (expectPos.y < 0){
//            expectPos = new Vector2d(expectPos.x, 0);
//        }
//        return expectPos;
//    }
//
//    private static MapDirection changeExpectOrient(MoveDirection command, MapDirection expectOrient){
//        switch (command){
//            case RIGHT -> {return expectOrient.next();}
//            case LEFT -> {return expectOrient.previous();}
//        }
//        return expectOrient;
//    }
//
//    private static void assertWrong(Animal creature, Vector2d expectPos, MapDirection expectOrient){
//        // jeżeli zwierze wyjdzie poza mapę to nie będzie się zgadzać z przewidywanymi wartościami
//        if (!(creature.toString().equals("Position: " + expectPos.toString() + "\nDirection: " + expectOrient.toString()))){
//            throw new AssertionError();
//        }
//    }
//
//    private static void assertCommands(String[] args, MoveDirection[] commands){
//        MoveDirection direction;
//        int i = 0;
//        for (String command: args) {
//            switch (command){
//                case "f", "forward" -> {direction = MoveDirection.FORWARD;}
//                case "b", "backward" -> {direction = MoveDirection.BACKWARD;}
//                case "r", "right" -> {direction = MoveDirection.RIGHT;}
//                case "l", "left" -> {direction = MoveDirection.LEFT;}
//                default -> {continue;}
//            }
//            if (direction != commands[i]){
//                throw new AssertionError();
//            }
//            i++;
//        }
//    }

