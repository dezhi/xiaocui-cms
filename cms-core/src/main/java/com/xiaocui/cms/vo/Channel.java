package com.xiaocui.cms.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 栏目、频道
 * 
 * @author Xiaocui
 * 
 */
@Entity
@Table(name = "t_channel")
public class Channel {
	public static final int ROOT_ID = 0;
	public static final String ROOT_NAME = "根目录";
	/**
	 * 频道编号
	 */
	private int id;
	/**
	 * 频道名称
	 */
	private String name;
	/**
	 * 自定义链接
	 */
	private int customLink;
	/**
	 * 指定链接地址
	 */
	private String customLinkUrl;
	/**
	 * 频道类型
	 */
	private ChannelType channelType;

	/**
	 * 是否为主页显示
	 */
	private int isIndex;

	/**
	 * 是否为顶部导航显示
	 */
	private int isTopNavigation;
	/**
	 * 是否为推荐频道
	 */
	private int recommend;;
	/**
	 * 频道状态、0、禁用，1、启用
	 */
	private int status;
	/**
	 * 频道排序、序号
	 */
	private int sorted;
	/**
	 * 频道父类
	 */
	private Channel parent;

	public Channel() {
	}

	public Channel(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	@ManyToOne
	@JoinColumn(name = "parent_id")
	public Channel getParent() {
		return parent;
	}

	public void setParent(Channel parent) {
		this.parent = parent;
	}

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "custom_link")
	public int getCustomLink() {
		return customLink;
	}

	public void setCustomLink(int customLink) {
		this.customLink = customLink;
	}

	@Column(name = "custom_link_url")
	public String getCustomLinkUrl() {
		return customLinkUrl;
	}

	public void setCustomLinkUrl(String customLinkUrl) {
		this.customLinkUrl = customLinkUrl;
	}

	@Column(name = "channel_type")
	public ChannelType getChannelType() {
		return channelType;
	}

	public void setChannelType(ChannelType channelType) {
		this.channelType = channelType;
	}

	@Column(name = "is_index")
	public int getIsIndex() {
		return isIndex;
	}

	public void setIsIndex(int isIndex) {
		this.isIndex = isIndex;
	}

	@Column(name = "is_top_navigation")
	public int getIsTopNavigation() {
		return isTopNavigation;
	}

	public void setIsTopNavigation(int isTopNavigation) {
		this.isTopNavigation = isTopNavigation;
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

	public int getSorted() {
		return sorted;
	}

	public void setSorted(int sorted) {
		this.sorted = sorted;
	}
}
