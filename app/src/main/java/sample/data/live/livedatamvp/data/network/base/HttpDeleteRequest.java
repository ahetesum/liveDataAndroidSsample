package sample.data.live.livedatamvp.data.network.base;

/**
 * @author Haniyeh Khaksar
 */

public class HttpDeleteRequest extends HttpRequest {
    private String url = null;

    public HttpDeleteRequest(String url, String token) {
        super(url);
        setAuthenticationHeader(token);
        setBody();
    }

    public void setBody() {
        requestBuilder.delete(null);
    }

    public void setAuthenticationHeader(String token) {
        requestBuilder.addHeader("token", token);
    }

}
