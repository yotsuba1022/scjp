package idv.carl.monad.casestudy.login;

import java.util.function.Function;

/**
 * @author Carl Lu
 */
public abstract class Try<T> {

    static <T, E extends Exception> Try<T> with(SupplierThrowsException<T, E> codeBlock) {
        try {
            return new Success<>(codeBlock.get());
        } catch (Exception tryException) {
            return new Failure<>(tryException);
        }
    }

    abstract <U> Try<U> chain(Function<T, Try<U>> func);

    abstract T get();

    abstract <U> Try<U> recoverWith(Function<Exception, Try<U>> func);

    abstract <U> Try<U> orElse(Try<U> other);

}
