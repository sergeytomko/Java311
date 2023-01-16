public class Demo {
    public static void main(String[] args) {
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

        Eagle eagle = (Eagle) eagleBuilder.build();
        Monkey monkey = (Monkey) monkeyBuilder.build();
        System.out.println(eagle);
        System.out.println(monkey);
    }
}
