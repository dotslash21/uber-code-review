package com.example.geektrust.Repository;

import com.example.geektrust.Constant;
import com.example.geektrust.Model.Ride;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RideRepository {
    List<Ride> rideList = new ArrayList<>();
    public void add(Ride R){
        rideList.add(R);
    }
    public void remove(Ride r){
        rideList.remove(r);
    }
    public void updateRide(Ride r){
        // TODO: Use findById method here
        Optional<Ride> ride = rideList.stream().filter(a -> a.getId().equals(r.getId())).findAny();
        if (ride.isPresent()){
            remove(ride.get());
            add(r);
        }
    }
    public List<Ride> getAllRideList(){
        return rideList;
    }

    public Optional<Ride> findById(String id) {
        return rideList.stream().filter(a -> a.getId().equals(id)).findAny();
    }
    // TODO: findIfUserIsOnARide -> isRideOngoing
    public boolean findIfUserIsOnARide(String id){
        return rideList.stream().anyMatch(a -> a.getId().equals(id) && a.isRideCompleted() == Constant.FALSE);
    }
}
