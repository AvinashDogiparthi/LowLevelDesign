package CA_ParkingLotDesign_V2;

import CA_ParkingLotDesign_V2.Parking.ParkingLot;
import CA_ParkingLotDesign_V2.Parking.ParkingTicket;
import CA_ParkingLotDesign_V2.PaymentStrategy.PaymentStrategyEnum;
import CA_ParkingLotDesign_V2.Vehicle.VehicleTypeEnum;

import java.util.List;
import java.util.Map;

public class ParkingLotDemo {

    public static void main(String[] args) {

        ParkingLot parkingLot = ParkingLot.getInstance();

        insertData(parkingLot);
        Map<Integer,List<Integer>> availableBikeTypeSpots = parkingLot.getRelevantParkingSpot(VehicleTypeEnum.BIKE);
        Map<Integer,List<Integer>> availableCarTypeSpots = parkingLot.getRelevantParkingSpot(VehicleTypeEnum.CAR);
        System.out.println("PARKINGLOTDEMO --- availableBikeTypeSpots : "+availableSpots(availableBikeTypeSpots)+" availableCarTypeSpots : "+availableSpots(availableCarTypeSpots));

        ParkingTicket parkingTicket = parkingLot.parkVehicle(0,0,VehicleTypeEnum.BIKE,1);

        Map<Integer,List<Integer>> availableBikeTypeSpotsPost = parkingLot.getRelevantParkingSpot(VehicleTypeEnum.BIKE);
        Map<Integer,List<Integer>> availableCarTypeSpotsPost = parkingLot.getRelevantParkingSpot(VehicleTypeEnum.CAR);
        System.out.println("PARKINGLOTDEMO --- availableBikeTypeSpots : "+availableSpots(availableBikeTypeSpotsPost)+" availableCarTypeSpots : "+availableSpots(availableCarTypeSpotsPost));

        parkingLot.unParkVehicle(parkingTicket.getTicketID(),2, PaymentStrategyEnum.UPI);

        Map<Integer,List<Integer>> availableBikeTypeSpotsEnd = parkingLot.getRelevantParkingSpot(VehicleTypeEnum.BIKE);
        Map<Integer,List<Integer>> availableCarTypeSpotsEnd = parkingLot.getRelevantParkingSpot(VehicleTypeEnum.CAR);
        System.out.println("PARKINGLOTDEMO --- availableBikeTypeSpots : "+availableSpots(availableBikeTypeSpotsEnd)+" availableCarTypeSpots : "+availableSpots(availableCarTypeSpotsEnd));
    }

    public static int availableSpots(Map<Integer,List<Integer>> availableMap){

        int available = 0;

        for(List<Integer> spots : availableMap.values()){
            available = available + spots.size();
        }

        return available;
    }

    private static void insertData(ParkingLot parkingLot) {
        parkingLot.addParkingFloor(0);
        parkingLot.addParkingSpot(0,0, VehicleTypeEnum.BIKE);
        parkingLot.addParkingSpot(0,1, VehicleTypeEnum.BIKE);
        parkingLot.addParkingSpot(0,2, VehicleTypeEnum.BIKE);
        parkingLot.addParkingSpot(0,3, VehicleTypeEnum.BIKE);
        parkingLot.addParkingSpot(0,4, VehicleTypeEnum.BIKE);
        parkingLot.addParkingSpot(0,5, VehicleTypeEnum.BIKE);

        parkingLot.addParkingSpot(0,6, VehicleTypeEnum.CAR);
        parkingLot.addParkingSpot(0,7, VehicleTypeEnum.CAR);
        parkingLot.addParkingSpot(0,8, VehicleTypeEnum.CAR);
        parkingLot.addParkingSpot(0,9, VehicleTypeEnum.CAR);
        parkingLot.addParkingSpot(0,10, VehicleTypeEnum.CAR);
        parkingLot.addParkingSpot(0,11, VehicleTypeEnum.CAR);

        parkingLot.addParkingFloor(1);
        parkingLot.addParkingSpot(1,0, VehicleTypeEnum.BIKE);
        parkingLot.addParkingSpot(1,1, VehicleTypeEnum.BIKE);
        parkingLot.addParkingSpot(1,2, VehicleTypeEnum.BIKE);
        parkingLot.addParkingSpot(1,3, VehicleTypeEnum.BIKE);
        parkingLot.addParkingSpot(1,4, VehicleTypeEnum.BIKE);
        parkingLot.addParkingSpot(1,5, VehicleTypeEnum.BIKE);

        parkingLot.addParkingSpot(1,6, VehicleTypeEnum.CAR);
        parkingLot.addParkingSpot(1,7, VehicleTypeEnum.CAR);
        parkingLot.addParkingSpot(1,8, VehicleTypeEnum.CAR);
        parkingLot.addParkingSpot(1,9, VehicleTypeEnum.CAR);
        parkingLot.addParkingSpot(1,10, VehicleTypeEnum.CAR);
        parkingLot.addParkingSpot(1,11, VehicleTypeEnum.CAR);
    }
}
