import attractions.Dodgems;
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
    Dodgems dodgems;
    Visitor visitor;

    @Before
    public void setUp(){
        rollerCoaster = new RollerCoaster("Blue Ridge", 10);
        themePark = new ThemePark();
        dodgems = new Dodgems("Bash", 30);
        tobaccoStall = new TobaccoStall("Jacks Drum", "Jack Jarvis", ParkingSpot.B1, 50);
        visitor = new Visitor(17, 180, 40.0);
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

    @Test
    public void canGetAllowedAttractions(){
        themePark.addToReviewed(dodgems);
        assertEquals(2, themePark.getAllAllowedFor(visitor).size());
    }


}
