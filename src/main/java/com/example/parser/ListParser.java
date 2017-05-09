package com.example.parser;

public class ListParser extends Parser {

	public ListParser(Lexer lexer) {
		super(lexer);
	}

	public void list() {
		match(ListLexer.LBRACK);
		elements();
		match(ListLexer.RBRACK);
	}

	public void elements() {
		element();
		while (lookahead.getType() == ListLexer.COMMA) {
			match(ListLexer.COMMA);
			element();
		}
	}

	private void element() {
		if (lookahead.getType() == ListLexer.NAME) match(ListLexer.NAME);
		else if (lookahead.getType() == ListLexer.LBRACK) list();
		else throw new RuntimeException("error");
	}

}
