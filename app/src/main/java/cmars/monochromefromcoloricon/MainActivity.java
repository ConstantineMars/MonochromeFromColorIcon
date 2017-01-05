package cmars.monochromefromcoloricon;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import cmars.monochromefromcoloricon.databinding.ActivityMainBinding;
import timber.log.Timber;


public class MainActivity extends AppCompatActivity {

    @Inject
    Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Timber.plant(new Timber.DebugTree());

        DaggerMainComponent.builder()
                .build()
                .inject(this);

        presenter.setColorImage(ResourcesCompat.getDrawable(getResources(), R.drawable.hangouts, getTheme()));

        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setPresenter(presenter);
    }


}
