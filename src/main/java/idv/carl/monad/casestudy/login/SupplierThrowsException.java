package idv.carl.monad.casestudy.login;

/**
 * @author Carl Lu
 */
public interface SupplierThrowsException<T, E extends Exception> {

    T get() throws E;
    
}
