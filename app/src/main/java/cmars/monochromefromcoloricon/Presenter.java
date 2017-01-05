package cmars.monochromefromcoloricon;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

import javax.inject.Inject;

import lombok.Data;
import timber.log.Timber;

import static cmars.monochromefromcoloricon.ImageHelper.createBlackAndWhite;

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
                createBlackAndWhite(((BitmapDrawable) colorImage).getBitmap())
        );
    }
}
