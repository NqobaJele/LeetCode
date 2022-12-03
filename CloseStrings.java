import java.util.*;

class Solution {
    
    public boolean operation1(String word1, String word2){
        
        ArrayList<Character> s1 = new ArrayList<Character>();
        ArrayList<Character> s2 = new ArrayList<Character>();

        for(int i =0 ;i<word1.length();i++){
            s1.add(word1.charAt(i));
        }
                
        for(int j =0 ;j<word2.length();j++){
            s2.add(word2.charAt(j));
        }
        
        
        Collections.sort(s1);
        Collections.sort(s2);
        
        return s1.equals(s2);
        
    }
     
    
    public boolean operation2(String word1, String word2){
    
        ArrayList<String> words=new ArrayList<String>();
        words.add(word1);
        words.add(word2);
        ArrayList<ArrayList<Integer>>  occurenciesBag = new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Character>>  uniqueCharsBag = new ArrayList<ArrayList<Character>>();
     
        for(String word : words){
            ArrayList<Integer>  occurs = new ArrayList<Integer>();
            ArrayList<Character>  uniqueChars = new ArrayList<Character>();
            // Creating a HashMap containing char
            // as a key and occurrences as a value
            HashMap<Character, Integer> charCountMap
                = new HashMap<Character, Integer>();

            // Converting given string to char array

            char[] strArray = word.toCharArray();

            // checking each char of strArray
            for (char c : strArray) {
                if (charCountMap.containsKey(c)) {

                    // If char is present in charCountMap,
                    // incrementing it's count by 1
                    charCountMap.put(c, charCountMap.get(c) + 1);
                }
                else {

                    // If char is not present in charCountMap,
                    // putting this char to charCountMap with 1 as it's value
                    charCountMap.put(c, 1);
                }
            }

            // Printing the charCountMap
            for (Map.Entry entry : charCountMap.entrySet()) {
                System.out.println(entry.getKey() + " " + entry.getValue());
                
                int x = (Integer)entry.getValue();
                char c = (Character)entry.getKey();
                occurs.add(x);
                uniqueChars.add(c);
                
            }
                    
            Collections.sort(occurs);
            occurenciesBag.add(occurs);
            
            Collections.sort(uniqueChars);
            uniqueCharsBag.add(uniqueChars);
        }

  
        return occurenciesBag.get(0).equals(occurenciesBag.get(1)) &                    uniqueCharsBag.get(0).equals(uniqueCharsBag.get(1));
       
        
    }
    
    public boolean closeStrings(String word1, String word2) {
        
        return  operation1(word1,word2) || operation2(word1,word2);
        
    }
}
