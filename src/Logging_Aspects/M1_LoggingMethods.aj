package Logging_Aspects;

import java.util.logging.Level;
import java.util.logging.Logger;








public aspect M1_LoggingMethods
{
	private static String loggerName = "trace";

	declare parents: banking.SimpleAccountImpl implements banking.Account;		//		Access the class
	static Logger loggerSAI = Logger.getLogger(loggerName);						//		Add a static attribute

	protected static pointcut methodExecutionSAI() :							//		Access the execution of each method to modify
		execution (void banking.SimpleAccountImpl.*(..));

	before(): methodExecutionSAI()												//		Log before each method execution
	{
		String className	= "class name";		// TODO
		String methodName	= "method name";	// TODO
		loggerSAI.logp(Level.INFO, className, methodName, "Entering");
	}


	declare parents: banking.InterAccountOperations implements Object;			//		Access the class
	static Logger loggerISO = Logger.getLogger(loggerName);						//		Add a static attribute

	protected static pointcut methodExecutionISO() :							//		Access the execution of each method to modify
		execution (void banking.InterAccountOperations.*(..));

	before(): methodExecutionISO()												//		Log before each method execution
	{
		String className	= "class name";		// TODO
		String methodName	= "method name";	// TODO
		loggerSAI.logp(Level.INFO, className, methodName, "Entering");
	}


	declare parents: test.SimpleAccountTest implements Object;					//		Access the class
	static Logger loggerSAT = Logger.getLogger(loggerName);						//		Add a static attribute

	protected static pointcut methodExecutionSAT() :							//		Access the execution of each method to modify
		execution (void test.SimpleAccountTest.*(..));

	before(): methodExecutionSAT()												//		Log before each method execution
	{
		String className	= "class name";		// TODO
		String methodName	= "method name";	// TODO
		loggerSAI.logp(Level.INFO, className, methodName, "Entering");
	}


}
