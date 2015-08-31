package entity;

import javax.persistence.*;

@Entity
@Table(name="customer")
public class CustomerEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int cid;
	
	@Column(name="uname")
	private String uname;
	
	@Column(name="fullName")
	private String fullName;
	
	@Column(name="pword")
	private String pword;
	
	@Column(name="gender")
	private String gender;
	
	@Column(name="favnum")
	private String favnumber;
	
	@Column(name="address")
	private String address;
	
	@Column(name="recNewLetter")
	private boolean recvNewLetter;
	
	@Column(name="mobNum")
	private String moblileNum;
	
	@Column(name="country")
	private String country;

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPword() {
		return pword;
	}

	public void setPword(String pword) {
		this.pword = pword;
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

	public boolean isRecvNewLetter() {
		return recvNewLetter;
	}

	public void setRecvNewLetter(boolean recvNewLetter) {
		this.recvNewLetter = recvNewLetter;
	}

	public String getMoblileNum() {
		return moblileNum;
	}

	public void setMoblileNum(String moblileNum) {
		this.moblileNum = moblileNum;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public CustomerEntity() {
		super();
	}

	public CustomerEntity(String uname, String fullName, String pword,
			String gender, String favnumber, String address,
			boolean recvNewLetter, String moblileNum, String country) {
		super();
		this.uname = uname;
		this.fullName = fullName;
		this.pword = pword;
		this.gender = gender;
		this.favnumber = favnumber;
		this.address = address;
		this.recvNewLetter = recvNewLetter;
		this.moblileNum = moblileNum;
		this.country = country;
	}

	@Override
	public String toString() {
		return "CustomerEntity [cid=" + cid + ", uname=" + uname
				+ ", fullName=" + fullName + ", pword=" + pword
				+  ", gender=" + gender
				+ ", favnumber=" + favnumber + ", address=" + address
				+ ", recvNewLetter=" + recvNewLetter + ", moblileNum="
				+ moblileNum + ", country=" + country + "]";
	}
	
	
	
	

}
