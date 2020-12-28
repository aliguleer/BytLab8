import java.util.HashMap;
import java.util.Map;

public class Expression {
	
	
	 static Map<Character, IOperator> operationsMap = new HashMap<>();
	    static {
	        operationsMap.put('c', new Constant());
	        operationsMap.put('+', new Add());
	        operationsMap.put('-', new Subtract());
	        operationsMap.put('*', new Multiply());
	        operationsMap.put('/', new Divide());
	    }
	

	private char op;

	private Expression left;

	private Expression right;

	private int constant;
	
	
	public Expression(int constant) {
		this.op = 'c';
		this.constant = constant;
	}

	public Expression(char op, Expression left, Expression right) {
		this.op = op;
		this.left = left;
		this.right = right;
	}

	public int evaluate() {
		
		IOperator op = operationsMap.get(this.op);
		return op.Calculate(constant, left, right);
					
	}

	

}
		