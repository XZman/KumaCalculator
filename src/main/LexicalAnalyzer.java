package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LexicalAnalyzer {

	public static ArrayList<Token> tokenize(String exp) {
		HashMap<String, Pattern> patterns = getTokenPatterns();

		ArrayList<Token> tokens = new ArrayList<>();

		int pos = 0;
		while (pos < exp.length()) {

			// skip white spaces
			while (exp.charAt(pos) == ' ')
				pos++;

			// find next token
			boolean nextTokenNotFound = true;
			for (Map.Entry<String, Pattern> ety : patterns.entrySet()) {
				Matcher matcher = ety.getValue().matcher(exp);

				// next token found
				if (matcher.find(pos) && matcher.start() == pos) {
					pos = matcher.end();
					nextTokenNotFound = false;
					tokens.add(new Token(ety.getKey(), matcher.group()));
					break;
				}
			}

			// next token not found, aka invalid token found
			if (nextTokenNotFound)
				throw new IllegalArgumentException("Invalid token: " + "\"" + exp.charAt(pos) + "\"");
		}

		return tokens;
	}

	public static HashMap<String, Pattern> getTokenPatterns() {
		HashMap<String, Pattern> patterns = new HashMap<>();

		patterns.put(Token.EQUAL, Pattern.compile(Token.EQUAL));
		patterns.put(Token.PLUS, Pattern.compile(Token.PLUS));
		patterns.put(Token.SUBTRACT, Pattern.compile(Token.SUBTRACT));
		patterns.put(Token.MULTIPLY, Pattern.compile(Token.MULTIPLY));
		patterns.put(Token.DIVIDE, Pattern.compile(Token.DIVIDE));
		patterns.put(Token.LBRACKET, Pattern.compile(Token.LBRACKET));
		patterns.put(Token.RBRACKET, Pattern.compile(Token.RBRACKET));
		patterns.put(Token.FACTORIAL, Pattern.compile(Token.FACTORIAL));
		patterns.put(Token.POWER, Pattern.compile(Token.POWER));
		patterns.put(Token.NUMBER, Pattern.compile(Token.NUMBER));
		patterns.put(Token.VARIABLE, Pattern.compile(Token.VARIABLE));

		patterns.put("SPACE", Pattern.compile(" +"));

		return patterns;
	}
}
