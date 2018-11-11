import java.util.Comparator;
import java.util.List;

public class SortChoiseInit {

    private String category;
    private Comparator<Book> comparator;
    private List<String> criterionValues;

    public SortChoiseInit(String category, Comparator<Book> comparator, List<String> criterionValues) {
        this.category = category;
        this.comparator = comparator;
        this.criterionValues = criterionValues;
    }

    public String getCategory() {
        return category;
    }

    public Comparator<Book> getComparator() {
        return comparator;
    }

    public List<String> getCriterionValues() {
        return criterionValues;
    }
}
