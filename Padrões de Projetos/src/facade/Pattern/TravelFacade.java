package facade.Pattern;

class TravelFacade {
    private Hotel hotel;
    private Flight flight;
    private CarRental carRental;
    
    public TravelFacade() {
        hotel = new Hotel();
        flight = new Flight();
        carRental = new CarRental();
    }
    
    public void bookTrip() {
        hotel.reserveRoom();
        flight.bookTicket();
        carRental.rentCar();
    }
    
    public void cancelTrip() {
        hotel.cancelReservation();
        flight.cancelTicket();
        carRental.cancelRental();
    }
}
