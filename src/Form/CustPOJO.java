/*
 * The CutomerRecordManagement program implements an application that
 * stores and maintains Customer Records and displays the records
 * @author: Swapnil Lahire
 * @since: 23-06-2014  
 */
package Form;

public class CustPOJO {

    private String cuName;
    private String cuEmail;
    private String cuPhone;
    private String cuAddress;
    private String cuCity;
    private String cuState;
    private String cuPincode;
    private String cuCountry;

    public CustPOJO(String s1, String s2, String s3, String s4, String s5, String s6, String s7, String s8) {
        this.cuName = s1;
        this.cuEmail = s2;
        this.cuPhone = s3;
        this.cuAddress = s4;
        this.cuCity = s5;
        this.cuState = s6;
        this.cuPincode = s7;
        this.cuCountry = s8;
    }

    /**
     * @return the cuName
     */
    public String getCuName() {
        return cuName;
    }

    /**
     * @param cuName the cuName to set
     */
    public void setCuName(String cuName) {
        this.cuName = cuName;
    }

    /**
     * @return the cuEmail
     */
    public String getCuEmail() {
        return cuEmail;
    }

    /**
     * @param cuEmail the cuEmail to set
     */
    public void setCuEmail(String cuEmail) {
        this.cuEmail = cuEmail;
    }

    /**
     * @return the cuPhone
     */
    public String getCuPhone() {
        return cuPhone;
    }

    /**
     * @param cuPhone the cuPhone to set
     */
    public void setCuPhone(String cuPhone) {
        this.cuPhone = cuPhone;
    }

    /**
     * @return the cuAddress
     */
    public String getCuAddress() {
        return cuAddress;
    }

    /**
     * @param cuAddress the cuAddress to set
     */
    public void setCuAddress(String cuAddress) {
        this.cuAddress = cuAddress;
    }

    /**
     * @return the cuCity
     */
    public String getCuCity() {
        return cuCity;
    }

    /**
     * @param cuCity the cuCity to set
     */
    public void setCuCity(String cuCity) {
        this.cuCity = cuCity;
    }

    /**
     * @return the cuState
     */
    public String getCuState() {
        return cuState;
    }

    /**
     * @param cuState the cuState to set
     */
    public void setCuState(String cuState) {
        this.cuState = cuState;
    }

    /**
     * @return the cuPincode
     */
    public String getCuPincode() {
        return cuPincode;
    }

    /**
     * @param cuPincode the cuPincode to set
     */
    public void setCuPincode(String cuPincode) {
        this.cuPincode = cuPincode;
    }

    /**
     * @return the cuCountry
     */
    public String getCuCountry() {
        return cuCountry;
    }

    /**
     * @param cuCountry the cuCountry to set
     */
    public void setCuCountry(String cuCountry) {
        this.cuCountry = cuCountry;
    }

}
