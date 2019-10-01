import attractions.Attraction;
import attractions.RollerCoaster;
import behaviours.IReviewed;
import people.Visitor;
import stalls.CandyflossStall;
import stalls.ParkingSpot;
import stalls.Stall;

import java.util.ArrayList;

public class ThemePark {

    Attraction attraction;
    Stall stall;
    private ArrayList<IReviewed> reviewedAttractions;

    public ThemePark(){
        reviewedAttractions = new ArrayList<IReviewed>();
    }

    public void addToReviewed(IReviewed place){
       reviewedAttractions.add(place);
    }

    public ArrayList<IReviewed> getReviewedAttractions() {
        return reviewedAttractions;
    }


    public void visit(Visitor visitor, Attraction attraction){
        int value = attraction.getVisitCount() + 1;
        attraction.setVisitCount(value);
        visitor.visitAttraction(attraction);
    }

}
