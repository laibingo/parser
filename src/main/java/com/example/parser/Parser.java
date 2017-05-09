package com.example.parser;

public abstract class Parser {

	Lexer lexer;

	Token lookahead;

	public Parser(Lexer lexer) {
		this.lexer = lexer;
		lookahead = this.lexer.nextToken();
	}

	public void match(int x) {
		if (lookahead.getType() == x) consume();
		else throw new RuntimeException("error");
	}

	private void consume() {
		lookahead = lexer.nextToken();
	}


}
