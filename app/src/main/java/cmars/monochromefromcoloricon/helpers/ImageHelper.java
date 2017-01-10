package cmars.monochromefromcoloricon.helpers;

import android.graphics.Bitmap;

import cmars.monochromefromcoloricon.lightconditions.BrightnessLightCondition;
import cmars.monochromefromcoloricon.lightconditions.LightCondition;
import cmars.monochromefromcoloricon.lightconditions.VibrantColorLightCondition;

/**
 * Created by Constantine Mars on 1/5/17.
 */

public class ImageHelper {

    private static final int WHITE = 0xFFFFFFFF;
    private static final int BLACK = 0xFF000000;
    private static final int TRANSPARENT = 0x00000000;

    public static Bitmap createMonochromeBasedOnBrightness(Bitmap src) {
        return createMonochromeWithCriteria(src, WHITE, BLACK, new BrightnessLightCondition());
    }

    public static Bitmap createBlackIconBasedOnVibrantColor(Bitmap src) {
        return createMonochromeWithCriteria(src, BLACK, TRANSPARENT, new VibrantColorLightCondition(src));
    }

    public static Bitmap createWhiteIconBasedOnVibrantColor(Bitmap src) {
        return createMonochromeWithCriteria(src, WHITE, TRANSPARENT, new VibrantColorLightCondition(src));
    }

    private static Bitmap createMonochromeWithCriteria(Bitmap src, int primaryColor, int secondaryColor, LightCondition lightCondition) {
        int width = src.getWidth();
        int height = src.getHeight();

        Bitmap bmOut = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);

        int length = width * height;
        int[] inpixels = new int[length];
        int[] oupixels = new int[length];

        src.getPixels(inpixels, 0, width, 0, 0, width, height);

        int point = 0;
        for (int pix : inpixels) {

            if (lightCondition.isLight(pix)) {
                oupixels[point] = primaryColor;
            } else {
                oupixels[point] = secondaryColor;
            }
            point++;
        }
        bmOut.setPixels(oupixels, 0, width, 0, 0, width, height);
        return bmOut;
    }
}
