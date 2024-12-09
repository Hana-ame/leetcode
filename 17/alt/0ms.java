

class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<String>();
        if(digits == null || digits.length() == 0) return result;
        
        String[] mapping = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        letterCombinations(digits, result, mapping, new StringBuffer(), 0);
        
        return result;
    }
    
    private void letterCombinations(String digits, List<String> result, String[] mapping, StringBuffer buffer, int index){
        if(index == digits.length()){
            result.add(buffer.toString());
            return;
        }
        String letters = mapping[digits.charAt(index)-'0'];
        
        for(int i=0; i<letters.length(); i++){
            buffer.append(letters.charAt(i));
            letterCombinations(digits, result, mapping, buffer, index+1);
            buffer.setLength(buffer.length()-1);
        }
    }
    
//      public List<String> letterCombinations(String digits) {
//         LinkedList<String> result = new LinkedList<String>();
//         if(digits == null || digits.length() == 0) return result;
        
//         String[] mapping = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
//          result.add("");
         
//          for(int i=0; i<digits.length(); i++){
//              String letters = mapping[digits.charAt(i)-'0'];
//              while(!result.isEmpty() && result.peek().length() == i){
//                  StringBuffer buffer = new StringBuffer();
//                      buffer.append(result.remove());
//                  for(int j=0; j<letters.length(); j++){
//                      buffer.append(letters.charAt(j));
//                      result.add(buffer.toString());
//                      buffer.setLength(buffer.length()-1);
//                  }
//              }
//          }
         
//         return result;
//     }
}
