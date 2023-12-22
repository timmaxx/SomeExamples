package timmax.mockito.p07Annotation;

public class DataProcessor {
    private final DataService dataService;

    public DataProcessor(DataService dataService) {
        this.dataService = dataService;
    }

    public int process() {
        return dataService.retrieveData() * 2;
    }
}
