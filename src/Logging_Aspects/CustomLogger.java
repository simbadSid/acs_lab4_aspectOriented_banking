package Logging_Aspects;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;







public class CustomLogger
{
// ----------------------------------------
// Attributes
// ----------------------------------------
	private String		loggerName;
	private Class<?>	loggerType;
	private Object		logger;
	private Method		logp;

// ----------------------------------------
// Builder
// ----------------------------------------
	public CustomLogger(String loggerName, Class<?> loggerType)
	{
		this.loggerName = loggerName;
		try
		{
			Method m = loggerType.getMethod("getLogger", String.class);
			this.logger = m.invoke(null, loggerName);
//TODO			this.logp	= loggerType.getMethod("logp", Level.class, String.class, String.class, String.class, Exception.class);
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
	public void logp(Level loggerLevel, String className, String methodName, String msg, Exception e)
	{
java.util.logging.Logger.getLogger(loggerName).logp(loggerLevel, className, methodName, msg, e);
/*
//TODO
		try 
		{
			this.logp.invoke(logger, loggerLevel, className, methodName, msg, e);
		}
		catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e1)
		{
			e1.printStackTrace();
			System.exit(0);
		}
*/	}
}