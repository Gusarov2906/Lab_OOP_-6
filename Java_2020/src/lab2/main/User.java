package lab2.main;

/**
 * Class User - class with user information.
 * @author gusarov2906
 *
 */

public class User {
	private String password;
	private String login;
	private Group group;
	
	/**
	 * Default constructor
	 * @param log - login of user.
	 * @param pas - password of user.
	 * @param gr - group of user.
	 */
	
	public User(String log, String pas, Group gr)
	{
		this.setLogin(log);
		this.password = pas;
		this.group = gr;
	}
	
	/**
	 * getPassword - getter for field "password".
	 * @return - returns field "password".
	 */
	
	String getPassword()
	{
		return this.password;
	}
	
	/**
	 * getGroup - getter for field "group".
	 * @return - returns field "group".
	 */
	
	Group getGroup()
	{
		return this.group;
	}
	
	/**
	 * getLogin - getter for field "login".
	 * @return - returns field "login".
	 */

	public String getLogin() {
		return login;
	}
	
	/**
	 * setLogin - setter for filed "login".
	 * @param login - set filed "login".
	 */
	public void setLogin(String login) {
		this.login = login;
	}
	
}
