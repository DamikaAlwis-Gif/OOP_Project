import java.util.List;

public class DataOperationsService {
    private IDataOperations dataOperations;

    public DataOperationsService(IDataOperations dataOperations) {
        this.dataOperations = dataOperations;
    }
    void saveData(String location , String content){
        dataOperations.saveData(location, content);
    };
    List<String> readData(String location){
        return dataOperations.readData(location);
    };
    public String getPersonalTaskLocation() {
        return dataOperations.getPersonalTaskLocation();
    }

    public void setPersonalTaskLocation(String personalTaskLocation) {
        dataOperations.setPersonalTaskLocation(personalTaskLocation);
    }

    public String getOfficialTaskLocation() {
        return dataOperations.getOfficialTaskLocation();
    }

    public void setOfficialTaskLocation(String officialTaskLocation) {
       dataOperations.setOfficialTaskLocation(officialTaskLocation);
    }
}
