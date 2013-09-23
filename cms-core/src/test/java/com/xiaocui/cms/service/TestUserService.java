package com.xiaocui.cms.service;

import javax.inject.Inject;

import org.easymock.EasyMock;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xiaocui.cms.dao.IGroupDao;
import com.xiaocui.cms.dao.IRoleDao;
import com.xiaocui.cms.dao.IUserDao;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("/test-beans.xml")
public class TestUserService {
	@Inject
	private IUserService userService;
	@Inject
	private IUserDao userDao;
	@Inject
	private IRoleDao roleDao;
	@Inject
	private IGroupDao groupDao;

	//@Test
	public void testDelete() {
		EasyMock.reset(userDao);

		int uid = 2;
		userDao.deleteUserGroups(uid);

		EasyMock.expectLastCall();
		userDao.deleteUserRoles(uid);
		EasyMock.expectLastCall();
		userDao.delete(uid);
		EasyMock.expectLastCall();

		EasyMock.replay(userDao);
		userService.delete(uid);
		EasyMock.verify(userDao);
	}

}
