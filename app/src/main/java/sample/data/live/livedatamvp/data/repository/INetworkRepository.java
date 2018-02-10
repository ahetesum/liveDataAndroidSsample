package sample.data.live.livedatamvp.data.repository;

import android.arch.lifecycle.LiveData;


import sample.data.live.livedatamvp.models.response.PostResponse;

/**
 * @author Haniyeh Khaksar
 */

public interface INetworkRepository {

    LiveData<PostResponse> getPosts();


}
