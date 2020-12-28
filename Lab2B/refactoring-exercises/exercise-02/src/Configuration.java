import java.util.*;

public class Configuration {
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
		
		interval=getProperty(props,"interval");

		duration=getProperty(props,"duration");

		departure=getProperty(props,"departure");
		
		 if ((duration % interval) != 0) {
			 throw new ConfigurationException("duration % checkInterval");
			 }
		 if ((departure % interval) != 0) {
			 throw new ConfigurationException("departure % checkInterval");
			 }
				
	}


	private int getProperty(Properties props,String type) throws ConfigurationException {
	
		if (props.getProperty(type) == null) {
			if(type=="departure")
				throw new ConfigurationException("departure offset");
			else if(type=="duration")
				throw new ConfigurationException("duration");
			else 
				throw new ConfigurationException("\"monitor interval");
			
		}
		if (Integer.parseInt(props.getProperty(type)) <= 0) {
			
			if(type=="departure")
				throw new ConfigurationException("departure > 0");
			else if(type=="duration")
				throw new ConfigurationException("duration > 0");
			else 
				throw new ConfigurationException("monitor interval > 0");
		}
		
		return Integer.parseInt(props.getProperty(type));
	}

	
	
}
