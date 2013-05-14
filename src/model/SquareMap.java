package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SquareMap {
	Map<PointInfo, List<PointInfo>> pointInfoMap = new HashMap<PointInfo, List<PointInfo>>();

	public void addPointInfoDetail(PointInfo key, PointInfo infoDetail){
		List<PointInfo> infoDetails = pointInfoMap.get(key);
		if(infoDetails == null){
			infoDetails = new ArrayList<PointInfo>();
		}
		infoDetails.add(infoDetail);
		pointInfoMap.put(key, infoDetails);
	}
	
	public List<PointInfo> getInfoDetails(PointInfo key){
		return pointInfoMap.get(key);
	}
	
	public Set<PointInfo> getAllPointInfoKeys(){
		return pointInfoMap.keySet();
	}
	
	public List<String> getPointListToString(PointInfo key) {
		List<String> values = new ArrayList<String>();
		for (PointInfo pointInfo : pointInfoMap.get(key)){
			values.add(pointInfo.toString());
		}
		return values;
	}
	
}
