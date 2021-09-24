package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;


public class Main extends Application {

    private int inired = 0;
    private int iniblue = 0;
    private int inigreen = 0;
    private Color currentcolor = Color.rgb(50,50,50);
    private Circle parentCircle;
    private ColourPallete pallete;
    private ListView<ColourPallete> listView;
    private ObservableList<ColourPallete> observableList;
    private int selctcrcl = 0;
    private PalleteView palleteView;
    private PaletteCell palleteCell;
    private ColorSlider redColorSlider,greenColorSlider,blueColorSlider;
    private int index  = 0;

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Creating new pallete of three circles
        palleteView = new PalleteView(pallete);
        pallete = new ColourPallete();

        observableList = FXCollections.observableArrayList();

        VBox root = new VBox();
        HBox root1 = new HBox();
        Stage stage = new Stage();
        Scene scene = new Scene(root1, 500, 500,Color.LIGHTBLUE);

//        Main circle which would have current colour
        parentCircle = new Circle();
        parentCircle.setRadius(50);
        parentCircle.setFill(Color.rgb(50,50,50));
        parentCircle.setStroke(Color.BLACK);

//       Current colour Hbox
        HBox mainCircleHBox = new HBox(10);
//        padding is top right bottom left
        mainCircleHBox.setPadding(new Insets(30,0,0,50));
        HBox.setMargin(parentCircle,new Insets(5));
//        positioning the Current color Circle Hbox
        mainCircleHBox.setAlignment(Pos.TOP_LEFT);
        mainCircleHBox.getChildren().addAll(parentCircle);
//       slider set created
        setColorSlider();
//      Creating buttons
        Button palletebutton = new Button();
        palletebutton.setText("Add to Pallette");
        palletebutton.setLayoutX(90);
        palletebutton.setLayoutY(280);
//        assigning action/function of add to pallete button
        palletebutton.setOnAction(e -> addToPallet());

        Button listbutton = new Button();
        listbutton.setText("Add to List");
//        assigning action/function of add to list button
        listbutton.setOnAction(e -> addToList());

//       Creating Listview object
        listView = new ListView<>();
        listView.setPrefWidth(240);
//        contents of listview an Observable list
        listView.setItems(observableList);
        listView.setCellFactory(listItem-> new PaletteCell());

//        Creating Hbox of listView
        HBox listBox = new HBox(listView);
        listBox.setPrefHeight(100);
        listBox.setAlignment(Pos.CENTER_RIGHT);

//        correcting position of Vbox(root) and its contents
        root.setSpacing(25);
        root.setMargin(redColorSlider.getBox(),new Insets(0,0,0,25));
        root.setMargin(greenColorSlider.getBox(),new Insets(0,0,0,25));
        root.setMargin(blueColorSlider.getBox(),new Insets(0,0,0,25));
        root.setMargin(palletebutton,new Insets(0,0,0,60));
        root.setMargin(palleteView.getCircleBox(),new Insets(0,0,0,15));
        root.setMargin(listbutton,new Insets(0,0,0,80));

        root1.setSpacing(15);
//        adding all boxes and sliders in main Vbox
        root.getChildren().addAll(mainCircleHBox,redColorSlider.getBox(),greenColorSlider.getBox(),blueColorSlider.getBox(),palletebutton,palleteView.getCircleBox(),listbutton);
        root1.getChildren().addAll(root,listBox);
//        setting and displaying scene
        stage.setScene(scene);
        stage.show();
    }

    /**
     * method for creating sliders labels and values of slider and their action on moving slider
     */
    private void setColorSlider() {
        redColorSlider = new ColorSlider("Red");
//
        redColorSlider.getSlider().valueProperty().addListener(changed->{
            redColorSlider.getSliderValue().setText(Integer.toString((int)redColorSlider.getSlider().getValue()));
//            assigning inired value of slider after moving slider
            inired = (int)redColorSlider.getValue();
            setcolor();
        });

        greenColorSlider = new ColorSlider("Green");
        greenColorSlider.getSlider().valueProperty().addListener(changed->{
            greenColorSlider.getSliderValue().setText(Integer.toString((int)greenColorSlider.getSlider().getValue()));
            inigreen = (int)greenColorSlider.getValue();
            setcolor();
        });

        blueColorSlider = new ColorSlider("Blue");
        blueColorSlider.getSlider().valueProperty().addListener(changed->{
            blueColorSlider.getSliderValue().setText(Integer.toString((int)blueColorSlider.getSlider().getValue()));
            iniblue = (int)blueColorSlider.getValue();
            setcolor();
        });
    }

    private void addToList() {
//        adding pallete to observableList
          observableList.add(this.pallete);

    }

//adding maincrcl colour to circle 1 of pallete of three colours when button add to pallete is clicked
    private void addToPallet() {
        if(selctcrcl == 0){
            palleteView.getC1().setFill(currentcolor);
        }else if (selctcrcl == 1){
            palleteView.getC2().setFill(currentcolor);
        }else if (selctcrcl == 2){
            palleteView.getC3().setFill(currentcolor);
        }
        selctcrcl+=1;
        if (selctcrcl == 3){selctcrcl=0;}
        pallete.addColor(currentcolor);
        palleteView.setPalette(pallete);
    }

//  updating current colour of maincircle
    public void setcolor(){
        Color colorset = Color.rgb(inired,inigreen,iniblue);
        parentCircle.setFill(colorset);
        currentcolor = colorset;
    }

    public static void main(String[] args) {
        launch(args);
    }
}