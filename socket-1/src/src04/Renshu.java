public class Renshu {
    
    // xを2倍にして返す関数
    public int doubleValue(int x) {
        return x * 2;
    }
        
    // 1からnまでの整数の合計値を返す
    public int sumUpToN(int n) {
        int result = 0;
        for(int i = 0; i <= n; i++){
            result += i;
        }
        return result;
    }

    //pからqまでの整数の合計値を返す
    public int sumFromPtoQ(int p, int q) {
        if(p > q) {    //p>qの場合,-1を返す
            return -1;
        }
        int result = 0;
        for(int i = p; i <= q; i++) {
            result += i;
        }
        return result;
    }

    //配列 a[] の指定された index から以降の要素の合計値を返す。不正な index の場合は -1 を返す。
    public int sumFromArrayIndex(int[] a, int index) {
        if(a.length <= index){   //配列aの長さよりindexが大きい場合,-1を返す
            return -1;
        }
        int result = 0;
        for(int i = index; i < a.length; i++) {
            result += a[i];
        }
        return result;
    }

    //配列 a の中で最大の値を返す。
    public int selectMaxValue(int[] a) {
        int result = a[0];
        for(int i = 0; i < a.length; i++) {
            if(result < a[i]){
                result = a[i];
            }
        }
        return result;
    }

    //配列 a の中で最小の値を返す。
    public int selectMinValue(int[] a) {
        int result = a[0];
        for(int i = 0; i < a.length; i++) {
            if(result > a[i]){
                result = a[i];
            }
        }
        return result;
    }

    //配列 a の中で最大の値が入っている要素の位置（index）を返す。最大値が複数の場合は最小のindexを返す。
    public int selectMaxIndex(int[] a) {
        int maxValue = selectMaxValue(a);
        int minValue = selectMinValue(a);
        int indexCount = 0;
        int maxValueIndex = 0;
        int minValueIndex = 0;
        for(int i = 0; i<a.length; i++){
            if(a[i] == maxValue){
                maxValueIndex = i;
                indexCount ++;
            }
            if(a[i] == minValue){
                minValueIndex = i;
            }
        }
        if(indexCount == 1){
            return maxValueIndex;
        }else{
            return minValueIndex;
        }
    }

    //配列 a の中で最小の値が入っている要素の位置（index）を返す。
    public int selectMinIndex(int[] a) {
        int minValue = selectMinValue(a);
        int minValueIndex = 0;
        for(int i = 0 ; i < a.length; i++) {
            if(a[i] == minValue){
                minValueIndex = i;
                break;
            }
        }
        return minValueIndex;
    }

    //配列 p の i 番目と j 番目の要素を入れ替える。
    public void swapArrayElements(int[] p, int i, int j){
        int moveValue = p[i];
        p[i] = p[j];
        p[j] = moveValue;
    }

    //同じ長さの二つの配列 a と b の内容を入れ替える。
    public boolean swapTwoArrays(int[] a,int[] b){
        if(a.length != b.length){
            return false;
        }
        
        int[] swapArrays = new int[a.length];
        for(int i = 0; i < a.length ; i++){
            swapArrays[i] = a[i];
            a[i] = b[i];
            b[i] = swapArrays[i];
        }
        return true;
    }
    //ここに続きを実装していく。
}
