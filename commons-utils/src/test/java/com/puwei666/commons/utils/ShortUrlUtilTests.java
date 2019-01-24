package com.puwei666.commons.utils;

import org.junit.Assert;
import org.junit.Test;

public class ShortUrlUtilTests {
    @Test
    public void getShortUrl () {
        String [] urlAry = ShortUrlUtil.getShortUrl("http://www.baidu.com");
        Assert.assertEquals(4, urlAry.length);
    }
}
