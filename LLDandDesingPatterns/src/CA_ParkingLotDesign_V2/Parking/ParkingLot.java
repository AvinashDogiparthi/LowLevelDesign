package CA_ParkingLotDesign_V2.Parking;

import CA_ParkingLotDesign_V2.PaymentStrategy.PaymentStrategyEnum;
import CA_ParkingLotDesign_V2.PaymentStrategy.PaymentStrategyFactory;
import CA_ParkingLotDesign_V2.Vehicle.VehicleTypeEnum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLot {

    private static ParkingLot instance = null;
    private Map<Integer, ParkingFloor> parkingFloorList;
    private Map<Integer, ParkingTicket> parkingTicketMap;

    public static ParkingLot getInstance(){
        if(instance == null){
            instance = new ParkingLot();
        }

        return instance;
    }

    private ParkingLot() {
        this.parkingFloorList = new HashMap<>();
        this.parkingTicketMap = new HashMap<>();
    }


    public ParkingTicket parkVehicle(int floorNumber, int spotNumber, VehicleTypeEnum vehicleTypeEnum, int entryTime){
        ParkingTicket parkingTicket = null;
        if(parkingFloorList.containsKey(floorNumber)){
            ParkingFloor parkingFloor = parkingFloorList.get(floorNumber);

            Map<Integer, ParkingSpot> parkingSpotMap = parkingFloor.getParkingSpotList();
            if(parkingSpotMap.containsKey(spotNumber)){
                ParkingSpot parkingSpot = parkingSpotMap.get(spotNumber);

                if(parkingSpot.getVehicleTypeEnum() == vehicleTypeEnum){
                    parkingSpot.setOccupied(true);
                    System.out.println("Successfull in parking vehicle");

                    int ticketID = floorNumber * spotNumber * 123;
                    if(parkingTicketMap.containsKey(ticketID)){
                        ticketID = floorNumber * spotNumber * 352;
                    }
                    parkingTicket = new ParkingTicket(floorNumber,spotNumber,entryTime,ticketID);
                    this.parkingTicketMap.put(ticketID,parkingTicket);
                } else {
                    System.out.println("You cannot park in a spot which doesn't support current vehicle type parking");
                }
            } else {
                System.out.println("No parking spot found");
            }
        } else {
            System.out.println("No parking floor found");
        }

        return parkingTicket;
    }

    public void unParkVehicle(int parkingTicketID, int exitTime, PaymentStrategyEnum paymentStrategy){
        if(parkingTicketMap.containsKey(parkingTicketID)){
            ParkingTicket parkingTicket = parkingTicketMap.get(parkingTicketID);
            int parkingFloorID = parkingTicket.getFloorNo();
            int parkingSpotID = parkingTicket.getSpotNo();

            if(parkingFloorList.containsKey(parkingFloorID)){
                ParkingFloor parkingFloor = parkingFloorList.get(parkingFloorID);

                Map<Integer,ParkingSpot> parkingSpotMap = parkingFloor.getParkingSpotList();
                if(parkingSpotMap.containsKey(parkingSpotID)){
                    ParkingSpot parkingSpot = parkingSpotMap.get(parkingSpotID);
                    parkingSpot.setOccupied(false);
                    System.out.println("Un parked vehicle");
                    parkingTicket.setExitTime(exitTime);

                    CA_ParkingLotDesign_V2.PaymentStrategy.PaymentStrategy paymentStrategyPay = PaymentStrategyFactory.getPaymentStrategy(paymentStrategy);
                    paymentStrategyPay.pay();

                    this.parkingTicketMap.remove(parkingTicketID);
                } else {
                    System.out.println("no such parking spot exist");
                }
            } else {
                System.out.println("no such parking floor exist");
            }
        } else{
            System.out.println("no such parking ticket exist");
        }
    }

    // Map<floorID,spotID>
    public Map<Integer,List<Integer>> getRelevantParkingSpot(VehicleTypeEnum vehicleTypeEnum){

        Map<Integer, List<Integer>> availableParkingSpots = new HashMap<>();

        for(ParkingFloor parkingFloor : parkingFloorList.values()){
            List<Integer> availableParkingSpotsID = new ArrayList<>();
            for(ParkingSpot parkingSpot : parkingFloor.getParkingSpotList().values()){
                if(parkingSpot.getVehicleTypeEnum() == vehicleTypeEnum && !parkingSpot.isOccupied()){
                    availableParkingSpotsID.add(parkingSpot.getId());
                }
            }

            availableParkingSpots.put(parkingFloor.getParkingFloor(),availableParkingSpotsID);
        }

        return availableParkingSpots;
    }

    public void addParkingFloor(int parkingFloorID){
        ParkingFloor parkingFloor = new ParkingFloor(parkingFloorID);
        this.parkingFloorList.put(parkingFloorID, parkingFloor);
        System.out.println("Successfully created a new parking floor in ParkingLot");
    }

    public void removeParkingFloor(int parkingFloorID){
        if(parkingFloorList.containsKey(parkingFloorID)){
            parkingFloorList.remove(parkingFloorID);
            System.out.println("Successfully removed parking floor : "+parkingFloorID);
        } else {
            System.out.println("No parking floor found");
        }
    }

    public void addParkingSpot(int parkingFloorID, int parkingSpotID, VehicleTypeEnum vehicleTypeEnum){
        ParkingSpot parkingSpot = new ParkingSpot(parkingSpotID,vehicleTypeEnum);
        if(parkingFloorList.containsKey(parkingFloorID)){
            ParkingFloor parkingFloor = parkingFloorList.get(parkingFloorID);
            parkingFloor.addParkingSpot(parkingSpot);
            System.out.println("Successfully added parking spot in parking floor : "+parkingFloorID);
        } else {
            System.out.println("No parking floor exist with the user sent request, please create a new one");
        }
    }

    public void removeParkingSpot(int parkingFloorID, int parkingSpotID){
        if(parkingFloorList.containsKey(parkingFloorID)){
            ParkingFloor parkingFloor = parkingFloorList.get(parkingFloorID);
            Map<Integer,ParkingSpot> availableSpots = parkingFloor.getParkingSpotList();

            if(availableSpots.containsKey(parkingFloorID)){
                parkingFloor.removeParkingSpot(parkingSpotID);
                System.out.println("Successfully removed parking spot :"+parkingSpotID+ " from parking floor : "+parkingFloorID);
            } else {
                System.out.println("No Parking spot found");
            }
        } else {
            System.out.println("No Parking floor found");
        }
    }
}
