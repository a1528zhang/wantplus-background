package com.plus.want.serviceImpl;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LikeServiceImplTest {
	
	private static LikeServiceImpl likeServiceImpl = new LikeServiceImpl();

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetUserBrief() {
		likeServiceImpl.getUserBrief(23, 1);
	}

}
