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
public class ShadeArea {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column (name = "batch_id")
	private Long batchId;
	
	@Column (name = "no_of_seedlings")
	private Long noOfSeedlings;
	
	private LocalDate date;

	private Long status;
	
	@Column(name ="created_by")
	private Long createdBy;
	
	@Column(name ="modified_by")
	private Long modifiedBy;
	
	@Column(name ="created_at")
	private LocalDate createdAt;
	
	@Column(name ="updated_at")
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
	 * @return the batchId
	 */
	public Long getBatchId() {
		return batchId;
	}

	/**
	 * @param batchId the batchId to set
	 */
	public void setBatchId(Long batchId) {
		this.batchId = batchId;
	}

	/**
	 * @return the noOfSeedlings
	 */
	public Long getNoOfSeedlings() {
		return noOfSeedlings;
	}

	/**
	 * @param noOfSeedlings the noOfSeedlings to set
	 */
	public void setNoOfSeedlings(Long noOfSeedlings) {
		this.noOfSeedlings = noOfSeedlings;
	}

	/**
	 * @return the date
	 */
	public LocalDate getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(LocalDate date) {
		this.date = date;
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

	public ShadeArea() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ShadeArea(Long batchId, Long noOfSeedlings, LocalDate date, Long status, 
		Long createdBy, Long modifiedBy, LocalDate createdAt, LocalDate updatedAt
	) {
		super();
		this.batchId = batchId;
		this.noOfSeedlings = noOfSeedlings;
		this.date = date;
		this.status = status;
		this.createdBy = createdBy;
		this.modifiedBy = modifiedBy;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		return "ShadeArea [batchId=" + batchId + ", noOfSeedlings=" + noOfSeedlings 
			+ ", date=" + date + ", status=" + status + ", createdBy=" + createdBy 
			+ ", modifiedBy=" + modifiedBy + ", createdAt=" + createdAt
			+ ", updatedAt=" + updatedAt + "]";
	}	
}