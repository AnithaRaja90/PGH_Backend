/**
 * 
 *
 * @category  
 * @package   
 * @author    Nichehands <nichehands@nichehands.com>
 * @copyright 2013 Nichehands Technologies Pvt Ltd.
 * @license   http://www.nichehandstechnologies.com / Private License
 * @link      http://www.nichehandstechnologies.com.
 */
package com.niche.model;

import java.time.LocalDate;
// import java.util.List;

// import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
// import javax.persistence.JoinColumn;
// import javax.persistence.ManyToMany;
// import javax.persistence.OneToMany;

/**
 * @author ilaiyarajat
 *
 */
@Entity
public class PickList extends AuditModel {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column (name = "pick_list_name")
	private String pickListName;
	
	private Long status;
	
	@Column(name ="created_by")
	private Long createdBy;
	
	@Column(name ="modified_by")
	private Long modifiedBy;
	
	// To set the one to many relation
	// @ManyToMany(cascade = CascadeType.ALL)
	// Here name is pick list table 
	// referencedColumnName Pick list value table
	// @JoinColumn(name = "id", referencedColumnName = "pick_list_id")
	// private List<PickListValue> pickListValue;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the pickListName
	 */
	public String getPickListName() {
		return pickListName;
	}

	/**
	 * @param pickListName the pickListName to set
	 */
	public void setPickListName(String pickListName) {
		this.pickListName = pickListName;
	}

	public Long getStatus() {
		return status;
	}

	public void setStatus(Long status) {
		this.status = status;
	}

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public Long getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(Long modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public PickList() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public PickList(String pickListName, Long status, Long createdBy, 
			Long modifiedBy
	) {
		super();
		this.pickListName = pickListName;
		this.status = status;
		this.createdBy = createdBy;
		this.modifiedBy = modifiedBy;
	}

	@Override
	public String toString() {
		return "PickList [pickListName=" + pickListName + ", status=" + status 
			+ ", createdBy=" + createdBy + ", modifiedBy=" + modifiedBy + "]";
	}
}
