package com.xiaocui.cms.vo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "t_article")
public class Article {
	/**
	 * 文章 编号
	 */
	private int id;
	/**
	 * 文章 关键词，使用|中划线分割
	 */
	private String keyword;
	/**
	 * 文章 标题
	 */
	private String title;
	/**
	 * 文章 是否推荐
	 */
	private int recommend;
	/**
	 * 文章 当前状态
	 */
	private int status;
	/**
	 * 频道图片ID，如果频道是图片类型，就显示图片
	 */
	private int channelPicId;
	/**
	 * 文章 内容
	 */
	private String content;

	/**
	 * 摘要、概要、总结
	 */
	private String summary;
	/**
	 * 文章 发布时间
	 */
	private Date publishDate;
	/**
	 * 文章 创建时间
	 */
	private Date createDate;
	/**
	 * 文章 作者
	 */
	private String author;

	// 文章的关联对象

	/**
	 * 频道
	 */
	private Channel channel;
	/**
	 * 用户
	 */
	private User user;

	public Article() {
	}

	public Article(int id, String keyword, String title, int recommend,
			int status, String content, String summary, Date publishDate,
			Date createDate, String author, Channel channel, User user) {
		super();
		this.id = id;
		this.keyword = keyword;
		this.title = title;
		this.recommend = recommend;
		this.status = status;
		this.content = content;
		this.publishDate = publishDate;
		this.author = author;
	}

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getRecommend() {
		return recommend;
	}

	public void setRecommend(int recommend) {
		this.recommend = recommend;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	@Column(name = "publish_date")
	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	@Column(name = "create_date")
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@ManyToOne
	@JoinColumn(name = "channel_id")
	public Channel getChannel() {
		return channel;
	}

	public void setChannel(Channel channel) {
		this.channel = channel;
	}

	@ManyToOne
	@JoinColumn(name = "user_id")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "channel_pic_id")
	public int getChannelPicId() {
		return channelPicId;
	}

	public void setChannelPicId(int channelPicId) {
		this.channelPicId = channelPicId;
	}

}
