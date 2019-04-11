package exercise.exercise_0411;

/*
句子反转
题目描述
给定一个句子（只包含字母和空格）， 将句子中的单词位置反转，单词用空格分割,
单词之间只有一个空格，前后没有空格。 比如： （1） “hello xiao mi”-> “mi xiao hello”
输入描述:
输入数据有多组，每组占一行，包含一个句子(句子长度小于1000个字符)
输出描述:
对于每个测试示例，要求输出句子中单词反转后形成的句子
示例1
输入
hello xiao mi
输出
mi xiao hello
 */
/*
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        System.out.println(solution());
    }
    public static String solution(){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] s = str.split(" ");
        String res = "";
        for(int i=s.length-1; i>=0; i--){
            res += s[i];
            if(i != 0){
                res += " ";
            }
        }
        return res;
    }
}*/

/*
geohash编码
题目描述
geohash编码：geohash常用于将二维的经纬度转换为字符串，分为两步：第一步是经纬度的二进制编码，第二步是base32转码。
此题考察纬度的二进制编码：算法对纬度[-90, 90]通过二分法进行无限逼近（取决于所需精度，本题精度为6）。
注意，本题进行二分法逼近过程中只采用向下取整来进行二分，针对二分中间值属于右区间。
算法举例如下： 针对纬度为80进行二进制编码过程：
1) 区间[-90, 90]进行二分为[-90, 0),[0, 90]，成为左右区间，可以确定80为右区间，标记为1；
2) 针对上一步的右区间[0, 90]进行二分为[0, 45),[45, 90]，可以确定80是右区间，标记为1；
3) 针对[45, 90]进行二分为[45, 67),[67,90],可以确定80为右区间，标记为1；
4) 针对[67,90]进行二分为[67, 78),[78,90]，可以确定80为右区间，标记为1；
5) 针对[78, 90]进行二分为[78, 84),[84, 90]，可以确定80为左区间，标记为0；
6) 针对[78, 84)进行二分为[78, 81), [81, 84)，可以确定80为左区间，标记为0；
输入描述:
输入包括一个整数n,(-90 ≤ n ≤ 90)
输出描述:
输出二进制编码
示例1
输入
80
输出
111100
 */

/*
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        System.out.println(solution());
    }
    public static String solution(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String res = "";
        int upper = 90;
        int lower = -90;
        for(int i=0; i<6; i++){
            int mid = (lower+upper)/2;
            if(n >= mid ){//右边
                res += "1";
                lower = mid;
            }else{
                res += "0";
                upper = mid;
            }
        }
        return res;
    }
}*/

/*
两种排序方法
题目描述
考拉有n个字符串字符串，任意两个字符串长度都是不同的。考拉最近学习到有两种字符串的排序方法：
1.根据字符串的字典序排序。例如：
"car" < "carriage" < "cats" < "doggies < "koala"
2.根据字符串的长度排序。例如：
"car" < "cats" < "koala" < "doggies" < "carriage"
考拉想知道自己的这些字符串排列顺序是否满足这两种排序方法，考拉要忙着吃树叶，所以需要你来帮忙验证。
输入描述:
输入第一行为字符串个数n(n ≤ 100)
接下来的n行,每行一个字符串,字符串长度均小于100，均由小写字母组成
输出描述:
如果这些字符串是根据字典序排列而不是根据长度排列输出"lexicographically",
如果根据长度排列而不是字典序排列输出"lengths",
如果两种方式都符合输出"both"，否则输出"none"
示例1
输入
3
a
aa
bbb
输出
both
 */
/*
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        System.out.println(solution());
    }
    public static String solution(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] str = new String[n];
        for(int i =0; i<n; i++){
            str[i] = sc.next();
        }
        boolean f1 = false;
        boolean f2 = false;
        //验证长度
        int i=1;
        for(; i<n; i++){
            if(str[i].length() < str[i-1].length()){
                break;
            }
        }
        if(i == n){
            f1 = true;//是按长度
        }
        //验证字典序
        int k=1;
        for(; k<n; k++){
            int len1 = str[k-1].length();
            int len2 = str[k].length();
            int len = Math.min(len1,len2);
            int j=0;
            for(; j<len; j++){
                if(str[k].charAt(j) != str[k-1].charAt(j)){
                    break;
                }
            }
            if((j<len && str[k].charAt(j) < str[k-1].charAt(j)) ||
                    (len1>len2 && j==len)){//不按字典序
                break;
            }
        }
        if(k == n){
            f2 = true;//按字典序
        }
        if(f1 && f2){
            return "both";
        }else if(f1 && !f2){
            return "lengths";
        }else if(!f1 && f2){
            return "lexicographically";
        }else{
            return "none";
        }
    }
}
*/

/*
题目描述
小B乘火车和朋友们一起在N市到M市之间旅行。她在路途中时睡时醒。当她醒来观看窗外的风景时，
注意到每个火车站都有一种特别颜色的旗帜，但是她看到的旗帜仅仅是经过的一小部分。
小B在乘车过程中有两次清醒的时间，她到达旅程终点时处于睡梦中。出站时，
她和朋友们谈论着一路的见闻，朋友们觉得很有意思，他们把N到和M之间经过车站的旗帜颜色依次列出来，
然后告诉你小B记得的旗帜颜色序列，让你判断小B究竟是从N和M之间哪些方向才能看到所说颜色的旗帜，
还是根本就不可能看到？颜色用字母代表，相同的字母代表相同的颜色，不同的字母则表示不同的颜色。
输入描述:
输入中有多组测试数据，每组测试数据包含三行，第一行为一个由小写拉丁字母构成的非空字符串，
长度不超过10^5，表示N到M之间车站的颜色。火车从M向N运行时，经过的车站相同，只是方向相反。
第二行为小B在第一次睡醒时看到的颜色序列，第三行为小B在第二次睡醒时看到的颜色序列。
两个序列都是小写的拉丁字母构成的字符串，长度不超过100个字母。每个序列的颜色顺序排列按小B看到的时间顺序排列。
输出描述:
对每组测试数据，在单独的行中输出小B的旅行方向。
forward - 由N到M方向；
backward -由M到N方向
both - 两种方向都有可能；

invalid - 不可能看到这样的颜色序列；
示例1
输入
atob
a
b
aaacaaa
aca
aa
输出
forward
both
 */
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        while(sc.hasNext()){
            String NM = sc.next();
            String c1 = sc.next();
            String c2 = sc.next();
            String MN = new StringBuffer(NM).reverse().toString();
            boolean f1 = look (NM,c1,c2);
            boolean f2 = look (MN,c1,c2);
            if(f1 && f2){
                System.out.println("both");
            }else if(f1 && !f2){
                System.out.println("forward");
            }else if(!f1 && f2){
                System.out.println("backward");
            }else{
                System.out.println("invalid");
            }
        }
    }
    public static boolean look (String NM,String c1,String c2){
        int len = NM.length();
        int len1 = c1.length();
        int len2 = c2.length();
        int i=0;
        for(; i<=len-len1-len2; i++){
            if(NM.substring(i,i+len1).equals(c1)){
                break;
            }
        }
        if(i > len-len1-len2){//没有找到子串一
            return false;
        }
        for(++i; i<=len-len2; i++){
            if(NM.substring(i,i+len2).equals(c2)){
                break;
            }
        }
        if(i> len-len2){//没有找到子串二
            return false;
        }
        return true;
    }
}
