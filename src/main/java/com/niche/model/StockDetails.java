package com.niche.model;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class StockDetails {
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name ="stock_id")
	private Long stockId;
	
	@Column(name ="batch_id")
	private Long batchId;
	
	@Column(name ="added_date")
	private LocalDate addedDate;
	
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getStockId() {
		return stockId;
	}

	public void setStockId(Long stockId) {
		this.stockId = stockId;
	}

	public Long getBatchId() {
		return batchId;
	}

	public void setBatchId(Long batchId) {
		this.batchId = batchId;
	}

	public LocalDate getAddedDate() {
		return addedDate;
	}

	public void setAddedDate(LocalDate addedDate) {
		this.addedDate = addedDate;
	}

	public Long getNoOfQuantity() {
		return noOfQuantity;
	}

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
	
	public StockDetails() {
		super();
	}

	public StockDetails(Long stockId, Long batchId, LocalDate addedDate, 
		Long noOfQuantity, Long status, Long createdBy,
		Long modifiedBy, LocalDate createdAt, LocalDate updatedAt
	) {
		super();
		this.stockId = stockId;
		this.batchId = batchId;
		this.addedDate = addedDate;
		this.noOfQuantity = noOfQuantity;
		this.status = status;
		this.createdBy = createdBy;
		this.modifiedBy = modifiedBy;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		return "StockDetails [stockId=" + stockId + ", batchId=" + batchId 
			+ ", addedDate=" + addedDate + ", noOfQuantity=" + noOfQuantity 
			+ ", status=" + status + ", createdBy=" + createdBy + ", modifiedBy="
			+ modifiedBy + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}

	
	

}
