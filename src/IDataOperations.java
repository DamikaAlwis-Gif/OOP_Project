import java.util.List;

public interface IDataOperations {


    void saveData(String location , String content);
    List<String> readData(String location);

    String getPersonalTaskLocation();

    void setPersonalTaskLocation(String personalTaskLocation);

    String getOfficialTaskLocation();

    void setOfficialTaskLocation(String officialTaskLocation);

}
