package serviceImpl;

import java.util.List;

import service.PrintService;

/*
 * Print Service is responsible for performing console operations
 * in consideration with the tweets
 * */
public class PrintServiceImpl implements PrintService {

	// Method for Printing the hash tags 
	@Override
	public void printHashTag(List<String> trendingHashTags) {
		// TODO Auto-generated method stub
		trendingHashTags.forEach(System.out::println);
	}

}
