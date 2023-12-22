package timmax.mockito.p08Annotation2;

public class DataProcessor {
    private final DataService dataService;

    public DataProcessor(DataService dataService) {
        this.dataService = dataService;
    }

    public int process() {
        return dataService.retrieveData() * 2;
    }
}
