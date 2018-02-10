package sample.data.live.livedatamvp.features.main;

import android.arch.lifecycle.LifecycleOwner;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import sample.data.live.livedatamvp.R;
import sample.data.live.livedatamvp.features.abstraction.AppView;
import sample.data.live.livedatamvp.features.abstraction.Presenter;
import sample.data.live.livedatamvp.models.response.PostResponse;

public class MainActivity extends AppCompatActivity implements MainView, LifecycleOwner {

    private MainPresenter mainPresenter=null;
    private RecyclerView postsRecyclerView=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void init() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        postsRecyclerView=(RecyclerView) findViewById(R.id.list_post_recyclerview);

        mainPresenter= new MainPresenter(this);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainPresenter.getAllPosts();
            }
        });
    }

    @Override
    public String onSetTitle() {
        return "Main Activity";
    }

    @Override
    public Context getViewContext() {
        return  this;
    }


    @Override
    public void showToast(String message) {

    }


    @Override
    public LifecycleOwner getLifeCycleOwner() {
        return this;
    }

    @Override
    public void hideKeyBoard() {

    }

    @Override
    public void updatePostList(PostResponse postResponse) {
        Toast.makeText(getViewContext(),postResponse.title,Toast.LENGTH_SHORT).show();
    }
}
