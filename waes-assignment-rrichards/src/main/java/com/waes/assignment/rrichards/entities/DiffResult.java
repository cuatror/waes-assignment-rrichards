package com.waes.assignment.rrichards.entities;

import org.springframework.stereotype.Component;

/**
 * @author Rafael Richards
 * Class to store the differences between the left and right properties of the
 * Diff entity    
 */
@Component
public class DiffResult 
{
	private String equals;
    private String size;
    private String differences;
    private String offset;
	
	
	public String getEquals() 
	{
		return equals;
	}

	public void setEquals(String equals) 
	{
		this.equals = equals;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getDifferences() {
		return differences;
	}

	public void setDifferences(String differences) {
		this.differences = differences;
	}
	
	public String getOffset() {
		return offset;
	}

	public void setOffset(String offset) {
		this.offset = offset;
	}


}
