import org.junit.jupiter.api.Test;

import scrapers.HSCodes;

public class HSCodesTest {
    @Test
    void Test() throws InterruptedException {
        System.out.println(HSCodes.getList());
        System.out.println(HSCodes.getProductNames());

    }
}
