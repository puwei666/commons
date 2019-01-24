package com.puwei666.commons.utils;

import org.junit.Assert;
import org.junit.Test;

public class CommonsUtilsApplicationTests {

	@Test
	public void contextLoads() {
		String dateStr = DateUtil.getCurrentTimeString("yyyy-MM-dd");
		Assert.assertEquals("2019-01-24", dateStr);
	}

}

