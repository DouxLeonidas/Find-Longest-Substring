class Main {
  public static void main(String[] args) {
    System.out.println("Find the longest substring");
    Solution solution = new Solution();
    String searchingTerm = "abppplee";
    String[] dictionary = {"able", "ale", "apple", "bale", "kangaroo"};
    String sol = solution.findLongestSubstring(searchingTerm, dictionary);
    System.out.println(sol);
  }
}