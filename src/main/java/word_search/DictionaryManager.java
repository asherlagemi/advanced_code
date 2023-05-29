package word_search;

import java.util.HashMap;

public class DictionaryManager {

	//private static DictionaryManager instance;	//DictionaryManager singleton
	private HashMap<String,Dictionary> map;	//each book gets its own dictionary
	
	private DictionaryManager() {
		this.map = new HashMap<>();
	}
	
	public int getSize() {
		return map.size();
	}
	
	public static DictionaryManager get() {
		return new DictionaryManager();
	}
	
	public void closeMap(){	//close all the unclosed threads from the searcher in the Dictionary class
        for(Dictionary dict: map.values()) {
            dict.close();
        }
    }
	
	public boolean query(String...args) {
		boolean flag = false;	//raise it if query found in a book, but still search all books
		for(int i=0; i<args.length-1; i++) {	//the last string in the array is the query word
			if(!map.containsKey(args[i])) {	//if book not in dictionary
				map.put(args[i], new Dictionary(args[i]));
			}
			if(map.get(args[i]).query(args[args.length-1])) {
				flag = true;
				//map.get(args[i]).close();
			}
		}
		return flag;
	}
	
	public boolean challenge(String...args) {
		boolean flag = false;	//raise it if query found in a book, but still search all books
		for(int i=0; i<args.length-1; i++) {	//the last string in the array is the challenge word
			if(!map.containsKey(args[i])) {	//if book not in dictionary
				map.put(args[i], new Dictionary(args[i]));
			}
			if(map.get(args[i]).challenge(args[args.length-1])) {
				flag = true;
				//map.get(args[i]).close();
			}
		}
		return flag;
	}	
}
