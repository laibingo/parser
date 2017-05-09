package com.example.parser;

public class ListParser extends Parser {

	public ListParser(Lexer lexer, int k) {
		super(lexer, k);
	}

	public void list() {
		match(ListLexer.LBRACK);
		elements();
		match(ListLexer.RBRACK);
	}

	public void elements() {
		element();
		while (LA(1) == ListLexer.COMMA) {
			match(ListLexer.COMMA);
			element();
		}
	}

	private void element() {
		if (LA(1) == ListLexer.NAME && LA(2) == ListLexer.EQUALS) {
			match(ListLexer.NAME);
			match(ListLexer.EQUALS);
			match(ListLexer.NAME);
		} else if (LA(1) == ListLexer.NAME)
			match(ListLexer.NAME);
		 else if (LA(1) == ListLexer.LBRACK) list();
		else throw new RuntimeException("error");
	}

}
