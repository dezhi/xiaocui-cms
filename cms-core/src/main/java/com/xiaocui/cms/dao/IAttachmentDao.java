package com.xiaocui.cms.dao;

import java.util.List;

import com.xiaocui.cms.vo.Attachment;
import com.xiaocui.dao.hibernate4.IBaseDao;
import com.xiaocui.vo.Pager;

public interface IAttachmentDao extends IBaseDao<Attachment> {

	/**
	 * 获取没有使用的附件
	 * 
	 * 获取没有引用次数的附件
	 * 
	 * @return
	 */
	public Pager<Attachment> findNotUsed();

	/**
	 * 清空没有引用的附件
	 * 
	 * 清除没有引用次数的附件
	 */
	public void clearNotUsed();

	/**
	 * 删除某篇文章的附件
	 */
	public void deleteByArticle(int articleId);

	/**
	 * 获取某篇文章的附件
	 * 
	 * @param articleId
	 */
	public List<Attachment> listByArticle(int articleId);

	/**
	 * 根据一个数量获取主页图片的附件信息
	 * 
	 * @param num
	 */
	public List<Attachment> listByIndexPic(int num);

	/**
	 * 获取某个频道的附件信息
	 * 
	 * @param num
	 */
	public Pager<Attachment> findByChannel(int channelId);

	/**
	 * 获取某个频道的附件图片信息
	 * 
	 * @param channelId
	 * @return
	 */
	public Pager<Attachment> findByChannelPic(int channelId);

	/**
	 * 获取某篇文章的属于附件类型的附件对象
	 * 
	 * @param num
	 * @return
	 */
	public List<Attachment> listAttachmentByArticle(int articleId);
}
