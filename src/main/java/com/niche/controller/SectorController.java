/**
 * SectorController - API implements CRUD actions for Sector details
 *
 * @category  Class
 * @package   SectorController
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
import com.niche.model.Sector;
import com.niche.repository.SectorRepository;

/**
 * API implements CRUD actions for Sector details
 * @author AnithaRaja Created at  July 21 2018
 */
@RestController
@RequestMapping("/api/sector")
public class SectorController {

	@Autowired
	private SectorRepository sectorRepository;
	
	/**
     * Load all the sector details from table using Interface (SectorRepository)
     * @return Array of sector details
     */
    @GetMapping("/list")
    public List<Sector> getAllSectorDetails() {
        return sectorRepository.findAll();
    }
    
    /**
     * Add a new sector details to a table using Interface (SectorRepository)
     * @param sector Object with entity
     * @return Object of sector details
     */
    @PostMapping("/add-sector")
    public Sector createSector(@Valid @RequestBody Sector sector) {
        return sectorRepository.save(sector);
    }
    
    /**
     * Get the particular sector details using id
     * @param sector id auto increment id of sector table
     * @return object
     */
    @GetMapping("/view/{id}")
    public Sector getSectorById(@PathVariable(value = "id") Long sectorId) {
        return sectorRepository.findById(sectorId)
                .orElseThrow(() -> new ResourceNotFoundException("Sector", "id", sectorId));
    }
    
    /**
     * Load the particular sector details using id and update the value
     * @param sectorId auto increment id of sector table
     * @param sectorDetails Object of entity values
     * @return Object of sector details
     */
    @PutMapping("/update/{id}")
    public Sector updateSector(@PathVariable(value = "id") Long sectorId,
                                           @Valid @RequestBody Sector sectorDetails) {

    	Sector sector = sectorRepository.findById(sectorId)
                .orElseThrow(() -> new ResourceNotFoundException("Sector", "id", sectorId));

    	sector.setSectorName(sectorDetails.getSectorName());
    	sector.setSectorAddress(sectorDetails.getSectorAddress());
    	sector.setZoneId(sectorDetails.getZoneId());

        Sector updatedsectorDetails = sectorRepository.save(sector);
        return updatedsectorDetails;
    }
    
    /**
     * Delete a particular sector details from a table
     * @param sectorId auto increment id of sector table
     * @return boolean value true or false
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteSector(@PathVariable(value = "id") Long sectorId) {
    	Sector sector = sectorRepository.findById(sectorId)
                .orElseThrow(() -> new ResourceNotFoundException("Sector", "id", sectorId));

    	sectorRepository.delete(sector);

        return ResponseEntity.ok().build();
    }
    
    /**
     * Load particular zone sector list value details from table using Interface (SectorRepository)
     * 
     * @return Array of sector details
     */
    @GetMapping("/get-zone-sectors/{id}")
    public List<Sector> getParticularZoneSectors(@PathVariable(value = "id") Long id) {
        return sectorRepository.findByZoneId(id);
    }
}
