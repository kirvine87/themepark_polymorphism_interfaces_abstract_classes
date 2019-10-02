package people;

import attractions.Attraction;
import attractions.RollerCoaster;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VisitorTest {

    Visitor visitor;
    Attraction attraction;

    @Before
    public void before(){
        visitor = new Visitor(14, 1.2, 40.0);
        attraction = new RollerCoaster("Spin", 50);
    }

    @Test
    public void hasAge() {
        assertEquals(14, visitor.getAge());
    }

    @Test
    public void hasHeight() {
        assertEquals(1.2, visitor.getHeight(), 0.01);
    }

    @Test
    public void hasMoney() {
        assertEquals(40.0, visitor.getMoney(), 0.01);
    }

    @Test
    public void hasAtractionVisitedList(){
        assertEquals(0, visitor.getVisitedAttractions().size());
    }

    @Test
    public void canAddAtractionToVisitedList(){
        visitor.visitAttraction(attraction);
        assertEquals(1, visitor.getVisitedAttractions().size());
    }
}
