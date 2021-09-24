package sample;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class ColorSlider extends Pane {

    private Label sliderValue;
    private Label colorLabel;
    private HBox box;
    public Slider slider;

    /**
     * method for creating slider and a Hbox of sliders label slider itself and its value
     * @param title label(red,green or blue) of slider
     */
    public ColorSlider(String title) {
        this.colorLabel = new Label(title);
        this.sliderValue = new Label("50");
        slider = new Slider(0, 255, 50);
        box = new HBox(colorLabel, slider, sliderValue);
        box.setAlignment(Pos.CENTER_LEFT);
        int space = 10;
        if(title.equals("Green") ) space = 5;
        box.setSpacing(space);
    }

    public HBox getBox() {
        return box;
    }

    public Label getSliderValue() {
        return sliderValue;
    }

    public Slider getSlider() {
        return slider;
    }

    public double getValue() {
        return slider.getValue();
    }

    public void setValue(Double newValue) {
        slider.setValue(newValue);
        sliderValue.setText(newValue + "");
    }

}
