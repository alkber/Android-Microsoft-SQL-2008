/**
 * 
 */
package com.alkber.androidmssql2008.listeners;

/**
 * Any class that wants to use Dao class must implement this interface
 * 
 * @author Althaf K Backer <althafkbacker@gmail.com>
 *
 */
public interface DBConnectionListener {
	
	/**
	 * Verbose information during the connnection progress
	 * @param status status information of the connection
	 */
	void onConnectionStatusInfo(String status);
	/**
	 * Called when connection was successful
	 */
	void onConnectionSuccessful();
	/**
	 * Called when connection failed
	 */
	void onConnectionFailed();
	
}
