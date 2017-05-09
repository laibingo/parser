package com.example.parser;

public class ListLexer extends Lexer {

	public static final int NAME = 2;

	public static final int COMMA = 3;

	public static final int LBRACK = 4;

	public static final int RBRACK = 5;

	public static String[] tokenNames = {
			"n/a", "<EOF>", "NAME", "COMMA", "LBRACK", "RBRACK"
	};

	public ListLexer(String input) {
		super(input);
	}

	@Override
	public Token nextToken() {
		while (c != EOF) {
			switch (c) {
				case ' ':
				case '\t':
				case '\n':
				case '\r':
					WS();
					continue;
				case ',':
					consume();
					return new Token(COMMA, ",");
				case '[':
					consume();
					return new Token(LBRACK, "[");
				case ']':
					consume();
					return new Token(RBRACK, "]");
				default:
					if (isLetter()) return NAME();
					throw new RuntimeException("error");
			}
		}
		return new Token(EOF_TYPE, "<EOF>");
	}

	private boolean isLetter() {
		return c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z';
	}

	private Token NAME() {
		String buf = "";
		do {
			buf += c;
			consume();
		} while (isLetter());
		return new Token(NAME, buf);
	}

	private void WS() {
		while (c == ' ' || c == '\t' || c == '\n' || c == '\r') {
			consume();
		}
	}

	@Override
	public String getTokenName(int tokenType) {
		return tokenNames[tokenType];
	}
}
