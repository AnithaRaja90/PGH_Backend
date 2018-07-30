/**
 * StockController - API implements CRUD actions for stock details
 *
 * @category  Class
 * @package   StockController
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
import com.niche.model.Stock;
import com.niche.repository.StockRepository;

/**
 * API implements CRUD actions for Stock details
 * @author AnithaRaja Created at  July 21 2018
 */
@RestController
@RequestMapping("/api/stock")
public class StockController {
	@Autowired
	private StockRepository repository;
	
	/**
     * Load all the Stock details from table using Interface (StockRepository)
     * @return Array of Stock details
     */
    @GetMapping("/list")
    public List<Stock> getAllStock() {
        return repository.findAll();
    }
    
    /**
     * Add a new Stock details to a table using Interface (StockRepository)
     * @param object Object with entity
     * @return Object of Stock details
     */
    @PostMapping("/add-stock")
    public Stock AddStock(@Valid @RequestBody Stock object) {
        return repository.save(object);
    }
    
    /**
     * Get the particular Stock details using id
     * @param id auto increment id of Stock table
     * @return object
     */
    @GetMapping("/view/{id}")
    public Stock getStockById(@PathVariable(value = "id") Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Stock", "id", id));
    }
    
    /**
     * Load the particular Stock details using id and update the value
     * @param id auto increment id of Stock table
     * @param object Object of entity values
     * @return Object of Stock details
     */
    @PutMapping("/update/{id}")
    public Stock updateStock(@PathVariable(value = "id") Long id,
                                           @Valid @RequestBody Stock object) {

    	Stock value = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Stock", "id", id));

    	value.setVarietyId(object.getVarietyId());
    	value.setCategoryId(object.getCategoryId());
    	value.setNoOfQuantity(object.getNoOfQuantity());
    	
    	Stock updatedDetails = repository.save(value);
        return updatedDetails;
    }
    
    /**
     * Delete a particular Stock details from a table
     * @param id auto increment id of Stock table
     * @return boolean value true or false
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteStock(@PathVariable(value = "id") Long id) {
    	Stock value = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Stock", "id", id));

    	repository.delete(value);

        return ResponseEntity.ok().build();
    }
}