package com.xiaocui.cms.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.xiaocui.cms.dao.IChannelDao;
import com.xiaocui.cms.vo.Channel;
import com.xiaocui.cms.vo.ChannelTree;
import com.xiaocui.cms.vo.CmsException;
import com.xiaocui.vo.PageContext;
import com.xiaocui.vo.Pager;

@Service("channelService")
public class ChannelService implements IChannelService {

	private IChannelDao channelDao;

	public IChannelDao getChannelDao() {
		return channelDao;
	}

	@Inject
	public void setChannelDao(IChannelDao channelDao) {
		this.channelDao = channelDao;
	}

	@Override
	public void add(Channel channel, Integer parentId) {
		if (parentId != null && parentId > 0) {
			Channel parentChannel = channelDao.load(parentId);

			if (parentChannel == null)

				throw new CmsException("添加的父类对象不正确");

			channel.setParent(parentChannel);
		}

		channelDao.add(channel);
	}

	@Override
	public void update(Channel channel, int parentId) {
		channelDao.update(channel);
	}

	@Override
	public void delete(int id) {
		// TODO 1 判断是否存在子频道
		List<Channel> parentChannel = channelDao.listByParent(id);

		if (parentChannel != null && parentChannel.size() > 0)

			throw new CmsException("当前频道存在子频道，不能删除");

		// TODO 2 判断是否存在文章

		// TODO 3 判断是否存在和组的关联

		channelDao.delete(id);

	}

	@Override
	public Channel load(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Channel> listByParent(Integer parentId) {
		String sort = PageContext.getSort();

		if (sort == null || "".equals(sort.trim())) {
			PageContext.setSort("orders");
			PageContext.setOrder("asc");
		}

		return channelDao.listByParent(parentId);
	}

	@Override
	public Pager<Channel> find() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void clearTopic(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<ChannelTree> generateTree() {
		return channelDao.generateTree();
	}

	@Override
	public List<ChannelTree> generateTreeByParent(Integer parentId) {
		return channelDao.generateTreeByParent(parentId);
	}

}
