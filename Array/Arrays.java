import java.util.*;
public class Arrays
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
        for(int i = 0;i<n;i++)
        {
            System.out.println(arr[i]);
        }
        sc.close();
    }
}