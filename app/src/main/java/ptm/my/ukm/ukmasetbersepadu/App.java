package ptm.my.ukm.ukmasetbersepadu;

import android.app.Application;
import android.content.Context;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

/**
 * Created by fird on 14/09/2015.
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        initImageLoader(getApplicationContext());
    }

    private void initImageLoader(Context applicationContext) {
        ImageLoaderConfiguration config = ImageLoaderConfiguration.createDefault(applicationContext);
        ImageLoader.getInstance().init(config);
    }
}
