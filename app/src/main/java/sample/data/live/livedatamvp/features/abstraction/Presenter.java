package sample.data.live.livedatamvp.features.abstraction;


public abstract class Presenter implements IPresenter {

    protected AppView mView = null;


    @SuppressWarnings("WeakerAccess")
    public Presenter(AppView view) {

        this.mView = view;
    }


}
