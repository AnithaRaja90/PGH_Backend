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
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
// import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
// import javax.persistence.OneToMany;

/**
 * @author ilaiyarajat
 *
 */
@Entity
public class PickListValue {
	@Id
	@GeneratedValue
	private Long id;
	
	@Column (name = "pick_list_id")
	private Long pickListId;
	
	@Column (name = "pick_list_value")
	private String pickListValue;
	
	@Column (name = "self_id")
	private Long selfId;
	
	private Long status;
	
	@Column(name ="created_by")
	private Long createdBy;
	
	@Column(name ="modified_by")
	private Long modifiedBy;
	
	@Column(name ="created_at")
	private LocalDate createdAt;
	
	@Column(name ="updated_at")
	private LocalDate updatedAt;

	
	// To set the one to many relation
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Batch> batchVarietyId;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Batch> batchCategoryId;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Stock> stockVarietyId;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Stock> stockCategoryId;
	
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
	 * @return the pickListId
	 */
	public Long getPickListId() {
		return pickListId;
	}

	/**
	 * @param pickListId the pickListId to set
	 */
	public void setPickListId(Long pickListId) {
		this.pickListId = pickListId;
	}

	/**
	 * @return the pickListValue
	 */
	public String getPickListValue() {
		return pickListValue;
	}

	/**
	 * @param pickListValue the pickListValue to set
	 */
	public void setPickListValue(String pickListValue) {
		this.pickListValue = pickListValue;
	}

	/**
	 * @return the selfId
	 */
	public Long getSelfId() {
		return selfId;
	}

	/**
	 * @param selfId the selfId to set
	 */
	public void setSelfId(Long selfId) {
		this.selfId = selfId;
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

	public LocalDate getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDate getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDate updatedAt) {
		this.updatedAt = updatedAt;
	}

	/**
	 * 
	 */
	public PickListValue() {
		super();
	}

	public PickListValue(Long pickListId, String pickListValue, Long selfId, Long status, 
		Long createdBy, Long modifiedBy, LocalDate createdAt, LocalDate updatedAt
	) {
		super();
		this.pickListId = pickListId;
		this.pickListValue = pickListValue;
		this.selfId = selfId;
		this.status = status;
		this.createdBy = createdBy;
		this.modifiedBy = modifiedBy;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		return "PickListValue [pickListId=" + pickListId + ", pickListValue=" + pickListValue 
			+ ", selfId=" + selfId + ", status=" + status + ", createdBy=" + createdBy 
			+ ", modifiedBy=" + modifiedBy + ", createdAt=" + createdAt 
			+ ", updatedAt=" + updatedAt + "]";
	}
}
