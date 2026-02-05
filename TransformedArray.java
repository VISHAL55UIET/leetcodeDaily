import java.util.*;
/************************************************************************************************* */


   // T.C=O(N);

   //S.C=O(1)






/************************************************************************************************ */
public class TransformedArray {
  public int[] constructTransformedArray(int[] arr) {
        int z = arr.length;
        int []result = new int[z]; 
        for(int i = 0;i<z;i++){
            if(arr[i]==0){
            result[i]=arr[i];
            } else{
               int newIdx = (i+arr[i])%z;
               if(newIdx<0) newIdx+=z;
                result[i]=arr[newIdx];
            }
      }
        return result;
    }
}





/***********************************************************************************************8 */