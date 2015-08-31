package bean;

import java.io.Serializable;
import java.util.Arrays;

public class Customer implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private String uname;
	private String fullName;
	private String pword;
	private String confPword;
	private String gender;
	private String favnumber;
	private String address;
	private String[] webFramework;
	private boolean recvNewLetter;
	private String mobileNum;
	private String country;
	

	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getConfPword() {
		return confPword;
	}
	public void setConfPword(String confPword) {
		this.confPword = confPword;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getFavnumber() {
		return favnumber;
	}
	public void setFavnumber(String favnumber) {
		this.favnumber = favnumber;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String[] getWebFramework() {
		return webFramework;
	}
	public void setWebFramework(String[] webFramework) {
		this.webFramework = webFramework;
	}
	public boolean isRecvNewLetter() {
		return recvNewLetter;
	}
	public void setRecvNewLetter(boolean recvNewLetter) {
		this.recvNewLetter = recvNewLetter;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPword() {
		return pword;
	}
	public void setPword(String pword) {
		this.pword = pword;
	}
	
	public Customer() {
		super();
	}
	public String getMobileNum() {
		return mobileNum;
	}
	public void setMobileNum(String mobileNum) {
		this.mobileNum = mobileNum;
	}
	public Customer(String uname, String fullName, String pword,
			String confPword, String gender, String favnumber, String address,
			String[] webFramework, boolean recvNewLetter, String mobileNum,
			String country) {
		super();
		this.uname = uname;
		this.fullName = fullName;
		this.pword = pword;
		this.confPword = confPword;
		this.gender = gender;
		this.favnumber = favnumber;
		this.address = address;
		this.webFramework = webFramework;
		this.recvNewLetter = recvNewLetter;
		this.mobileNum = mobileNum;
		this.country = country;
	}
	@Override
	public String toString() {
		return "Customer [uname=" + uname + ", fullName=" + fullName
				+ ", pword=" + pword + ", confPword=" + confPword + ", gender="
				+ gender + ", favnumber=" + favnumber + ", address=" + address
				+ ", webFramework=" + Arrays.toString(webFramework)
				+ ", recvNewLetter=" + recvNewLetter + ", mobileNum="
				+ mobileNum + ", country=" + country + "]";
	}
	
	

	
}
