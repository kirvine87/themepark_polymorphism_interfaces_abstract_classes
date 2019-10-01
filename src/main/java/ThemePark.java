import attractions.Attraction;
import behaviours.IReviewed;
import behaviours.ISecurity;
import people.Visitor;
import stalls.Stall;

import java.util.ArrayList;
import java.util.HashMap;

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

    public HashMap<String, Integer> reviewMap(){
        HashMap<String, Integer> mapOfReviews = new HashMap<String, Integer>();
        for (IReviewed reviewed : this.reviewedAttractions){
            mapOfReviews.put(reviewed.getName(), reviewed.getRating());
        }
        return mapOfReviews;
    }

    public ArrayList<IReviewed> getAllAllowedFor(Visitor visitor){
        ArrayList<IReviewed> isAllowedAttractions = new ArrayList<>();
        for (IReviewed reviewed : this.reviewedAttractions){
            if (reviewed instanceof ISecurity) {
                if (((ISecurity) reviewed).isAllowedTo(visitor)) {
                    isAllowedAttractions.add(reviewed);
                }
            } else {
                isAllowedAttractions.add(reviewed);
            }
        }
        return isAllowedAttractions;
    }

}
