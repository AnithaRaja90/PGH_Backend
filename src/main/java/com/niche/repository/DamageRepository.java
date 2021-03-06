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

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.niche.model.Damage;

/**
 * @author ilaiyarajat
 *
 */
@Repository
public interface DamageRepository extends JpaRepository<Damage, Long>{

}
