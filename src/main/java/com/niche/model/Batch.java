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

@Entity
public class Batch {
	@Id
	@GeneratedValue
	private Long id;
	
	@Column (name = "nursery_id")
	private Long nurseryId;
	
	@Column (name = "batch_no")
	private String batchNo;
	
	@Column (name = "batch_name")
	private String batchName;
	
	@Column (name = "variety_id")
	private Long varietyId;
	
	@Column (name = "category_id")
	private Long categoryId;
	
	private Long quantity;

	@Column (name = "mother_bed")
	private Long motherBed;
	
	@Column (name = "sowing_date")
	private LocalDate sowingDate;
	
	@Column (name = "closed_date")
	private LocalDate closedDate;
	
	@Column (name = "showing_type")
	private Long showingType;

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
	 * @return the nurseryId
	 */
	public Long getNurseryId() {
		return nurseryId;
	}

	/**
	 * @param nurseryId the nurseryId to set
	 */
	public void setNurseryId(Long nurseryId) {
		this.nurseryId = nurseryId;
	}

	/**
	 * @return the batchNo
	 */
	public String getBatchNo() {
		return batchNo;
	}

	/**
	 * @param batchNo the batchNo to set
	 */
	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}

	/**
	 * @return the batchName
	 */
	public String getBatchName() {
		return batchName;
	}

	/**
	 * @param batchName the batchName to set
	 */
	public void setBatchName(String batchName) {
		this.batchName = batchName;
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
	 * @return the quantity
	 */
	public Long getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the motherBed
	 */
	public Long getMotherBed() {
		return motherBed;
	}

	/**
	 * @param motherBed the motherBed to set
	 */
	public void setMotherBed(Long motherBed) {
		this.motherBed = motherBed;
	}

	/**
	 * @return the sownDate
	 */
	public LocalDate getSowingDate() {
		return sowingDate;
	}

	/**
	 * @param sowningDate the sownDate to set
	 */
	public void setSowingDate(LocalDate sowingDate) {
		this.sowingDate = sowingDate;
	}

	/**
	 * @return the closedDate
	 */
	public LocalDate getClosedDate() {
		return closedDate;
	}

	/**
	 * @param closedDate the closedDate to set
	 */
	public void setClosedDate(LocalDate closedDate) {
		this.closedDate = closedDate;
	}
	
	/**
	 * @return the showingType
	 */
	public Long getShowingType() {
		return showingType;
	}

	/**
	 * @param showingType the showingType to set
	 */
	public void setShowingType(Long showingType) {
		this.showingType = showingType;
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

	// To set the one to many relation Table - Nursery
	// @OneToMany(cascade = CascadeType.ALL)
	// Here name is roles table 
	// referencedColumnName user table
	// @JoinColumn(name = "id", referencedColumnName = "nurseryId")
	// private List<Nursery> nursery;
	
	// To set the one to many relation Table - Nursery
	// @OneToMany(cascade = CascadeType.ALL)
	// Here name is roles table 
	// referencedColumnName user table
	// @JoinColumn(name = "id", referencedColumnName = "batchId")
	// private List<StockDetails> stockDetails;

	// Relation for shade area Table - Many to many
	// @ManyToMany(cascade = CascadeType.ALL)
	// private List<ShadeArea> shadeArea;
	
	// Relation for seasoning area Table - Many to many
	// @ManyToMany(cascade = CascadeType.ALL)
	//private List<SeasoningArea> seasoningArea;
	
	// Relation for Damage Table - Many to many
	// @ManyToMany(cascade = CascadeType.ALL)
	// private List<Damage> damage;
		
	public Batch() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Batch(Long nurseryId, String batchNo, String batchName, Long varietyId, 
		Long categoryId, Long quantity, Long motherBed, LocalDate sowingDate, 
		LocalDate closedDate, Long showingType, Long status, Long createdBy, Long modifiedBy,
		LocalDate createdAt, LocalDate updatedAt
	) {
		super();
		this.nurseryId = nurseryId;
		this.batchNo = batchNo;
		this.batchName = batchName;
		this.varietyId = varietyId;
		this.categoryId = categoryId;
		this.quantity = quantity;
		this.motherBed = motherBed;
		this.sowingDate = sowingDate;
		this.closedDate = closedDate;
		this.showingType = showingType;
		this.status = status;
		this.createdBy = createdBy;
		this.modifiedBy = modifiedBy;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		return "batch [nurseryId=" + nurseryId + ", batchNo=" + batchNo 
				+ ", batchName=" + batchName + ", varietyId=" + varietyId 
				+ ", categoryId=" + categoryId + ", quantity=" + quantity + ", motherBed=" + motherBed 
				+ ", sowingDate=" + sowingDate + ", closedDate=" + closedDate 
				+ ", showingType =" + showingType + ", status=" + status
				+ ", createdBy=" + createdBy + ", modifiedBy=" + modifiedBy + ", createdAt=" + createdAt
				+ ", updatedAt=" + updatedAt + "]";
	}
}
