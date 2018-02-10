package sample.data.live.livedatamvp.features.main;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;

import java.util.List;

import sample.data.live.livedatamvp.data.repository.NetworkRepository;
import sample.data.live.livedatamvp.features.abstraction.AppView;
import sample.data.live.livedatamvp.features.abstraction.Presenter;
import sample.data.live.livedatamvp.models.Post;
import sample.data.live.livedatamvp.models.response.PostResponse;

public class MainPresenter extends Presenter{

    private MainView mainView=null;

    public MainPresenter(MainView view) {
        super(view);
        this.mainView=view;
    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void onError(String message) {

    }


    public void getAllPosts()
    {
        NetworkRepository networkRepository=new NetworkRepository(mainView.getViewContext());
        LiveData<PostResponse> listBookmark = networkRepository.getPosts();
        listBookmark.observe(mainView.getLifeCycleOwner(), new Observer<PostResponse>() {
            @Override
            public void onChanged(@Nullable PostResponse postResponse) {
                mainView.updatePostList(postResponse);
            }
        });

    }


}