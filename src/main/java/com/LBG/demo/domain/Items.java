package com.LBG.demo.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Items {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Integer id;

	private String type;

	private String title;

	private boolean available = true;

	/**
	 * @return the available
	 */
	public boolean isAvailable() {
		return available;
	}

	/**
	 * @param available the available to set
	 */
	public void setAvailable(boolean available) {
		this.available = available;
	}

	/**
	 * @return the available
	 */
//	public boolean isAvailable() {
//		return available;
//	}
//
//	/**
//	 * @param available the available to set
//	 */
//	public void setAvailable(boolean available) {
//		this.available = available;
//	}

	@JsonBackReference
	@ManyToOne
	private People people;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	public Items() {
		super();

	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the people
	 */
	public People getPeople() {
		return people;
	}

	/**
	 * @param people the people to set
	 */
	public void setPeople(People people) {
		this.people = people;
	}

}
