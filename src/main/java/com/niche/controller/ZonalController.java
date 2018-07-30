/**
 * ZonalController - API implements CRUD actions for Zonal details
 * 
 * @category  Class
 * @package   ZonalController
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
import com.niche.model.Zonal;
import com.niche.repository.ZonalRepository;

/**
 * API implements CRUD actions for Zonal details
 * @author AnithaRaja Created at  July 21 2018
 */
@RestController
@RequestMapping("/api/zonal")
public class ZonalController {
	@Autowired
	private ZonalRepository zonalRepository;
	
	/**
     * Load all the zonal details from table using Interface (ZonalRepository)
     * @return Array of zonal details
     */
    @GetMapping("/list")
    public List<Zonal> getAllZonalDetails() {
        return zonalRepository.findAll();
    }
    
    /**
     * Add a new zonal details to a table using Interface (ZonalRepository)
     * @param zonal Object with entity
     * @return Object of zonal details
     */
    @PostMapping("/add-zonal")
    public Zonal createZonal(@Valid @RequestBody Zonal zonal) {
        return zonalRepository.save(zonal);
    }
    
    /**
     * Get the particular zonal details using id
     * @param zone id auto increment id of zonal table
     * @return object
     */
    @GetMapping("/view/{id}")
    public Zonal getZoneById(@PathVariable(value = "id") Long zoneId) {
        return zonalRepository.findById(zoneId)
                .orElseThrow(() -> new ResourceNotFoundException("Zonal", "id", zoneId));
    }
    
    /**
     * Load the particular zonal details using id and update the value
     * @param zoneId auto increment id of zonal table
     * @param zonalDetails Object of entity values
     * @return Object of zonal details
     */
    @PutMapping("/update/{id}")
    public Zonal updateZone(@PathVariable(value = "id") Long zoneId,
                                           @Valid @RequestBody Zonal zonalDetails) {

        Zonal zonal = zonalRepository.findById(zoneId)
                .orElseThrow(() -> new ResourceNotFoundException("Zonal", "id", zoneId));

        zonal.setZoneName(zonalDetails.getZoneName());
        zonal.setZoneAddress(zonalDetails.getZoneAddress());     

        Zonal updatedZonalDetails = zonalRepository.save(zonal);
        return updatedZonalDetails;
    }
    
    /**
     * Delete a particular zonal details from a table
     * @param zoneId auto increment id of zonal table
     * @return boolean value true or false
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteZone(@PathVariable(value = "id") Long zoneId) {
        Zonal zonal = zonalRepository.findById(zoneId)
                .orElseThrow(() -> new ResourceNotFoundException("Zonal", "id", zoneId));

        zonalRepository.delete(zonal);

        return ResponseEntity.ok().build();
    }
}
