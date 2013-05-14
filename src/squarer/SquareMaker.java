package squarer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import util.Constants;
import util.Utility;

import model.PointInfo;
import model.SquareMap;

import datahandler.DBHandler;

public class SquareMaker {

	public static void main(String args[]) {

		DBHandler dataHandler = new DBHandler();
		for (int limit = 0; limit < Constants.DB_POINT_COUNT; ) {
			int start = limit;
			List<PointInfo> pointInfoCollection = dataHandler.getAllPoints("select latitude,longitude from point limit "+start+","+Constants.LOOP_COUNTER);
			System.out.println("Start="+start+" ,end="+Constants.LOOP_COUNTER+",size="+pointInfoCollection.size());
			SquareMap squareMap = squarifyThePoints(pointInfoCollection);
			for (PointInfo key : squareMap.getAllPointInfoKeys()) {
				Utility.appendDataToFile(Constants.POINTS_FILE + key.toString(), squareMap.getPointListToString(key));
			}
			limit += Constants.LOOP_COUNTER;
			System.out.println("File written");
		}
		
	}

	private static SquareMap squarifyThePoints(List<PointInfo> pointInfoCollection) {
		SquareMap squareMap = new SquareMap();
		for (PointInfo searchPoint : pointInfoCollection) {
			boolean notAdded = true;
			for (PointInfo key : squareMap.getAllPointInfoKeys()) {
				if (isPresentInThisSquare(key, searchPoint)) {
					squareMap.addPointInfoDetail(key, searchPoint);
					notAdded = false;
					break;
				}
			}
			if (notAdded) {
				squareMap.addPointInfoDetail(searchPoint, searchPoint);
			}
		}
		return squareMap;
	}

	private static boolean isPresentInThisSquare(PointInfo key, PointInfo searchPoint) {
		int key_lat = key.getLatitudeWoDec();
		int key_longt = key.getLongitudeWoDec();
		int searchPoint_lat = searchPoint.getLatitudeWoDec();
		int searchPoint_long = searchPoint.getLongitudeWoDec();		
		if( (searchPoint_long<=key_longt+Constants.SQUARE_SIDE && searchPoint_long>=key_longt) &&
				(searchPoint_lat<=key_lat+Constants.SQUARE_SIDE && searchPoint_lat>=key.getLongitude()) ){
			return true;
		}
		
		if( (searchPoint_lat<=key_lat+Constants.SQUARE_SIDE && searchPoint_lat>=key_lat) &&
				(searchPoint_long<=key_longt+Constants.SQUARE_SIDE && searchPoint_long>=key_longt) ){
			return true;
		}
		return false;
	}
}
