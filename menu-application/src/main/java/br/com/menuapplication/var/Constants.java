package br.com.menuapplication.var;

public class Constants {
	private static final String APPLICATION_USER = "root";
	private static final String APPLICATION_PASSWORD = "x8pdkv19";
	private static final String APPLICATION_DB_NAME = "financeiro";
	private static final String MENU_DB_NAME = "menuapplication";
	
	
	public static String getApplicationUser() {
		return APPLICATION_USER;
	}
	public static String getApplicationPassword() {
		return APPLICATION_PASSWORD;
	}
	public static String getApplicationDbName() {
		return APPLICATION_DB_NAME;
	}
	public static String getMenuDbName() {
		return MENU_DB_NAME;
	}
	/**
	 * Pega ip do banco para configuração
	 * @return
	 */
	public static String getIpDb() {
		return "localhost:3306";
	}
	
	
}
