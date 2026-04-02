class Solution {

    public String encode(List<String> strs) {
        String result = "";
        for(String str : strs){
            result+=(str+"#");
        }
        return result;
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int idx=0;
        for(int i =0; i< str.length(); i++){
            idx = str.indexOf("#",i);
               
                result.add(str.substring(i,idx));
                i=idx;
            }
            return result;
        }
        
}

