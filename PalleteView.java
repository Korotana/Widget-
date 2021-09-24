package sample;

import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PalleteView extends Pane {

    private Circle c1;
    private Circle c2;
    private Circle c3;
    private ColourPallete palette;
    private HBox circleBox;

    public PalleteView(ColourPallete palette) {
        if (palette != null) {
            this.palette = palette;
            setCircles();
        }
        else {
            this.palette = new ColourPallete();
            setCircles();
        }
    }

    /**
     * Creating Pallete of three circles
     */
    private void setCircles() {
        c1 = new Circle(35);
        c1.setFill(palette.getCircle1());
        c1.setStroke(Color.BLACK);

        c2 = new Circle(35);
        c2.setFill(palette.getCircle2());
        c2.setStroke(Color.BLACK);

        c3 = new Circle(35);
        c3.setFill(palette.getCircle3());
        c3.setStroke(Color.BLACK);
//        hbox of pallete
        circleBox = new HBox(c1, c2, c3);
        circleBox.setSpacing(5);
        this.getChildren().addAll(this.circleBox);
    }

    public ColourPallete getPalette() {
        return palette;
    }

    public void setPalette(ColourPallete palette) {
        this.palette = palette;
    }

    public HBox getCircleBox() {
        return circleBox;
    }

    public Circle getC1() {
        return c1;
    }

    public Circle getC2() {
        return c2;
    }

    public Circle getC3() {
        return c3;
    }
}
