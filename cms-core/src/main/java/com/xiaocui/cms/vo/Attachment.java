package com.xiaocui.cms.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "t_attachment")
public class Attachment {
	private int id;
	/**
	 * 附件 上传之前的名称
	 */
	private String oldName;
	/**
	 * 附件 上传之后的名称
	 */
	private String newName;
	/**
	 * 附件类型
	 */
	private String type;
	/**
	 * 附件 后缀名称
	 */
	private String suffix;

	private long size;

	private int isIndexPic;

	private int isImage;
	/**
	 * 是否为附件信息
	 */
	private int isAttachment;

	// 附件的关联对象

	private Article article;

	// 附件的构造方法

	public Attachment() {
		super();
	}

	// 性能
	public Attachment(int id, String oldName, String newName, String type,
			String suffix, long size, int isIndexPic, int isImage,
			int isAttachment, int articleId) {
		super();
		this.id = id;
		this.oldName = oldName;
		this.newName = newName;
		this.type = type;
		this.suffix = suffix;
		this.size = size;
		this.isIndexPic = isIndexPic;
		this.isImage = isImage;
		this.isAttachment = isAttachment;

		// 避免空指针异常
		this.article = new Article();

		this.article.setId(articleId);
	}

	public Attachment(int id, String oldName, String newName, String type,
			String suffix, long size, int isIndexPic, int isImage,
			int isAttachment, Article article) {
		super();
		this.id = id;
		this.oldName = oldName;
		this.newName = newName;
		this.type = type;
		this.suffix = suffix;
		this.size = size;
		this.isIndexPic = isIndexPic;
		this.isImage = isImage;
		this.isAttachment = isAttachment;
		this.article = article;
	}

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "old_name")
	public String getOldName() {
		return oldName;
	}

	public void setOldName(String oldName) {
		this.oldName = oldName;
	}

	@Column(name = "new_name")
	public String getNewName() {
		return newName;
	}

	public void setNewName(String newName) {
		this.newName = newName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	@Column(name = "is_index_pic")
	public int getIsIndexPic() {
		return isIndexPic;
	}

	public void setIsIndexPic(int isIndexPic) {
		this.isIndexPic = isIndexPic;
	}

	@Column(name = "is_image")
	public int getIsImage() {
		return isImage;
	}

	public void setIsImage(int isImage) {
		this.isImage = isImage;
	}

	@ManyToOne
	@JoinColumn(name = "article_id")
	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	@Column(name = "is_attachment")
	public int getIsAttachment() {
		return isAttachment;
	}

	public void setIsAttachment(int isAttachment) {
		this.isAttachment = isAttachment;
	}

}
