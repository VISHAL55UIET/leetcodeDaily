import java.util.Stack;
/********************************************************************************************** */



  






/************************************************************************************************** */
public class HappyString {
    public String getHappyString(int n, int k) {
        Stack<String>st= new Stack<>();
        int idx = 0;
        st.push("");
        while(!st.isEmpty()){
         String str  = st.pop();
         if(str.length()==n){
            idx++;
            if(idx==k){
                return str;
            }
            continue;
         }
            for (char ch = 'c'; ch >= 'a'; ch--) {
                // Avoid consecutive identical characters
                if (str.length() == 0 || str.charAt(str.length() - 1) != ch) {
                    st.push(str + ch);
                }
            }
        }
        return "";
    }
}
