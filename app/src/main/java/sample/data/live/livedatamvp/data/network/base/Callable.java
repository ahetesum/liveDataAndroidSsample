package sample.data.live.livedatamvp.data.network.base;

/**
 * @author Haniyeh Khaksar
 */

public interface Callable<T> {
    T call() throws Exception;
}
