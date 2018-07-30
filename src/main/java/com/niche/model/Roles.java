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
public class Roles {
	@Id
	@GeneratedValue
	private Long id;
	
	@Column (name = "role_name")
	private String roleName;
	
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
	// @ManyToMany(cascade = CascadeType.ALL)
	// Here name is roles table 
	// referencedColumnName user table
	// @JoinColumn(name = "id", referencedColumnName = "role_id")
	// private List<User> users;
	
	// To set the one to many relation
	// @OneToMany(cascade = CascadeType.ALL)
	// Here name is roles table 
	// referencedColumnName user table
	// @JoinColumn(name = "id", referencedColumnName = "role_id")
	// private List<User> users;
	
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
	 * @return the roleName
	 */
	public String getRoleName() {
		return roleName;
	}
	
	/**
	 * @param roleName the roleName to set
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Roles(String roleName) {
		super();
		this.roleName = roleName;
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

	public Roles() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Roles(String roleName, Long status, Long createdBy, Long modifiedBy, 
		LocalDate createdAt, LocalDate updatedAt) {
		super();
		this.roleName = roleName;
		this.status = status;
		this.createdBy = createdBy;
		this.modifiedBy = modifiedBy;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		return "Roles [roleName=" + roleName + ", status=" + status 
			+ ", createdBy=" + createdBy + ", modifiedBy=" + modifiedBy 
			+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt 
			+ "]";
	}
}
