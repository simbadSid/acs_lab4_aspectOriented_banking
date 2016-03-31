package Logging_Aspects;

import java.util.logging.Level;

import org.aspectj.lang.Signature;

import banking.AccountException;






public aspect M2_LoggingExceptions
{
	after() throwing(AccountException e) throws AccountException: M1_LoggingMethods.methodExecutionSimpleAccountTest()
	{
		Signature sig = thisJoinPointStaticPart.getSignature();
		M1_LoggingMethods.printer(sig, Level.WARNING, false, null, null, "Exception", e);
		throw e;
	}

	after() throwing(AccountException e) throws AccountException: M1_LoggingMethods.methodExecutionSimpleAccountImplement()
	{
		Signature sig = thisJoinPointStaticPart.getSignature();
		M1_LoggingMethods.printer(sig, Level.WARNING, false, null, null, "Exception", e);
		throw e;
	}

	after() throwing(AccountException e) throws AccountException: M1_LoggingMethods.methodExecutionInterAccountOperations()
	{
		Signature sig = thisJoinPointStaticPart.getSignature();
		M1_LoggingMethods.printer(sig, Level.WARNING, false, null, null, "Exception", e);
		throw e;
	}
}