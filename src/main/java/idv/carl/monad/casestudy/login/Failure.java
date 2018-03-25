package idv.carl.monad.casestudy.login;

import java.util.function.Function;

/**
 * @author Carl Lu
 */
public class Failure<T> extends Try<T> {

    private final Exception exception;

    public Failure(Exception exception) {
        this.exception = exception;
    }

    @Override
    <U> Try<U> chain(Function<T, Try<U>> func) {
        return (Try<U>) this;
    }

    @Override
    T get() {
        throw new RuntimeException(exception);
    }

    @Override
    <U> Try<U> recoverWith(Function<Exception, Try<U>> func) {
        try {
            return func.apply(exception);
        } catch (Exception exception) {
            return new Failure<>(exception);
        }
    }

    @Override
    <U> Try<U> orElse(Try<U> other) {
        return other;
    }

}
