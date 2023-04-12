class Solution {
    public String toBinary(int n1, int n2, int size){
        String result = "";
        String zero = "0";
        String n1binary = Integer.toBinaryString(n1);
        String n2binary = Integer.toBinaryString(n2);
        if(n1binary.length() < size)
            n1binary = zero.repeat(size-n1binary.length()) + n1binary;
        if(n2binary.length() < size)
            n2binary = zero.repeat(size-n2binary.length()) + n2binary;
        
        for(int i = 0; i < size; i++){
            String tmp = (n1binary.charAt(i) == '0' && n2binary.charAt(i) == '0')? " " : "#";
            result += tmp;
        }
        
        return result;
    }
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for(int i = 0; i < n; i++)
            answer[i] = toBinary(arr1[i], arr2[i], n);
        return answer;
    }
}