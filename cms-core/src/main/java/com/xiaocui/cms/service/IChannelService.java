package com.xiaocui.cms.service;

import java.util.List;

import com.xiaocui.cms.vo.Channel;
import com.xiaocui.cms.vo.ChannelTree;
import com.xiaocui.vo.Pager;

public interface IChannelService {
	/**
	 * 添加栏目
	 * 
	 * @param channel
	 * @param parentId
	 */
	public void add(Channel channel, Integer parentId);

	/**
	 * 更新栏目
	 * 
	 * @param channel
	 * @param parentId
	 */
	public void update(Channel channel, int parentId);

	/**
	 * 删除栏目
	 * 
	 * @param id
	 */
	public void delete(int id);

	public Channel load(int id);

	/**
	 * 根据父ID加载频道，该方面首先检查PageContext中是否有排序
	 * 
	 * @return
	 */
	public List<Channel> listByParent(Integer parentId);

	public Pager<Channel> find();

	/**
	 * 清除栏目中的文章
	 */
	public void clearTopic(int id);

	/**
	 * 获取并生成频道树
	 */
	public List<ChannelTree> generateTree();

	/**
	 * 根据父频道ID，获取并生成当前频道树
	 * 
	 * @param parentId
	 * @return
	 */
	public List<ChannelTree> generateTreeByParent(Integer parentId);
}
