package com.xiaocui.cms.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xiaocui.cms.vo.Group;
import com.xiaocui.cms.vo.Role;
import com.xiaocui.cms.vo.RoleType;
import com.xiaocui.cms.vo.UserGroup;
import com.xiaocui.cms.vo.UserRole;
import com.xiaocui.dao.hibernate4.BaseDao;
import com.xiaocui.cms.vo.User;
import com.xiaocui.cms.dao.IUserDao;
import com.xiaocui.vo.Pager;

@SuppressWarnings("unchecked")
@Repository("userDao")
public class UserDao extends BaseDao<User> implements IUserDao {

	// @Override
	// public void add(User user, Integer[] roleIds, Integer[] groupIds) {
	// // TODO Auto-generated method stub
	//
	// }
	//
	// @Override
	// public void update(User user, Integer[] roleIds, Integer[] groupIds) {
	// // TODO Auto-generated method stub
	//
	// }

	@Override
	public void addUserGroup(int userId, int groupId) {
		// TODO Auto-generated method stub

	}

	/**
	 * 获取所有用户
	 * 
	 * @return
	 */
	public List<User> listUser() {
		return this.list("from User");
	}

	public Pager<User> findUser() {
		return this.find("from User");
	}

	public List<User> deleteUser(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 删除当前用户角色对象
	 */
	@Override
	public void deleteUserRole(int userId, int roleId) {
		String hql = "delete UserRole ur where ur.user.id=? and ur.role.id=?";

		this.updateByHql(hql, new Object[] { userId, roleId });
	}

	/**
	 * 删除当前用户角色信息
	 */
	public void deleteUserRoles(int userId) {
		String hql = "delete UserRole ur where ur.user.id=?";
		this.updateByHql(hql, userId);
	}

	/**
	 * 删除当前用户组对象
	 */
	@Override
	public void deleteUserGroup(int userId, int groupId) {
		String hql = "delete UserGroup ug where ug.user.id=? and ug.group.id=?";

		this.updateByHql(hql, new Object[] { userId, groupId });
	}

	/**
	 * 删除当前用户组信息
	 */
	@Override
	public void deleteUserGroups(int userId) {
		String hql = "delete UserGroup ug where ug.user.id=?";
		this.updateByHql(hql, userId);
	}

	public void addUserRole(int userId, int roleId) {
	}

	@Override
	public void addUserRole(User user, Role role) {
		UserRole ur = this.loadUserRole(user.getId(), role.getId());
		// 已存在
		if (ur != null)
			return;
		
		ur = new UserRole();

		ur.setRole(role);

		ur.setUser(user);

		this.getSession().save(ur);
	}

	@Override
	public void addUserGroup(User user, Group group) {
		UserGroup ug = this.loadUserGroup(user.getId(), group.getId());

		// 已存在
		if (ug != null)
			return;

		ug = new UserGroup();

		ug.setGroup(group);

		ug.setUser(user);

		this.getSession().save(ug);
	}

	/**
	 * 获取用户角色关联对象
	 */
	@Override
	public UserRole loadUserRole(int userId, int roleId) {
		String hql = "select ur from UserRole ur left join fetch ur.user u left join fetch ur.role r where u.id=? and r.id=?";
		return (UserRole) this.getSession().createQuery(hql)
				.setParameter(0, userId).setParameter(1, roleId).uniqueResult();
	}

	/**
	 * 获取用户组关联对象
	 */
	@Override
	public UserGroup loadUserGroup(int userId, int groupId) {
		//String hql = "select ug from UserGroup ug where ug.user.id=? and ug.group.id=?";
		
		String hql = "select ug from UserGroup ug left join fetch ug.user u left join fetch ug.group g where u.id=? and g.id=?";
		return (UserGroup) this.getSession().createQuery(hql)
				.setParameter(0, userId).setParameter(1, groupId)
				.uniqueResult();
	}

	/**
	 * 根据用户名称获取用户对象
	 */
	@Override
	public User loadByUsername(String username) {
		String hql = "from User where username=?";
		return (User) this.queryObject(hql, username);
	}

	/**
	 * 获取当前用户所有角色信息
	 * 
	 * @return
	 */
	@Override
	public List<Role> listUserRoles(int userId) {
		String hql = "select ur.role from UserRole ur where ur.user.id=?";
		return this.getSession().createQuery(hql).setParameter(0, userId)
				.list();
	}

	@Override
	public List<User> listRoleUsers(int roleId) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 根据角色类型获取用户对象
	 */
	@Override
	public List<User> listRoleUsers(RoleType roleType) {
		String hql = "select ur.user from UserRole ur where ur.role.roleType=?";
		return this.list(hql, roleType);
	}

	/**
	 * 获取当前用户所有角色编号
	 * 
	 * @return
	 */
	@Override
	public List<Integer> listUserRolesByIds(int userId) {
		String hql = "select ur.role.id from UserRole ur where ur.user.id=?";
		return this.getSession().createQuery(hql).setParameter(0, userId)
				.list();

	}

	/**
	 * 获取当前用户所有组信息
	 * 
	 * @return
	 */
	@Override
	public List<Group> listUserGroups(int userId) {
		String hql = "select ug.group from UserGroup ug where ug.user.id=?";
		return this.getSession().createQuery(hql).setParameter(0, userId)
				.list();
	}

	/**
	 * 获取当前用户所有组编号
	 * 
	 * @return
	 */
	public List<Integer> listUserGroupsByIds(int userId) {
		String hql = "select ug.group.id from UserGroup ug where ug.user.id=?";
		return this.getSession().createQuery(hql).setParameter(0, userId)
				.list();
	}

	/**
	 * 获取某个组的用户对象
	 */
	public List<User> listGroupUsers(int groupId) {
		String hql = "select ur.user from UserGroup ug where ug.group.id=?";
		return this.getSession().createQuery(hql).setParameter(0, groupId)
				.list();
	}

}
