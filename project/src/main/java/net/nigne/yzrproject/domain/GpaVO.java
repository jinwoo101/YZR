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
	String direction;
	
	@Column(name="ost")
	String ost;
	
	@Column(name="story")
	String story;
	
	@Column(name="acting")
	String acting;	
	
	@Column(name="beauty")
	String beauty;
	
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

	public String getMovie_id() {
		return movie_id;
	}

	public void setMovie_id(String movie_id) {
		this.movie_id = movie_id;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public String getOst() {
		return ost;
	}

	public void setOst(String ost) {
		this.ost = ost;
	}

	public String getStory() {
		return story;
	}

	public void setStory(String story) {
		this.story = story;
	}

	public String getActing() {
		return acting;
	}

	public void setActing(String acting) {
		this.acting = acting;
	}

	public String getBeauty() {
		return beauty;
	}

	public void setBeauty(String beauty) {
		this.beauty = beauty;
	}

	public String getMale() {
		return male;
	}

	public void setMale(String male) {
		this.male = male;
	}

	public String getFemale() {
		return female;
	}

	public void setFemale(String female) {
		this.female = female;
	}

	public String getTeenager() {
		return teenager;
	}

	public void setTeenager(String teenager) {
		this.teenager = teenager;
	}

	public String getTwenties() {
		return twenties;
	}

	public void setTwenties(String twenties) {
		this.twenties = twenties;
	}

	public String getThirties() {
		return thirties;
	}

	public void setThirties(String thirties) {
		this.thirties = thirties;
	}

	public String getForties() {
		return forties;
	}

	public void setForties(String forties) {
		this.forties = forties;
	}
}