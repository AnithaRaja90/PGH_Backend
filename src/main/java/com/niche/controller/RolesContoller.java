/**
 * RolesController - API implements CRUD actions for Roles details
 *
 * @category  Class
 * @package   RolesController
 * @author    Nichehands <nichehands@nichehands.com>
 * @copyright 2013 Nichehands Technologies Pvt Ltd.
 * @license   http://www.nichehandstechnologies.com / Private License
 * @link      http://www.nichehandstechnologies.com.
 */
package com.niche.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.niche.exception.ResourceNotFoundException;
import com.niche.model.Roles;
import com.niche.repository.RolesRepository;

/**
 * API implements CRUD actions for roles details
 * @author AnithaRaja Created at  July 21 2018
 */
@RestController
@RequestMapping("/api/role")
public class RolesContoller {
	@Autowired
	private RolesRepository roleRepository;
	
	/**
     * Load all the role details from table using Interface (RoleRepository)
     * @return Array of role details
     */
    @GetMapping("/list")
    public List<Roles> getAllRoles() {
        return roleRepository.findAll();
    }
    
    /**
     * Add a new role details to a table using Interface (RolesRepository)
     * @param role Object with entity
     * @return Object of role details
     */
    @PostMapping("/add-role")
    public Roles createRoles(@Valid @RequestBody Roles role) {
        return roleRepository.save(role);
    }
    
    /**
     * Get the particular role details using id
     * @param role id auto increment id of roles table
     * @return object
     */
    @GetMapping("/view/{id}")
    public Roles getRoleById(@PathVariable(value = "id") Long roleId) {
        return roleRepository.findById(roleId)
                .orElseThrow(() -> new ResourceNotFoundException("Roles", "id", roleId));
    }
    
    /**
     * Load the particular role details using id and update the value
     * @param roleId auto increment id of role table
     * @param roleDetails Object of entity values
     * @return Object of role details
     */
    @PutMapping("/update/{id}")
    public Roles updateRole(@PathVariable(value = "id") Long roleId,
                                           @Valid @RequestBody Roles roleDetails) {

    	Roles role = roleRepository.findById(roleId)
                .orElseThrow(() -> new ResourceNotFoundException("Roles", "id", roleId));

    	role.setRoleName(roleDetails.getRoleName());

    	Roles updatedRoleDetails = roleRepository.save(role);
        return updatedRoleDetails;
    }
    
    /**
     * Delete a particular role details from a table
     * @param roleId auto increment id of role table
     * @return boolean value true or false
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteRole(@PathVariable(value = "id") Long roleId) {
    	Roles role = roleRepository.findById(roleId)
                .orElseThrow(() -> new ResourceNotFoundException("Roles", "id", roleId));

    	roleRepository.delete(role);

        return ResponseEntity.ok().build();
    }
}
