package E_CarRentalSystem.Payment;

import E_CarRentalSystem.Reservation.Reservation;

public class Bill
{
    Reservation reservation;
    double totalBillAmount;
    boolean isBillPaid;

    Bill(Reservation reservation){
        this.reservation = reservation;
        this.totalBillAmount = computeBillAmount();
        isBillPaid = false;
    }

    public double computeBillAmount(){
        return 100.0;
    }
}
