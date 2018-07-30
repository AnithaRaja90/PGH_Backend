/**
 * NurseryController - API implements CRUD actions for Nursery details
 *
 * @category  Class
 * @package   NurseryController
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
import com.niche.model.Nursery;
import com.niche.repository.NurseryRepository;

/**
 * API implements CRUD actions for Nursery details
 * @author AnithaRaja Created at  July 21 2018
 */
@RestController
@RequestMapping("/api/nursery")
public class NurseryController {
	@Autowired
	private NurseryRepository nurseryRepository;
	
	/**
     * Load all the nursery details from table using Interface (NurseryRepository)
     * @return Array of nursery details
     */
    @GetMapping("/list")
    public List<Nursery> getAllNurseryDetails() {
        return nurseryRepository.findAll();
    }
    
    /**
     * Add a new nursery details to a table using Interface (NurseryRepository)
     * @param nursery Object with entity
     * @return Object of nursery details
     */
    @PostMapping("/add-nursery")
    public Nursery createNursery(@Valid @RequestBody Nursery nursery) {
        return nurseryRepository.save(nursery);
    }
    
    /**
     * Get the particular nursery details using id
     * @param nursery id auto increment id of nursery table
     * @return object
     */
    @GetMapping("/view/{id}")
    public Nursery getNurseryById(@PathVariable(value = "id") Long nurseryId) {
        return nurseryRepository.findById(nurseryId)
                .orElseThrow(() -> new ResourceNotFoundException("Nursery", "id", nurseryId));
    }
    
    /**
     * Load the particular nursery details using id and update the value
     * @param nurseryId auto increment id of nursery table
     * @param nurseryDetails Object of entity values
     * @return Object of nursery details
     */
    @PutMapping("/update/{id}")
    public Nursery updateNursery(@PathVariable(value = "id") Long nurseryId,
                                           @Valid @RequestBody Nursery nurseryDetails) {

    	Nursery nursery = nurseryRepository.findById(nurseryId)
                .orElseThrow(() -> new ResourceNotFoundException("Nursery", "id", nurseryId));

    	nursery.setNurseryName(nurseryDetails.getNurseryName());
    	nursery.setNurseryAddress(nurseryDetails.getNurseryAddress());
    	nursery.setSectorId(nurseryDetails.getSectorId());

        Nursery updatedNurseryDetails = nurseryRepository.save(nursery);
        return updatedNurseryDetails;
    }
    
    /**
     * Delete a particular nursery details from a table
     * @param nurseryId auto increment id of nursery table
     * @return boolean value true or false
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteNursery(@PathVariable(value = "id") Long nurseryId) {
    	Nursery nursery = nurseryRepository.findById(nurseryId)
                .orElseThrow(() -> new ResourceNotFoundException("Nursery", "id", nurseryId));

    	nurseryRepository.delete(nursery);

        return ResponseEntity.ok().build();
    }
    
    /**
     * Load particular sector nursery list value details from table using Interface (NurseryRepository)
     * 
     * @return Array of nursery details
     */
    @GetMapping("/get-sector-nurserys/{id}")
    public List<Nursery> getParticularSectorNurserys(@PathVariable(value = "id") Long id) {
        return nurseryRepository.findBySectorId(id);
    }
}
