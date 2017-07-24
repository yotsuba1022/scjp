package idv.carl.scjp.compare;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author Carl Lu
 */
public class CompareCouponTest {

    private final static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
    private List<Coupon> coupons;

    @Before
    public void init() throws InterruptedException {
        createFixture();
    }

    @After
    public void tearDown() {
        coupons = null;
    }

    @Test
    public void testCompare() {
        assertEquals(3, coupons.size());
        Comparator<Coupon> acquireEndTsComparator = Comparator.comparing(c -> toLong(c.getAcquireEndTs()));
        coupons.sort(acquireEndTsComparator.reversed());
        assertEquals(1, coupons.get(2).getId());
        assertEquals(2, coupons.get(1).getId());
        assertEquals(3, coupons.get(0).getId());
    }

    private void createFixture() throws InterruptedException {
        Coupon coupon1 = Coupon.getInstance();
        coupon1.setId(1)
                .setAcquireStartTs(getCurrentTime())
                .setAcquireEndTs(getCurrentTime())
                .setRedeemStartTs(getCurrentTime())
                .setRedeemEndTs(getCurrentTime());

        Coupon coupon2 = Coupon.getInstance();
        coupon2.setId(2)
                .setAcquireStartTs(getCurrentTime())
                .setAcquireEndTs(getCurrentTime())
                .setRedeemStartTs(getCurrentTime())
                .setRedeemEndTs(getCurrentTime());

        Coupon coupon3 = Coupon.getInstance();
        coupon3.setId(3)
                .setAcquireStartTs(getCurrentTime())
                .setAcquireEndTs(getCurrentTime())
                .setRedeemStartTs(getCurrentTime())
                .setRedeemEndTs(getCurrentTime());

        coupons = new ArrayList<>();
        coupons.add(coupon1);
        coupons.add(coupon2);
        coupons.add(coupon3);
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
