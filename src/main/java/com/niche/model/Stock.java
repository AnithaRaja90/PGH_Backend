package com.niche.model;

import java.time.LocalDate;
// import java.util.List;

// import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
// import javax.persistence.JoinColumn;
// import javax.persistence.OneToMany;

@Entity
public class Stock {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name ="variety_id")
	private Long varietyId;
	
	@Column(name ="category_id")
	private Long categoryId;
	
	@Column(name ="no_of_quantity")
	private Long noOfQuantity;
	
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
	// @OneToMany(cascade = CascadeType.ALL)
	// Here name is zonal table 
	// referencedColumnName sector table
	// @JoinColumn(name = "id", referencedColumnName = "stock_id")
	// private List<StockDetails> stockDetails;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the varietyId
	 */
	public Long getVarietyId() {
		return varietyId;
	}

	/**
	 * @param varietyId the varietyId to set
	 */
	public void setVarietyId(Long varietyId) {
		this.varietyId = varietyId;
	}

	/**
	 * @return the categoryId
	 */
	public Long getCategoryId() {
		return categoryId;
	}

	/**
	 * @param categoryId the categoryId to set
	 */
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	/**
	 * @return the noOfQuantity
	 */
	public Long getNoOfQuantity() {
		return noOfQuantity;
	}

	/**
	 * @param noOfQuantity the noOfQuantity to set
	 */
	public void setNoOfQuantity(Long noOfQuantity) {
		this.noOfQuantity = noOfQuantity;
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

	public Stock() {
		super();
	}

	public Stock(Long varietyId, Long categoryId, Long noOfQuantity, 
		Long status, Long createdBy, Long modifiedBy, LocalDate createdAt, LocalDate updatedAt
	) {
		super();
		this.varietyId = varietyId;
		this.categoryId = categoryId;
		this.noOfQuantity = noOfQuantity;
		this.status = status;
		this.createdBy = createdBy;
		this.modifiedBy = modifiedBy;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		return "Stock [varietyId=" + varietyId + ", categoryId=" + categoryId 
			+ ", noOfQuantity=" + noOfQuantity + ", status=" + status 
			+ ", createdBy=" + createdBy + ", modifiedBy=" + modifiedBy 
			+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}
}
