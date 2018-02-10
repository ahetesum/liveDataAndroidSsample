package sample.data.live.livedatamvp.features.abstraction;

import android.arch.lifecycle.LifecycleOwner;
import android.content.Context;

/**
 * Created by 80056 on 2/22/2017.
 */

@SuppressWarnings("SameReturnValue")
public interface AppView {

    void init();

    /**
     * Implement this to return the title of the which should be show when this Fragment is shown
     *
     * @return String to set title null or empty string to no to change existing title
     */
    @SuppressWarnings("unused")
    String onSetTitle();


    /**
     * Call this method to get the context of the activity or fragment implementing this view.
     *
     * @return Context of the activity or fragment
     */
    Context getViewContext();

    /**
     * Call this method to show error in toast.
     * Implement this method to show custom error.
     * By default a toast with error message will be shown
     *
     * @param message Message to be displayed.
     */
    void showToast(String message);

    LifecycleOwner getLifeCycleOwner();

    /**
     * Call this method to hide the keyboard.
     *
     * @return Context of the activity or fragment
     */
    @SuppressWarnings("unused")
    void hideKeyBoard();
}
