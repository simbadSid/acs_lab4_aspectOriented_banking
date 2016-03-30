package banking;

/**********************************/
/* ADDING LOGGIN BY HAND: METHODS */
/**********************************/
import org.apache.log4j.Logger;


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
	static Logger log = Logger.getLogger(SimpleAccountImpl.class);
		
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
		log.info("Entering SimpleAccountImpl.getAccountNumber");
		
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
		log.info("Entering SimpleAccountImpl.getBalance");
		
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
		log.info("Entering SimpleAccountImpl.setBalance");

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
		log.info("Entering SimpleAccountImpl.credit");


		/*************************************/
		/* ADDING LOGGIN BY HAND: EXCEPTIONS */
		/*************************************/
		try {
			
			setBalance(getBalance() + amount);
		
		/*************************************/
		/* ADDING LOGGIN BY HAND: EXCEPTIONS */
		/*************************************/
		} catch (AccountException e) {
			log.warn("Exception",e);
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
		log.info("Entering SimpleAccountImpl.debit");


		/*************************************/
		/* ADDING LOGGIN BY HAND: EXCEPTIONS */
		/*************************************/
		try {
			
			float balance = getBalance();
			
			if (balance < amount)
			{
				log.error("Error",new InsufficientBalanceException("Total balance not sufficient"));
			}
			else
			{
				setBalance(balance - amount);
			}
		
		/*************************************/
		/* ADDING LOGGIN BY HAND: EXCEPTIONS */
		/*************************************/
		} catch (AccountException e) {
			log.warn("Exception",e);
		}
		
	}
	
}