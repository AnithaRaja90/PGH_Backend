/**
 * 
 *
 * @category  
 * @package   
 * @author    Nichehands <nichehands@nichehands.com>
 * @copyright 2013 Nichehands Technologies Pvt Ltd.
 * @license   http://www.nichehandstechnologies.com / Private License
 * @link      http://www.nichehandstechnologies.com.
 */
package com.niche.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.niche.model.Nursery;

/**
 * @author ilaiyarajat
 *
 */
@Repository
public interface NurseryRepository extends JpaRepository<Nursery, Long>{
	List<Nursery> findBySectorId(Long sectorId);
}
