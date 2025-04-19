package M_UberDesign.Management;

import M_UberDesign.Models.Cab;
import M_UberDesign.Models.CabBuilder;
import M_UberDesign.Models.Driver;
import M_UberDesign.Models.Location;
import Y_Utils.SystemDesignConstants;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CabManagementService {

    private Map<String, List<Cab>> cabList;

    private static CabManagementService instance = null;

    public static CabManagementService getInstance(){
        if(instance == null){
            instance = new CabManagementService();
            return instance;
        }

        return instance;
    }

    private CabManagementService(){
        this.cabList = new HashMap<>();
        assignCabs();
    }

    private void assignCabs(){

        List<Cab> bangloreCityCabs = new ArrayList<>();
        Driver driver1 = new Driver("Avinash",1);
        Location location1 = new Location(1,3);
        Cab cab1 = new CabBuilder()
                .withDriver(driver1)
                .withIsAvailable(true)
                .withLocation(location1)
                .withVehicleNumber("VEHICLE1")
                .withCityName(SystemDesignConstants.BANGALORE)
                .build();
        bangloreCityCabs.add(cab1);

        Driver driver2 = new Driver("Snehith",2);
        Location location2 = new Location(1,10);
        Cab cab2 = new CabBuilder()
                .withDriver(driver2)
                .withIsAvailable(true)
                .withLocation(location2)
                .withVehicleNumber("VEHICLE2")
                .withCityName(SystemDesignConstants.BANGALORE)
                .build();
        bangloreCityCabs.add(cab2);

        Driver driver5 = new Driver("Thalapathy Vijay",5);
        Location location5 = new Location(0,4);
        Cab cab5 = new CabBuilder()
                .withDriver(driver5)
                .withIsAvailable(true)
                .withLocation(location5)
                .withVehicleNumber("VEHICLE5")
                .withCityName(SystemDesignConstants.BANGALORE)
                .build();
        bangloreCityCabs.add(cab5);

        Driver driver6 = new Driver("SalmanKhan",6);
        Location location6 = new Location(2,4);
        Cab cab6 = new CabBuilder()
                .withDriver(driver6)
                .withIsAvailable(true)
                .withLocation(location6)
                .withVehicleNumber("VEHICLE6")
                .withCityName(SystemDesignConstants.BANGALORE)
                .build();

        bangloreCityCabs.add(cab6);

        cabList.put(SystemDesignConstants.BANGALORE,bangloreCityCabs);

        List<Cab> chennaiCityCabs = new ArrayList<>();
        Driver driver3 = new Driver("Sai charan",3);
        Location location3 = new Location(10,10);
        Cab cab3 = new CabBuilder()
                .withDriver(driver3)
                .withIsAvailable(true)
                .withLocation(location3)
                .withVehicleNumber("VEHICLE3")
                .withCityName(SystemDesignConstants.CHENNAI)
                .build();
        chennaiCityCabs.add(cab3);

        Driver driver4 = new Driver("Ajith Kumar Puli",4);
        Location location4 = new Location(10,10);
        Cab cab4 = new CabBuilder()
                .withDriver(driver4)
                .withIsAvailable(true)
                .withLocation(location4)
                .withVehicleNumber("VEHICLE4")
                .withCityName(SystemDesignConstants.CHENNAI)
                .build();

        cabList.put(SystemDesignConstants.CHENNAI,chennaiCityCabs);
    }

    public Cab getNearestCab(String cityName, Location location){
        List<Cab> listOfAvailableCabs = cabList.get(cityName);
        int distance = Integer.MAX_VALUE;
        Cab nearestCab = null;
        for(Cab cab : listOfAvailableCabs){
            int currentCabDistance = cab.currentLocation.calculateDistance(location);
            System.out.println("Vehicle : "+cab.getVehicleNumber()+" and it's distance : "+currentCabDistance);
            if(currentCabDistance < distance && cab.isAvailable){
                distance = currentCabDistance;
                nearestCab = cab;
            }
        }
        return nearestCab;
    }

    public void updateCab(String cityName, Cab cab){
        List<Cab> currentCityCabs = cabList.get(cityName);
        Cab currentCab = null;
        for(Cab iterableCab : currentCityCabs){
            if(iterableCab.getVehicleNumber().equalsIgnoreCase(cab.getVehicleNumber())){
                currentCab = iterableCab;
            }
        }
        currentCab.setCurrentLocation(cab.getCurrentLocation());
        currentCab.setAvailable(cab.isAvailable);
    }

    public Map<String, List<Cab>> getCabList() {
        return cabList;
    }

    public void setCabList(Map<String, List<Cab>> cabList) {
        this.cabList = cabList;
    }

    public void assignNewDriverToCab(Cab cab, Driver driver){
        cab.setDriver(driver);
    }

    public void updateCabLocation(Cab cab, Location location){
        cab.setCurrentLocation(location);
    }
}
