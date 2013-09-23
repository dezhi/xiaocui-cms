package com.xiaocui.cms.service;

import java.util.List;

import com.xiaocui.cms.vo.Article;
import com.xiaocui.vo.Pager;

public interface IArticleService {
	
	public List<Article> list();
	
	public Pager<Article> find();
}
