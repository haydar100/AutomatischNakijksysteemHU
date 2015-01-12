package fnt.hu.nl.automatischNakijken.domain;

import java.util.Calendar;
import java.util.List;

import edu.emory.mathcs.backport.java.util.concurrent.TimeUnit;

public class DetectionResult {
	private int id;
	private List<SolutionSimilarity> _sortedSimilarities;
	private int _solutionCount;
	private long _calcTime;
	private Calendar _startTime;
	
	public DetectionResult(){
		this._startTime = Calendar.getInstance();
	}
	
	public int getId() {
		return id;
	}

	private void setId(int id) {
		this.id = id;
	}
	
	public List<SolutionSimilarity> getSortedSimilarities() {
		return _sortedSimilarities;
	}

	public void setSortedSimilarities(List<SolutionSimilarity> _sortedSimilarities) {
		this._sortedSimilarities = _sortedSimilarities;
	}

	public int getSolutionCount() {
		return _solutionCount;
	}

	public void setSolutionCount(int _solutionCount) {
		this._solutionCount = _solutionCount;
	}

	public long getCalcTime() {
		return _calcTime;
	}

	public void setCalcTime(long _calcTime) {
		this._calcTime = _calcTime;
	}
	
	public Calendar getStartTime(){
		return this._startTime;
	}
	
	private void setStartTime(Calendar startTime){
		this._startTime = startTime;
	}
	
	@Override
	public String toString(){
		if(_calcTime == 0 || _solutionCount == 0 || _sortedSimilarities == null){
			throw new IllegalArgumentException("Attributes can not be null");
		}
		String results = "";
		for(SolutionSimilarity sim : _sortedSimilarities)
			results += sim.toString() + "\n";
		return "Detection started at " + this._startTime.getTime() + ".\nCompared " 
				+ this._solutionCount + " solutions.\n" + "Calculation took " + TimeUnit.NANOSECONDS.toMillis(_calcTime) 
				+ "ms.\nResults:\n" + results;
	}
}
