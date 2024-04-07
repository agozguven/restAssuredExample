package models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Booking{

	@JsonProperty("firstname")
	private String firstname;

	@JsonProperty("bookingdates")
	private Bookingdates bookingdates;

	@JsonProperty("totalprice")
	private Integer totalprice;

	@JsonProperty("depositpaid")
	private Boolean depositpaid;

	@JsonProperty("lastname")
	private String lastname;

	public Booking(String firstname, Bookingdates bookingdates, Integer totalprice, Boolean depositpaid, String lastname) {
		this.firstname = firstname;
		this.bookingdates = bookingdates;
		this.totalprice = totalprice;
		this.depositpaid = depositpaid;
		this.lastname = lastname;
	}
	public Booking(){}


	public void setFirstname(String firstname){
		this.firstname = firstname;
	}

	public String getFirstname(){
		return firstname;
	}

	public void setBookingdates(Bookingdates bookingdates){
		this.bookingdates = bookingdates;
	}

	public Bookingdates getBookingdates(){
		return bookingdates;
	}

	public void setTotalprice(Integer totalprice){
		this.totalprice = totalprice;
	}

	public Integer getTotalprice(){
		return totalprice;
	}

	public void setDepositpaid(Boolean depositpaid){
		this.depositpaid = depositpaid;
	}

	public Boolean isDepositpaid(){
		return depositpaid;
	}

	public void setLastname(String lastname){
		this.lastname = lastname;
	}

	public String getLastname(){
		return lastname;
	}
}