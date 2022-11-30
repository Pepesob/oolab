
package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;


public class App extends Application {
    private GrassField map;

    Vector2d lowerLeft;
    Vector2d upperRight;


    public void init(){

        String[] args = getParameters().getRaw().toArray(new String[0]);

        try{MoveDirection[] directions = OptionParser.parse(args);
            map = new GrassField(10);
            Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
            IEngine engine = new SimulationEngine(directions, map, positions);
            engine.run();
            System.out.println(map);
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            System.exit(0);
        }
    }
    public void start(Stage stage){

        int width = 20;
        int height = 20;

        Vector2d lowerLeft = map.lowerLeft();
        Vector2d upperRight = map.upperRight();

        GridPane gridPane = new GridPane();
        gridPane.setGridLinesVisible(true);

        Label elem = new Label("y\\x");
        gridPane.add(elem,0,0);
        GridPane.setHalignment(elem, HPos.CENTER);

        for (int i = 0; i <= upperRight.y; i++) {
            RowConstraints row = new RowConstraints(height);
            gridPane.getRowConstraints().add(row);
            elem = new Label(Integer.toString(i));
            gridPane.add(elem,i+1,0);
            GridPane.setHalignment(elem, HPos.CENTER);
        }

        for (int i = 0; i <= upperRight.x; i++) {
            ColumnConstraints col = new ColumnConstraints(width);
            gridPane.getColumnConstraints().add(col);
            elem = new Label(Integer.toString(i));
            gridPane.add(elem,0,upperRight.y - i+1);
            GridPane.setHalignment(elem, HPos.CENTER);
        }


        for (Animal animal: map.animals.values()){
            placeObject(animal, animal.getPosition(), gridPane);
        }

        for (Grass grass: map.grass.values()){
            placeObject(grass,grass.getPosition(),gridPane);
        }


        Scene scene = new Scene(gridPane, 400, 400);
        stage.setScene(scene);
        stage.show();
    }

    private void placeObject(Object o,Vector2d pos, GridPane gridPane){
        Label elem = new Label(o.toString());
        gridPane.add(elem, pos.x+1,  map.upperRight().y-pos.y+1);
        GridPane.setHalignment(elem, HPos.CENTER);
    }
}
