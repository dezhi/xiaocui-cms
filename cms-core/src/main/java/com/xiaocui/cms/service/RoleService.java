package com.xiaocui.cms.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.xiaocui.cms.dao.IRoleDao;
import com.xiaocui.cms.dao.IUserDao;
import com.xiaocui.cms.vo.CmsException;
import com.xiaocui.cms.vo.Role;
import com.xiaocui.cms.vo.User;
import com.xiaocui.vo.Pager;

@Service("roleService")
public class RoleService implements IRoleService {

	private IRoleDao roleDao;

	private IUserDao userDao;

	public IRoleDao getRoleDao() {
		return roleDao;
	}

	@Inject
	public void setRoleDao(IRoleDao roleDao) {
		this.roleDao = roleDao;
	}

	public IUserDao getUserDao() {
		return userDao;
	}

	@Inject
	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public void add(Role role) {
		roleDao.add(role);
	}

	@Override
	public void delete(int roleId) {
		List<User> users = userDao.listRoleUsers(roleId);
		if (users != null && users.size() > 0)
			throw new CmsException("角色里存在用户，不能删除。");

		roleDao.delete(roleId);
	}

	@Override
	public void update(Role role) {
		roleDao.update(role);
	}

	@Override
	public Role load(int roleId) {
		return roleDao.load(roleId);
	}

	@Override
	public List<Role> listRole() {
		return roleDao.listRole();
	}

	@Override
	public Pager<Role> findRole() {
		return roleDao.findRole();
	}
}
