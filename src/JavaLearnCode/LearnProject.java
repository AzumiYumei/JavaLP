package JavaLearnCode;
//import java.util.Scanner;//键盘输入数字
//import java.util.Random;//键盘输入随机数

public class LearnProject {
    public static void main(String[] args) {
        //Scanner sc=new Scanner(System.in)
        //Random ra=new Random();
        //System.out.println("please input number");

        //int x=sc.nextInt();//键盘输入数
        //int y=ra.nextInt(x);//制造1-x随机数

        long startTime1=System.nanoTime();
        int count=0;
        for(int i=1;i<=10;i++)
        {
            boolean flag=true;
            for(int j=2;j<i;j++)
            {
                if(i%j==0)
                {
                    flag=false;
                    break;
                }
            }
            if (flag)
            {
                System.out.println(i);
                count++;
            }
        }
        System.out.println(count);
        long endTime1=System.nanoTime();
        System.out.println(endTime1-startTime1);


        long startTime=System.nanoTime();
        priceSeason(1,10);
        long endTime=System.nanoTime();
        System.out.println(endTime-startTime);
    }


    public static void priceSeason(int rangeBefore,int rangeAfter)
    {
        int sum=0;
        if((rangeBefore<=1&rangeAfter<=3))
        {
            for (int i = rangeBefore; i < rangeAfter; i++) {
                System.out.println(i);
                sum++;
            }
        }
        else if(rangeBefore<=1&rangeAfter>=3)
        {
            System.out.println(1);
            System.out.println(2);
            System.out.println(3);
            sum+=3;
        }
        for (int i = rangeBefore/6+1; i*6+1 <= rangeAfter; i++) {
            boolean isSD=true;
            boolean isSP=true;
            for(int j=2;j<=SQ(i*6+1);j++)
            {
                isSD=DP(-1,i,j,isSD);
                isSP=DP(+1,i,j,isSP);
                if(!isSD&!isSP)
                    break;
            }
            sum+=Out(-1,isSD,i);
            sum+=Out(+1,isSP,i);
        }
        System.out.println(sum);
    }

    public static int Out(int DP,boolean isTrue,int i)
    {
        int sum=0;
        if(isTrue) {
            sum++;
            System.out.println(i * 6 + DP);
        }
        return sum;
    }

    public static boolean DP(int DP,int i,int j,boolean isTrue)
    {
        if((i*6+DP)%j==0)
        {
            isTrue=false;
        }
        return isTrue;
    }

    public static int SQ(int num)
    {
        int i=1;
        while(i*i<num)
            i++;
        return i;
    }
}
