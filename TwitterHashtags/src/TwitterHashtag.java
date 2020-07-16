import java.util.List;
import java.util.Scanner;

import entity.Tweet;
import service.HashTagService;
import service.PrintService;
import serviceImpl.HashTagServiceImpl;
import serviceImpl.PrintServiceImpl;

public class TwitterHashtag {

	public static void main(String []args) {
		
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the number of tweets to be pushed");
		
		// Getting the count of tweets
		int countOfTweets = s.nextInt(); 
		HashTagService hashTagService = new HashTagServiceImpl();
		PrintService printService = new PrintServiceImpl();
		while(countOfTweets-- >= 0) {
			String message = s.nextLine();
			Tweet tweet = new Tweet(message);
			
			// Checking if the tweet contains any hash tag or not
			if(hashTagService.checkIfTweetContainsHashTag(tweet)) {
				hashTagService.putHashTagInMap(tweet);
			}
		}
		
		System.out.println("Enter number of Trending hash tags required");
		
		// variable for finding the N trending hash tags
		int nTrendingHashTags = s.nextInt();
		
		List<String> trendingHashTags = hashTagService.topNTrendingHashTags(nTrendingHashTags);
		printService.printHashTag(trendingHashTags);
		s.close();
		
	}
}
