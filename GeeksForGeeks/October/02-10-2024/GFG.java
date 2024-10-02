class Solution {
    public static int rotateDelete(ArrayList<Integer> arr) {
        int k=1;
        while(arr.size()>1){
            arr.add(0,arr.get(arr.size()-1));
            arr.remove(arr.size()-1);
            arr.remove(arr.size()-k);
            k++;
            if(k>arr.size()){
                break;
            }
        }
        return arr.get(0);
    }
}
