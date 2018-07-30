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

// import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
// import javax.persistence.JoinColumn;
/// import javax.persistence.OneToMany;

import java.time.LocalDate;
// import java.util.List;

/**
 * Zonal for entity creation.
 * @author ilaiyarajat
 *
 */
@Entity
public class Zonal {
	@Id
	@GeneratedValue
	private Long id;
	
	@Column (name = "zone_name")
	private String zoneName;
	
	@Column (name = "zone_address")
	private String zoneAddress;
	
	@Column (name = "zone_incharge")
	private Long zoneIncharge;
	
	private Long status;
	
	@Column (name = "created_by")
	private Long createdBy;
	
	@Column (name = "modified_by")
	private Long modifiedBy;
	
	@Column (name = "created_at")
	private LocalDate createdAt;
	
	@Column (name = "updated_at")
	private LocalDate updatedAt;

	// To set the one to many relation
	// @ManyToMany(cascade = CascadeType.ALL)
	// Here name is zonal table 
	// referencedColumnName sector table
	// @JoinColumn(name = "id", referencedColumnName = "zone_id")
	// private List<Sector> sector;
	
	/**
	 * To get the Id
	 *  
	 * @return id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * To set the Id
	 * 
	 * @param id Id
	 * 
	 * @return id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * To get the zonal name
	 * 
	 * @return zoneName
	 */
	public String getZoneName() {
		return zoneName;
	}

	/**
	 * To set the
	 * 
	 * @param zoneName
	 * 
	 * @return zoneName
	 */
	public void setZoneName(String zoneName) {
		this.zoneName = zoneName;
	}

	/**
	 * To get the zonal address
	 * 
	 * @return zoneAddress
	 */
	public String getZoneAddress() {
		return zoneAddress;
	}

	/**
	 * @param zoneAddress the zoneAddress to set
	 */
	public void setZoneAddress(String zoneAddress) {
		this.zoneAddress = zoneAddress;
	}

	/**
	 * To get the Zonal Incharger
	 * 
	 * @return zoneIncharge
	 */
	public Long getZoneIncharge() {
		return zoneIncharge;
	}

	/**
	 * @param zoneIncharge the zoneIncharge to set
	 */
	public void setZoneIncharge(Long zoneIncharge) {
		this.zoneIncharge = zoneIncharge;
	}

	/**
	 * To get the status
	 * 
	 * @return status
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
	 * To get the createdBy - user
	 * 
	 * @return createdBy
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
	 * To get the modifiedBy - user
	 * 
	 * @return modifiedBy
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
	 * To get the createdAt as Date
	 * 
	 * @return createdAt
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

	/**
	 * to created the constructor with fields
	 * @param zoneName
	 * @param zoneAddress
	 * @param zoneIncharge
	 * @param status
	 * @param createdBy
	 * @param modifiedBy
	 * @param createdAt
	 * @param updatedAt
	 */
	public Zonal(String zoneName, String zoneAddress, Long zoneIncharge, Long status,
		Long createdBy, Long modifiedBy, LocalDate createdAt, LocalDate updatedAt) {
		super();
		this.zoneName = zoneName;
		this.zoneAddress = zoneAddress;
		this.zoneIncharge = zoneIncharge;
		this.status = status;
		this.createdBy = createdBy;
		this.modifiedBy = modifiedBy;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	/**
	 * To create the empty constructor
	 */
	public Zonal() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Zonal [zoneName=" + zoneName + ", zoneAddress=" + zoneAddress 
				+ ", zoneIncharge=" + zoneIncharge + ", status=" + status 
				+ ", createdBy=" + createdBy + ", modifiedBy=" + modifiedBy 
				+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}
}
