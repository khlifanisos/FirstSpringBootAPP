package tn.iit.dto;

import java.io.Serializable;

public class StudentDto implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String name;
	private char gender;

	public StudentDto() {
		super();
	}

	public StudentDto(Long id, String name, char gender) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
