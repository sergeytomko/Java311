public class Lab0Variant10 {
    public static int integerTask(int number)
    {
        int res;
        res = number % 10 * 10;
        res += number % 100 / 10;
        return res;
    }
    public static boolean booleanTask(int a, int b)
    {
        boolean res = ((a % 2 != 0 && b % 2 == 0) || (a % 2 == 0 && b % 2 != 0));
        return res;
    }
    public static int ifTask(int a, int b)
    {
        if(a == b)
        {
            a = a + b;
        }
        else
        {
            a = 0;
        }
        return a;
    }
    public static char caseTask(int n, char c)
    {
        switch(n)
        {
            case 1:
                switch(c)
                {
                    case 'c': c = 'z'; return c;
                    case 'z': c = 'y'; return c;
                    case 'y': c = 'v'; return c;
                    case 'v': c = 'c'; return c;
                }

            case -1:
                switch(c)
                {
                    case 'c': c = 'v'; return c;
                    case 'v': c = 'y'; return c;
                    case 'y': c = 'z'; return c;
                    case 'z': c = 'c'; return c;
                }

            case 0:
                return c;

        }
        return c;
    }
    public static int[] arrayTask(int[] arr)
    {
        int res[] = new int [arr.length];
        int counter = 0;
        for (int i = 0; i < arr.length; i++)
        {
            if(arr[i] % 2 == 0)
            {
                res[counter] = arr[i];
                counter++;
            }
        }

        for (int i = arr.length-1; i >= 0; i--)
        {
            if(arr[i] % 2 == 1)
            {
                res[counter] = arr[i];
                counter++;
            }
        }
        return res;
    }
    public static int[][] matrixTask(int[][] arr, int n, int m)
    {
        int[][] res;
        if(m % 2 != 0)
        {
            res = new int[n][m/2+1];
        }
        else
        {
            res = new int[n][m/2];
        }

        int counter = 0;
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j+=2)
            {
                res[i][counter] = arr[i][j];
                counter++;
            }
            counter = 0;
        }
        return res;
    }
    public static double forTask(int n)
    {
        double sum = 0;
        for (int i = 1; i <= n; i++)
        {
            sum += 1 / (double)i;
        }
        return sum;
    }
    public static int whileTask(int n)
    {
        int k = 0;
        int temp = 3;
        while(temp < n)
        {
            temp *= 3;
            k++;
        }
        return k;
    }
    public static void main(String[] args) {
        System.out.println(integerTask(10001));
        System.out.println(booleanTask(2,2));
        System.out.println(ifTask(10, 10));
	    System.out.println(caseTask(-1, 'c'));
        int[] arr1 = {9,8,7,6,5,4};
        arr1 = arrayTask(arr1);
        for(int i : arr1)
        {
            System.out.print(i + " ");
        }
        System.out.println();
        int[][] arr2 = {{1,2,3}, {4,5,6}, {7,8,9}};
        arr2 = matrixTask(arr2, 3, 3);
        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 3-1; j++)
            {
                System.out.print(arr2[i][j] + " ");
            }
            System.out.print("\n");
        }
        System.out.println("for : " + forTask(2));
        System.out.println("while : " + whileTask(81));
    }
}
