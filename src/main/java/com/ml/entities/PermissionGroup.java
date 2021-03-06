package com.ml.entities;

// Generated 2016-4-1 18:42:43 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

/**
 * PermissionGroup generated by hbm2java
 */
@Entity
@Table(name = "permission_group")
public class PermissionGroup implements java.io.Serializable {

	private String groupId;
	private String groupName;
	private Integer system_code;
	private Set<Permission> permissions = new HashSet<>(0);

	public PermissionGroup() {
	}

	public PermissionGroup(String groupId) {
		this.groupId = groupId;
	}

	public PermissionGroup(String groupId, String groupName, Set<Permission> permissions) {
		this.groupId = groupId;
		this.groupName = groupName;
		this.permissions = permissions;
	}

	@Id
	@Column(name = "group_id", unique = true, nullable = false, length = 36)
	public String getGroupId() {
		return this.groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	@Column(name = "group_name", length = 600)
	public String getGroupName() {
		return this.groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	@Column(name = "system_code")
	public Integer getSystem_code() {
		return system_code;
	}

	public void setSystem_code(Integer system_code) {
		this.system_code = system_code;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "permissionGroup")
	public Set<Permission> getPermissions() {
		return this.permissions;
	}

	public void setPermissions(Set<Permission> permissions) {
		this.permissions = permissions;
	}

}
