package idv.carl.scjp.domain;

/**
 * @author Carl Lu
 */
public class Coupon {

    private int id;
    private String campaignId;
    private String acquireStartTs;
    private String acquireEndTs;
    private String redeemStartTs;
    private String redeemEndTs;
    private String discount;

    public static Coupon getInstance() {
        return new Coupon();
    }

    public int getId() {
        return id;
    }

    public Coupon setId(int id) {
        this.id = id;
        return this;
    }

    public String getCampaignId() {
        return campaignId;
    }

    public Coupon setCampaignId(String campaignId) {
        this.campaignId = campaignId;
        return this;
    }

    public String getAcquireStartTs() {
        return acquireStartTs;
    }

    public Coupon setAcquireStartTs(String acquireStartTs) {
        this.acquireStartTs = acquireStartTs;
        return this;
    }

    public String getAcquireEndTs() {
        return acquireEndTs;
    }

    public Coupon setAcquireEndTs(String acquireEndTs) {
        this.acquireEndTs = acquireEndTs;
        return this;
    }

    public String getRedeemStartTs() {
        return redeemStartTs;
    }

    public Coupon setRedeemStartTs(String redeemStartTs) {
        this.redeemStartTs = redeemStartTs;
        return this;
    }

    public String getRedeemEndTs() {
        return redeemEndTs;
    }

    public Coupon setRedeemEndTs(String redeemEndTs) {
        this.redeemEndTs = redeemEndTs;
        return this;
    }

    public String getDiscount() {
        return discount;
    }

    public Coupon setDiscount(String discount) {
        this.discount = discount;
        return this;
    }

    @Override
    public String toString() {
        return "Coupon{" + "id=" + id + ", campaignId='" + campaignId + '\'' + ", acquireStartTs='" + acquireStartTs + '\''
                + ", acquireEndTs='" + acquireEndTs + '\'' + ", redeemStartTs='" + redeemStartTs + '\'' + ", redeemEndTs='"
                + redeemEndTs + '\'' + ", discount='" + discount + '\'' + '}';
    }

}
