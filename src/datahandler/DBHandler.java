package datahandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.PointInfo;

import com.mysql.jdbc.exceptions.MySQLSyntaxErrorException;

public class DBHandler {

	private ResultSet getResults(String query, Connection conn) {
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
		} catch (MySQLSyntaxErrorException me) {
			System.out.println("Error in select query =" + query);
		} catch (SQLException e) {
			System.out.println("Error in select query =" + query);
			e.printStackTrace();
		}
		return rs;
	}
	
	private List<PointInfo> makePointInfoFromResultSet(ResultSet results) {
		List<PointInfo> pointInfoCollection = new ArrayList<PointInfo>();
		if (results != null) {
			try {
				while (results.next()) {
					float latitude = results.getFloat("latitude");
					float longitude = results.getFloat("longitude");
					PointInfo pointInfo = new PointInfo();
					pointInfo.setLatitude(latitude);
					pointInfo.setLongitude(longitude);
					pointInfoCollection.add(pointInfo);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					results.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return pointInfoCollection;
	}

	public List<PointInfo> getAllPoints(String query) {
		List<PointInfo> pointInfoCollection = new ArrayList<PointInfo>();
		if (query != null) {
			PreparedStatement ps;
			try {
				ps = DBConnect.getConnection().prepareStatement(query);
				ResultSet results = ps.executeQuery();
				pointInfoCollection = makePointInfoFromResultSet(results);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return pointInfoCollection;
	}

}
