package agh.ics.oop;

import java.util.Objects;

class OptionParser {

    public static MoveDirection[] parse(String[] args){
        MoveDirection[] dir = new MoveDirection[args.length];
        int i = 0;
        for (String command: args) {
            switch (command){
                case "f", "forward" -> {dir[i] = MoveDirection.FORWARD; i++;}
                case "b", "backward" -> {dir[i] = MoveDirection.BACKWARD; i++;}
                case "r", "right" -> {dir[i] = MoveDirection.RIGHT; i++;}
                case "l", "left" -> {dir[i] = MoveDirection.LEFT; i++;}
            }
        }
        return dir;
    }
}
