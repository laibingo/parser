package com.example.parser;

public abstract class Parser {

	Lexer lexer;

	Token[] lookahead;

	int k;

	int p = 0;

	public Parser(Lexer lexer, int k) {
		this.lexer = lexer;
		this.k = k;
		this.lookahead = new Token[k];
		for (int i = 0; i < k; i++) {
			consume();
		}
	}

	public Token LT(int i) {
		return lookahead[(p + i - 1) % k];
	}

	public int LA(int i) {
		return LT(i).getType();
	}

	public void match(int x) {
		if (LA(1) == x) consume();
		else throw new RuntimeException("error");
	}

	private void consume() {
		lookahead[p] = lexer.nextToken();
		p = (p + 1) % k;
	}


}
