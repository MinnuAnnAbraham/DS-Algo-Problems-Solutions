class Solution {
    void mergeSort(int[] arr, int l, int m, int r){
        int n1 = m-l+1;
        int n2 = r-m;
        int[] L = new int[n1];
        int[] R = new int[n2];
        for(int i = 0 ; i < n1; i++){
            L[i] = arr[l+i];
        }
        for(int j = 0 ; j < n2; j++){
            R[j] = arr[m+1+j];
        }
        int k = l;
        int i = 0, j = 0;
        while(i<n1 && j< n2){
            if(L[i]<=R[j]){
                arr[k] = L[i];
                i++;
            }
            else{
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        while(i<n1){
            arr[k] = L[i];
            k++;
            i++;
        }
        while(j<n2){
            arr[k] = R[j];
            k++;
            j++;
        }
        

    }
    void sort(int[] num, int l, int r){
        if(l<r){
            int m = l+(r-l)/2;
            sort(num, l, m);
            sort(num, m+1, r);
            mergeSort(num, l, m, r);
        }
    }
    public int[] sortArray(int[] num) {
        sort(num,0,num.length-1);
        return num;
    }
}