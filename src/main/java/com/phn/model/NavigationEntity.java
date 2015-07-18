/**
 * 
 */
package com.phn.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Administrator
 */
@Table(name="tb_navigation")
@Entity
public class NavigationEntity {
	private int id;
	private String NavigationName;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "UID", nullable = false, length = 9)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name = "tb_naviName", nullable = false, length = 20)
	public String getNavigationName() {
		return NavigationName;
	}
	public void setNavigationName(String navigationName) {
		NavigationName = navigationName;
	}
	
}
