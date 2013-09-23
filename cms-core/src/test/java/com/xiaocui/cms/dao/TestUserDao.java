package com.xiaocui.cms.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import org.dbunit.DatabaseUnitException;
import org.dbunit.dataset.IDataSet;
import org.dbunit.operation.DatabaseOperation;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.springframework.orm.hibernate4.SessionHolder;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.xiaocui.cms.vo.Group;
import com.xiaocui.cms.vo.Role;
import com.xiaocui.cms.vo.RoleType;
import com.xiaocui.cms.vo.User;
import com.xiaocui.cms.vo.UserGroup;
import com.xiaocui.cms.vo.UserRole;
import com.xiaocui.test.AbstractDbunitTestCase;
import com.xiaocui.test.EntitiesHelper;
import com.xiaocui.cms.dao.IUserDao;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("/beans.xml")
public class TestUserDao extends AbstractDbunitTestCase {
	@Inject
	private SessionFactory sessionFactory;
	@Inject
	private IUserDao userDao;
	@Inject
	private IRoleDao roleDao;
	@Inject
	private IGroupDao groupDao;

	@Before
	public void setUp() throws SQLException, IOException, DatabaseUnitException {
		Session s = sessionFactory.openSession();
		TransactionSynchronizationManager.bindResource(sessionFactory,
				new SessionHolder(s));

		this.backupAllTable();

		IDataSet ids = createDataSet("t_user");

		DatabaseOperation.CLEAN_INSERT.execute(dbunitConn, ids);
	}

	// @Test
	public void testlistuserroles() throws DatabaseUnitException, SQLException {

		List<Role> actuals = Arrays.asList(new Role(2, "审核人员",
				RoleType.role_audit),
				new Role(3, "发布人员", RoleType.role_publish));

		List<Role> roles = userDao.listUserRoles(2);

		EntitiesHelper.assertRoles(roles, actuals);

	}

	// @Test
	public void testAddUserRole() {
		User u = userDao.load(1);

		Role r = roleDao.load(1);

		userDao.addUserRole(u, r);

		UserRole ur = userDao.loadUserRole(1, 1);

		Assert.assertNotNull(ur);
		Assert.assertEquals(ur.getRole().getId(), 1);
		Assert.assertEquals(ur.getUser().getId(), 1);

	}

	// @Test
	public void testAddUserGroup() {
		User u = userDao.load(1);

		Group g = groupDao.load(1);

		userDao.addUserGroup(u, g);

		UserGroup ug = userDao.loadUserGroup(1, 1);

		Assert.assertNotNull(ug);
		Assert.assertEquals(ug.getGroup().getId(), 1);
		Assert.assertEquals(ug.getUser().getId(), 1);

	}

	@After
	public void tearDown() throws DatabaseUnitException, SQLException,
			IOException {
		SessionHolder holder = (SessionHolder) TransactionSynchronizationManager
				.getResource(sessionFactory);
		Session s = holder.getSession();
		s.flush();
		TransactionSynchronizationManager.unbindResource(sessionFactory);
		this.resumeTable();
	}
}
