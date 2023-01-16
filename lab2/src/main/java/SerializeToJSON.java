import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class SerializeToJSON implements Serialize<Animal> {
    @Override
    public void writeToFile(List<Animal> objs, String fileName) throws IOException
    {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File(fileName),objs);
    }

    @Override
    public List<Animal> readFromFile(String fileName) throws IOException
    {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File(fileName), new TypeReference<List<Animal>>(){});
    }
}
