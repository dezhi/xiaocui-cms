package com.xiaocui.cms.vo;

/**
 * 频道树
 * 
 * @author Xiaocui
 * 
 */
public class ChannelTree {
	/**
	 * 频道树 编号
	 */
	private Integer id;
	/**
	 * 频道树 名称
	 */
	private String name;
	/**
	 * 频道树 父编号
	 */
	private Integer parentId;
	
	private Integer parent_id;

	public ChannelTree() {
	}

	public ChannelTree(Integer id, String name, Integer parent_id) {
		super();
		this.id = id;
		this.name = name;
		this.parent_id = parent_id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public Integer getParent_id() {
		return parent_id;
	}

	public void setParent_id(Integer parent_id) {
		this.parent_id = parent_id;
	}
	
	

}
