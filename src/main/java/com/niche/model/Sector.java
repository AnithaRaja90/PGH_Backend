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
 * Sector for entity creation.
 * @author ilaiyarajat
 *
 */
@Entity
public class Sector {
	@Id
	@GeneratedValue
	private Long id;
	
	@Column (name = "zone_id")
	private Long zoneId;
	
	@Column (name = "sector_name")
	private String sectorName;
	
	@Column (name = "sector_address")
	private String sectorAddress;
	
	@Column (name = "sector_incharge")
	private Long sectorIncharge;
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
	 * @return the zoneId
	 */
	public Long getZoneId() {
		return zoneId;
	}

	/**
	 * @param zoneId the zoneId to set
	 */
	public void setZoneId(Long zoneId) {
		this.zoneId = zoneId;
	}

	/**
	 * @return the sectorName
	 */
	public String getSectorName() {
		return sectorName;
	}

	/**
	 * @param sectorName the sectorName to set
	 */
	public void setSectorName(String sectorName) {
		this.sectorName = sectorName;
	}

	/**
	 * @return the sectorAddress
	 */
	public String getSectorAddress() {
		return sectorAddress;
	}

	/**
	 * @param sectorAddress the sectorAddress to set
	 */
	public void setSectorAddress(String sectorAddress) {
		this.sectorAddress = sectorAddress;
	}

	/**
	 * @return the sectorIncharge
	 */
	public Long getSectorIncharge() {
		return sectorIncharge;
	}

	/**
	 * @param sectorIncharge the sectorIncharge to set
	 */
	public void setSectorIncharge(Long sectorIncharge) {
		this.sectorIncharge = sectorIncharge;
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
	 * @return the createdBy
	 */
	public Long getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBy the createdBy to set
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

	public Sector(Long zoneId, String sectorName, String sectorAddress, 
			Long sectorIncharge, Long status, Long createdBy, Long modifiedBy, 
			LocalDate createdAt, LocalDate updatedAt
	) {
		super();
		this.zoneId = zoneId;
		this.sectorName = sectorName;
		this.sectorAddress = sectorAddress;
		this.sectorIncharge = sectorIncharge;
		this.status = status;
		this.createdBy = createdBy;
		this.modifiedBy = modifiedBy;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public Sector() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Sector [id=" + id + ", zoneId=" + zoneId + ", sectorName=" 
				+ sectorName + ", sectorAddress=" + sectorAddress 
				+ ", sectorIncharge=" + sectorIncharge + ", status=" + status
				+ ", createdBy=" + createdBy + ", modifiedBy=" + modifiedBy 
				+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt
			+ "]";
	}
}
