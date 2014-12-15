package fnt.hu.nl.automatischNakijken.domain;

import java.io.File;

public class SolutionFile extends File {
	private int id;
	private String filePath;
	
	private SolutionFile(){
		super("");
	}

	public SolutionFile(String pathname) {
		super(pathname);
		this.filePath = pathname;
	}
	
	public int getId() {
		return id;
	}

	private void setId(int id) {
		this.id = id;
	}
	
	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
}
