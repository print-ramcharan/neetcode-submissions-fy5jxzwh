// class Solution {

//     public String encode(List<String> strs) {
//         StringBuilder encoded = new StringBuilder();

//         for(String str : strs){
//             encoded.append(str.length()).append("#").append(str);
//         }
//         return encoded.toString();
//     }

//     // public List<String> decode(String str) {
//     //     List<String> decode = new ArrayList<>();
//     //     int i = 0;
//     //     while(i < str.length()){
//     //         int j = i;

//     //         while(str.charAt(j) != '#' && j < str.length()) j++;
//     //         int length = Integer.parseInt(str.substring(i,j));
//     //         int start = j+1;
//     //         String word = str.substring(start,start+length);
//     //         decode.add(word);
//     //     }
//     //     return decode;
//     // }
//     public List<String> decode(String str) {
//     List<String> decode = new ArrayList<>();
//     int i = 0;
//     while (i < str.length()) {
//         int j = i;
//         while (j < str.length() && str.charAt(j) != '#') {
//             j++;
//         }
//         if (j == str.length()) break; // sanity check in case of malformed input
//         int length = Integer.parseInt(str.substring(i, j));
//         int start = j + 1;
//         int end = start + length;
//         if (end > str.length()) break; // sanity check for bounds
//         String word = str.substring(start, end);
//         decode.add(word);
//         i = end;
//     }
//     return decode;
// }

// }
class Solution {

    public String encode(List<String> strs) {
        String result = "";
        for(String str : strs){
            result+=(str.length()+"#"+str);
        }
        return result;
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int idx=0;
        // for(int i =0; i< str.length(); ){
        //     idx = str.indexOf("#",i);
        //        // 5#nigga5#nigga
        //        // i i+5
        //         int length = Integer.parseInt(str.substring(i,idx));
        //         result.add(str.substring(idx+1,idx+length+1));
        //         i=length+idx+1;
        //     }
        //     return result;
        // }
        for(int i = 0; i < str.length(); ){
            idx = str.indexOf('#',i);
            int length = Integer.parseInt(str.substring(i,idx));
            result.add(str.substring(idx+1,idx+length+1));
            i = length+idx+1;
        }
        return result;
    }
}

