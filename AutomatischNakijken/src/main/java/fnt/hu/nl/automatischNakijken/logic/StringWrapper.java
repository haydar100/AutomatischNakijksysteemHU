package fnt.hu.nl.automatischNakijken.logic;

import java.util.ArrayList;
import java.util.List;

//This class will serve as a wrapper for the tokenised filecontent, allowing the Greedy String Tiling algorithm to compare them
public class StringWrapper {
	private List<StringItem> _stringItems;
	
	public StringWrapper(String content){
		_stringItems = new ArrayList<StringItem>(content.length());
		
		for(char item : content.toCharArray()){
			this._stringItems.add(new StringItem(item));		
		}
	}
	
	public List<StringItem> getStringItems() {
		return _stringItems;
	}
	public void setStringItems(List<StringItem> stringItems) {
		this._stringItems = stringItems;
	}
}
