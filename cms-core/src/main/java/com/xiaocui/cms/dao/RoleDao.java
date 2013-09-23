package com.xiaocui.cms.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xiaocui.cms.vo.Role;
import com.xiaocui.dao.hibernate4.BaseDao;
import com.xiaocui.vo.Pager;

@Repository("roleDao")
public class RoleDao extends BaseDao<Role> implements IRoleDao {
	@Override
	public List<Role> listRole() {
		return this.list("from Role");
	}

	@Override
	public Pager<Role> findRole() {
		return this.find("from Role");
	}

	@Override
	public void deleteRoleUsers(int roleId) {
		this.updateByHql("delete UserRole ur where ur.role.id=?", roleId);
	}

}
