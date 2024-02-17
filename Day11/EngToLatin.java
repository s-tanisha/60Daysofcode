package Day11;

import java.util.*;

public class EngToLatin {
    public static boolean isU(char u, char first){
        if(first == 'q'){
            return false;
        }
        return true;
    }
    public static boolean isVowel(char alpha){
        
        if(alpha =='a' || alpha =='e' || alpha =='i' || alpha =='o' ){
            if(alpha == 'u'){

            }
            return true;
        }
    
        return false;
    }
    public static String ItsConsonant(String str){
        StringBuilder newstr = new StringBuilder();
        char c[]= new char[str.length()+1];
        int idx=0;
       
        for(int i=0; i<str.length(); i++){
            if(isVowel(str.charAt(i)) && isU(str.charAt(i), str.charAt(i-1))){
                
                for(int j=i; j<str.length(); j++){
                    newstr.append(str.charAt(j));
                }
                break;
            }else{
                c[idx]= str.charAt(i);
                idx++;
            }
        }
        for(char s: c){
            newstr.append(s);
        }
        
        newstr.append("ay");
        return newstr.toString();
    }
    public static String ItsVowel(String str){
        StringBuilder newstr = new StringBuilder();
        for(int i=0; i<str.length(); i++){
            newstr.append(str.charAt(i));
        }
        newstr.append("yay");
        return newstr.toString();
    }
  
    public static String EngToPiglatin(String str){
        String newstr="";
        if(str.length()==1){
            return str;
        }
        char fL= str.charAt(0);
        char sL = str.charAt(1);
        if(isVowel(fL)){
            if(fL == 'u' && (sL =='q')){
                newstr = ItsConsonant(str);
            }
            newstr=ItsVowel(str);
        }else if(fL =='y' && (sL != 'a' && sL !='e' && sL !='i'&& sL !='o' && sL !='u')){
            newstr = ItsVowel(str);
        }else{
            newstr = ItsConsonant(str);
        }


        return newstr;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the String to convert");
        String str= sc.nextLine();
       System.out.println( EngToPiglatin(str));
    }
}
