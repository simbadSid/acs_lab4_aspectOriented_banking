package testHandCodedMethod2.banking;

/**********************************/
/* ADDING LOGGIN BY HAND: METHODS */
/**********************************/
import java.util.logging.Logger;
import java.util.logging.Level;

/**
 *  A simple banking SimpleAccountImpl class.
 *
 *@author     <a href="mailto:Sara.Bouchenak@inria.fr">Sara Bouchenak</a>
 *@version    1.0 - 13/01/2004
 */
public class SimpleAccountImpl
	implements Account {
		
	/**********************************/
	/* ADDING LOGGIN BY HAND: METHODS */
	/**********************************/
	static Logger logger = Logger.getLogger("trace");
		
	/**
	 * The account number.
	 */
	private	int 	accountNumber;
	
	/**
	 * The account balance.
	 */
	private	float	accountBalance;
	
	/**
	 * Constructs an <code>SimpleAccountImpl</code> with the specified number.
	 * 
	 * @param	number	The account number
	 * @param	balance The initial balance
	 */
	public SimpleAccountImpl(int number, float balance)
	{
		this.accountNumber	= number;
		this.accountBalance	= balance;
	}
	
	/**
	 * Returns the number of this account.
	 * 
	 * @return 	The account number.
	 */
	public int getAccountNumber()
	{
		
		/**********************************/
		/* ADDING LOGGIN BY HAND: METHODS */
		/**********************************/
		logger.logp(Level.INFO, "SimpleAccountImpl", 
			"getAccountNumber", "Entering");
		
		return accountNumber;
	}
	
	/**
	 * Returns the current balance of this account.
	 * 
	 * @return	The account balance.
	 * @throws	AccountException	If a problem occurs during
	 * this operation, e.g., a problem to access the underlying
	 * database if any.
	 */
	public float getBalance()
		throws AccountException
	{

		/**********************************/
		/* ADDING LOGGIN BY HAND: METHODS */
		/**********************************/
		logger.logp(Level.INFO, "SimpleAccountImpl", 
			"getBalance", "Entering");
		
		return accountBalance;
	}
	
	/**
	 * Sets the balance of this account.
	 * 
	 * @param amount	The balance to be set
	 * @throws	AccountException	If a problem occurs during
	 * this operation, e.g., a problem when updating the underlying
	 * database if any.
	 */
	public void setBalance(float amount)
		throws AccountException
	{

		/**********************************/
		/* ADDING LOGGIN BY HAND: METHODS */
		/**********************************/
		logger.logp(Level.INFO, "SimpleAccountImpl", 
			"setBalance", "Entering");

		accountBalance = amount;
	}
	
	/**
	 * Adds an amount to the current balance of this account.
	 * 
	 * @param 	amount	The amount to add.
	 * @throws	AccountException	If a problem occurs during
	 * this operation, e.g., a problem when accessing/updating 
	 * the underlying database if any.
	 */
	public void credit(float amount)
		throws AccountException
	{

		/**********************************/
		/* ADDING LOGGIN BY HAND: METHODS */
		/**********************************/
		logger.logp(Level.INFO, "SimpleAccountImpl", 
			"credit", "Entering");


		/*************************************/
		/* ADDING LOGGIN BY HAND: EXCEPTIONS */
		/*************************************/
		try {
			
			setBalance(getBalance() + amount);
		
		/*************************************/
		/* ADDING LOGGIN BY HAND: EXCEPTIONS */
		/*************************************/
		} catch (AccountException e) {
			logger.logp(Level.WARNING, "SimpleAccountImpl", 
				"credit", "Exception", e);
			throw e;
		}
		
	}
	
	/**
	 * Deducts an amount from the current balance of this account.
	 * 
	 * @param 	amount				The amount to be deducted.
	 * @throws 	AccountException	In case the amount to deduct 
	 * is greater than the current balance, or if a problem occurs 
	 * when querying/updating the underlying database if any.
	 */
	public void debit(float amount)
		throws AccountException
	{

		/**********************************/
		/* ADDING LOGGIN BY HAND: METHODS */
		/**********************************/
		logger.logp(Level.INFO, "SimpleAccountImpl", 
			"debit", "Entering");


		/*************************************/
		/* ADDING LOGGIN BY HAND: EXCEPTIONS */
		/*************************************/
		try {
			
			float balance = getBalance();
			
			if (balance < amount)
			{
				throw (new InsufficientBalanceException("Total balance not sufficient"));
			}
			else
			{
				setBalance(balance - amount);
			}
		
		/*************************************/
		/* ADDING LOGGIN BY HAND: EXCEPTIONS */
		/*************************************/
		} catch (AccountException e) {
			logger.logp(Level.WARNING, "SimpleAccountImpl", 
			"debit", "Exception", e);
			throw e;
		}
		
	}
	
}