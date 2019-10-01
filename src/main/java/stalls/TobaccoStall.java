package stalls;

import behaviours.IReviewed;
import behaviours.ISecurity;
import people.Visitor;

public class TobaccoStall extends Stall implements ISecurity, IReviewed {

    private int rating;

    public TobaccoStall(String name, String ownerName, ParkingSpot parkingSpot, int rating) {
        super(name, ownerName, parkingSpot);
        this.rating = rating;
    }


    @Override
    public boolean isAllowedTo(Visitor visitor) {
        if (visitor.getAge() >= 18) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int getRating() {
        return rating;
    }
}
