package sample.data.live.livedatamvp.features.main;

import sample.data.live.livedatamvp.features.abstraction.AppView;
import sample.data.live.livedatamvp.models.response.PostResponse;

public interface MainView extends AppView
{

    void updatePostList(PostResponse postResponse);
}
