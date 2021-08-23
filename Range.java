import java.util.*;
public class Range
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of elements:");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter "+n+" elements:");
        for(int i = 0;i<n;i++)
        {
            arr[i] = sc.nextInt();
        }
        int max = arr[0];
        int min = arr[0];
        for(int i = 0;i<n;i++)
        {
            if(arr[i]>max)
            {
                max = arr[i];
            }
        }
        for(int i = 0;i<n;i++)
        {
            if(arr[i]<min)
            {
                min = arr[i];
            }
        }
        System.out.println("Range = "+(max-min));
        sc.close();
    }
}