package recursion;

public class PrintRecursion {
    public static void main(String[] args) {
      recursion("I love Recursion", 3, 0);
    }

    public static void recursion(String str , int target , int count){
        if(count >= target){
            return ;
        }
    System.out.println(str);
     recursion(str, target, count + 1);
    }
}
