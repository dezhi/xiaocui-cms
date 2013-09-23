package com.xiaocui.cms.service;

import java.util.List;

import com.xiaocui.cms.vo.Group;
import com.xiaocui.cms.vo.Role;
import com.xiaocui.cms.vo.User;
import com.xiaocui.vo.Pager;

public interface IUserService {
	/**
	 * 添加用户
	 * 
	 * 1 判断用户是否存在，如果存在，则抛出异常
	 * 
	 * @param user
	 *            用户对象
	 * @param roleIds
	 *            获取用户所有角色编号
	 * @param groupIds
	 *            获取用户所有组编号
	 */
	public void add(User user, Integer[] roleIds, Integer[] groupIds);

	/**
	 * 更新用户
	 * 
	 * @param user
	 *            用户对象
	 * @param roleIds
	 *            获取用户所有角色编号
	 * @param groupIds
	 *            获取用户所有组编号
	 */
	public void update(User user, Integer[] roleIds, Integer[] groupIds);

	/**
	 * 更新用户状态
	 * 
	 * @param user
	 * @param roleIds
	 * @param groupIds
	 */
	public void updateStatus(int id);

	public Pager<User> findUser();

	public User load(int id);

	/**
	 * 获取用户的所有角色信息
	 * 
	 * @param id
	 * @return
	 */
	public List<Role> listUserRoles(int id);

	/**
	 * 获取用户的所有组信息
	 * 
	 * @param id
	 * @return
	 */
	public List<Group> listUserGroups(int id);

	/**
	 * 删除用户
	 * 
	 * 1 判断当前用户，是否存在用户和角色的关联
	 * 
	 * 2 判断当前用户，是否存在用户和组的关联
	 * 
	 * 3 判断当前用户，是否存在文章记录
	 * 
	 */
	public void delete(int id);
}
