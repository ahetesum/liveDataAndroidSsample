package sample.data.live.livedatamvp.data.repository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.content.Context;

import rx.Scheduler;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import sample.data.live.livedatamvp.data.network.RestApi;
import sample.data.live.livedatamvp.data.network.RestApiImpl;
import sample.data.live.livedatamvp.models.response.PostResponse;

/**
 * @author Haniyeh Khaksar
 */

public class NetworkRepository implements INetworkRepository {

    private RestApi restApi = null;

    public NetworkRepository(Context context) {
        restApi = new RestApiImpl(context);
    }

    @Override
    public LiveData<PostResponse> getPosts() {
        final MutableLiveData<PostResponse> result= new MutableLiveData<>();
        restApi.getPosts().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<PostResponse>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(PostResponse postResponse) {
                result.postValue(postResponse);
            }
        });

        return result;
    }
}
