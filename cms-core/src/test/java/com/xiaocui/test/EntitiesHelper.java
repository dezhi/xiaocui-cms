package com.xiaocui.test;

import java.util.List;

import static org.junit.Assert.*;

import com.xiaocui.cms.vo.Role;
import com.xiaocui.cms.vo.User;

public class EntitiesHelper {
	private static User baseUser = new User(1, "admin1", "admin1", "admin1",
			"admin1", "admin1@admin.com", "131", "110", 1);

	public static User getBaseUser() {
		return baseUser;
	}

	public static void assertUser(User expected, User actual) {
		// 预期值不能为空
		assertNotNull(expected);
		assertEquals(expected.getId(), actual.getId());
		assertEquals(expected.getName(), actual.getName());
	}

	public static void assertRole(Role expected, Role actual) {
		// 预期值不能为空
		assertNotNull(expected);
		assertEquals(expected.getId(), actual.getId());
		assertEquals(expected.getName(), actual.getName());
		assertEquals(expected.getRoleType(), actual.getRoleType());
	}

	public static void assertUsers(List<User> expected, List<User> actual) {
		for (int i = 0; i < expected.size(); i++) {
			// 预期值
			User ue = expected.get(i);
			// 实际值
			User ua = actual.get(i);
			assertUser(ue, ua);
		}
	}

	public static void assertRoles(List<Role> expected, List<Role> actual) {
		for (int i = 0; i < expected.size(); i++) {
			// 预期值
			Role re = expected.get(i);
			// 实际值
			Role ra = actual.get(i);
			assertRole(re, ra);
		}
	}

	public static void assertUser(User expected) {
		assertUser(expected, baseUser);
	}

}
