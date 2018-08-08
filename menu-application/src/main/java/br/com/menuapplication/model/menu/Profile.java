package br.com.menuapplication.model.menu;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Parent;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "profile")
@EntityListeners(AuditingEntityListener.class)
@JsonIdentityInfo(scope=Parent.class, generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
public class Profile extends EntityDoman implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	@Column
	private String name;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="application_id", insertable=true, updatable=false, referencedColumnName="id")
	@JsonBackReference
	private Application application;
	private transient String nameapplication;
	private transient String check;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNameapplication() {
		return nameapplication;
	}
	public void setNameapplication(String nameapplication) {
		this.nameapplication = nameapplication;
	}
	public String getCheck() {
		return check;
	}
	public void setCheck(String check) {
		this.check = check;
	}
	public Application getApplication() {
		return application;
	}
	public void setApplication(Application application) {
		this.application = application;
	}
}