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
// import org.springframework.data.jpa.repository.Query;
// import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.niche.model.PickListValue;
import java.util.List;

/**
 * @author ilaiyarajat
 *
 */
@Repository
public interface PickListValueRepository extends JpaRepository<PickListValue, Long>{
	
	/*@Query("select p from pick_list_value p where p.pickListId = :pickListId")
	List<PickListValue> findAllByPickListIdAndStatus(@Param("pickListId") Long pickListId);*/
	
	List<PickListValue> findByPickListId(Long pickListId);
	
	List<PickListValue> findBySelfId(Long selfId);
	
	/*@Query("select pv from pick_list_value pv where pv.self_id = :self_id and pv.status = :status")
	List<PickListValue> findAllBySelfIdAndStatus(@Param("self_id") Long self_id,
	                             @Param("statusChild") int status);*/
}
