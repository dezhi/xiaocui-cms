package com.xiaocui.cms.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xiaocui.cms.vo.Article;
import com.xiaocui.dao.hibernate4.BaseDao;
import com.xiaocui.vo.Pager;

@Repository("articleDao")
public class ArticleDao extends BaseDao<Article> implements IArticleDao {

	@Override
	public List<Article> list() {
		return this.list("from Article");
	}

	@Override
	public Pager<Article> find() {
		return this.find("from Article");
	}

	@Override
	public Pager<Article> find(Integer userId, Integer channelId, String title,
			Integer status) {
		String hql = "select a from Article a where 1=1";

		if (status != null) {
			hql += " and a.status=" + status;
		}
		if (title != null && !title.equals("")) {
			hql += " and a.title like '%" + title + "%'";
		}
		if (userId != null) {
			hql += " and a.user.id=" + userId;
		}
		if (channelId != null) {
			hql += " and a.channel.id=" + channelId;
		}

		return this.find(hql);
	}

	@Override
	public Pager<Article> find(Integer channelId, String title, Integer status) {
		return this.find(null, channelId, title, status);
	}

	@Override
	public Pager<Article> find(Integer channelId) {

		String hql = "select * from Article a  where a.status=1 and a.recommend=1";

		// 父频道
		if (channelId == null || channelId == 0) {

			return this.find(hql);
		} else {
			hql += " and a.channel.id=?";

			return this.find(hql, channelId);
		}
	}

	@Override
	public Pager<Article> searchAritcle(String content) {
		String hql = "from Aritcle a where t.status=1 and " + "(title like '%"
				+ content + "%' or content like '%" + content
				+ "%' or summary like '%" + content + "%')";
		return this.find(hql);
	}

	@Override
	public Pager<Article> search(String content) {
		String hql = "from Aritcle a where t.status=1 and " + "(title like '%"
				+ content + "%' or content like '%" + content
				+ "%' or summary like '%" + content + "%')";
		return this.find(hql);
	}

	@Override
	public Pager<Article> searchByKeyword(String keyword) {
		String hql = "from Aritcle a where t.status=1 and t.keyword like '%"
				+ keyword + "%'";

		return this.find(hql);
	}

}
