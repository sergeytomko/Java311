import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class Lab0Test {
    @Test(dataProvider = "integerProvider")
    public void integerProviderTest(int number, int res)
    {
        assertEquals(new Lab0Variant10().integerTask(number),res);
    }
    @DataProvider
    public Object[][] integerProvider()
    {
        return new Object[][]{{365,56},{495,59},{321,12}};
    }
    @Test(dataProvider = "booleanProvider")
    public void booleanProviderTest(int a,int b, boolean res)
    {
        assertEquals(new Lab0Variant10().booleanTask(a,b),res);
    }
    @DataProvider
    public Object[][] booleanProvider()
    {
        return new Object[][]{{10,11,true},{10,10,false},{3,3,false}};
    }
    @Test(dataProvider = "ifProvider")
    public void ifProviderTest(int a, int b, int res)
    {
        assertEquals(new Lab0Variant10().ifTask(a,b),res);
    }
    @DataProvider
    public Object[][] ifProvider()
    {
        return new Object[][]{{10,10,20},{10,0,0},{1,2,0}};
    }

    @Test(dataProvider = "caseProvider")
    public void caseProviderTest(int n, char c,char res)
    {
        assertEquals(new Lab0Variant10().caseTask(n,c),res);
    }
    @DataProvider
    public Object[][] caseProvider()
    {
        return new Object[][]{{1,'z','y'},{-1,'c','v'}};
    }

    @Test(dataProvider = "arrayProvider")
    public void arrayProviderTest(int arr[], int res[])
    {
        assertEquals(new Lab0Variant10().arrayTask(arr),res);
    }
    @DataProvider
    public Object[][] arrayProvider()
    {
        return new Object[][]{
                {new int[]{1,2,3,4,5},new int[]{2,4,5,3,1}},
                {new int[]{9,8,7,6,5,4}, new int[]{8,6,4,5,7,9}}
        };
    }

    @Test(dataProvider = "matrixProvider")
    public void matrixProviderTest(int n, int m, int[][]arr, int[][]res)
    {
        assertEquals(new Lab0Variant10().matrixTask(arr,n,m),res);
    }
    @DataProvider
    public Object[][] matrixProvider()
    {
        return new Object[][]{{3,3,new int[][]{{1,2,3}, {4,5,6}, {7,8,9}},new int[][]{{1,3},{4,6},{7,9}}}};
    }
    @Test(dataProvider = "forProvider")
    public void forProviderTest(int n, double res)
    {
        assertEquals(new Lab0Variant10().forTask(n),res);
    }
    @DataProvider
    public Object[][] forProvider()
    {
        return new Object[][]{{1,1},{2,1.5}};
    }
    @Test(dataProvider = "whileProvider")
    public void whileProviderTask(int n, int res)
    {
        assertEquals(new Lab0Variant10().whileTask(n),res);
    }
    @DataProvider
    public Object[][] whileProvider()
    {
        return new Object[][]{{99,4},{27,2},{81,3}};
    }
}
