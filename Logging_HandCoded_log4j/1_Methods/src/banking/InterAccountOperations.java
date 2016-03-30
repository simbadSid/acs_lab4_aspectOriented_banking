package banking;

import org.apache.log4j.Logger;

/**********************************/
/* ADDING LOGGIN BY HAND: METHODS */
/**********************************/


/**
 *  A class that provides inter-account operations.
 *
 *@author     <a href="mailto:Sara.Bouchenak@inria.fr">Sara Bouchenak</a>
 *@version    1.0 - 13/01/2004
 */
public class InterAccountOperations {

	/**********************************/
	/* ADDING LOGGIN BY HAND: METHODS */
	/**********************************/
	static Logger log = Logger.getLogger(InterAccountOperations.class);
		
	/**
	 * Performs funds transfer between two banking accounts.
	 * 
	 * @param	from	The origin account for funds transfer
	 * @param	to		The target account for funds transfer
	 * @param	amount	The amount to transfer
	 * @throws	AccountException	If a problem occurs during
	 * the <code>debit</code> operation, e.g., insufficient balance.
	 */
	public static void transfer(Account from, Account to, 
		float amount)
		throws AccountException
	{

		/**********************************/
		/* ADDING LOGGIN BY HAND: METHODS */
		/**********************************/
		log.info("Entering InterAccountOperations.transfer");

		// Deducts the amount from the 'from' account
		from.debit(amount);
		// Adds the amount to the 'to' account
		to.credit(amount);
	}
	
}