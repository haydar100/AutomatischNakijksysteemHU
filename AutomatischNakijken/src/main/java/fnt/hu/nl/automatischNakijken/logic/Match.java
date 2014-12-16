package fnt.hu.nl.automatischNakijken.logic;

public class Match {
	private int _patternPosition;
	
	private int _textPosition;
	private int _length;
	private String _value;
	
	public Match(int patternPosition, int textPosition, int length, String value){
		this._patternPosition = patternPosition;
		this._textPosition = textPosition;
		this._length = length;
		this._value = value;
	}
	
	public int getPatternPosition() {
		return _patternPosition;
	}

	public void setPatternPosition(int patternPosition) {
		this._patternPosition = patternPosition;
	}

	public int getTextPosition() {
		return _textPosition;
	}

	public void setTextPosition(int textPosition) {
		this._textPosition = textPosition;
	}

	public int getLength() {
		return _length;
	}

	public void setLength(int length) {
		this._length = length;
	}

	public String getValue() {
		return _value;
	}

	public void setValue(String value) {
		this._value = value;
	}
	
	@Override
	public String toString(){
		return "The match has length " + this._length + " and value " + this._value;
	}
}
