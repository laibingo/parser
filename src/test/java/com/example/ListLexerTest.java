package com.example;


import com.example.parser.ListLexer;
import com.example.parser.Token;
import org.junit.Test;

public class ListLexerTest {

	@Test
	public void test() {
		for (String input : new String[]{"[a,b,c]", "[a,b,]"}) {
			ListLexer lexer = new ListLexer(input);
			Token token = lexer.nextToken();
			while (token.getType() != ListLexer.EOF_TYPE) {
				System.out.println(token);
				token = lexer.nextToken();
			}
			System.out.println(token);
			System.out.println("---");
		}
	}

}
