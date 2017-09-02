package idv.carl.scjp.collection.list;

import idv.carl.scjp.collection.stream.DistinctDemo;
import idv.carl.scjp.domain.Coupon;
import idv.carl.scjp.domain.ProductBundle;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author Carl Lu
 */
public class ListDistinctTest {

    @Test
    public void testGetDistinctResult() {
        List<ProductBundle> productBundles = new ArrayList<>();

        ProductBundle productBundle1 = ProductBundle.getInstance();
        ProductBundle productBundle2 = ProductBundle.getInstance();

        productBundle1.setCoupons(getTestCoupons1());
        productBundle2.setCoupons(getTestCoupons2());

        productBundles.add(productBundle1);
        productBundles.add(productBundle2);

        List<String> campaignIds = DistinctDemo.filterDistinctCampaignIds(productBundles);

        assertEquals(8, campaignIds.size());
    }

    private List<Coupon> getTestCoupons1() {
        List<Coupon> coupons = new ArrayList<>();

        Coupon coupon1 = new Coupon();
        coupon1.setId(1);
        coupon1.setCampaignId("1");
        coupon1.setDiscount("100");
        coupons.add(coupon1);

        Coupon coupon2 = new Coupon();
        coupon2.setId(2);
        coupon2.setCampaignId("2");
        coupon2.setDiscount("200");
        coupons.add(coupon2);

        Coupon coupon3 = new Coupon();
        coupon3.setId(3);
        coupon3.setCampaignId("10");
        coupon3.setDiscount("140");
        coupons.add(coupon3);

        Coupon coupon4 = new Coupon();
        coupon4.setId(4);
        coupon4.setCampaignId("4");
        coupon4.setDiscount("120");
        coupons.add(coupon4);

        Coupon coupon5 = new Coupon();
        coupon5.setId(5);
        coupon5.setCampaignId("5");
        coupon5.setDiscount("310");
        coupons.add(coupon5);

        return coupons;
    }

    private List<Coupon> getTestCoupons2() {
        List<Coupon> coupons = new ArrayList<>();

        Coupon coupon1 = new Coupon();
        coupon1.setId(1);
        coupon1.setCampaignId("6");
        coupon1.setDiscount("20");
        coupons.add(coupon1);

        Coupon coupon2 = new Coupon();
        coupon2.setId(2);
        coupon2.setCampaignId("4");
        coupon2.setDiscount("120");
        coupons.add(coupon2);

        Coupon coupon3 = new Coupon();
        coupon3.setId(3);
        coupon3.setCampaignId("8");
        coupon3.setDiscount("230");
        coupons.add(coupon3);

        Coupon coupon4 = new Coupon();
        coupon4.setId(4);
        coupon4.setCampaignId("9");
        coupon4.setDiscount("50");
        coupons.add(coupon4);

        Coupon coupon5 = new Coupon();
        coupon5.setId(5);
        coupon5.setCampaignId("10");
        coupon5.setDiscount("140");
        coupons.add(coupon5);

        return coupons;
    }

}
