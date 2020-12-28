public class Matcher {
	public Matcher() {
	}

	public boolean match(MatchParameter parameterObject) {

		
		clipTooLargeValues(parameterObject);

		checkDifferencesOfLength(parameterObject);
	
		checkEachInExpected(parameterObject);

		return true;
	}

	private boolean checkEachInExpected(MatchParameter parameterObject) {
		for (int i = 0; i < parameterObject.actuals.length; i++)
			if (Math.abs(parameterObject.expecteds[i] - parameterObject.actuals[i]) > parameterObject.delta)
				return false;
			
		return false;
	}

	private boolean checkDifferencesOfLength(MatchParameter parameterObject) {
		
		if (parameterObject.actuals.length != parameterObject.expecteds.length)
			return false;
		
		return true;
	}

	private void clipTooLargeValues(MatchParameter parameterObject) {
		for (int i = 0; i < parameterObject.actuals.length; i++)
			if (parameterObject.actuals[i] > parameterObject.clipLimit)
				parameterObject.actuals[i] = parameterObject.clipLimit;
	}
}