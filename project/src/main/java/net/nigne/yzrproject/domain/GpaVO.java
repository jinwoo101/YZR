package net.nigne.yzrproject.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="gpa")
public class GpaVO {
	@Id
	@Column(name="movie_id")
	String movie_id;
	
	@Column(name="direction")
	int direction;
	
	@Column(name="ost")
	int ost;
	
	@Column(name="story")
	int story;
	
	@Column(name="acting")
	int acting;	
	
	@Column(name="beauty")
	int beauty;
	
	@Column(name="male")
	String male;	
	
	@Column(name="female")
	String female;	
	
	@Column(name="teenager")
	String teenager;
	
	@Column(name="twenties")
	String twenties;
	
	@Column(name="thirties")
	String thirties;
	
	@Column(name="forties")
	String forties;
	
}