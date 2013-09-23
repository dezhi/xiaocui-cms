package com.xiaocui.cms.dao;

import java.util.List;

import com.xiaocui.cms.vo.Channel;
import com.xiaocui.cms.vo.ChannelTree;
import com.xiaocui.dao.hibernate4.IBaseDao;

public interface IChannelDao extends IBaseDao<Channel> {
	/**
	 * 根据父频道ID，获取所有的子频道
	 * 
	 * @param parentId
	 * @return
	 */
	public List<Channel> listByParent(Integer parentId);

	/**
	 * 根据父频道ID，获取子频道最大的排序值
	 * 
	 * @param parentId
	 * @return
	 */
	public int maxSortedByParent(Integer parentId);

	/**
	 * 获取并生成频道树
	 */
	public List<ChannelTree> generateTree();

	/**
	 * 根据父频道ID，获取并生成当前频道树
	 * @return 
	 */
	public List<ChannelTree> generateTreeByParent(Integer parentId);
}
