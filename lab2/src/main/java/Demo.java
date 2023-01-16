import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
        myList.add(eagle1);
        myList.add(monkey1);
        myList.add(monkey2);

        List<Monkey> myList2 = new ArrayList<>();
        myList2.add(monkey1);
        myList2.add(monkey2);

        SerializeToJSON serializerJSON = new SerializeToJSON();
        SerializeToXml serializerToXml = new SerializeToXml();
        SerializeToTxt serializerToTxt = new SerializeToTxt();

        System.out.println("JSON:");
        serializerJSON.writeToFile(myList,"testJSON.json");
        System.out.println(serializerJSON.readFromFile("testJSON.json"));
        System.out.println("XML:");
        serializerToXml.writeToFile(myList,"testXML.xml");
        System.out.println(serializerToXml.readFromFile("testXML.xml"));
        System.out.println("TXT:");
        serializerToTxt.writeToFile(myList2,"testTXT.txt");
        System.out.println(serializerToTxt.readFromFile("testTXT.txt"));
    }
}
