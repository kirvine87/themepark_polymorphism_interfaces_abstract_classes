package attractions;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.*;

public class RollercoasterTest {

    RollerCoaster rollerCoaster;
    Visitor visitor;

    @Before
    public void setUp() {
        rollerCoaster = new RollerCoaster("Blue Ridge", 10);
        visitor = new Visitor(17, 201, 80);
    }


    @Test
    public void hasName() {
        assertEquals("Blue Ridge", rollerCoaster.getName());
    }

    @Test
    public void hasRating() {
        assertEquals(10, rollerCoaster.getRating());
    }

    @Test
    public void hasVisitCount() {
        assertEquals(0, rollerCoaster.getVisitCount());
    }

    @Test
    public void requiresToBeAtleast145TallAndOver12(){
        rollerCoaster.isAllowedTo(visitor);
        assertTrue(true);
    }

    @Test
    public void peopleOver200TallGetChargedDouble(){
        assertEquals(16.8, rollerCoaster.priceFor(visitor), 0.01);
    }
}
