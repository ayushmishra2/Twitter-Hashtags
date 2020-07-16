package service;

import java.util.List;

import entity.Tweet;

public interface HashTagService {

	void putHashTagInMap(Tweet t);
	List<String> topNTrendingHashTags(int n);
	Boolean checkIfTweetContainsHashTag(Tweet t);
}
