package com.lwb.system.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * 角色
 * 
 * @author lwb
 * @email lwbldy@163.com
 * @date 2018-07-20 11:49:45
 */
public class RoleDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long roleId;
	//角色名称
	private String roleName;
	//角色标识
	private String roleSign;

	//备注
	private String remark;
	//创建用户id
	private Long userIdCreate;
	//创建时间
	private Date gmtCreate;
	//创建时间
	private Date gmtModified;

	//角色id
	private List<Integer> menuIdList;

	public List<Integer> getMenuIdList() {
		return menuIdList;
	}

	public void setMenuIdList(List<Integer> menuIdList) {
		this.menuIdList = menuIdList;
	}

	/**
	 * 设置：
	 */
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	/**
	 * 获取：
	 */
	public Long getRoleId() {
		return roleId;
	}
	/**
	 * 设置：角色名称
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	/**
	 * 获取：角色名称
	 */
	public String getRoleName() {
		return roleName;
	}
	/**
	 * 设置：角色标识
	 */
	public void setRoleSign(String roleSign) {
		this.roleSign = roleSign;
	}
	/**
	 * 获取：角色标识
	 */
	public String getRoleSign() {
		return roleSign;
	}
	/**
	 * 设置：备注
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 获取：备注
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * 设置：创建用户id
	 */
	public void setUserIdCreate(Long userIdCreate) {
		this.userIdCreate = userIdCreate;
	}
	/**
	 * 获取：创建用户id
	 */
	public Long getUserIdCreate() {
		return userIdCreate;
	}
	/**
	 * 设置：创建时间
	 */
	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getGmtCreate() {
		return gmtCreate;
	}
	/**
	 * 设置：创建时间
	 */
	public void setGmtModified(Date gmtModified) {
		this.gmtModified = gmtModified;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getGmtModified() {
		return gmtModified;
	}
}
