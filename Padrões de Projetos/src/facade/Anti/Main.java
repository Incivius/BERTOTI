package facade.Anti;

public class Main {
    public static void main(String[] args) {
        Hotel hotel = new Hotel();
        hotel.reserveRoom();
        hotel.cancelReservation();
        
        Flight flight = new Flight();
        flight.bookTicket();
        flight.cancelTicket();
        
        CarRental carRental = new CarRental();
        carRental.rentCar();
        carRental.cancelRental();
    }
}