package fnt.hu.nl.automatischNakijken.domain;

public class AutomaticCheck implements AssignmentCheck {
	private String name;
	private boolean isFailable;
	
	
	/**
	 * @param name
	 * @param isFailable
	 */
	public AutomaticCheck(String name, boolean isFailable) {
		super();
		this.name = name;
		this.isFailable = isFailable;
	}


	public SolutionEvaluationCriteria runCheck(Solution s) {
		return null;
		
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}


	/**
	 * @return the isFailable
	 */
	public boolean isFailable() {
		return isFailable;
	}

	/**
	 * @param isFailable
	 *            the isFailable to set
	 */
	public void setFailable(boolean isFailable) {
		this.isFailable = isFailable;
	}
	
	
	
	
	

}
