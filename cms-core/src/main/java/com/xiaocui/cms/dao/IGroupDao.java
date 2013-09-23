package com.xiaocui.cms.dao;

import java.util.List;

import com.xiaocui.cms.vo.Group;
import com.xiaocui.dao.hibernate4.IBaseDao;
import com.xiaocui.vo.Pager;

public interface IGroupDao extends IBaseDao<Group> {
	/**
	 * 获取所有组信息
	 */
	public List<Group> listGroup();

	/**
	 * 获取所有组信息
	 * 
	 * @return
	 */
	public Pager<Group> findGroup();

	/**
	 * 删除组中的用户
	 * 
	 * @param groupId
	 */
	public void deleteGroupUsers(int groupId);
}
