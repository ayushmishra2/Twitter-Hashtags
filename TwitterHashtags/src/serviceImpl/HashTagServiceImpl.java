package serviceImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import entity.Tweet;
import service.HashTagService;


/* HashTag Service is responsible for collecting all the hash tag
 * and storing them in a map and returning the N trending hash tags
 * 
 * */
public class HashTagServiceImpl implements HashTagService {

	private static Map<String, Integer> hashTagCountMap = new HashMap<>();

	
	// Method for storing hash tags in a map
	@Override
	public void putHashTagInMap(Tweet t) {
		// TODO Auto-generated method stub
		String tweet = t.getMessage();
		
		for(int i=0;i<tweet.length();i++) {
			char ch = tweet.charAt(i);
			if(ch == '#') {
				String temp = "";
				i++;
				while(i<tweet.length() && tweet.charAt(i) != ' ') {
					temp = temp + tweet.charAt(i);
					i++;
				}
				hashTagCountMap.put(temp,hashTagCountMap.getOrDefault(temp, 0)+1);
			}
		}
	}

	
	// Method for returning N trending hash tags
	@Override
	public List<String> topNTrendingHashTags(int n) {
		
		List<String> hashTagList = new ArrayList<>(hashTagCountMap.keySet());
		Collections.sort(hashTagList, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				if(hashTagCountMap.get(s1) > hashTagCountMap.get(s2)) {
					return -1;
				}
				else if(hashTagCountMap.get(s1) == hashTagCountMap.get(s2)) {
					return s1.compareTo(s2);
				}
				return 1;
			}
		});
		int size = hashTagList.size();
        return size > 10 ? hashTagList.subList(0, 10) : hashTagList.subList(0, size);
	}

	
	// Method for checking if the tweet contains any hash tag or not
	@Override
	public Boolean checkIfTweetContainsHashTag(Tweet t) {
		// checking if # is present in the tweet
		return t.getMessage().indexOf('#') != -1;
	}

}
