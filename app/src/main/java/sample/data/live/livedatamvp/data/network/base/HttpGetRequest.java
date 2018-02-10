package sample.data.live.livedatamvp.data.network.base;

/**
 * @author Haniyeh Khaksar
 */

public class HttpGetRequest extends HttpRequest {

    String url;


    public HttpGetRequest(String url) {
        super(url);
        this.url = url;
    }

    public HttpGetRequest(String url, String token) {
        super(url);
        this.url = url;
        setAuthenticationHeader(token);
    }

    @Override
    protected void addHeaders() {
    }

    public void setAuthenticationHeader(String token) {
        requestBuilder.addHeader("token", token);
    }
}
