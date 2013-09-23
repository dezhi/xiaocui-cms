package com.xiaocui.cms.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.xiaocui.cms.dao.IGroupDao;
import com.xiaocui.cms.dao.IUserDao;
import com.xiaocui.cms.vo.CmsException;
import com.xiaocui.cms.vo.Group;
import com.xiaocui.cms.vo.User;
import com.xiaocui.vo.Pager;

@Service("groupService")
public class GroupService implements IGroupService {

	private IGroupDao groupDao;

	private IUserDao userDao;

	public IGroupDao getGroupDao() {
		return groupDao;
	}

	@Inject
	public void setGroupDao(IGroupDao groupDao) {
		this.groupDao = groupDao;
	}

	public IUserDao getUserDao() {
		return userDao;
	}

	@Inject
	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public void add(Group group) {
		groupDao.add(group);
	}

	@Override
	public void delete(int groupId) {
		List<User> users = userDao.listGroupUsers(groupId);

		if (users != null && users.size() > 0)
			throw new CmsException("组中存在用户，不能删除哦");

		groupDao.delete(groupId);
	}

	@Override
	public void update(Group group) {
		groupDao.update(group);
	}

	@Override
	public Group load(int groupId) {
		return groupDao.load(groupId);
	}

	@Override
	public List<Group> listGroup() {
		return groupDao.listGroup();
	}

	@Override
	public Pager<Group> findGroup() {
		return groupDao.findGroup();
	}

	@Override
	public void deleteGroupUsers(int groupId) {
		groupDao.deleteGroupUsers(groupId);
	}

}
