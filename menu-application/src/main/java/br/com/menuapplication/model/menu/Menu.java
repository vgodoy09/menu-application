package br.com.menuapplication.model.menu;

import java.io.Serializable;
import java.util.List;

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
@Table(name = "menu")
@EntityListeners(AuditingEntityListener.class)
@JsonIdentityInfo(scope=Parent.class, generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
public class Menu extends EntityDoman implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String link;
	@Column
	private String name;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="fathermenu_id", insertable=true, updatable=false, referencedColumnName="id")
	@JsonBackReference
	private Menu fatherMenu;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="application_id", insertable=true, updatable=false, referencedColumnName="id")
	@JsonBackReference
	private Application application;
	@Column
	private Integer element_id;
	@Column
	private Integer ordination;
	@Column
	private String image;
	@Column
	private Boolean active;
	private transient List<Menu> listmenu;
	private transient boolean ischeck;
	private transient String check;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getOrdination() {
		return ordination;
	}
	public void setOrdination(Integer ordination) {
		this.ordination = ordination;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	public Integer getElement_id() {
		return element_id;
	}
	public void setElement_id(Integer element_id) {
		this.element_id = element_id;
	}
	
	public List<Menu> getListmenu() {
		return listmenu;
	}
	public void setListmenu(List<Menu> listmenu) {
		this.listmenu = listmenu;
	}
	public boolean isIscheck() {
		return ischeck;
	}
	public void setIscheck(boolean ischeck) {
		this.ischeck = ischeck;
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
	public Menu getFatherMenu() {
		return fatherMenu;
	}
	public void setFatherMenu(Menu fatherMenu) {
		this.fatherMenu = fatherMenu;
	}
	
}
