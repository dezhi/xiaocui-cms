package com.xiaocui.cms.dao;

import static org.junit.Assert.fail;

import java.io.IOException;
import java.sql.SQLException;
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
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.orm.hibernate4.SessionHolder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.xiaocui.cms.vo.Channel;
import com.xiaocui.test.AbstractDbunitTestCase;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/beans.xml")
public class TestChannelDao extends AbstractDbunitTestCase {
	@Inject
	private SessionFactory sessionFactory;
	@Inject
	private IChannelDao channelDao;

	@Before
	public void setUp() throws SQLException, IOException, DatabaseUnitException {
		Session s = sessionFactory.openSession();
		TransactionSynchronizationManager.bindResource(sessionFactory,
				new SessionHolder(s));

		this.backupAllTable();

		IDataSet ids = createDataSet("topic");

		DatabaseOperation.CLEAN_INSERT.execute(dbunitConn, ids);
	}

	//@Test
	public void testListByParent() {
		List<Channel> cs = channelDao.listByParent(1);

		Assert.assertNotNull(cs);

		Assert.assertEquals(cs.size(), 4);
	}

	@Test
	public void test() {
		System.out.println(channelDao);
	}

	// @Test
	public void testMaxSortedByParent() {
		int max = channelDao.maxSortedByParent(1);

		Assert.assertEquals(max, 4);
	}

	//@Test
	public void testGenerateTree() {
		fail("Not yet implemented");
	}

	//@Test
	public void testGenerateTreeByParent() {
		fail("Not yet implemented");
	}

	@After
	public void tearDown() throws DatabaseUnitException, SQLException,
			IOException {
		SessionHolder holder = (SessionHolder) TransactionSynchronizationManager
				.getResource(sessionFactory);
		Session s = holder.getSession();
		s.flush();
		TransactionSynchronizationManager.unbindResource(sessionFactory);
		//this.resumeTable();
	}
}
