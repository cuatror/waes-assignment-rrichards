/**
 * 
 */
package com.waes.assignment.rrichards.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.waes.assignment.rrichards.entities.Base64String;
import com.waes.assignment.rrichards.entities.DiffResult;
import com.waes.assignment.rrichards.service.DiffService;

/**
 * @author Rafael Richards
 * Controller for the endpoints to be used by the Diff operations    
 */
@RestController
public class DiffController {

	@Autowired 
	private DiffService diffService;

	/**
	 * POST API to save the left property of the Diff entity    
	 */
	@RequestMapping(method = RequestMethod.POST, path="/v1/diff/{id}/left")
    public ResponseEntity<String> saveLeftData(@PathVariable long id, @RequestBody Base64String data) throws IllegalAccessException 
 	{
		diffService.diffSaveLeft(id, data.getData());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
	
	/**
	 * POST API to save the right property of the Diff entity    
	 */
	@RequestMapping(method = RequestMethod.POST, path="/v1/diff/{id}/right")
    public ResponseEntity<String> saveRightData(@PathVariable long id, @RequestBody Base64String data) throws IllegalAccessException 
 	{
		diffService.diffSaveRight(id, data.getData());
		return new ResponseEntity<>(HttpStatus.CREATED);
    }
	
	/**
	 * GET API to get the information of the differences between left and right properties
	 * of the Diff entity    
	 */
	@RequestMapping(method = RequestMethod.GET, path="/v1/diff/{id}")
    @ResponseBody
    public ResponseEntity<DiffResult> getDiffResult(@PathVariable long id)
	{
		return ResponseEntity.ok(diffService.getDiffResult(id));
    }

}
