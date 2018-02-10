package sample.data.live.livedatamvp.features.abstraction;

/**
 * Created by 80056 on 2/22/2017.
 */

public interface IPresenter {
    @SuppressWarnings({"EmptyMethod", "unused"})
    void resume();

    @SuppressWarnings({"EmptyMethod", "unused"})
    void pause();

    @SuppressWarnings({"EmptyMethod", "unused"})
    void stop();

    @SuppressWarnings({"EmptyMethod", "unused"})
    void destroy();

    @SuppressWarnings({"EmptyMethod", "unused"})
    void onError(@SuppressWarnings("unused") String message);
}
