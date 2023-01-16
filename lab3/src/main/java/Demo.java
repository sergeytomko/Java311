import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Demo {
    public static void main(String[] args) throws IOException {

        Eagle.EagleBuilder eagleBuilder = new Eagle.EagleBuilder();
        Monkey.MonkeyBuilder monkeyBuilder = new Monkey.MonkeyBuilder();

        eagleBuilder.setName("Oleg");
        eagleBuilder.setEyes(2);
        eagleBuilder.setLegs(2);
        eagleBuilder.setEars(2);
        eagleBuilder.setWings(2);

        monkeyBuilder.setName("Egor");
        monkeyBuilder.setEyes(2);
        monkeyBuilder.setLegs(2);
        monkeyBuilder.setEars(2);
        monkeyBuilder.setHands(2);
        monkeyBuilder.setFingers(20);

        Eagle eagle1 = (Eagle) eagleBuilder.build();
        Monkey monkey1 = (Monkey) monkeyBuilder.build();

        monkeyBuilder.setName("Lea");
        monkeyBuilder.setEyes(1);
        monkeyBuilder.setLegs(2);
        monkeyBuilder.setEars(2);
        monkeyBuilder.setHands(2);
        monkeyBuilder.setFingers(19);
        Monkey monkey2 = (Monkey) monkeyBuilder.build();

        List<Animal> myList = new ArrayList<>();
        myList.add(monkey2);
        myList.add(eagle1);
        myList.add(monkey1);

        List<Animal> myList2 = new ArrayList<>();
        myList2.add(monkey1);
        myList2.add(monkey2);
        myList2.add(eagle1);

        TreeSet<Animal>myList3 = new TreeSet<>();
        myList3.add(eagle1);
        myList3.add(monkey1);
        myList3.add(monkey2);

        System.out.println("Sort by name");
        for(Animal a : myList3)
        {
            System.out.println(a);
        }
        System.out.println();

        System.out.println("Sort by type");
        Comparator typeComparator = new AnimalComparator();
        Collections.sort(myList2,typeComparator);
        for(Animal a : myList2)
        {
            System.out.println(a);
        }
        System.out.println();

        System.out.println("Sort by type with streamAPI");
        myList = myList.stream().sorted(Comparator.comparing(Animal::getType)).collect(Collectors.toList());
        for(Animal a : myList)
        {
            System.out.println(a);
        }
        System.out.println();

        AnimalService animalService = new AnimalService( myList2);
        System.out.println("getMonkeyList");
        for(Animal a : animalService.getMonkeyList())
        {
            System.out.println(a);
        }
        System.out.println();

        System.out.println("getEagleList");
        for(Animal a : animalService.getEagleList())
        {
            System.out.println(a);
        }
        System.out.println();

        System.out.println("getByName");
        for(Animal a : animalService.getByName("Lea"))
        {
            System.out.println(a);
        }
        System.out.println();
    }
}
