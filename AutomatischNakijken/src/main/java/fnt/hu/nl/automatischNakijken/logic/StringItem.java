package fnt.hu.nl.automatischNakijken.logic;

//This class will serve as a representation of individual items in a tokenised file
public class StringItem {
	private char _content;
	private boolean _marked;
	
	public StringItem(char content){
		this._content = content;
		this._marked = false;
	}
	
	public char getContent() {
		return _content;
	}
	public void setContent(char content) {
		this._content = content;
	}
	public boolean isMarked() {
		return _marked;
	}
	public void setMarked(boolean marked) {
		this._marked = marked;
	}
}
