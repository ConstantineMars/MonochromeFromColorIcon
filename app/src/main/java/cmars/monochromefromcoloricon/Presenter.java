package cmars.monochromefromcoloricon;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

import javax.inject.Inject;

import cmars.monochromefromcoloricon.helpers.ImageHelper;
import lombok.Data;
import timber.log.Timber;

/**
 * Created by Constantine Mars on 1/4/17.
 */
@Data
public class Presenter {

    public Drawable colorImage;
    public Drawable monochromeImage;

    @Inject
    public Presenter() {
        Timber.d("Presenter constructor");
    }

    public void setColorImage(Drawable image) {
        colorImage = image;
        monochromeImage = new BitmapDrawable(
                ImageHelper.createWhiteIconBasedOnVibrantColor(((BitmapDrawable) colorImage).getBitmap())
        );
    }
}
