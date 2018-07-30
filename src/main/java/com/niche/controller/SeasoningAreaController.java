/**
 * SeasoningAreaController - API implements CRUD actions for 
 * Seasoning Area details
 *
 * @category  Class
 * @package   SeasoningAreaController
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
import com.niche.model.SeasoningArea;
import com.niche.repository.SeasoningAreaRepository;

/**
 * API implements CRUD actions for SeasoningArea details
 * @author AnithaRaja Created at  July 21 2018
 */
@RestController
@RequestMapping("/api/seasoning-area")
public class SeasoningAreaController {
	@Autowired
	private SeasoningAreaRepository seasoningAreaRepository;
	
	/**
     * Load all the seasoning area details from table using Interface (SeasoningAreaRepository)
     * @return Array of SeasoningArea details
     */
    @GetMapping("/list")
    public List<SeasoningArea> getAllSeasoningAreaDetails() {
        return seasoningAreaRepository.findAll();
    }
    
    /**
     * Add a new seasoningArea details to a table using Interface (SeasoningAreaRepository)
     * @param object Object with entity
     * @return Object of seasoningArea details
     */
    @PostMapping("/add-seasoning-area")
    public SeasoningArea createSeasoningArea(@Valid @RequestBody SeasoningArea object) {
        return seasoningAreaRepository.save(object);
    }
    
    /**
     * Get the particular seasoningArea details using id
     * @param id auto increment id of seasoningArea table
     * @return object
     */
    @GetMapping("/view/{id}")
    public SeasoningArea getSaplingById(@PathVariable(value = "id") Long id) {
        return seasoningAreaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("SeasoningArea", "id", id));
    }
    
    /**
     * Load the particular seasoning area details using id and update the value
     * @param id auto increment id of seasoning area table
     * @param object Object of entity values
     * @return Object of seasoning area details
     */
    @PutMapping("/update/{id}")
    public SeasoningArea updateSeasoningArea(@PathVariable(value = "id") Long id,
                                           @Valid @RequestBody SeasoningArea object) {

    	SeasoningArea value = seasoningAreaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("SeasoningArea", "id", id));

    	value.setBatchId(object.getBatchId());
    	value.setNoOfSaplings(object.getNoOfSaplings());
    	value.setDate(object.getDate());
    	
    	SeasoningArea updatedDetails = seasoningAreaRepository.save(value);
        return updatedDetails;
    }
    
    /**
     * Delete a particular seasoning area details from a table
     * @param id auto increment id of seasoning area table
     * @return boolean value true or false
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteSeasoningArea(@PathVariable(value = "id") Long id) {
    	SeasoningArea value = seasoningAreaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("SeasoningArea", "id", id));

    	seasoningAreaRepository.delete(value);

        return ResponseEntity.ok().build();
    }
}