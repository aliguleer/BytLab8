public class ExpressionBefore {

	private char op;

	private ExpressionBefore left;

	private ExpressionBefore right;

	private int constant;

	public ExpressionBefore(int constant) {
		this.op = 'c';
		this.constant = constant;
	}

	public ExpressionBefore(char op, ExpressionBefore left, ExpressionBefore right) {
		this.op = op;
		this.left = left;
		this.right = right;
	}

	public int evaluate() {
		switch (op) {
		case 'c':
			return constant;
		case '+':
			return left.evaluate() + right.evaluate();
		case '-':
			return left.evaluate() - right.evaluate();
		case '*':
			return left.evaluate() * right.evaluate();
		case '/':
			return left.evaluate() / right.evaluate();
		default:
			throw new IllegalStateException();
		}
		
		
	}

	
		
	
	

}
