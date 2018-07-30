/**
 * PickListController - API implements CRUD actions for Pick List details
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
import com.niche.model.PickList;
import com.niche.repository.PickListRepository;

/**
 * API implements CRUD actions for pick list details
 * @author AnithaRaja Created at  July 21 2018
 */
@RestController
@RequestMapping("/api/pick-list")
public class PickListController {
	@Autowired
	private PickListRepository pickListRepository;
	
	/**
     * Load all the pickList details from table using Interface (PickListRepository)
     * 
     * @return Array of role details
     */
    @GetMapping("/list")
    public List<PickList> getAllPickList() {
        return pickListRepository.findAll();
    }
    
    /**
     * Add a new pickList details to a table using Interface (PickListRepository)
     * 
     * @param pickList Object with entity
     * @return Object of pickList details
     */
    @PostMapping("/add-pick-list")
    public PickList createPickList(@Valid @RequestBody PickList pickList) {
        return pickListRepository.save(pickList);
    }
    
    /**
     * Get the particular pick list details using id
     * 
     * @param id auto increment id of pick list table
     * @return object
     */
    @GetMapping("/view/{id}")
    public PickList getPickListById(@PathVariable(value = "id") Long id) {
        return pickListRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("PickList", "id", id));
    }
    
    /**
     * Load the particular pick list details using id and update the value
     * 
     * @param id auto increment id of role table
     * @param pickListDetails Object of entity values
     * @return Object of pickList details
     */
    @PutMapping("/update/{id}")
    public PickList updatePickList(@PathVariable(value = "id") Long id,
                                           @Valid @RequestBody PickList pickListDetails) {

    	PickList pickList = pickListRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("PickList", "id", id));

    	pickList.setPickListName(pickListDetails.getPickListName());

    	PickList updatedPickListDetails = pickListRepository.save(pickList);
        return updatedPickListDetails;
    }
    
    /**
     * Delete a particular pickList details from a table
     * 
     * @param id auto increment id of pickList table
     * @return boolean value true or false
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePickList(@PathVariable(value = "id") Long id) {
    	PickList pickList = pickListRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("PickList", "id", id));

    	pickListRepository.delete(pickList);

        return ResponseEntity.ok().build();
    }
}
