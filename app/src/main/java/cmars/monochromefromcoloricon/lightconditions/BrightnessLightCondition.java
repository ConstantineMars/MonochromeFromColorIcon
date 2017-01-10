package cmars.monochromefromcoloricon.lightconditions;

/**
 * Created by Constantine Mars on 1/10/17.
 */

public class BrightnessLightCondition implements LightCondition {
    final float factor = 255f;
    final float redBri = 0.2126f;
    final float greenBri = 0.2126f;
    final float blueBri = 0.0722f;

    @Override
    public boolean isLight(int inpixel) {
        int R = (inpixel >> 16) & 0xFF;
        int G = (inpixel >> 8) & 0xFF;
        int B = inpixel & 0xFF;

        float lum = (redBri * R / factor) + (greenBri * G / factor) + (blueBri * B / factor);

        return lum > 0.4;
    }
}
