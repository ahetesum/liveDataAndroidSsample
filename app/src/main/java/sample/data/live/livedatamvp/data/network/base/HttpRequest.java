package sample.data.live.livedatamvp.data.network.base;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @author Haniyeh Khaksar
 */

public class HttpRequest implements Callable<String> {

    protected static final MediaType TEXT = MediaType.parse("application/text; charset=utf-8");
    protected static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    protected static final MediaType IMAGE = MediaType.parse("image/jpeg");

    protected OkHttpClient httpClient;
    protected Request.Builder requestBuilder;

    protected HttpRequest(String url) {
        requestBuilder = new Request.Builder();
        requestBuilder.url(url);

        httpClient = new OkHttpClient();
        addHeaders();
    }

    protected void addHeaders() {
        requestBuilder.addHeader("Content-Type", "application/json");
        requestBuilder.addHeader("charset", "UTF-8");
    }

    public void addAuthHeader(String auth) {
        if (auth.length() > 0)
            requestBuilder.addHeader("token", auth);
    }


    @Override
    public String call() throws Exception {

        Response response = httpClient.newCall(requestBuilder.build()).execute();

        if (response.networkResponse().code() >= 200 && response.networkResponse().code() < 300)
            return response.body().string();
        else throw new Exception(response.message());
    }

}