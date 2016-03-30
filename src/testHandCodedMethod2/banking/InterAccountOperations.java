package testHandCodedMethod2.banking;

/**********************************/
/* ADDING LOGGIN BY HAND: METHODS */
/**********************************/
import java.util.logging.Logger;
import java.util.logging.Level;

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
	static Logger logger = Logger.getLogger("trace");
		
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
		logger.logp(Level.INFO, "InterAccountOperations", 
			"transfer", "Entering");


		/*************************************/
		/* ADDING LOGGIN BY HAND: EXCEPTIONS */
		/*************************************/
		try {
			
			// Deducts the amount from the 'from' account
			from.debit(amount);
			// Adds the amount to the 'to' account
			to.credit(amount);
		
		/*************************************/
		/* ADDING LOGGIN BY HAND: EXCEPTIONS */
		/*************************************/
		} catch (AccountException e) {
			logger.logp(Level.WARNING, "InterAccountOperations", 
				"transfer", "Exception", e);
			throw e;
		}
		
	}
	
}