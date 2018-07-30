/**
 * PickListValueController - API implements CRUD actions for Pick List details
 *
 * @category  Class
 * @package   PickListController
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
import com.niche.model.PickListValue;
import com.niche.repository.PickListValueRepository;

/**
 * API implements CRUD actions for pick list value details
 * @author AnithaRaja Created at  July 21 2018
 */
@RestController
@RequestMapping("/api/pick-list-value")
public class PickListValueContoller {
	@Autowired
	private PickListValueRepository pickListValueRepository;
	// private int statusParent = 1;
	// private int statusChild = 2;
	
	/**
     * Load all the pickList details from table using Interface (PickListRepository)
     * 
     * @return Array of pickListValue details
     */
    @GetMapping("/list")
    public List<PickListValue> getAllPickListValue() {
        return pickListValueRepository.findAll();
    }
    
    /**
     * Add a new pickListValue details to a table using Interface (PickListValueRepository)
     * 
     * @param pickListValue Object with entity
     * @return Object of pickListValue details
     */
    @PostMapping("/add-pick-list")
    public PickListValue createPickListValue(@Valid @RequestBody PickListValue pickListValue) {
        return pickListValueRepository.save(pickListValue);
    }
    
    /**
     * Get the particular pick list details using id
     * 
     * @param id auto increment id of pick list table
     * @return object
     */
    @GetMapping("/view/{id}")
    public PickListValue getPickListValueById(@PathVariable(value = "id") Long id) {
        return pickListValueRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("PickListValue", "id", id));
    }
    
    /**
     * Load the particular pick list details using id and update the value
     * 
     * @param id auto increment id of role table
     * @param pickListDetails Object of entity values
     * @return Object of pickList details
     */
    @PutMapping("/update/{id}")
    public PickListValue updatePickList(@PathVariable(value = "id") Long id,
                                           @Valid @RequestBody PickListValue pickListDetails) {

    	PickListValue pickListValue = pickListValueRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("PickListValue", "id", id));

    	pickListValue.setPickListValue(pickListDetails.getPickListValue());
    	pickListValue.setPickListId(pickListDetails.getPickListId());
    	pickListValue.setSelfId(pickListDetails.getSelfId());

    	PickListValue updatedDetails = pickListValueRepository.save(pickListValue);
        return updatedDetails;
    }
    
    /**
     * Delete a particular pickListValue details from a table
     * 
     * @param id auto increment id of pickListValue table
     * @return boolean value true or false
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePickListValue(@PathVariable(value = "id") Long id) {
    	PickListValue pickListValue = pickListValueRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("PickListValue", "id", id));

    	pickListValueRepository.delete(pickListValue);

        return ResponseEntity.ok().build();
    }
    
    /**
     * Load particular pick list value details from table using Interface (PickListRepository)
     * 
     * @return Array of pickListValue details
     */
    @GetMapping("/list-parent/{id}")
    public List<PickListValue> getAllPickListParent(@PathVariable(value = "id") Long id) {
        return pickListValueRepository.findByPickListId(id);
    }
    
    /**
     * Load particular pick list value details from table using Interface (PickListRepository)
     * 
     * @return Array of pickListValue details
     */
    @GetMapping("/list-child/{id}")
    public List<PickListValue> getAllPickListChild(@PathVariable(value = "id") Long id) {
        return pickListValueRepository.findBySelfId(id);
    }
}