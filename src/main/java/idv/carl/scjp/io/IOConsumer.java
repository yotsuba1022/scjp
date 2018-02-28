package idv.carl.scjp.io;

import java.io.IOException;

/**
 * @author Carl Lu
 */
public interface IOConsumer<T> {

    void accept(T t) throws IOException;

}
