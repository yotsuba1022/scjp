package idv.carl.scjp.domain;

import java.util.List;

/**
 * @author Carl Lu
 */
public class ProductBundle {

    private List<Coupon> coupons;

    public static ProductBundle getInstance() {
        return new ProductBundle();
    }

    public List<Coupon> getCoupons() {
        return coupons;
    }

    public void setCoupons(List<Coupon> coupons) {
        this.coupons = coupons;
    }
}
