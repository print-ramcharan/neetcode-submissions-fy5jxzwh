class Solution {

    public String encode(List<String> strs) {
        String result = "";
        for(String str : strs){
            result+=(str+"_");
        }
        return result;
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int idx=0;
        for(int i =0; i< str.length(); i++){
            idx = str.indexOf("_",i);
               
                result.add(str.substring(i,idx));
                i=idx;
            }
            return result;
        }
        
}

