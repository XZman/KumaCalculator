package main;

/**
 * Created by XZman on 09/12/2017.
 */
public final class Token {

	// symbol names in regex notation
	public static final String EQUAL = "=";

	public static final String PLUS = "\\+";
	public static final String SUBTRACT = "-";
	public static final String MULTIPLY = "\\*";
	public static final String DIVIDE = "/";
	public static final String LBRACKET = "\\(";
	public static final String RBRACKET = "\\)";
	public static final String FACTORIAL = "!";
	public static final String POWER = "\\^";

	public static final String NUMBER = "-{0,1}[0123456789]+(\\.[0123456789]+){0,1}([eE]-{0,1}[0123456789]+){0,1}";
	public static final String VARIABLE = "[abcdefghijklmnopqrstuvwxyz]+[0123456789]*";

	public String name;
	public String content;

	public Token(String name, String content) {
		this.name = name;
		this.content = content;
	}

	public String getName() {
		String tokenName = null;

		if (name.equals(EQUAL))
			tokenName = "EQUAL";
		if (name.equals(PLUS))
			tokenName = "PLUS";
		if (name.equals(SUBTRACT))
			tokenName = "SUBSTRACT";
		if (name.equals(MULTIPLY))
			tokenName = "MULTIPLY";
		if (name.equals(DIVIDE))
			tokenName = "DIVIDE";
		if (name.equals(LBRACKET))
			tokenName = "LBRACKET";
		if (name.equals(RBRACKET))
			tokenName = "RBRACKET";
		if (name.equals(FACTORIAL))
			tokenName = "FACTORIAL";
		if (name.equals(POWER))
			tokenName = "POWER";
		if (name.equals(NUMBER))
			tokenName = "NUMBER";
		if (name.equals(VARIABLE))
			tokenName = "VARIABLE";

		return tokenName;
	}

	@Override
	public String toString() {
		return getName() + ":" + "\"" + content + "\"";
	}
}