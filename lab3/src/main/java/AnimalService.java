import java.util.List;
import java.util.stream.Collectors;

public class AnimalService
{
    private List<Animal> list;

    public AnimalService(List<Animal> list) {
        this.list = list;
    }

    public List<Animal> getList() {
        return list;
    }

    public void setList(List<Animal> list) {
        this.list = list;
    }
    public List<Animal> getMonkeyList()
    {
        return getList().stream().filter(animal -> "monkey".equals(animal.getType())).collect(Collectors.toList());
    }
    public List<Animal> getEagleList()
    {
        return getList().stream().filter(animal -> "eagle".equals(animal.getType())).collect(Collectors.toList());
    }
    public List<Animal> getByName(String name)
    {
        return getList().stream().filter(animal -> name.equals(animal.getName())).collect(Collectors.toList());
    }
}
