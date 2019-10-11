package com.waes.assignment.rrichards.enums;

/**
 * @author Rafael Richards
 * ENUM File that stores the messages to be used in the application
 */
public enum DiffResultsMessages
{
	EQUALS("Left and Right are equals"),
	DIFFERENT_SIZE("Left and Right have different length sizes"),
	EQUAL_SIZE_WITH_DIFFERENCES("Left and Right have equal length sizes but have differences"),
	MISSING_RIGHT_DATA("Right information is missing"),
	MISSING_LEFT_DATA("Left information is missing"),
	MISSING_DATA("Both left and right information are missing");
    
	private final String text;

    DiffResultsMessages(String text) 
    {
        this.text = text;
    }

    public String getText() 
    {
        return text;
    }
}