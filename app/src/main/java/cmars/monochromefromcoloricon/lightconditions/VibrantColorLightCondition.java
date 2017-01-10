package cmars.monochromefromcoloricon.lightconditions;

import android.graphics.Bitmap;
import android.support.v7.graphics.Palette;

import static cmars.monochromefromcoloricon.helpers.ColorHelper.getBlue;
import static cmars.monochromefromcoloricon.helpers.ColorHelper.getGreen;
import static cmars.monochromefromcoloricon.helpers.ColorHelper.getRed;

/**
 * Created by Constantine Mars on 1/10/17.
 */

public class VibrantColorLightCondition implements LightCondition {

    private final static int THRESHOLD = 25;
    private static int vibrantRMin;
    private static int vibrantRMax;
    private static int vibrantGMin;
    private static int vibrantGMax;
    private static int vibrantBMin;
    private static int vibrantBMax;
    private int vibrantR;
    private int vibrantG;
    private int vibrantB;

    public VibrantColorLightCondition(Bitmap src) {
        Palette palette = Palette.from(src).generate();
        int vibrantColor = palette.getVibrantSwatch().getRgb();

        vibrantR = getRed(vibrantColor);
        vibrantG = getGreen(vibrantColor);
        vibrantB = getBlue(vibrantColor);

        vibrantRMin = vibrantR - THRESHOLD;
        vibrantRMax = vibrantR + THRESHOLD;

        vibrantGMin = vibrantG - THRESHOLD;
        vibrantGMax = vibrantG + THRESHOLD;

        vibrantBMin = vibrantB - THRESHOLD;
        vibrantBMax = vibrantB + THRESHOLD;
    }

    private static boolean matchesRedWithThreshold(int inR) {
        return matchesWithThreshold(inR, vibrantRMin, vibrantRMax);
    }

    private static boolean matchesGreenWithThreshold(int inG) {
        return matchesWithThreshold(inG, vibrantGMin, vibrantGMax);
    }

    private static boolean matchesBlueWithThreshold(int inB) {
        return matchesWithThreshold(inB, vibrantBMin, vibrantBMax);
    }

    private static boolean matchesWithThreshold(int inColor, int vibrantMin, int vibrantMax) {
        return (inColor >= vibrantMin && inColor <= vibrantMax);
    }

    @Override
    public boolean isLight(int inpixel) {

        int inRed = getRed(inpixel);
        int inGreen = getGreen(inpixel);
        int inBlue = getBlue(inpixel);

        return (matchesRedWithThreshold(inRed)
                && matchesGreenWithThreshold(inGreen)
                && matchesBlueWithThreshold(inBlue));
    }
}
