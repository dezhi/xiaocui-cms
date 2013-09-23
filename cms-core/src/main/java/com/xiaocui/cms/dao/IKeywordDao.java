package com.xiaocui.cms.dao;

import java.util.List;

import com.xiaocui.cms.vo.Keyword;
import com.xiaocui.dao.hibernate4.IBaseDao;
import com.xiaocui.vo.Pager;

public interface IKeywordDao extends IBaseDao<Keyword> {

	/**
	 * 添加或者更新关键词
	 * 
	 * 如果不存在，就进行添加，如果存在，就进行更新，让引用次数加1
	 * 
	 * @param name
	 */
	public void addOrUpdate(String name);

	/**
	 * 查询引用次数最多的关键词
	 * 
	 * @return
	 */
	public List<Keyword> list();

	/**
	 * 查询正在被引用的关键词
	 * 
	 * @return
	 */
	public Pager<Keyword> findUsed();

	/**
	 * 查询没有引用的关键词
	 * 
	 * @return
	 */
	public Pager<Keyword> findNotUsed();

	/**
	 * 清空没有引用的关键词
	 */
	public void clearNotUsed();

}
