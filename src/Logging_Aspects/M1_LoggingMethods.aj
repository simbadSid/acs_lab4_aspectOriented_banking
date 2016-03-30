package Logging_Aspects;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.aspectj.lang.Signature;








public aspect M1_LoggingMethods
{
	private static String loggerName = "trace";

	declare parents: test.SimpleAccountTest			implements Object;			//	Access the class
	declare parents: banking.InterAccountOperations	implements Object;			//	Access the class
	declare parents: banking.SimpleAccountImpl		implements banking.Account;	//	Access the class

	static Logger logger = Logger.getLogger(loggerName);						//	Add a static attribute to all the classes

	protected static pointcut methodExecutionSimpleAccountTest() :				//	Access the execution of each method to modify
		execution(void test.SimpleAccountTest.main(..));
	protected static pointcut methodExecutionSimpleAccountImplement() :			//	Access the execution of each method to modify
		execution(* banking.SimpleAccountImpl.*(..));
	protected static pointcut methodExecutionInterAccountOperations() :			//	Access the execution of each method to modify
		execution(* banking.InterAccountOperations.*(..));

	before(): methodExecutionSimpleAccountTest()								//	Log before each method execution
	{
		Signature sig = thisJoinPointStaticPart.getSignature();
		printer(sig);
	}
	before(): methodExecutionSimpleAccountImplement()							//	Log before each method execution
	{
		Signature sig = thisJoinPointStaticPart.getSignature();
		printer(sig);
	}
	before(): methodExecutionInterAccountOperations()							//	Log before each method execution
	{
		Signature sig = thisJoinPointStaticPart.getSignature();
		printer(sig);
	}

	void printer(Signature sig)													// Auxiliary method
	{
		String		className	= sig.getDeclaringTypeName();
		String		methodName	= sig.getName();
		logger.logp(Level.INFO, className, methodName, "Entering");
	}

}
