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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author ilaiyarajat
 *
 */
@Entity
public class Nursery {
	@Id
	@GeneratedValue
	private Long id;
	
	@Column (name = "sector_id")
	private Long sectorId;
	
	@Column (name = "nursery_name")
	private String nurseryName;
	
	@Column (name = "nursery_address")
	private String nurseryAddress;
	
	@Column (name = "nursery_incharge")
	private Long nurseryIncharge;
	
	private Long status;
	
	@Column (name = "created_by")
	private Long createdBy;
	
	@Column (name = "modified_by")
	private Long modifiedBy;
	
	@Column (name = "created_at")
	private LocalDate createdAt;
	
	@Column (name = "updated_at")
	private LocalDate updatedAt;

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
	 * @return the sectorId
	 */
	public Long getSectorId() {
		return sectorId;
	}

	/**
	 * @param sectorId the sectorId to set
	 */
	public void setSectorId(Long sectorId) {
		this.sectorId = sectorId;
	}

	/**
	 * @return the nurseryName
	 */
	public String getNurseryName() {
		return nurseryName;
	}

	/**
	 * @param nurseryName the nurseryName to set
	 */
	public void setNurseryName(String nurseryName) {
		this.nurseryName = nurseryName;
	}

	/**
	 * @return the nurseryAddress
	 */
	public String getNurseryAddress() {
		return nurseryAddress;
	}

	/**
	 * @param nurseryAddress the nurseryAddress to set
	 */
	public void setNurseryAddress(String nurseryAddress) {
		this.nurseryAddress = nurseryAddress;
	}

	/**
	 * @return the nursery_incharge
	 */
	public Long getNurseryIncharge() {
		return nurseryIncharge;
	}

	/**
	 * @param nursery_incharge the nursery_incharge to set
	 */
	public void setNurseryIncharge(Long nurseryIncharge) {
		this.nurseryIncharge = nurseryIncharge;
	}

	/**
	 * @return the status
	 */
	public Long getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(Long status) {
		this.status = status;
	}

	/**
	 * @return the created_by
	 */
	public Long getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param created_by the created_by to set
	 */
	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * @return the modifiedBy
	 */
	public Long getModifiedBy() {
		return modifiedBy;
	}

	/**
	 * @param modifiedBy the modifiedBy to set
	 */
	public void setModifiedBy(Long modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	/**
	 * @return the createdAt
	 */
	public LocalDate getCreatedAt() {
		return createdAt;
	}

	/**
	 * @param createdAt the createdAt to set
	 */
	public void setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
	}

	/**
	 * @return the updatedAt
	 */
	public LocalDate getUpdatedAt() {
		return updatedAt;
	}

	/**
	 * @param updatedAt the updatedAt to set
	 */
	public void setUpdatedAt(LocalDate updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Nursery() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Nursery(Long sectorId, String nurseryName, String nurseryAddress, 
		Long nurseryIncharge, Long status, Long createdBy, Long modifiedBy, 
		LocalDate createdAt, LocalDate updatedAt
	) {
		super();
		this.sectorId = sectorId;
		this.nurseryName = nurseryName;
		this.nurseryAddress = nurseryAddress;
		this.nurseryIncharge = nurseryIncharge;
		this.status = status;
		this.createdBy = createdBy;
		this.modifiedBy = modifiedBy;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		return "Nursery [sectorId=" + sectorId + ", nurseryName=" + nurseryName 
			+ ", nurseryAddress=" + nurseryAddress + ", nurseryIncharge=" + nurseryIncharge 
			+ ", status=" + status + ", createdBy=" + createdBy + ", modifiedBy=" + modifiedBy 
			+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt 
			+ "]";
	}
	
	
	
}
