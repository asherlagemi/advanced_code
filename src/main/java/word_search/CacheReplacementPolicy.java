package word_search;

public interface CacheReplacementPolicy{
	void add(String word);
	String remove(); 
}
