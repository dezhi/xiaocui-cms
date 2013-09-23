package com.xiaocui.cms.dao;

import java.util.List;

import com.xiaocui.cms.vo.Role;
import com.xiaocui.dao.hibernate4.IBaseDao;
import com.xiaocui.vo.Pager;

public interface IRoleDao extends IBaseDao<Role> {
	/**
	 * 获取所有角色
	 */
	public List<Role> listRole();

	/**
	 * 获取所有角色
	 * 
	 * @return
	 */
	public Pager<Role> findRole();

	/**
	 * 删除角色中的用户
	 * 
	 * @param roleId
	 */
	public void deleteRoleUsers(int roleId);
}
