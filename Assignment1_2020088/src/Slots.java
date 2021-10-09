public class Slots {

    private int dayNo;
    private Vaccine vaccineGiven;
    private int quantity;
    
    public Slots(int dayNo, int quantity, Vaccine vaccineGiven){
        this.quantity = quantity;
        this.dayNo = dayNo;
        this.vaccineGiven = vaccineGiven;
    }

    public void setQuantity(int newquantity){
        this.quantity = newquantity;
    }

    public Vaccine getVaccineGiven(){
        return this.vaccineGiven;
    }
    public int getDayNo(){
        return this.dayNo;
    }
    public int getQuantity(){
        return this.quantity;
    }

    
}
