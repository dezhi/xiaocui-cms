package com.xiaocui.cms.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xiaocui.cms.vo.Channel;
import com.xiaocui.cms.vo.ChannelTree;
import com.xiaocui.dao.hibernate4.BaseDao;

@Repository("channelDao")
public class ChannelDao extends BaseDao<Channel> implements IChannelDao {

	@Override
	public List<Channel> listByParent(Integer parentId) {
		// null值，设置为Integer

		// 获取频道父类
		// String hql = "select c from Channel c where c.parent.id=" + parentId;

		String hql = "select c from Channel c left join fetch c.parent cp where cp.id="
				+ parentId;
		// 频道的父类值或许会为null
		if (parentId == null || parentId == 0)
			hql = "select c from Channel c where c.parent.id is null";

		return this.list(hql);
	}

	@Override
	public int maxSortedByParent(Integer parentId) {
		String hql = "select max(c.sorted) from Channel c where c.parent.id="
				+ parentId;

		if (parentId == null || parentId == 0)
			hql = "select max(c.sorted) from Channel c where c.parent.id is null";

		return (Integer) this.queryObject(hql);
	}

	@Override
	public List<ChannelTree> generateTree() {
		String sql = "select id,name,parent_id from t_channel order by sorted";

		List<ChannelTree> cts = this.listBySql(sql, ChannelTree.class, false);

		// 获取第一条数据或许为null，不能直接使用int数据类型

		cts.add(0, new ChannelTree(Channel.ROOT_ID, Channel.ROOT_NAME, -1));

		for (ChannelTree ct : cts) {
			if (ct.getParentId() == null)
				ct.setParentId(0);
		}

		return cts;
	}

	@Override
	public List<ChannelTree> generateTreeByParent(Integer parentId) {
		// 一般适用于，异步加载

		// 判断是当前频道是否为父频道
		// 父频道的判断值为null或0
		if (parentId == null || parentId == 0) {

			String sql = "select id,name,parent_id from t_channel where parend_id is null order by sorted";

			return this.listBySql(sql, ChannelTree.class, false);
		} else {

			String sql = "select id,name,parent_id from t_channel where parend_id="
					+ parentId + " order by sorted";
			return this.listBySql(sql, ChannelTree.class, false);
		}

	}
}
