import java.util.LinkedList;
import java.util.List;

public class Search {
  Dictionary dictionary;
  List<String> found;
  
  public Search(Dictionary dictionary) {
    this.dictionary = dictionary;
    this.found = new LinkedList<String>();
  }

  public void addChar(char c) {
    if (!dictionary.data.containsKey(c)) return;
    LinkedList<Dictionary.Entry> modifiedEntries = new LinkedList<>();
    for (Dictionary.Entry entry : dictionary.data.get(c)) {
      if (entry.matches + 1 == entry.word.length()) {
        found.add(entry.word);
      } else {
        modifiedEntries.add(entry);
      }
    }
    dictionary.data.remove(c);
    for (Dictionary.Entry entry : modifiedEntries) {
      entry.matches += 1;
      char key = entry.word.charAt(entry.matches);
      dictionary.addEntry(key, entry);
    }
  }
}