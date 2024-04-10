package HW1;


public class Patient {
	    private String id;
	    private String fname;
	    private String lname;
	    private String phoneNumber,healthHistory,insuranceID,pharmacy;
	    
	    private int totalCAC;
	    private int lmValue;
	    private int ladValue;
	    private int lcxValue;
	    private int rdaValue;
	    private int pdaValue;
		private String bday;
		private String Dnotes;

	    public Patient() {
	        // Default constructor
	    	this.id = "";
	    	this.fname = "";
	    	this.lname = "";
	    	this.bday = "";
	    	this.phoneNumber = "";
	    	this.healthHistory = "";
	    	this.insuranceID = "";
	    	this.pharmacy = "";
	        this.totalCAC = 0;
	        this.lmValue = 0;
	        this.ladValue = 0;
	        this.lcxValue = 0;
	        this.rdaValue = 0;
	        this.pdaValue = 0;
	        this.Dnotes = "";
	    }

	    public Patient( String Dnotes, String fname, String lname, String bday, String phoneNumber, String healthHistory,String insuranceID,String pharmacy, int totalCAC, int lmValue, int ladValue, int lcxValue, int rdaValue, int pdaValue) {
	       
	    	this.fname = fname;
	    	this.lname = lname;
	    	this.bday = bday;
	    	this.phoneNumber = phoneNumber;
	    	this.healthHistory = healthHistory;
	    	this.insuranceID = insuranceID;
	    	this.pharmacy = pharmacy;
	        this.totalCAC = totalCAC;
	        this.lmValue = lmValue;
	        this.ladValue = ladValue;
	        this.lcxValue = lcxValue;
	        this.rdaValue = rdaValue;
	        this.pdaValue = pdaValue;
	        this.Dnotes = Dnotes;
	    }

	    // Getters and setters
	    
	    public String getID() {
	        return id;
	    }

	    public void setID(String id) {
	        this.id = id;
	    }

	    public String getFirstName() {
	        return fname;
	    }

	    public void setFirstName(String fname) {
	        this.fname = fname;
	    }
	    
	    public String getLastName() {
	        return lname;
	    }
	    
	    

	    public void setLastName(String lname) {
	        this.lname = lname;
	    }
	    
	    public String getBirthDay() {
	    	return bday;
	    }
	    public void setBirthDay(String bday) {
	    	this.bday = bday;
	    }
	    
	    
	    
	    public String getPhoneNumber() {
	        return phoneNumber;
	    }

	    public void setPhoneNumber(String phoneNumber) {
	        this.phoneNumber = phoneNumber;
	    }

	    // Getter and setter for healthHistory
	    public String getHealthHistory() {
	        return healthHistory;
	    }

	    public void setHealthHistory(String healthHistory) {
	        this.healthHistory = healthHistory;
	    }

	    // Getter and setter for insuranceID
	    public String getInsuranceID() {
	        return insuranceID;
	    }

	    public void setInsuranceID(String insuranceID) {
	        this.insuranceID = insuranceID;
	    }

	    // Getter and setter for pharmacy
	    public String getPharmacy() {
	        return pharmacy;
	    }

	    public void setPharmacy(String pharmacy) {
	        this.pharmacy = pharmacy;
	    }

	    public int getTotalCAC() {
	        return totalCAC;
	    }

	    public void setTotalCAC(int totalCAC) {
	        this.totalCAC = totalCAC;
	    }

	    public int getLmValue() {
	        return lmValue;
	    }

	    public void setLmValue(int lmValue) {
	        this.lmValue = lmValue;
	    }

	    public int getLadValue() {
	        return ladValue;
	    }

	    public void setLadValue(int ladValue) {
	        this.ladValue = ladValue;
	    }

	    public int getLcxValue() {
	        return lcxValue;
	    }

	    public void setLcxValue(int lcxValue) {
	        this.lcxValue = lcxValue;
	    }

	    public int getRdaValue() {
	        return rdaValue;
	    }

	    public void setRdaValue(int rdaValue) {
	        this.rdaValue = rdaValue;
	    }

	    public int getPdaValue() {
	        return pdaValue;
	    }

	    public void setPdaValue(int pdaValue) {
	        this.pdaValue = pdaValue;
	    }
	    
	    public String getDoctornotes() {
	        return Dnotes;
	    }

	    public void setDoctornotes(String Dnotes) {
	        this.Dnotes = Dnotes;
	    }
	    
   

}