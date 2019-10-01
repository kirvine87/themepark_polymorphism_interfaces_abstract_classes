import attractions.RollerCoaster;
import org.junit.Before;
import org.junit.Test;
import people.Visitor;
import stalls.ParkingSpot;
import stalls.TobaccoStall;

import static org.junit.Assert.*;

public class ThemeParkTest {

    ThemePark themePark;
    RollerCoaster rollerCoaster;
    TobaccoStall tobaccoStall;
    Visitor visitor;

    @Before
    public void setUp(){
        rollerCoaster = new RollerCoaster("Blue Ridge", 10);
        themePark = new ThemePark();
        tobaccoStall = new TobaccoStall("Jacks Drum", "Jack Jarvis", ParkingSpot.B1, 50);
        visitor = new Visitor(14, 1.2, 40.0);
        themePark.addToReviewed(rollerCoaster);
        themePark.addToReviewed(tobaccoStall);
    }

    @Test
    public void canGetReviewedAttractions(){
        assertEquals(2,themePark.getReviewedAttractions().size());
    }

    @Test
    public void canVisit(){
        themePark.visit(visitor, rollerCoaster);
        assertEquals(1,rollerCoaster.getVisitCount());
        assertEquals(1,visitor.getVisitedAttractions().size());
    }

    @Test
    public void hasHashMapOfReviewed(){
        assertFalse(themePark.reviewMap().isEmpty());
    }

}
