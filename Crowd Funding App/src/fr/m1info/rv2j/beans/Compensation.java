package fr.m1info.rv2j.beans;

import java.util.List;

public class Compensation {
	private int id;
	private float threshold;
	private int project_id;
	private String text;
	private int contributor_limit;
	private List<Integer> contributors;
	
	/*	GETTERS	*/
	public int getId() { return id; }
	
	public float getThreshold() { return threshold; }

	public int getProjectID() { return project_id; }

	public String getText() { return text; }

	public int getContributorLimit() { return contributor_limit; }

	public List<Integer> getContributors() { return contributors; }

	/*	SETTERS	*/
	public void setId(int id) { this.id = id; }
	
	public void setThreshold(float threshold) { this.threshold = threshold; }
	
	public void setProjectID(int id) { this.project_id = id; }
	
	public void setText(String text) { this.text = text; }
	
	public void setContributorLimit(int contributor_limit) { this.contributor_limit = contributor_limit; }
	
	public void setContributors(List<Integer> contributors) { this.contributors = contributors; }
}
