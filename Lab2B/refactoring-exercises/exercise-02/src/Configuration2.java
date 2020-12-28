import java.util.*;

public class Configuration2 {
	private int interval;

	private int duration;

	private int departure;
	
	public int getInterval() {
		return interval;
	}

	public int getDuration() {
		return duration;
	}

	public int getDeparture() {
		return departure;
	}

	public void load(Properties props) throws ConfigurationException {
		
		interval=interval(props);

		duration=duration(props);

		departure=deperture(props);
	}

	
	private int deperture(Properties props) throws ConfigurationException {
		String valueString;
		int value;
		valueString = props.getProperty("departure");
		if (valueString == null) {
			throw new ConfigurationException("departure offset");
		}
		value = Integer.parseInt(valueString);
		if (value <= 0) {
			throw new ConfigurationException("departure > 0");
		}
		if ((value % interval) != 0) {
			throw new ConfigurationException("departure % interval");
		}
		return value;
	}

	private int duration(Properties props) throws ConfigurationException {
		String valueString;
		int value;
		valueString = props.getProperty("duration");
		if (valueString == null) {
			throw new ConfigurationException("duration");
		}
		value = Integer.parseInt(valueString);
		if (value <= 0) {
			throw new ConfigurationException("duration > 0");
		}
		if ((value % interval) != 0) {
			throw new ConfigurationException("duration % interval");
		}
		return value;
	}

	private int interval(Properties props) throws ConfigurationException {
		String valueString;
		int value;

		valueString = props.getProperty("interval");
		if (valueString == null) {
			throw new ConfigurationException("monitor interval");
		}
		value = Integer.parseInt(valueString);
		if (value <= 0) {
			throw new ConfigurationException("monitor interval > 0");
		}
		return value;
	}
}
