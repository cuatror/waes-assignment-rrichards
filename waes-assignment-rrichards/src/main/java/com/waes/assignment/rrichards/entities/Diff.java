/**
 * 
 */
package com.waes.assignment.rrichards.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Rafael Richards
 * Diff entity
 */
@Entity
public class Diff 
{
	@Id
	@GeneratedValue
	@Column(name = "id")
	private long id;
	
	@Column(name = "left")
	private String left;
	
	@Column(name = "right")
	private String right;
	
	public Diff() 
	{
	}

	
	public Diff(long id) 
	{
		super();
		this.id = id;
	}

	public Diff(long id, String left, String right) 
	{
		super();
		this.id = id;
		this.left = left;
		this.right = right;
	}

	public long getId() 
	{
		return id;
	}
	
	public void setId(long id) 
	{
		this.id = id;
	}
	
	public String getLeft() 
	{
		return left;
	}
	
	public void setLeft(String left) 
	{
		this.left = left;
	}
	
	public String getRight() 
	{
		return right;
	}
	
	public void setRight(String right)
	{
		this.right = right;
	}
}
