
public class Multiply  implements IOperator{

	@Override
	public int Calculate(int constant, Expression left, Expression right) {
		// TODO Auto-generated method stub
		return left.evaluate()*right.evaluate();
	}

	
	
}
