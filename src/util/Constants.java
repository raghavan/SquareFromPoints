package util;

public interface Constants {
	// DB props
	String dbDriver = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://localhost:8889/PathFinder";
	String username = "root";
	String password = "root";

	//File
	String POINTS_FILE = "files/pointinfos/";

	// Symbols
	String QUOTE = "\"";
	String COMMA = ",";
	String AND = " and ";

	// Config
	int SQUARE_SIDE = 20;
	int DB_POINT_COUNT = 3650348;
	int LOOP_COUNTER = 16000;
	
}
