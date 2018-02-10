package sample.data.live.livedatamvp.data.network;


import java.io.File;
import java.net.MalformedURLException;

import okhttp3.RequestBody;
import sample.data.live.livedatamvp.data.network.base.HttpDeleteRequest;
import sample.data.live.livedatamvp.data.network.base.HttpGetRequest;
import sample.data.live.livedatamvp.data.network.base.HttpPostRequest;
import sample.data.live.livedatamvp.data.network.base.HttpRequest;


/**
 * Api Connection class used to retrieve data from the cloud.
 * Implements {@link java.util.concurrent.Callable} so when executed asynchronously can
 * return a value.
 */
public class ApiConnection {

    public static HttpRequest createGET(String url) {
        return new HttpGetRequest(url);

    }

    public static HttpRequest createGET(String url, String token) {
        return new HttpGetRequest(url, token);

    }

    public static HttpRequest createPOST(String url, String body) throws MalformedURLException {
        return new HttpPostRequest(url, body);
    }

    public static HttpRequest createPOST(String url, RequestBody body) {
        return new HttpPostRequest(url, body);
    }

    public static HttpRequest createPOST(String url) throws MalformedURLException {
        return new HttpPostRequest(url);
    }

    public static HttpRequest createPOST(String url, String body, String token) throws MalformedURLException {
        return new HttpPostRequest(url, body, token);
    }

    public static HttpRequest createDelete(String url, String token) throws MalformedURLException {
        return new HttpDeleteRequest(url, token);
    }

    public static HttpRequest createPOST(String url, File file, String token) throws MalformedURLException {
        return new HttpPostRequest(url, file, token);
    }

}
