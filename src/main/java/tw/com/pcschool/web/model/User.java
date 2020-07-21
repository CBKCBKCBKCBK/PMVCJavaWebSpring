package tw.com.pcschool.web.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;



@Entity
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull(message = "此欄位必填")
	@Pattern(regexp = "^[a-zA-Z]+[\\w]{5,19}$"
			,message = "帳號格式錯誤,6~20字元,第一字元為英文")
	private String username;
	@NotNull(message = "此欄位必填")
	@Pattern(regexp = "^[a-zA-Z]+[\\w]{5,19}$"
			,message = "密碼格式錯誤,6~20字元,第一字元為英文")
	private String pass;
	@NotNull(message = "此欄位必填")
	@Email(message = "Email格式錯誤")
	@Pattern(regexp = "^(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:"
			+ "[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]"
			+ "|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+"
			+ "[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}"
			+ "(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:"
			+ "(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]"
			+ "|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])$"
			,message = "Email格式錯誤或欄位為空")
	private String email;
	@NotNull(message = "此欄位必填")
	@Pattern(regexp = "^[\\u4E00-\\u9FFF\\w]{2,50}$"
			,message = "地址最少2文字")
	private String address;
	@NotNull(message = "此欄位必填")
	@Pattern(regexp = "^[08]+[\\d]{8,14}$"
			,message = "電話需要包含區碼,不包含中間符號")
	private String phone;
//	@Pattern(regexp = "^(" + 
//			"([1-9]\\d([13579][26]|[02468][048])[\\s\\.\\-/]?" + 
//			"(0?2[\\s\\.\\-/]?(0?[1-9]|[12]\\d)|" + 
//			"((0?[13578]|1[02])[\\s\\.\\-/]?(0?[1-9]|[12]\\d|3[01])|(0?[469]|11)[\\s\\.\\-/]?(0?[1-9]|[12]\\d|30))))" + 
//			"|" + 
//			"([1-9]\\d([13579][01345789]|[02468][1235679])[\\s\\.\\-/]?" + 
//			"(0?2[\\s\\.\\-/]?(0?[1-9]|1\\d|2[0-8])|" + 
//			"((0?[13578]|1[02])[\\s\\.\\-/]?(0?[1-9]|[12]\\d|3[01])|(0?[469]|11)[\\s\\.\\-/]?(0?[1-9]|[12]\\d|30))))" + 
//			")$"
//			,message = "日期格式錯誤")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull(message = "此欄位必填")
	private Date birthday;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "time_build",nullable = false)
	private Date timeBuild;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="time_modify",nullable = false)
	private Date timeModify;
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", pass=" + pass + ", email=" + email + ", address="
				+ address + ", phone=" + phone + ", birthday=" + birthday + ", timeBuild=" + timeBuild + ", timeModify="
				+ timeModify + "]";
	}
	public User() {
		super();
	}
	public User(
			String username,
			String pass,
			String email,
			String address,
			String phone,
			Date birthday,Date timeBuild,
			Date timeModify) {
		super();
		this.username = username;
		this.pass = pass;
		this.email = email;
		this.address = address;
		this.phone = phone;
		this.birthday = birthday;
		this.timeBuild = timeBuild;
		this.timeModify = timeModify;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Date getTimeBuild() {
		return timeBuild;
	}
	public void setTimeBuild(Date timeBuild) {
		this.timeBuild = timeBuild;
	}
	public Date getTimeModify() {
		return timeModify;
	}
	public void setTimeModify(Date timeModify) {
		this.timeModify = timeModify;
	}
}
