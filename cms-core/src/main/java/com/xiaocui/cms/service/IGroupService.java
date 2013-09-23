package com.xiaocui.cms.service;

import java.util.List;

import com.xiaocui.cms.vo.Group;
import com.xiaocui.vo.Pager;

public interface IGroupService {

	public void add(Group group);

	public void delete(int groupId);

	public void update(Group group);

	public Group load(int groupId);

	public List<Group> listGroup();

	public Pager<Group> findGroup();

	public void deleteGroupUsers(int groupId);

}
