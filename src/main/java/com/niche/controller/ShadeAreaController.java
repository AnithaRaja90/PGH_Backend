/**
 * ShadeAreaController - API implements CRUD actions for shade area details
 *
 * @category  Class
 * @package   ShadeAreaController
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
import com.niche.model.ShadeArea;
import com.niche.repository.ShadeAreaRepository;

/**
 * API implements CRUD actions for shade area details
 * @author AnithaRaja Created at  July 21 2018
 */
@RestController
@RequestMapping("/api/shade-area")
public class ShadeAreaController {
	@Autowired
	private ShadeAreaRepository repository;
	
	/**
     * Load all the shade area details from table using Interface (ShadeAreaRepository)
     * @return Array of shade area details
     */
    @GetMapping("/list")
    public List<ShadeArea> getAllShadeAreaDetails() {
        return repository.findAll();
    }
    
    /**
     * Add a new shade area details to a table using Interface (ShadeAreaRepository)
     * @param shadeArea Object with entity
     * @return Object of shade area details
     */
    @PostMapping("/move-to-shade-area")
    public ShadeArea MoveToShadeArea(@Valid @RequestBody ShadeArea shadeArea) {
        return repository.save(shadeArea);
    }
    
    /**
     * Get the particular shade area details using id
     * @param id auto increment id of shadeArea table
     * @return object
     */
    @GetMapping("/view/{id}")
    public ShadeArea getShadeAreaById(@PathVariable(value = "id") Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ShadeArea", "id", id));
    }
    
    /**
     * Load the particular shade area details using id and update the value
     * @param id auto increment id of shade area table
     * @param object Object of entity values
     * @return Object of shade area details
     */
    @PutMapping("/update/{id}")
    public ShadeArea updateShadeArea(@PathVariable(value = "id") Long id,
                                           @Valid @RequestBody ShadeArea object) {

    	ShadeArea value = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ShadeArea", "id", id));

    	value.setBatchId(object.getBatchId());
    	value.setNoOfSeedlings(object.getNoOfSeedlings());

    	ShadeArea updatedDetails = repository.save(value);
        return updatedDetails;
    }
    
    /**
     * Delete a particular shade area details from a table
     * @param id auto increment id of shade area table
     * @return boolean value true or false
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteShadaArea(@PathVariable(value = "id") Long id) {
    	ShadeArea value = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ShadeArea", "id", id));

    	repository.delete(value);

        return ResponseEntity.ok().build();
    }
}
