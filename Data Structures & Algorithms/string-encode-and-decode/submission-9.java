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
        for(int i =0; i< str.length(); ){
            idx = str.indexOf("#",i);
               // 5#nigga5#nigga
               // i i+5
                int length = Integer.parseInt(str.substring(i,idx));
                result.add(str.substring(idx+1,idx+length+1));
                i=length+idx+1;
            }
            return result;
        }
        
}

