package com.example.mirissabeachresort;

public class CusWhaleBooking_Model {
    String name,nic,phone,arrivalDate,boatNo,adult,chlidren;

    CusWhaleBooking_Model(){

    }

    public CusWhaleBooking_Model(String name, String nic, String phone, String arrivalDate, String boatNo, String adult, String chlidren) {
        this.name = name;
        this.nic = nic;
        this.phone = phone;
        this.arrivalDate = arrivalDate;
        this.boatNo = boatNo;
        this.adult = adult;
        this.chlidren = chlidren;
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

    public String getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public String getBoatNo() {
        return boatNo;
    }

    public void setBoatNo(String boatNo) {
        this.boatNo = boatNo;
    }

    public String getAdult() {
        return adult;
    }

    public void setAdult(String adult) {
        this.adult = adult;
    }

    public String getChlidren() {
        return chlidren;
    }

    public void setChlidren(String chlidren) {
        this.chlidren = chlidren;
    }
}
