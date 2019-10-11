/**
 * 
 */
package com.waes.assignment.rrichards.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.waes.assignment.rrichards.entities.Diff;

/**
 * @author Rafael Richards
 *  H2 Database repository interface, for the CRUD operations on the Diff entity
 */
public interface DiffRepository extends JpaRepository<Diff, Long> 
{

}
