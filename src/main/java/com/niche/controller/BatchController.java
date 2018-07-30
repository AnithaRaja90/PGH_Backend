/**
 * BatchController - API implements CRUD actions for Batch details
 *
 * @category  Class
 * @package   BatchController
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
import com.niche.model.Batch;
import com.niche.repository.BatchRepository;

/**
 * API implements CRUD actions for Batch details
 * @author AnithaRaja Created at  July 21 2018
 */
@RestController
@RequestMapping("/api/batch")
public class BatchController {
	@Autowired
	private BatchRepository batchRepository;
	
	/**
     * Load all the batch details from table using Interface (BatchRepository)
     * @return Array of role details
     */
    @GetMapping("/list")
    public List<Batch> getAllBatch() {
        return batchRepository.findAll();
    }
    
    /**
     * Add a new batch details to a table using Interface (BatchRepository)
     * @param batch Object with entity
     * @return Object of batch details
     */
    @PostMapping("/add-batch")
    public Batch createBatch(@Valid @RequestBody Batch batch) {
        return batchRepository.save(batch);
    }
    
    /**
     * Get the particular batch details using id
     * @param id auto increment id of batch table
     * @return object
     */
    @GetMapping("/view/{id}")
    public Batch getBatchById(@PathVariable(value = "id") Long id) {
        return batchRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Batch", "id", id));
    }
    
    /**
     * Load the particular batch details using id and update the value
     * @param id auto increment id of batch table
     * @param batchDetails Object of entity values
     * @return Object of batch details
     */
    @PutMapping("/update/{id}")
    public Batch updateBatch(@PathVariable(value = "id") Long id,
                                           @Valid @RequestBody Batch batchDetails) {

    	Batch batch = batchRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Batch", "id", id));

    	batch.setNurseryId(batchDetails.getNurseryId());
    	batch.setBatchNo(batchDetails.getBatchNo());
    	batch.setBatchName(batchDetails.getBatchName());
    	batch.setVarietyId(batchDetails.getVarietyId());
    	batch.setCategoryId(batchDetails.getCategoryId());
    	batch.setQuantity(batchDetails.getQuantity());
    	batch.setMotherBed(batchDetails.getMotherBed());
    	batch.setSowingDate(batchDetails.getSowingDate());
    	batch.setClosedDate(batchDetails.getClosedDate());
    	batch.setShowingType(batchDetails.getShowingType());
    	batch.setStatus(batchDetails.getStatus());
    	
    	Batch updatedBatchDetails = batchRepository.save(batch);
        return updatedBatchDetails;
    }
    
    /**
     * Delete a particular batch details from a table
     * @param id auto increment id of batch table
     * @return boolean value true or false
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteBatch(@PathVariable(value = "id") Long id) {
    	Batch batch = batchRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Batch", "id", id));

    	batchRepository.delete(batch);

        return ResponseEntity.ok().build();
    }
}