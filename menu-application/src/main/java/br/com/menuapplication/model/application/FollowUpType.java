package br.com.menuapplication.model.application;

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

import br.com.menuapplication.model.menu.EntityDoman;

@Entity
@Table(name = "followuptype")
@EntityListeners(AuditingEntityListener.class)
@JsonIdentityInfo(scope=Parent.class, generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
public class FollowUpType extends EntityDoman implements Serializable {
	
	public static final Integer FollowUpTypeLogUser = 1;
	public static final Integer FollowUpTypeLogInsertUser = 2;
	public static final Integer FollowUpTypeLogUpdateUser = 3;
	public static final Integer FollowUpInsertCategoria = 4;
	public static final Integer FollowUpUpdateCategoria = 5;
	
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column
	private String name;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
