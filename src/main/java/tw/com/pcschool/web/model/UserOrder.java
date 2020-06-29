package tw.com.pcschool.web.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="userorder")
public class UserOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long order_id;
	@ManyToOne
	@JoinColumn(name = "id_user", nullable = false)
	private User id_user;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull(message = "此欄位必填")
	private Date orderDate;
	
	@NotNull(message = "此欄位必填")
	private String orderName;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "time_build",nullable = false)
	private Date timeBuild;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "time_modify",nullable = false)
	private Date timeModify;
	@Override
	public String toString() {
		return "UserOrder [order_id=" + order_id + ", id_user=" + id_user + ", orderDate=" + orderDate + ", orderName="
				+ orderName + ", timeBuild=" + timeBuild + ", timeModify=" + timeModify + "]";
	}
	public UserOrder() {
		super();
	}
	public UserOrder(User id_user, Date orderDate, String orderName,Date timeBuild,
			Date timeModify) {
		super();
		this.id_user = id_user;
		this.orderDate = orderDate;
		this.orderName = orderName;
		this.timeBuild = timeBuild;
		this.timeModify = timeModify;
	}
	public Long getOrder_id() {
		return order_id;
	}
	public void setOrder_id(Long order_id) {
		this.order_id = order_id;
	}
	public User getId_user() {
		return id_user;
	}
	public void setId_user(User id_user) {
		this.id_user = id_user;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public String getOrderName() {
		return orderName;
	}
	public void setOrderName(String orderName) {
		this.orderName = orderName;
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
