import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class FileOperations implements IDataOperations {
    private String personalTaskLocation;
    private String officialTaskLocation;

    public FileOperations() {
        personalTaskLocation = "personalTasks";
        officialTaskLocation = "officialTasks";
    }

    @Override
    public void saveData(String location, String content) {
        Path filePath = Path.of(location);
        String modifiedContent = content+"\n";
        try {

            // Write the content to the file
            Files.writeString(filePath, modifiedContent, StandardOpenOption.CREATE, StandardOpenOption.APPEND);

            System.out.println("Content has been written to the file.");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<String> readData(String location) {
        Path filePath = Path.of(location);
        List<String> lines = new ArrayList<>();
        try {
            // Read all lines from the file into a List<String>
            lines = Files.readAllLines(filePath, StandardCharsets.UTF_8);


        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }
    @Override
    public String getPersonalTaskLocation() {
        return personalTaskLocation;
    }
    @Override
    public void setPersonalTaskLocation(String personalTaskLocation) {
        this.personalTaskLocation = personalTaskLocation;
    }
    @Override
    public String getOfficialTaskLocation() {
        return officialTaskLocation;
    }
    @Override
    public void setOfficialTaskLocation(String officialTaskLocation) {
        this.officialTaskLocation = officialTaskLocation;
    }
}
