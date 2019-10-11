/**
 * 
 */
package com.waes.assignment.rrichards.service;

import org.springframework.stereotype.Component;
import com.waes.assignment.rrichards.entities.Diff;
import com.waes.assignment.rrichards.entities.DiffResult;


/**
 * @author Rafael Richards
 * Service that contains the signatures of the methods to be used in the Application
 */

@Component
public interface DiffService 
{
	Diff findDiff(long id);
	
	Diff diffSaveLeft(long id, String data);
	
	Diff diffSaveRight(long id, String data);
	
	DiffResult getDiffResult(long id);

}
