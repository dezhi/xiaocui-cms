package com.xiaocui.cms.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xiaocui.cms.vo.Group;
import com.xiaocui.dao.hibernate4.BaseDao;
import com.xiaocui.vo.Pager;

@Repository("groupDao")
public class GroupDao extends BaseDao<Group> implements IGroupDao {
	@Override
	public List<Group> listGroup() {
		return this.list("from Group");
	}

	@Override
	public Pager<Group> findGroup() {
		return this.find("from Group");
	}

	@Override
	public void deleteGroupUsers(int groupId) {
		this.updateByHql("delete UserGroup ug where ug.group.id=?", groupId);
	}

}
