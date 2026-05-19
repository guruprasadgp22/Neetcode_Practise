class Solution {
   public static List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
		Map<String, TreeMap<Integer, String>> userTimeWeb = new HashMap<>();
		
		for(int i=0;i<username.length;i++) {
			if(!userTimeWeb.containsKey(username[i])) {
				userTimeWeb.put(username[i], new TreeMap<>());
			}
			
			TreeMap<Integer, String> timeWebSite = userTimeWeb.get(username[i]);
			timeWebSite.put(timestamp[i], website[i]);
			userTimeWeb.put(username[i], timeWebSite);
		}
		
//		Printing userTImeWeb
		for(Map.Entry<String, TreeMap<Integer, String>> entry: userTimeWeb.entrySet()) {
			System.out.println(entry.getKey() + ": ");
			TreeMap<Integer, String> value = entry.getValue();
			for(Map.Entry<Integer,String> entries: value.entrySet()) {
				System.out.println(entries.getKey() + " -> " + entries.getValue());
			}
		}
		
//		
		
		Map<String,Integer> sequenceMap = new HashMap<>();
		for(String user: userTimeWeb.keySet()) {
			TreeMap<Integer, String> timeStampWebSite = userTimeWeb.get(user);
			
			if(timeStampWebSite.size() < 3) {
				continue;
			} else  {
				List<Integer> timeStamps = new ArrayList<>();
				for(int num: timeStampWebSite.keySet()) {
					timeStamps.add(num);
				}
				
				List<String> allSeq = getAllSequ(timeStamps, timeStampWebSite);
				Set<String> visited = new HashSet<>();
				for(String s: allSeq) {
					if(visited.add(s)) {
						sequenceMap.put(s, sequenceMap.getOrDefault(s, 0)+1);
					}
				}
				
				for(String str: allSeq) {
					System.out.print(str + " ");
				}
				System.out.println();
				
				for(String str: visited) {
					System.out.print(str + " ");
				}
				System.out.println();
			}
//			TimeStamp Website
			for(Map.Entry<Integer, String> entry: timeStampWebSite.entrySet()) {
				System.out.println(entry.getKey() + " : " + entry.getValue());
			}
		}
		
//		Sequence
		for(Map.Entry<String, Integer> entry: sequenceMap.entrySet()) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
		
		int count = 0;
		String ans = "";
		
		for(String str: sequenceMap.keySet()) {
			if(sequenceMap.get(str) > count) {
				count = sequenceMap.get(str);
				ans = str;
			} else if(sequenceMap.get(str) == count){
				if(str.compareTo(ans) < 0) {
					ans = str;
				}
			}
		}
		
		List<String> finalResult = new ArrayList<>();
		for(String key: ans.split(" ")) {
			finalResult.add(key);
		}
		
		return finalResult;
	}
	
	private static List<String> getAllSequ(List<Integer> time, TreeMap<Integer, String> timeWeb) {
		List<String> result = new ArrayList<>();
		
		for(int i=0;i<time.size()-2;i++) {
			for(int j=i+1;j<time.size()-1;j++) {
				for(int k=j+1;k<time.size();k++) {
					result.add(
					timeWeb.get(time.get(i)) + " " +
					timeWeb.get(time.get(j)) + " " +
					timeWeb.get(time.get(k))
							);
				}
			}
		}
		
		return result;
	}
}