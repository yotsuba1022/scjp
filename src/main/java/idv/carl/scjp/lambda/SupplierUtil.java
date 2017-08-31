package idv.carl.scjp.lambda;

import java.util.function.Supplier;

/**
 * @author Carl Lu
 */
public class SupplierUtil {

    public static String getGuid() {
        String guid = generateGuid();
        guid = guid.replace("QQ", "QAQ");
        return guid;
    }

    public static String getSsoyid() {
        String ssoyid = generateSsoyid();
        ssoyid = ssoyid.replace("BB", "BBB");
        return ssoyid;
    }

    private static String generateGuid() {
        return "GUID";
    }

    private static String generateSsoyid() {
        return "SSOYID";
    }

    public static String whenInvoke(Supplier<String> func) {
        return func.get();
    }

}
