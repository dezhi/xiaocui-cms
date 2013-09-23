package com.xiaocui.cms.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xiaocui.cms.vo.Attachment;
import com.xiaocui.cms.vo.Keyword;
import com.xiaocui.dao.hibernate4.BaseDao;
import com.xiaocui.vo.Pager;

@Repository("attachmentDao")
public class AttachmentDao extends BaseDao<Attachment> implements
		IAttachmentDao {

	// 基于构造函数HQL
	private String getAttachment() {
		return "select new Attachment(a.id,a.old_name,a.new_name,a.type,a.suffix,a.size,a.is_index_pic,a.isImage,a.isAttachment,a.article.id)";
	}

	private String selectAttachment() {
		return "select new Attachment(a.id,a.oldName,a.newName,a.type,a.suffix,a.size,a.isIndexPic,a.isImage,a.isAttachment,a.article.id)";
	}

	@Override
	public Pager<Attachment> findNotUsed() {
		// 获取文章中没有使用的附件
		String hql = "select a from Attachment a where a.article is null";
		return this.find(hql);
	}

	@Override
	public void clearNotUsed() {
		// 1 删除附件的文件
		// TODO 清除文章中没有使用的附件
		String hql = "delete Attachemnt a where a.article is null";
		this.updateByHql(hql);
	}

	@Override
	public void deleteByArticle(int articleId) {
		// TODO 删除某篇文章中的附件
		String hql = "delete Attachement a where a.article.id=?";
		this.updateByHql(hql, articleId);
	}

	@Override
	public List<Attachment> listByArticle(int articleId) {
		// TODO 获取某篇文章中的附件
		// 普通HQL
		String hql = "select a from Attachement a where a.article.id=?";

		// 抓取HQL
		// String hql = "select a from Attachement a where a.article.id=?";

		// 基于构造函数HQL
		// String hql = selectAttachment()
		// + " from Attachment a where a.article.id=?";
		return this.list(hql, articleId);
	}

	@Override
	public List<Attachment> listByIndexPic(int num) {
		// TODO Auto-generated method stub

		String hql = selectAttachment()
				+ " from Attachment a where a.isIndexPic=?";

		// JDBC，参数从0开始
		// Hibernate，参数从1开始
		return this.getSession().createQuery(hql).setParameter(0, 1)
				.setFirstResult(0).setMaxResults(num).list();
	}

	@Override
	public Pager<Attachment> findByChannel(int channelId) {
		// TODO Auto-generated method stub

		// 文章必须已发布的
		String hql = " from Attachment a where a.article.status=1"
				+ "and a.article.channel.id=?"
				+ "and a.id=a.aricle.channelPic.id=?";

		return this.find(hql);
	}

	@Override
	public Pager<Attachment> findByChannelPic(int channelId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Attachment> listAttachmentByArticle(int articleId) {
		String hql = selectAttachment()
				+ " from Attachment a where a.aricle.id=?"
				+ " and a.isAttachment=1";

		return this.list(hql, articleId);
	}
}
