package cmars.monochromefromcoloricon.helpers;

/**
 * Created by Constantine Mars on 1/10/17.
 */

public class ColorHelper {
    public static int getRed(int inpixel) {
        return (inpixel >> 16) & 0xFF;
    }

    public static int getGreen(int inpixel) {
        return (inpixel >> 8) & 0xFF;
    }

    public static int getBlue(int inpixel) {
        return inpixel & 0xFF;
    }
}
