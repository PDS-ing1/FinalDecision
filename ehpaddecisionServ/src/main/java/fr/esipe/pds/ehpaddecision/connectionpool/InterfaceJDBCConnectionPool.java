package fr.esipe.pds.ehpaddecision.connectionpool;
import java.sql.Connection;
import java.sql.SQLException;

public interface InterfaceJDBCConnectionPool { 
	public void fillConnectionsList() throws SQLException;
	
	
	/**
	 * 
	 * @return a connections of the connections attribute
	 * @throws Exception when there are no connections left
	 */
	public Connection getConnection() throws Exception;
	
	
	/**
	 * puts the parameter of type Connection inside the connections attribute
	 * 
	 * @param connection
	 */
	public void putConnection(Connection connection);
	
	
	/**
	 * Closes all connections of the connections attributes
	 */
	public void closeAllConnections();

}
