package idv.carl.scjp.collection.stream;

import idv.carl.scjp.domain.Coupon;
import idv.carl.scjp.domain.ProductBundle;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author Carl Lu
 */
public class DistinctDemo {

    public static List<String> filterDistinctCampaignIds(List<ProductBundle> productBundles) {
        return productBundles.stream()
                .flatMap(productBundle -> productBundle.getCoupons().stream().filter(coupon -> !coupon.getCampaignId().isEmpty()))
                .filter(distinctByKey(Coupon::getCampaignId))
                .map(Coupon::getCampaignId)
                .collect(Collectors.toList());
    }

    /*
    * This function uses a ConcurrentHashMap instance to find out if there is any existing key
    * with same value-where key is obtained from a function reference, and here we will pass
    * the object’s property getter method which will cause the property value to act as the key to map.
    * */
    private static <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor) {
        Map<Object, Boolean> map = new ConcurrentHashMap<>();
        return t -> map.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }

}
