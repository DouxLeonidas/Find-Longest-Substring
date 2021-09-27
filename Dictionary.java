import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Dictionary {
  HashMap<Character, LinkedList<Dictionary.Entry>> data;

  public Dictionary(String[] words) {
    this.data = new HashMap<Character, LinkedList<Dictionary.Entry>>();
    
    for (String word : words) {
      if (word.length() == 0) continue;
      addEntry(word.charAt(0), new Dictionary.Entry(word));
    }
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    for (Map.Entry<Character, LinkedList<Entry>> entry : data.entrySet()) {
      sb.append(entry.getKey());
      sb.append(" -> ");
      sb.append(entry.getValue());
      sb.append("\n");
    }
    return sb.toString();
  }

  public void addEntry(char key, Entry entry) {
    LinkedList<Dictionary.Entry> entryList;
    entryList = data.getOrDefault(key, new LinkedList<>());
    entryList.add(entry);
    data.put(key, entryList);
  }

  public class Entry {
    String word;
    int matches;
    
    public Entry(String word) {
      this.word = word;
      matches = 0;
    }

    @Override
    public String toString() {
      return "(" + word + ", " + matches + ")";
    }
  }
}
