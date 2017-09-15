package models;

import lombok.Data;


import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public @Data class User {

	private String name;
	private String email;

	private int htmlSkill;
	private int cssSkill;
	private int javaScriptSkill;
	private int pythonSkill;
	private int djangoSkill;
	private int iosSkill;
	private int androidSkill;


}
