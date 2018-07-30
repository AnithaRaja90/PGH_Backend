/**
 * StockDetailsController - API implements CRUD actions for stock details
 *
 * @category  Class
 * @package   StockDetailsController
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
import com.niche.model.StockDetails;
import com.niche.repository.StockDetailsRepository;

/**
 * API implements CRUD actions for Stock details
 * @author AnithaRaja Created at  July 21 2018
 */
@RestController
@RequestMapping("/api/stock-details")
public class StockDetailsController {
	@Autowired
	private StockDetailsRepository repository;
	
	/**
     * Load all the Stock details from table using Interface (StockDetailsRepository)
     * @return Array of Stock details
     */
    @GetMapping("/list")
    public List<StockDetails> getAllStockDetails() {
        return repository.findAll();
    }
    
    /**
     * Add a new Stock details to a table using Interface (StockRepository)
     * @param object Object with entity
     * @return Object of Stock details
     */
    @PostMapping("/add-stock-details")
    public StockDetails CreateStockDetails(@Valid @RequestBody StockDetails object) {
        return repository.save(object);
    }
    
    /**
     * Get the particular Stock details using id
     * @param id auto increment id of Stock table
     * @return object
     */
    @GetMapping("/view/{id}")
    public StockDetails getStockDetailById(@PathVariable(value = "id") Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("StockDetails", "id", id));
    }
    
    /**
     * Load the particular Stock details using id and update the value
     * @param id auto increment id of Stock table
     * @param object Object of entity values
     * @return Object of Stock details
     */
    @PutMapping("/update/{id}")
    public StockDetails updateStockDetails(@PathVariable(value = "id") Long id,
                                           @Valid @RequestBody StockDetails object) {

    	StockDetails value = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("StockDetails", "id", id));

    	value.setStockId(object.getStockId());
    	value.setBatchId(object.getBatchId());
    	value.setAddedDate(object.getAddedDate());
    	value.setNoOfQuantity(object.getNoOfQuantity());
    	value.setStatus(object.getStatus());
    	
    	StockDetails updatedDetails = repository.save(value);
        return updatedDetails;
    }
    
    /**
     * Delete a particular Stock details from a table
     * @param id auto increment id of Stock table
     * @return boolean value true or false
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteStockDetails(@PathVariable(value = "id") Long id) {
    	StockDetails value = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("StockDetails", "id", id));

    	repository.delete(value);

        return ResponseEntity.ok().build();
    }
}