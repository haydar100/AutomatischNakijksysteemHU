package fnt.hu.nl.automatischNakijken.logic;

import java.io.FileNotFoundException;
import java.io.IOException;

import fnt.hu.nl.automatischNakijken.domain.AutomaticCheck;
import fnt.hu.nl.automatischNakijken.domain.Grade;
import fnt.hu.nl.automatischNakijken.domain.Solution;
import fnt.hu.nl.automatischNakijken.domain.SolutionEvaluationCriteria;
import fnt.hu.nl.automatischNakijken.domain.SolutionFile;
import fnt.hu.nl.automatischNakijken.domain.Student;
import fnt.hu.nl.automatischNakijken.util.PMDRunner;

public class PMDEvaluator extends AutomaticCheck {


	private String absolutePathToClass;
	private Grade grade;
	private String name;


	public PMDEvaluator(String name, boolean isFailable, Solution s, String absolutePathToClass) {
		super(name, isFailable);
		this.name = name;
		this.absolutePathToClass = absolutePathToClass;
	}


	@Override
	public SolutionEvaluationCriteria runCheck(Solution s) {
		try {
			runPMD();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (Student student : s.getStudents()) {
			System.out.println(student.getFullName());
		for (SolutionFile file : s.getFiles()) {
			System.out.println(file.toString());
		}
		System.out.println(s.getTimeOfSubmission().getTime());
		}
		SolutionEvaluationCriteria criteria = new SolutionEvaluationCriteria(name, grade);
		System.out.println(name.toString());
		System.out.println(grade.toString());
		return criteria;
		
	}
	

	public void runPMD() throws IOException {
		PMDRunner pmd = new PMDRunner();
		pmd.callPmd(absolutePathToClass);
		grade = pmd.grade();
		
	}



}
