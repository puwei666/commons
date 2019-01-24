package com.puwei666.commons.utils;

import org.junit.Assert;
import org.junit.Test;

public class DateUtilTests {
    @Test
    public void contextLoads() {
        String dateStr = DateUtil.getCurrentTimeString("yyyy-MM-dd");
        Assert.assertEquals("2019-01-23", dateStr);
    }

}
