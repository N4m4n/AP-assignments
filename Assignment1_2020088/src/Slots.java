public class Slots {

    private int dayNo;
    private String vaccineGiven;
    private int quantity;
    
    public Slots(int dayNo, int quantity, String vaccineGiven){
        this.quantity = quantity;
        this.dayNo = dayNo;
        this.vaccineGiven = vaccineGiven;
    }

    public void setQuantity(int newquantity){
        this.quantity = newquantity;
    }

    public String getVaccineGiven(){
        return this.vaccineGiven;
    }
    public int getDayNo(){
        return this.dayNo;
    }
    public int getQuantity(){
        return this.quantity;
    }

    
}
