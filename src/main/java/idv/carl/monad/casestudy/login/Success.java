package idv.carl.monad.casestudy.login;

import java.util.function.Function;

/**
 * @author Carl Lu
 */
public class Success<T> extends Try<T> {

    private final T value;

    public Success(T value) {
        this.value = value;
    }

    @Override
    public <U> Try<U> chain(Function<T, Try<U>> func) {
        try {
            return func.apply(value);
        } catch (Exception exception) {
            return new Failure<>(exception);
        }
    }

    @Override
    T get() {
        return value;
    }

    @Override
    <U> Try<U> recoverWith(Function<Exception, Try<U>> func) {
        return (Try<U>) this;
    }

    @Override
    <U> Try<U> orElse(Try<U> other) {
        return (Try<U>) this;
    }

}
