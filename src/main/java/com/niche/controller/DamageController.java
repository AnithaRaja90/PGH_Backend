/**
 * DamageController - API implements CRUD actions for damage details
 *
 * @category  
 * @package   
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
import com.niche.model.Damage;
import com.niche.repository.DamageRepository;

/**
 * API implements CRUD actions for damage details
 * @author AnithaRaja Created at  July 21 2018
 */
@RestController
@RequestMapping("/api/damage")
public class DamageController {
	@Autowired
	private DamageRepository repository;
	
	/**
     * Load all the damage details from table using Interface (DamageRepository)
     * @return Array of Damage details
     */
    @GetMapping("/list")
    public List<Damage> getAllDamageDetails() {
        return repository.findAll();
    }
    
    /**
     * Add a new damage details to a table using Interface (DamageRepository)
     * @param object Object with entity
     * @return Object of damage details
     */
    @PostMapping("/add-damage")
    public Damage createDamage(@Valid @RequestBody Damage object) {
        return repository.save(object);
    }
    
    /**
     * Get the particular damage details using id
     * @param id auto increment id of damage table
     * @return object
     */
    @GetMapping("/view/{id}")
    public Damage getSaplingById(@PathVariable(value = "id") Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Damage", "id", id));
    }
    
    /**
     * Load the particular damage details using id and update the value
     * @param id auto increment id of damage table
     * @param object Object of entity values
     * @return Object of damage details
     */
    @PutMapping("/update/{id}")
    public Damage updateDamege(@PathVariable(value = "id") Long id,
                                           @Valid @RequestBody Damage object) {

    	Damage value = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Damage", "id", id));

    	value.setBatchId(object.getBatchId());
    	value.setDescription(object.getDescription());
    	value.setNoOfQuantity(object.getNoOfQuantity());
    	value.setDate(object.getDate());
    	value.setStatus(object.getStatus());
    	
    	Damage updatedDetails = repository.save(value);
        return updatedDetails;
    }
    
    /**
     * Delete a particular damage details from a table
     * @param id auto increment id of damage table
     * @return boolean value true or false
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteDamage(@PathVariable(value = "id") Long id) {
    	Damage value = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Damage", "id", id));

    	repository.delete(value);

        return ResponseEntity.ok().build();
    }
}
