package br.com.menuapplication.model.menu;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Parent;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "application")
@EntityListeners(AuditingEntityListener.class)
@JsonIdentityInfo(scope=Parent.class, generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
public class Application extends EntityDoman implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	@Column
	private String nome;
	@Column
	private String imageLogoAvailable;
	@Column
	private String imageLogoUnavailable;
	@Column
	private String link;
	@Column 
	private Boolean visible;
	@Column
	private String messageUserActivation;
	@Column
	private String namebutton;
	private transient String check;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getImageLogoAvailable() {
		return imageLogoAvailable;
	}
	public void setImageLogoAvailable(String imageLogoAvailable) {
		this.imageLogoAvailable = imageLogoAvailable;
	}
	public String getImageLogoUnavailable() {
		return imageLogoUnavailable;
	}
	public void setImageLogoUnavailable(String imageLogoUnavailable) {
		this.imageLogoUnavailable = imageLogoUnavailable;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public Boolean getVisible() {
		return visible;
	}
	public void setVisible(Boolean visible) {
		this.visible = visible;
	}
	public String getMessageUserActivation() {
		return messageUserActivation;
	}
	public void setMessageUserActivation(String messageUserActivation) {
		this.messageUserActivation = messageUserActivation;
	}
	public String getNamebutton() {
		return namebutton;
	}
	public void setNamebutton(String namebutton) {
		this.namebutton = namebutton;
	}
	public String getCheck() {
		return check;
	}
	public void setCheck(String check) {
		this.check = check;
	}
	
}
