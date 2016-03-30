package Logging_Aspects;

import java.lang.reflect.Constructor;






public class CustomLogger
{
// ----------------------------------------
// Attributes
// ----------------------------------------
	private Object logger;

// ----------------------------------------
// Builder
// ----------------------------------------
	public CustomLogger(String loggerName, Class<?> loggerType)
	{
		try
		{
			Constructor<?> c = loggerType.getConstructor(String.class);
			this.logger = c.newInstance(loggerName);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.exit(0);
		}
	}

// ----------------------------------------
// Local method
// ----------------------------------------
	public void logp()
	{
		
	}
}