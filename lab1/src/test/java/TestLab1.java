import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Objects;

import static org.testng.AssertJUnit.assertEquals;

public class TestLab1 {
    @Test(dataProvider = "equalAnimals")
    public void equalAnimalsProvider(Animal obj1, Animal obj2, boolean res)
    {
        assertEquals(Objects.equals(obj1,obj2),res);
    }
    @DataProvider
    public Object[][] equalAnimals()
    {
        Eagle.EagleBuilder eagleBuilder = new Eagle.EagleBuilder();
        eagleBuilder.setName("Oleg");
        eagleBuilder.setEyes(2);
        eagleBuilder.setLegs(2);
        eagleBuilder.setEars(2);
        eagleBuilder.setWings(2);

        Monkey.MonkeyBuilder monkeyBuilder = new Monkey.MonkeyBuilder();
        monkeyBuilder.setName("Egor");
        monkeyBuilder.setEyes(2);
        monkeyBuilder.setLegs(2);
        monkeyBuilder.setEars(2);
        monkeyBuilder.setHands(2);
        monkeyBuilder.setFingers(20);

        Eagle eagle1 = (Eagle) eagleBuilder.build();
        Eagle eagle2 = (Eagle) eagleBuilder.build();
        Monkey monkey1 = (Monkey) monkeyBuilder.build();
        Monkey monkey2 = (Monkey) monkeyBuilder.build();
        return new Object[][] {{eagle1,eagle2,true},{monkey1,monkey2,true},{monkey1,eagle1,false}};
    }
    @Test(dataProvider = "hashEqualAnimals")
    public void hashEqualAnimalsProvider(Animal obj1, Animal obj2)
    {
        assertEquals(obj1.hashCode(),obj2.hashCode());
    }
    @DataProvider
    public Object[][] hashEqualAnimals()
    {
        Eagle.EagleBuilder eagleBuilder = new Eagle.EagleBuilder();
        eagleBuilder.setName("Oleg");
        eagleBuilder.setEyes(2);
        eagleBuilder.setLegs(2);
        eagleBuilder.setEars(2);
        eagleBuilder.setWings(2);

        Monkey.MonkeyBuilder monkeyBuilder = new Monkey.MonkeyBuilder();
        monkeyBuilder.setName("Egor");
        monkeyBuilder.setEyes(2);
        monkeyBuilder.setLegs(2);
        monkeyBuilder.setEars(2);
        monkeyBuilder.setHands(2);
        monkeyBuilder.setFingers(20);

        Eagle eagle1 = (Eagle) eagleBuilder.build();
        Eagle eagle2 = (Eagle) eagleBuilder.build();
        Monkey monkey1 = (Monkey) monkeyBuilder.build();
        Monkey monkey2 = (Monkey) monkeyBuilder.build();
        return new Object[][] {{eagle1,eagle2},{monkey1,monkey2}};
    }
    @Test(dataProvider = "stringEqualAnimals")
    public void stringEqualAnimalsProvider(Animal obj1, Animal obj2)
    {
        assertEquals(obj1.toString(),obj2.toString());
    }
    @DataProvider
    public Object[][] stringEqualAnimals()
    {
        Eagle.EagleBuilder eagleBuilder = new Eagle.EagleBuilder();
        eagleBuilder.setName("Oleg");
        eagleBuilder.setEyes(2);
        eagleBuilder.setLegs(2);
        eagleBuilder.setEars(2);
        eagleBuilder.setWings(2);

        Monkey.MonkeyBuilder monkeyBuilder = new Monkey.MonkeyBuilder();
        monkeyBuilder.setName("Egor");
        monkeyBuilder.setEyes(2);
        monkeyBuilder.setLegs(2);
        monkeyBuilder.setEars(2);
        monkeyBuilder.setHands(2);
        monkeyBuilder.setFingers(20);

        Eagle eagle1 = (Eagle) eagleBuilder.build();
        Eagle eagle2 = (Eagle) eagleBuilder.build();
        Monkey monkey1 = (Monkey) monkeyBuilder.build();
        Monkey monkey2 = (Monkey) monkeyBuilder.build();
        return new Object[][] {{eagle1,eagle2},{monkey1,monkey2}};
    }
}
