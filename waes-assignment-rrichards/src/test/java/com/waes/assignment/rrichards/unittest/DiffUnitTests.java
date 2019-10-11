package com.waes.assignment.rrichards.unittest;

import static org.junit.Assert.assertNull;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import com.waes.assignment.rrichards.entities.Diff;
import com.waes.assignment.rrichards.repository.DiffRepository;
import com.waes.assignment.rrichards.service.DiffServiceImpl;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;

@RunWith(SpringRunner.class)
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.waes.assignment.rrichards"})
@SpringBootTest(classes = DiffUnitTests.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DiffUnitTests 
{
	@Mock
    private DiffRepository diffRepository;
    
	@Mock
    private DiffServiceImpl diffService;
    
    @Test
    public void testSaveDiffRightSide() 
    {
    	Diff diff = new Diff(1);
    	Optional<Diff> optionalDiff = Optional.of(diff);

    	Mockito.when(diffRepository.findById(anyLong())).thenReturn(optionalDiff);

    	Mockito.when(diffService.findDiff(anyLong())).thenReturn(diff);
    	Mockito.when(diffRepository.save(any())).thenReturn(diff);
    	
    	Exception e = null;
    	try
    	{
    		diffService.diffSaveRight(anyLong(), anyString());
    	}
    	catch(Exception ex)
    	{
    		e = ex;
    	}
    	
    	assertNull(e);
    } 
    
   
    @Test
    public void testSaveDiffLeftSide() 
    {
    	Diff diff = new Diff(1);
    	Optional<Diff> optionalDiff = Optional.of(diff);

    	Mockito.when(diffRepository.findById(anyLong())).thenReturn(optionalDiff);

    	Mockito.when(diffService.findDiff(anyLong())).thenReturn(diff);
    	Mockito.when(diffRepository.save(any())).thenReturn(diff);
    	
    	Exception e = null;
    	try
    	{
    		diffService.diffSaveLeft(anyLong(), anyString());
    	}
    	catch(Exception ex)
    	{
    		e = ex;
    	}
    	
    	assertNull(e);
    } 
    
}
