package agh.ics.oop;

public class World {
    public static void main(String[] args){
        System.out.println("system wystartowal");
        Directions[] d = toDirections(args);
        run(d);
        System.out.println("system zakonczyl dzialanie");
        Vector2d position1 = new Vector2d(1,2);
        System.out.println(position1);
        Vector2d position2 = new Vector2d(-2,1);
        System.out.println(position2);
        System.out.println(position1.add(position2));
        MapDirection test = MapDirection.NORTH;
        System.out.println(test.toUnitVector());
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
                case PRAWO -> System.out.println("Zwierzak skreca w prawo");
                case LEWO -> System.out.println("Zwierzak skreca w lewo");
                case PRZOD -> System.out.println("Zwierzak idzie do przodu");
                case TYL -> System.out.println("Zwierzak idzie do tylu");
                default -> System.out.print("");
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
                default -> dir[j] = Directions.DEFAULT;
            }
            j++;
        }
        return dir;
    }
}
