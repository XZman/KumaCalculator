package main;

import java.util.ArrayList;

/**
 * Created by XZman on 09/12/2017.
 */
public class KumaCalculator {
	public static void main(String[] args) {
		ArrayList<Token> tokens = LexicalAnalyzer.tokenize("(2+3)*5+a6");
		System.out.println(tokens);
	}
}
