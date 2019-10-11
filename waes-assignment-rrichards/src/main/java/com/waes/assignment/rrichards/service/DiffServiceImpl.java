package com.waes.assignment.rrichards.service;

import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.waes.assignment.rrichards.entities.Diff;
import com.waes.assignment.rrichards.entities.DiffResult;
import com.waes.assignment.rrichards.enums.DiffResultsMessages;
import com.waes.assignment.rrichards.exceptions.DiffResultException;
import com.waes.assignment.rrichards.repository.DiffRepository;


/**
 * @author Rafael Richards
 * Implementation of the service  that contains the signatures of 
 * the methods to be used in the Application
 */
@Component
public class DiffServiceImpl implements DiffService 
{
	
	@Autowired 
	private DiffRepository diffRepository;
	
	public DiffServiceImpl()
	{
		
	}
	
	/*
	 * Method to get the Diff entity by id
	 */
	public Diff findDiff(long id)
	{
		Optional<Diff> optionalDiff = diffRepository.findById(id);
		if(optionalDiff.isPresent()) return optionalDiff.get();
		else return new Diff(id);
	}


	/*
	 * Method to save the Diff entity with the left part
	 */
	@Override
	public Diff diffSaveLeft(long id, String base64String) 
	{
		Diff localDiff = this.findDiff(id);
		localDiff.setLeft(base64String);
		return diffRepository.save(localDiff);
	}

	/*
	 * Method to save the Diff entity with the right part
	 */
	@Override
	public Diff diffSaveRight(long id, String base64String) 
	{
		Diff localDiff = this.findDiff(id);
		localDiff.setRight(base64String);
		return diffRepository.save(localDiff);
	}
	
	/*
	 * Method to get the response with the differences between right and left properties
	 */
	@Override
	public DiffResult getDiffResult(long id) 
	{
		Diff localDiff = this.findDiff(id);
		DiffResult localDiffResult = new DiffResult();
		initializeDiffResponse(localDiffResult);
		
		if(!StringUtils.isEmpty(localDiff.getLeft()) && !StringUtils.isEmpty(localDiff.getRight()))
		{
			if (localDiff.getLeft().equals(localDiff.getRight()))
			{
				localDiffResult.setEquals(DiffResultsMessages.EQUALS.getText());
			}
			else if (localDiff.getLeft().length() != localDiff.getRight().length())
			{
				localDiffResult.setSize(DiffResultsMessages.DIFFERENT_SIZE.getText());
			}
			else 
			{
				localDiffResult.setDifferences(StringUtils.difference(localDiff.getLeft(), localDiff.getRight()));
				localDiffResult.setOffset(String.valueOf(StringUtils.indexOfDifference(localDiff.getLeft(), localDiff.getRight())));
		    }
		}
		else
		{
			if(StringUtils.isEmpty(localDiff.getLeft()) && StringUtils.isEmpty(localDiff.getRight()))
			{
				throw new DiffResultException(DiffResultsMessages.MISSING_DATA.getText());
			}
			else if(StringUtils.isEmpty(localDiff.getLeft()))
			{
				throw new DiffResultException(DiffResultsMessages.MISSING_LEFT_DATA.getText());
			}
			else if(StringUtils.isEmpty(localDiff.getRight()))
			{
				throw new DiffResultException(DiffResultsMessages.MISSING_RIGHT_DATA.getText());
			}
		}
        return localDiffResult;
	}

	/*
	 * Method to clean the response variables for the DiffResult entity
	 */
	public void initializeDiffResponse(DiffResult localDiffResult)
	{
		localDiffResult.setEquals("");
		localDiffResult.setSize("");
		localDiffResult.setDifferences("");
		localDiffResult.setOffset("");
	}
}
