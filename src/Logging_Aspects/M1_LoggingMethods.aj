package Logging_Aspects;

import java.util.logging.Level;
import org.aspectj.lang.Signature;









public aspect M1_LoggingMethods
{
// ----------------------------------------
// Attributes
// ----------------------------------------
	public static String		loggerName		= "trace";
	public static boolean		loggerHasArg	= true;								// Used for method 3
	public static Class<?>		loggerType		= java.util.logging.Logger.class;
//	public static Class<?>		loggerType		= org.apache.log4j.Logger.class;
	public static CustomLogger	logger 			= new CustomLogger(loggerName, loggerType);

// ----------------------------------------
// Used classes
// ----------------------------------------
	declare parents: test.SimpleAccountTest			implements Object;			//	Access the class
	declare parents: banking.InterAccountOperations	implements Object;			//	Access the class
	declare parents: banking.SimpleAccountImpl		implements banking.Account;	//	Access the class

// ----------------------------------------
// Point cuts
// ----------------------------------------
	protected static pointcut methodExecutionSimpleAccountTest() :				//	Access the execution of each method to modify
		execution(void test.SimpleAccountTest.main(..));
	protected static pointcut methodExecutionSimpleAccountImplement() :			//	Access the execution of each method to modify
		execution(* banking.SimpleAccountImpl.*(..));
	protected static pointcut methodExecutionInterAccountOperations() :			//	Access the execution of each method to modify
		execution(* banking.InterAccountOperations.*(..));

// ----------------------------------------
// Advices
// ----------------------------------------
	before(): methodExecutionSimpleAccountTest()								//	Log before each method execution
	{
		Signature	sig				= thisJoinPointStaticPart.getSignature();
		Object		currentObj		= null;
		Object[]	parameterTab	= thisJoinPoint.getArgs();

		printer(sig, Level.INFO, loggerHasArg, currentObj, parameterTab, "Entering", null);
	}

	before(): methodExecutionSimpleAccountImplement()							//	Log before each method execution
	{
		Signature	sig = thisJoinPointStaticPart.getSignature();
		Object		currentObj		= thisJoinPoint.getTarget();
		Object[]	parameterTab	= thisJoinPoint.getArgs();

		printer(sig, Level.INFO, loggerHasArg, currentObj, parameterTab, "Entering", null);
	}

	before(): methodExecutionInterAccountOperations()							//	Log before each method execution
	{
		Signature sig = thisJoinPointStaticPart.getSignature();
		Object		currentObj		= null;
		Object[]	parameterTab	= thisJoinPoint.getArgs();

		printer(sig, Level.INFO, loggerHasArg, currentObj, parameterTab, "Entering", null);
	}

// ----------------------------------------
// Auxiliary method
// ----------------------------------------
	public static void printer(Signature sig, Level loggerLevel, boolean printArg,
			Object currentObj, Object[] parameterTab, String msg, Exception e)
	{
		String		className	= sig.getDeclaringTypeName();
		String		methodName	= sig.getName();
		String		args		= "";

		if (printArg)
		{
			String		parameterStr	= "";
			int			nbrParameters	= parameterTab.length;
			for (int i=0; i<nbrParameters-1; i++)
				parameterStr += parameterTab[i] + ", ";
			if (nbrParameters > 0)
				parameterStr += parameterTab[nbrParameters-1];
			args = "\n\t[This: " + currentObj + "]\n\t[Args: (" + parameterStr + ")";
		}

		logger.logp(loggerLevel, className, methodName+args, msg, e);
	}
}