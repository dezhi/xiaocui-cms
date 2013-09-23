package com.xiaocui.cms.dao;

import java.util.List;

import com.xiaocui.cms.vo.Group;
import com.xiaocui.cms.vo.Role;
import com.xiaocui.cms.vo.RoleType;
import com.xiaocui.cms.vo.User;
import com.xiaocui.cms.vo.UserGroup;
import com.xiaocui.cms.vo.UserRole;
import com.xiaocui.dao.hibernate4.IBaseDao;
import com.xiaocui.vo.Pager;

public interface IUserDao extends IBaseDao<User> {
	/**
	 * 获取所有用户
	 */
	public List<User> listUser();

	/**
	 * 获取所有用户
	 */
	public Pager<User> findUser();

	/**
	 * 删除用户
	 * 
	 * @return
	 */
	public List<User> deleteUser(int userId);

	/**
	 * 获取当前用户所有角色信息
	 * 
	 * @return
	 */
	public List<Role> listUserRoles(int userId);

	/**
	 * 获取当前用户所有角色编号
	 * 
	 * @return
	 */
	public List<Integer> listUserRolesByIds(int userId);

	/**
	 * 获取当前用户所有组信息
	 * 
	 * @return
	 */
	public List<Group> listUserGroups(int userId);

	/**
	 * 获取当前用户所有组编号
	 * 
	 * @return
	 */
	public List<Integer> listUserGroupsByIds(int userId);

	/**
	 * 根据用户和角色，获取用户角色关联对象
	 * 
	 * @param userId
	 * @param roleId
	 * @return
	 */
	public UserRole loadUserRole(int userId, int roleId);

	/**
	 * 根据用户和组，获取用户组关联对象
	 * 
	 * @param userId
	 * @param roleId
	 * @return
	 */
	public UserGroup loadUserGroup(int userId, int groupId);

	/**
	 * 根据用户名称获取用户对象
	 * 
	 * @param username
	 * @return
	 */
	public User loadByUsername(String username);

	/**
	 * 根据角色类型获取用户对象
	 * 
	 * @param username
	 * @return
	 */
	public List<User> listRoleUsers(RoleType roleType);

	/**
	 * 根据角色编号获取用户列表
	 * 
	 * @param roleType
	 * @return
	 */
	public List<User> listRoleUsers(int roleId);

	/**
	 * 根据组编号获取用户列表
	 * 
	 * @param groupId
	 * @return
	 */
	public List<User> listGroupUsers(int groupId);

	// /**
	// * 添加用户
	// *
	// * @param user
	// * 用户对象
	// * @param roleId
	// * 用户的所有角色编号
	// * @param groupId
	// * 用户的所有组编号
	// */
	// public void add(User user, Integer[] roleIds, Integer[] groupIds);
	//
	// /**
	// * 更新用户
	// *
	// * @param user
	// * 用户对象
	// * @param roleId
	// * 用户的所有角色编号
	// * @param groupId
	// * 用户的所有组编号
	// */
	// public void update(User user, Integer[] roleIds, Integer[] groupIds);

	/**
	 * 添加用户角色对象
	 * 
	 * @param userId
	 * @param roleId
	 */
	public void addUserRole(int userId, int roleId);

	/**
	 * 添加用户角色的关联对象
	 * 
	 * @param user
	 * @param role
	 */
	public void addUserRole(User user, Role role);

	/**
	 * 添加用户组对象
	 * 
	 * @param user
	 * @param group
	 */
	public void addUserGroup(int userId, int groupId);

	/**
	 * 添加用户组的关联对象
	 * 
	 * @param user
	 * @param group
	 */
	public void addUserGroup(User user, Group group);

	/**
	 * 删除当前用户角色对象
	 * 
	 * @param roleId
	 */
	public void deleteUserRole(int userId, int roleId);

	/**
	 * 删除当前用户角色信息
	 * 
	 * @param roleId
	 */
	public void deleteUserRoles(int roleId);

	/**
	 * 删除当前用户组对象
	 * 
	 * @param groupId
	 */
	public void deleteUserGroup(int userId, int groupId);

	/**
	 * 删除当前用户组信息
	 * 
	 * @param userId
	 */
	public void deleteUserGroups(int userId);

}
