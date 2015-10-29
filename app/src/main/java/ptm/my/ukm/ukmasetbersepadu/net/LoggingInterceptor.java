package ptm.my.ukm.ukmasetbersepadu.net;

import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

/**
 * Created by fird on 14/09/2015.
 */
public class LoggingInterceptor implements Interceptor {
    @Override public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        System.out.println(request.uri());
        System.out.println(request.headers());

        Response response = chain.proceed(request);
        return response;
    }
}