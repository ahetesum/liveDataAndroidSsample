package sample.data.live.livedatamvp.data.network;

import rx.Observable;
import sample.data.live.livedatamvp.models.response.PostResponse;

public interface RestApi
{
    Observable<PostResponse> getPosts();
} 