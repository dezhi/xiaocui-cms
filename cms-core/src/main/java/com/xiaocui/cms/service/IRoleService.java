package com.xiaocui.cms.service;

import java.util.List;

import com.xiaocui.cms.vo.Role;
import com.xiaocui.vo.Pager;

public interface IRoleService {
	public void add(Role role);

	public void delete(int roleId);

	public void update(Role role);

	public Role load(int roleId);

	public List<Role> listRole();

	public Pager<Role> findRole();
}
