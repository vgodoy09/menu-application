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

import br.com.menuapplication.model.application.User;

@Entity
@Table(name = "userprofile")
@EntityListeners(AuditingEntityListener.class)
@JsonIdentityInfo(scope=Parent.class, generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
public class UserProfile extends EntityDoman implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id", insertable=true, updatable=false, referencedColumnName="id")
	@JsonBackReference
	private User user;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="profile_id", insertable=true, updatable=false, referencedColumnName="id")
	@JsonBackReference
	private Profile profile;
	
	public UserProfile(User user, Profile profile) {
		this.user = user;
		this.profile = profile;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}
}
