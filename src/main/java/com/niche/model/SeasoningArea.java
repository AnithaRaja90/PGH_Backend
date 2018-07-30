package com.niche.model;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class SeasoningArea {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name ="batch_id")
	private Long batchId;
	
	@Column(name ="no_of_saplings")
	private Long noOfSaplings;
	
	@Column(name ="date")
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getBatchId() {
		return batchId;
	}

	public void setBatchId(Long batchId) {
		this.batchId = batchId;
	}

	public Long getNoOfSaplings() {
		return noOfSaplings;
	}

	public void setNoOfSaplings(Long noOfSaplings) {
		this.noOfSaplings = noOfSaplings;
	}

	public LocalDate getDate() {
		return date;
	}

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

	public SeasoningArea() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SeasoningArea(Long batchId, Long noOfSaplings, LocalDate date, Long status, 
			Long createdBy, Long modifiedBy, LocalDate createdAt, LocalDate updatedAt
	) {
		super();
		this.batchId = batchId;
		this.noOfSaplings = noOfSaplings;
		this.date = date;
		this.status = status;
		this.createdBy = createdBy;
		this.modifiedBy = modifiedBy;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		return "SeasoningArea [batchId=" + batchId + ", noOfSaplings=" + noOfSaplings 
			+ ", date=" + date + ", status=" + status + ", createdBy=" + createdBy 
			+ ", modifiedBy=" + modifiedBy + ", createdAt=" + createdAt
			+ ", updatedAt=" + updatedAt + "]";
	}
}


