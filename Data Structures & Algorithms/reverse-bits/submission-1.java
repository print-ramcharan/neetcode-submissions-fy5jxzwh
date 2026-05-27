class Solution {
    public int reverseBits(int n) {
        n = (n >>> 16) | (n << 16);
        
        n = ((n >>> 8) & 0x00FF00FF) | ((n << 8) & 0xFF00FF00);
        
        n = ((n >>> 4) & 0x0F0F0F0F) | ((n << 4) & 0xF0F0F0F0);
        
        n = ((n >>> 2) & 0x33333333) | ((n << 2) & 0xCCCCCCCC);
        
        n = ((n >>> 1) & 0x55555555) | ((n << 1) & 0xAAAAAAAA);
        
        return n;
    }
}