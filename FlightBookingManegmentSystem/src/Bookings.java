public class Bookings {
	private int flight_id;
	private int flight_Number;
	private String passenger_name;
	private String passenger_email;
	private String booking_date;
	public int getFlight_id() {
		return flight_id;
	}
	public void setFlight_id(int flight_id) {
		this.flight_id = flight_id;
	}
	
	public int getFlight_Number() {
		return flight_Number;
	}
	public void setFlight_Number(int flight_Number) {
		this.flight_Number = flight_Number;
	}
	public String getPassenger_name() {
		return passenger_name;
	}
	public void setPassenger_name(String passenger_name) {
		this.passenger_name = passenger_name;
	}
	public String getPassenger_email() {
		return passenger_email;
	}
	public void setPassenger_email(String passenger_email) {
		this.passenger_email = passenger_email;
	}
	public String getBooking_date() {
		return booking_date;
	}
	public void setBooking_date(String booking_date) {
		this.booking_date = booking_date;
	}

}
