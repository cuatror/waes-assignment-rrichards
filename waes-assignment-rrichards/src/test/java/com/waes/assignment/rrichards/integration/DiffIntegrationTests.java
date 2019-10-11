package com.waes.assignment.rrichards.integration;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.waes.assignment.rrichards.entities.Base64String;
import com.waes.assignment.rrichards.entities.DiffResult;
import com.waes.assignment.rrichards.enums.DiffResultsMessages;

@RunWith(SpringRunner.class)
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.waes.assignment.rrichards"})
@SpringBootTest(classes = DiffIntegrationTests.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DiffIntegrationTests 
{
    
    @Autowired
    private TestRestTemplate testRestTemplate;
    
    @Test
    public void testInsertionOfDiffRightSide() 
    {
    	Base64String request = new Base64String("aGVsbG86d29ybGQ=");
    	ResponseEntity<String> response = testRestTemplate.postForEntity("/v1/diff/1/right", request, String.class);
    	assert(response.getStatusCode().equals(HttpStatus.CREATED));
    } 
    
    @Test
    public void testInsertionOfDiffLeftSide() 
    {
    	Base64String request = new Base64String("aGVsbG86d34xbGA=");
    	ResponseEntity<String> response = testRestTemplate.postForEntity("/v1/diff/1/left", request, String.class);
    	assert(response.getStatusCode().equals(HttpStatus.CREATED));
    } 
    
    @Test
    public void testInsertionOfDiffWithAllSides() 
    {
    	Base64String requestRight = new Base64String("aGVsbG86d29ybGQ=");
    	ResponseEntity<String> responseRight = testRestTemplate.postForEntity("/v1/diff/1/right", requestRight, String.class);
    	assert(responseRight.getStatusCode().equals(HttpStatus.CREATED));

    	Base64String requestLeft = new Base64String("aGVsbG86d34xbGA=");
    	ResponseEntity<String> responseLeft = testRestTemplate.postForEntity("/v1/diff/1/left", requestLeft, String.class);
    	assert(responseLeft.getStatusCode().equals(HttpStatus.CREATED));
    } 
    
    @Test
    public void testDiffResult_RightException() 
    {
    	Base64String requestLeft = new Base64String("aGVsbG86d34xbGA=");
    	testRestTemplate.postForEntity("/v1/diff/1/left", requestLeft, String.class);
    	
    	try
    	{
    	   testRestTemplate.getForEntity("/v1/diff/1", DiffResult.class);
    	}
    	catch(Exception e)
    	{
    		assert(e.getMessage().contains(DiffResultsMessages.MISSING_RIGHT_DATA.getText()));
    	}
    } 
    
    @Test
    public void testDiffResult_LeftException() 
    {
    	Base64String requestRight = new Base64String("aGVsbG86d29ybGQ=");
    	testRestTemplate.postForEntity("/v1/diff/1/right", requestRight, String.class);
    	
    	try
    	{
    		testRestTemplate.getForEntity("/v1/diff/1", DiffResult.class);
    	}
    	catch(Exception e)
    	{
    		assert(e.getMessage().contains(DiffResultsMessages.MISSING_LEFT_DATA.getText()));	
    	}
    } 
    
    @Test
    public void testDiffResult_MissingDataException() 
    {
    	try
    	{
    		testRestTemplate.getForEntity("/v1/diff/1", DiffResult.class);
    	}
    	catch(Exception e)
    	{
    		assert(e.getMessage().contains(DiffResultsMessages.MISSING_DATA.getText()));	
    	}
    } 
}
