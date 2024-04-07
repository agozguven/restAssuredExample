package models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateBookingResponse{

	@JsonProperty("booking")
	private Booking booking;

	@JsonProperty("bookingid")
	private Integer bookingid;

	public void setBooking(Booking booking){
		this.booking = booking;
	}

	public Booking getBooking(){
		return booking;
	}

	public void setBookingid(Integer bookingid){
		this.bookingid = bookingid;
	}

	public Integer getBookingid(){
		return bookingid;
	}
}