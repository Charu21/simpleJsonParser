import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class SimpleJsonParserTest {

    @Test
    public void getCompanyAccordingToSector_WithNullList_ShouldReturnEmptyList() {
        Map<String, List<model>> actualCompanyAccordingToSector = SimpleJsonParser.getCompanyAccordingToSector("");
        assertEquals(actualCompanyAccordingToSector, Collections.emptyMap());
    }

    @Test
    public void getCompanyAccordingToSector_WithList_ShouldReturnList() {
        List<model> expected1 = new ArrayList<>();
        expected1.add(new model("3M Company", "Industrials", "MMM", "A80C7A725BE4", 56.72));
        expected1.add(new model("A.O. Smith Corp", "Industrials", "AOS", "DAB7C6FE8B72", 154.54));

        List<model> expected2 = new ArrayList<>();
        expected2.add(new model( "Abbott Laboratories", "Health Care", "ABT", "F2A9F8D38836", 73.55));
        expected2.add(new model("AbbVie Inc.", "Health Care", "ABBV", "173E3FD20628", 110.32));

        Map<String, List<model>> expectedCompanyBySector = new HashMap<>();
        expectedCompanyBySector.put("Industrials", expected1);
        expectedCompanyBySector.put("Health Care", expected2);
        Map<String, List<model>> actualCompanyAccordingToSector = SimpleJsonParser.getCompanyAccordingToSector("D:\\javaPractice\\simpleJsonParser\\src\\main\\resources\\company.json");
        //assertEquals(expectedCompanyBySector, actualCompanyAccordingToSector);
        assertEquals(actualCompanyAccordingToSector, expectedCompanyBySector);
    }
}
