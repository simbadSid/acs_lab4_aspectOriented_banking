package test;

import banking.SimpleAccountImpl;
import banking.InterAccountOperations;
import banking.AccountException;

/**********************************/
/* ADDING LOGGIN BY HAND: METHODS */
/**********************************/
import org.apache.log4j.Logger;


/**
 *  A simple banking account test class.
 *
 *@author     <a href="mailto:Sara.Bouchenak@inria.fr">Sara Bouchenak</a>
 *@version    1.0 - 13/01/2004
 */
public class SimpleAccountTest
{

	/**********************************/
	/* ADDING LOGGIN BY HAND: METHODS */
	/**********************************/
	static Logger log = Logger.getLogger(SimpleAccountTest.class);
	
	public static void main(String[] args)
		throws AccountException
	{

		/*************************************/
		/* ADDING LOGGIN BY HAND: PARAMETERS */
		/*************************************/
		String arguments = "\n\t[This: null]\n\t[Args: ("
			+ args + ")";

		/**********************************/
		/* ADDING LOGGIN BY HAND: METHODS */
		/**********************************/
		log.info("Entering SimpleAccountTest.main");

		/*************************************/
		/* ADDING LOGGIN BY HAND: EXCEPTIONS */
		/*************************************/
		try {

			SimpleAccountImpl 	account1, account2;
			int					accountNb1 = 1, accountNb2 = 2;
		
			account1	= new SimpleAccountImpl(accountNb1, 100);
			account2	= new SimpleAccountImpl(accountNb2, 0);
				
			log.info("\nSimpleAccountTest.main: Initially, account1.balance="
				+ account1.getBalance() + ", account2.balance="
				+ account2.getBalance());
				
			InterAccountOperations.transfer(account1, account2, 100);
			log.info"\nSimpleAccountTest.main: After 1st transfer 100 ac1 -> ac2, account1.balance="
				+ account1.getBalance() + ", account2.balance="
				+ account2.getBalance());
					
			InterAccountOperations.transfer(account1, account2, 100);
			log.info"\nSimpleAccountTest.main: After 2nd transfer 100 ac1 -> ac2, account1.balance="
				+ account1.getBalance() + ", account2.balance="
				+ account2.getBalance());
		
		/*************************************/
		/* ADDING LOGGIN BY HAND: EXCEPTIONS */
		/*************************************/
		} catch (AccountException e) {
			log.warn("Exception", e);
		}
	}
	
}