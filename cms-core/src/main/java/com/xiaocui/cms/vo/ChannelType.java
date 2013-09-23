package com.xiaocui.cms.vo;

/**
 * 栏目、频道类型
 * 
 * @author Xiaocui
 * 
 */
public enum ChannelType {
	nav_channel("导航频道"), topic_list("文章列表频道"), topic_content("文章内容频道"), topic_image(
			"文章图片频道");

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private ChannelType(String name) {
		this.name = name;
	}

}
