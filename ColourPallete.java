package sample;

import javafx.scene.paint.Color;

public class ColourPallete {

    private Color circle1;
    private Color circle2;
    private Color circle3;
    private int paltcontr = 0;

    /**
     * Assigning circles of palletes colour
     */
    public ColourPallete() {
        this.circle1 = Color.WHITE;
        this.circle2 = Color.WHITE;
        this.circle3 = Color.WHITE;
    }

    /**
     * Updating colour of circles of pallete
     * @param c New colour for circle of pallete
     */
    public void addColor(Color c) {
        if (paltcontr == 0) circle1 = c;
        else if (paltcontr == 1) circle2 = c;
        else if (paltcontr == 2) circle3 = c;
        paltcontr += 1;
        if (paltcontr == 3) paltcontr = 0;
    }

    public Color getCircle1() {return circle1;}

    public Color getCircle2() {return circle2;}

    public Color getCircle3() {return circle3;}

    @Override
    public String toString() {
        String colorstring;
        colorstring = circle1.getRed() + "," + circle1.getGreen() + "," + circle1.getBlue() + "\n";
        colorstring += circle2.getRed() + "," + circle2.getGreen() + "," + circle2.getBlue() + "\n";
        colorstring += circle3.getRed() + "," + circle3.getGreen() + "," + circle3.getBlue() + "\n";
        return colorstring;
    }
}
