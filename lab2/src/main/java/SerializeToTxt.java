import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class SerializeToTxt implements Serialize<Monkey> {
    @Override
    public void writeToFile(List<Monkey> objs, String fileName) throws IOException
    {
        //створили маппер для конфігурації інформації
        CsvMapper mapper = new CsvMapper();
        mapper.configure(JsonGenerator.Feature.IGNORE_UNKNOWN,true);
        //створили схему нашого класу
        CsvSchema schema = mapper.schemaFor(Monkey.class).withHeader();;
        //створили врайтер та передали конфігурацію з маппера
        ObjectWriter writer = mapper.writerFor(Monkey.class).with(schema);
        //записали інформацію в файл
        writer.writeValues(new File(fileName)).writeAll(objs);
    }

    @Override
    public List<Monkey> readFromFile(String fileName) throws IOException
    {
        //створили маппер для конфігурації інформації
        CsvMapper mapper = new CsvMapper();
        mapper.configure(JsonGenerator.Feature.IGNORE_UNKNOWN,true);
        //створили схему нашого класу
        CsvSchema schema = mapper.schemaFor(Monkey.class).withHeader();
        //створили рідер та передали конфігурацію з маппера
        ObjectReader reader = mapper.readerFor(Monkey.class).with(schema);
        //зчитали інформацію з файлу
        return (List)reader.readValues(new File(fileName)).readAll();
    }
}
