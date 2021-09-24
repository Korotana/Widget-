package sample;

import javafx.scene.control.ListCell;
import javafx.scene.paint.Color;

import java.util.Random;

public class PaletteCell extends ListCell<ColourPallete> {

    public void updateItem(ColourPallete item, boolean empty) {
        super.updateItem(item, empty);
        PalleteView pv = new PalleteView(item);
        setGraphic(pv.getCircleBox());

    }

}
