package com.xiaocui.cms.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.xiaocui.cms.dao.IArticleDao;
import com.xiaocui.cms.vo.Article;
import com.xiaocui.vo.Pager;

@Service("articleService")
public class ArticleService implements IArticleService {
	private IArticleDao articleDao;

	public IArticleDao getArticleDao() {
		return articleDao;
	}

	@Inject
	public void setArticleDao(IArticleDao articleDao) {
		this.articleDao = articleDao;
	}

	public List<Article> list() {
		return articleDao.list();
	}

	public Pager<Article> find() {
		return articleDao.find();
	}
}
