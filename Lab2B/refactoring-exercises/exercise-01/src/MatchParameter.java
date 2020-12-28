
public class MatchParameter {
	public int[] expecteds;
	public int[] actuals;
	public int clipLimit;
	public int delta;

	public MatchParameter(int[] expecteds, int[] actuals, int clipLimit, int delta) {
		this.expecteds = expecteds;
		this.actuals = actuals;
		this.clipLimit = clipLimit;
		this.delta = delta;
	}
}