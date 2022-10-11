package agh.ics.oop;

public class World {
    public static void main(String[] args){
        System.out.println("system wystartował");
        Directions[] d = toDirections(args);
        run(d);
        System.out.println("system zakończył działanie");
    }

    static void print_str_arr(String[] arr){
        for (int i=0; i < arr.length-1; i++){
            System.out.print(arr[i]+",");
        }
        if (arr.length != 0) {
            System.out.println(arr[arr.length - 1]);
        }
    }
    static void run(Directions[] arr){
        for (Directions command: arr) {
            switch (command) {
                case PRAWO -> System.out.println("Zwierzak skręca w prawo");
                case LEWO -> System.out.println("Zwierzak skręca w lewo");
                case PRZOD -> System.out.println("Zwierzak idzie do przodu");
                case TYL -> System.out.println("Zwierzak idzie do tyłu");
            }
        }
    }
    static Directions[] toDirections(String[] arr){
        Directions[] dir = new Directions[arr.length];
        int j = 0;
        for (String command : arr) {
            switch (command) {
                case "f" -> dir[j] = Directions.PRZOD;
                case "b" -> dir[j] = Directions.TYL;
                case "r" -> dir[j] = Directions.PRAWO;
                case "l" -> dir[j] = Directions.LEWO;
            }
            j++;
        }
        return dir;
    }
}
