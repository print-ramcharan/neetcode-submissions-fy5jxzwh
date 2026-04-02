class Solution {
    public int countSubstrings(String s) {
        // int length = s.length();
        // int count = 0;
        // if(length % 2 == 0){
        //     return length;
        // }else{
        //     int mid = length / 2;
        //     int l = mid - 1, r = mid + 1;
        //     count = 1;
        //     while(l >= 0 && r <= length){
        //         if(s.charAt(l) == s.charAt(r)){
        //             count ++;
        //             l --;
        //             r ++;
        //         }else{
        //             count += 2;
        //         }
        //     }
        // }
        // return count;

        int length = s.length();
        int count = 0;
        for(int i = 0; i < length ; i ++){
            count ++;
            int left = i - 1, right = i + 1;
            while(left >= 0 || right <= length - 1){
                if(left >= 0 && right <= length - 1){
                    if(s.charAt(left) == s.charAt(right)){
                        count ++;
                        left --;
                        right ++;
                        
                    }
                }
                if((left >= 0 && s.charAt(i) == s.charAt(left)) || (right <= length - 1 &&s.charAt(i) == s.charAt(right))){
                    count ++;
                    break;
                }else{
                    break;
                }
            }
        }
        return count;
    }
}
