package com.example.parser;

public class Token {

	private int type;

	private String text;

	public Token(int type, String text) {
		this.type = type;
		this.text = text;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		String tokenName = ListLexer.tokenNames[type];
		return "Token{" +
				"type=" + type +
				", tokenName='" + tokenName + '\'' +
				'}';
	}
}
