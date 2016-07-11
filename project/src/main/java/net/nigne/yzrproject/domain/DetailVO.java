package net.nigne.yzrproject.domain;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalIdCache;

@Entity
@Table(name="movie")
public class DetailVO {
	@Id
	@Column(name="movie_id")
	String movie_id;
	
	@Column(name="title")
	String title;
	
	@Column(name="open_date")
	Timestamp open_date;
	
	@Column(name="runtime")
	int runtime;
	
	@Column(name="rating")
	String rating;
	
	@Column(name="moviegoers_cnt")
	int moviegoers_cnt;
	
	@Column(name="poster")
	String poster;
	
	public String getMovie_id() {
		return movie_id;
	}

	public void setMovie_id(String movie_id) {
		this.movie_id = movie_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Timestamp getOpen_date() {
		return open_date;
	}

	public void setOpen_date(Timestamp open_date) {
		this.open_date = open_date;
	}

	public int getRuntime() {
		return runtime;
	}

	public void setRuntime(int runtime) {
		this.runtime = runtime;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public int getMoviegoers_cnt() {
		return moviegoers_cnt;
	}

	public void setMoviegoers_cnt(int moviegoers_cnt) {
		this.moviegoers_cnt = moviegoers_cnt;
	}

	public String getReservation_rate() {
		return reservation_rate;
	}

	public void setReservation_rate(String reservation_rate) {
		this.reservation_rate = reservation_rate;
	}

	public String getStory() {
		return story;
	}

	public void setStory(String story) {
		this.story = story;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	@Column(name="reservation_rate")
	String reservation_rate;
	
	@Column(name="story")
	String story;
	
	@Column(name="site")
	String site;
}