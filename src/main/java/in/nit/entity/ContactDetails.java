package in.nit.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
@Entity
@Table(name = "contacts_details")
public class ContactDetails {
	
	@Id
	@Column(name = "CONTACT_ID")
	@GeneratedValue
	private Integer  contactId;
	
	@Column(name = "CONTACT_NAME")
	private String   contactName;
	
	@Column(name = "CONTACT_EMAIL")
	private String   contactEmail;
	
	@Column(name = "CONTACT_NUMBER")
	private Long     contactNumber;
	
	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	@Column(name = "CREATE_DATE",updatable = false)
	private Date     createDate;
	
	@UpdateTimestamp
	@Temporal(TemporalType.DATE)
	@Column(name = "UPDATE_DATE",insertable = false)
	private Date     updateDate;

}
