package sample.data.live.livedatamvp.data.network;

import android.content.Context;
import com.google.gson.Gson;

import rx.Observable;
import rx.Subscriber;
import sample.data.live.livedatamvp.models.response.PostResponse;
import sample.data.live.livedatamvp.utils.URLHelper;


/**
 * @author Haniyeh Khaksar
 */

public class RestApiImpl implements RestApi {

    private Gson gsonMapper;

    public RestApiImpl(Context context) {
        gsonMapper = new Gson();
    }


    @Override
    public Observable<PostResponse> getPosts() {
        return Observable.create(new Observable.OnSubscribe<PostResponse>() {
            @Override
            public void call(Subscriber<? super PostResponse> subscriber) {
                try {

                    String responseString = getPostsApi();

                    if (responseString == null) {
                        subscriber.onError(new Throwable("Error From Server"));
                    } else {
                        PostResponse entity = gsonMapper.fromJson(responseString, PostResponse.class);
                        subscriber.onNext(entity);
                        subscriber.onCompleted();
                    }

                } catch (Exception e) {
                    subscriber.onError(e);

                }
            }
        });
    }

    private String getPostsApi() throws Exception {

        String apiUrl = URLHelper.POST_API_URL;

        return ApiConnection.createGET(apiUrl).call();
    }
}
