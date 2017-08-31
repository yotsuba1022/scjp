package idv.carl.scjp.compare;

import idv.carl.scjp.domain.Coupon;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

/**
 * @author Carl Lu
 */
public class CompareCouponTest {

    private final static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
    private List<Coupon> coupons;

    @Before
    public void init() {

    }

    @After
    public void tearDown() {
        coupons = null;
    }

    @Test
    public void testCompareAcquireEndTs() throws InterruptedException {
        createFixture();
        assertEquals(3, coupons.size());
        Comparator<Coupon> acquireEndTsComparator = Comparator.comparing(c -> toLong(c.getAcquireEndTs()));
        coupons.sort(acquireEndTsComparator.reversed());
        assertEquals(1, coupons.get(2).getId());
        assertEquals(2, coupons.get(1).getId());
        assertEquals(3, coupons.get(0).getId());
    }

    @Test
    public void testCompareCampaignId() {
        createFixtureWithoutTimestamp();
        assertEquals(4, coupons.size());
        Comparator<Coupon> campaignIdComparator = Comparator.comparing(c -> Integer.valueOf(c.getCampaignId()));
        coupons.sort(campaignIdComparator.reversed());
        assertEquals("27040", coupons.get(0).getCampaignId());
        assertEquals("15023", coupons.get(1).getCampaignId());
        assertEquals("5023", coupons.get(2).getCampaignId());
        assertEquals("3950", coupons.get(3).getCampaignId());
    }

    @Test
    public void testCompareDiscount() {
        createFixtureWithoutTimestamp();
        Comparator<Coupon> discountComparator = Comparator.comparing(c -> Double.valueOf(c.getDiscount()));
        coupons.sort(discountComparator.reversed());
        assertEquals("300.0", coupons.get(0).getDiscount());
        assertEquals("220.0", coupons.get(1).getDiscount());
        assertEquals("220.0", coupons.get(2).getDiscount());
        assertEquals("100.0", coupons.get(3).getDiscount());
    }

    @Test
    public void testCompareDiscountAndCampaignId() {
        createFixtureWithoutTimestamp();

        coupons.sort((c1, c2) -> {
            if (Double.valueOf(c1.getDiscount()).equals(Double.valueOf(c2.getDiscount()))) {
                return Integer.valueOf(c1.getCampaignId()) - Integer.valueOf(c2.getCampaignId());
            } else {
                return -( c1.getDiscount().compareTo(c2.getDiscount()) );
            }
        });

        assertEquals("300.0", coupons.get(0).getDiscount());
        assertEquals("220.0", coupons.get(1).getDiscount());
        assertEquals("220.0", coupons.get(2).getDiscount());
        assertEquals("100.0", coupons.get(3).getDiscount());

        assertEquals("3950", coupons.get(0).getCampaignId());
        assertEquals("5023", coupons.get(1).getCampaignId());
        assertEquals("15023", coupons.get(2).getCampaignId());
        assertEquals("27040", coupons.get(3).getCampaignId());
    }

    @Test
    public void testCompareDiscountAndCampaignIdWithMap() {
        createFixtureWithoutTimestamp();
        Map<Coupon, Double> couponDiscountMap =
                coupons.stream().collect(Collectors.toMap(Function.identity(), coupon -> Double.valueOf(coupon.getDiscount())));
        List<Coupon> result = couponDiscountMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        assertEquals("3950", result.get(0).getCampaignId());
        assertEquals("15023", result.get(1).getCampaignId());
        assertEquals("5023", result.get(2).getCampaignId());
        assertEquals("27040", result.get(3).getCampaignId());
    }

    private void createFixture() throws InterruptedException {
        Coupon coupon1 = Coupon.getInstance();
        coupon1.setId(1)
                .setCampaignId("27040")
                .setAcquireStartTs(getCurrentTime())
                .setAcquireEndTs(getCurrentTime())
                .setRedeemStartTs(getCurrentTime())
                .setRedeemEndTs(getCurrentTime())
                .setDiscount("100.0");

        Coupon coupon2 = Coupon.getInstance();
        coupon2.setId(2)
                .setCampaignId("3950")
                .setAcquireStartTs(getCurrentTime())
                .setAcquireEndTs(getCurrentTime())
                .setRedeemStartTs(getCurrentTime())
                .setRedeemEndTs(getCurrentTime())
                .setDiscount("300.0");

        Coupon coupon3 = Coupon.getInstance();
        coupon3.setId(3)
                .setCampaignId("15023")
                .setAcquireStartTs(getCurrentTime())
                .setAcquireEndTs(getCurrentTime())
                .setRedeemStartTs(getCurrentTime())
                .setRedeemEndTs(getCurrentTime())
                .setDiscount("220.0");

        coupons = new ArrayList<>();
        coupons.add(coupon1);
        coupons.add(coupon2);
        coupons.add(coupon3);
    }

    private void createFixtureWithoutTimestamp() {
        Coupon coupon1 = Coupon.getInstance();
        coupon1.setId(1).setCampaignId("27040").setDiscount("100.0");

        Coupon coupon2 = Coupon.getInstance();
        coupon2.setId(2).setCampaignId("3950").setDiscount("300.0");

        Coupon coupon3 = Coupon.getInstance();
        coupon3.setId(3).setCampaignId("15023").setDiscount("220.0");

        Coupon coupon4 = Coupon.getInstance();
        coupon4.setId(4).setCampaignId("5023").setDiscount("220.0");

        coupons = new ArrayList<>();
        coupons.add(coupon1);
        coupons.add(coupon2);
        coupons.add(coupon3);
        coupons.add(coupon4);
    }

    private String getCurrentTime() throws InterruptedException {
        Thread.sleep(1000);
        Date now = new Date();
        return DATE_FORMAT.format(now);
    }

    private Long toLong(String dateStr) {
        Date date = null;
        try {
            date = DATE_FORMAT.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date != null ? date.getTime() : 0;
    }

}
