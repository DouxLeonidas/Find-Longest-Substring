import java.util.Collections;

public class Solution {
  public String findLongestSubstring(String searchingTerm, String[] words) {
    Dictionary dictionary = new Dictionary(words);
    Search mySearch = new Search(dictionary);
    for (char c : searchingTerm.toCharArray()) {
      mySearch.addChar(c);
      System.out.println("Adding " + c);
      System.out.println(mySearch.dictionary);
      System.out.println("Result: " + mySearch.found);
    }

    if (mySearch.found.isEmpty()) return "No words found";
    Collections.sort(mySearch.found,
                      (a, b) -> b.length() - a.length());
    return mySearch.found.get(0);
  }
}