package com.xiaocui.cms.dao;

import java.util.List;

import com.xiaocui.cms.vo.Article;
import com.xiaocui.dao.hibernate4.IBaseDao;
import com.xiaocui.vo.Pager;

public interface IArticleDao extends IBaseDao<Article> {

	public List<Article> list();

	public Pager<Article> find();

	/**
	 * 根据某个频道，检索推荐的文章
	 * 
	 * @param channelId
	 * @param title
	 * @param status
	 * @param recommend
	 * @return
	 */
	public Pager<Article> find(Integer channelId);

	/**
	 * 根据频道、文章标题检索文章
	 * 
	 * @return
	 */
	public Pager<Article> find(Integer channelId, String title, Integer status);

	/**
	 * 根据用户、频道、文章标题检索文章
	 * 
	 * @param userId
	 * @param channelId
	 * @param title
	 * @return
	 */
	public Pager<Article> find(Integer userId, Integer channelId, String title,
			Integer status);

	/**
	 * 根据条件检索文章
	 * 
	 * @param content
	 * @return
	 */
	public Pager<Article> searchAritcle(String content);

	/**
	 * 根据某个条件检索文章、标题、内容、概要
	 * 
	 * @param content
	 * @return
	 */
	public Pager<Article> search(String content);

	/**
	 * 根据文章关键词检索文章
	 * 
	 * @param keyword
	 * @return
	 */
	public Pager<Article> searchByKeyword(String keyword);
}
