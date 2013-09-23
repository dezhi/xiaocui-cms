package com.xiaocui.cms.service;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.apache.commons.lang.ArrayUtils;
import org.springframework.stereotype.Service;

import com.xiaocui.cms.dao.IGroupDao;
import com.xiaocui.cms.dao.IRoleDao;
import com.xiaocui.cms.dao.IUserDao;
import com.xiaocui.cms.vo.CmsException;
import com.xiaocui.cms.vo.Group;
import com.xiaocui.cms.vo.Role;
import com.xiaocui.cms.vo.User;
import com.xiaocui.vo.Pager;

@Service("userService")
public class UserService implements IUserService {

	private IUserDao userDao;

	private IRoleDao roleDao;

	private IGroupDao groupDao;

	public IUserDao getUserDao() {
		return userDao;
	}

	@Inject
	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	public IRoleDao getRoleDao() {
		return roleDao;
	}

	@Inject
	public void setRoleDao(IRoleDao roleDao) {
		this.roleDao = roleDao;
	}

	public IGroupDao getGroupDao() {
		return groupDao;
	}

	@Inject
	public void setGroupDao(IGroupDao groupDao) {
		this.groupDao = groupDao;
	}

	private void addUserRole(User user, int rId) {
		// 1 判断角色对象是否存在，如果不存在，则抛出异常
		Role role = roleDao.load(rId);

		if (role == null)
			throw new CmsException("添加的角色不存在");

		// 2 判断用户角色的关联对象是否存在，如果存在，就不进行添加
		userDao.addUserRole(user, role);
	}

	private void addUserGroup(User user, int gId) {
		Group group = groupDao.load(gId);

		if (group == null)
			throw new CmsException("添加的组不存在");

		userDao.addUserGroup(user, group);
	}

	@Override
	public void add(User user, Integer[] roleIds, Integer[] groupIds) {

		User u = userDao.loadByUsername(user.getUsername());

		if (u != null)
			throw new CmsException("用户已存在");

		System.out.println(u + "有时居民？");
		
		user.setCreateDate(new Date());

		userDao.add(user);

		// 添加角色对象
		for (Integer roleId : roleIds) {
			this.addUserRole(user, roleId);
		}

		// 添加组对象
		for (Integer groupId : groupIds) {
			this.addUserGroup(user, groupId);
		}

	}

	@Override
	public void update(User user, Integer[] roleIds, Integer[] groupIds) {

		List<Integer> rIds = userDao.listUserRolesByIds(user.getId());

		List<Integer> gIds = userDao.listUserGroupsByIds(user.getId());

		// 1 添加角色对象
		for (Integer rId : roleIds) {
			// 如果不存在，就进行添加
			if (!rIds.contains(rId)) {
				this.addUserRole(user, rId);
			}
		}

		// 2 添加组对象
		for (Integer gId : groupIds) {
			// 如果不存在，就进行添加
			if (!gIds.contains(gId)) {
				this.addUserGroup(user, gId);
			}
		}
		// 3 进行删除
		for (Integer rId : rIds) {
			if (!ArrayUtils.contains(roleIds, rId)) {
				userDao.deleteUserRole(user.getId(), rId);
			}
		}

		for (Integer gId : gIds) {
			if (!ArrayUtils.contains(roleIds, gId)) {
				userDao.deleteUserRole(user.getId(), gId);
			}
		}
	}

	@Override
	public void updateStatus(int id) {
		User u = userDao.load(id);

		if (u == null)
			throw new CmsException("修改的用户状态不存在");

		if (u.getStatus() == 0) {
			u.setStatus(1);
		} else {
			u.setStatus(0);
		}

		userDao.update(u);
	}

	@Override
	public Pager<User> findUser() {
		return userDao.findUser();
	}

	@Override
	public User load(int id) {
		return userDao.load(id);
	}

	@Override
	public List<Role> listUserRoles(int id) {
		return userDao.listUserRoles(id);
	}

	@Override
	public List<Group> listUserGroups(int id) {
		return userDao.listUserGroups(id);
	}

	@Override
	public void delete(int id) {

		// TODO删除文章
		// 1 删除用户的角色对象

		userDao.deleteUserRoles(id);

		// 2 删除用户的组对象
		userDao.deleteUserGroups(id);

		userDao.delete(id);

	}

}
