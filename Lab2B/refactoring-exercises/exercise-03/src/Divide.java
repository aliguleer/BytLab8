
public class Divide  implements IOperator{

	@Override
	public int Calculate(int constant, Expression left, Expression right) {
		
		return left.evaluate()/right.evaluate();
		
	}


	
	
}
