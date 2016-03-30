package Logging_Aspects;

import java.util.logging.Level;

import org.aspectj.lang.Signature;

import banking.AccountException;






public aspect M2_LoggingExceptions
{
	after() throwing(AccountException e) throws AccountException: M1_LoggingMethods.methodExecutionSimpleAccountTest()
	{
		Signature sig = thisJoinPointStaticPart.getSignature();
		exceptionHandler(sig, e);
	}

	after() throwing(AccountException e) throws AccountException: M1_LoggingMethods.methodExecutionSimpleAccountImplement()
	{
		Signature sig = thisJoinPointStaticPart.getSignature();
		exceptionHandler(sig, e);
	}

	after() throwing(AccountException e) throws AccountException: M1_LoggingMethods.methodExecutionInterAccountOperations()
	{
		Signature sig = thisJoinPointStaticPart.getSignature();
		exceptionHandler(sig, e);
	}

	void exceptionHandler(Signature sig, AccountException e) throws AccountException
	{
		String		className	= sig.getDeclaringTypeName();
		String		methodName	= sig.getName();
		M1_LoggingMethods.logger.logp(Level.INFO, className, methodName, "Exception");
		throw e;
	}
}
