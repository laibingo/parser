package com.example;

import com.example.parser.ListLexer;
import com.example.parser.ListParser;
import org.junit.Test;

public class ListParserTest {

	@Test
	public void test() {
		for (String input : new String[]{"[a,b,c]","[a,b,c,[d=e,f],[g,h]]", "[a,b,c,[d,e],f]", "[a,b,]"}) {
			ListLexer lexer = new ListLexer(input);
			ListParser parser = new ListParser(lexer, 5);
			parser.list();
			System.out.println("ok");
		}
	}

}
