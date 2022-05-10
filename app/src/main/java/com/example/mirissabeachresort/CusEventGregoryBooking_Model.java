package com.example.mirissabeachresort;

public class CusEventGregoryBooking_Model {
    String name, nic, phone, email ,bookingDate, time, guest;

    CusEventGregoryBooking_Model() {

    }

    public CusEventGregoryBooking_Model(String name, String nic, String phone, String email, String bookingDate, String time, String guest) {
        this.name = name;
        this.nic = nic;
        this.phone = phone;
        this.email = email;
        this.bookingDate = bookingDate;
        this.time = time;
        this.guest = guest;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getGuest() {
        return guest;
    }

    public void setGuest(String guest) {
        this.guest = guest;
    }
}
