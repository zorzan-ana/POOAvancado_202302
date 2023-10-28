package br.edu.atitus.pooavancado.atitusound.entities;

import java.time.Duration;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_music")
public class MusicEntity extends GenericEntity{

	private Duration duration;
	private int likes_count = 0;
	private String url;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "artist_uuid")
	private ArtistEntity artistEntity;
	
	public MusicEntity() {
		
	}
	
	public MusicEntity(Duration duration, int likes_count, String url) {
		super();
		this.duration = duration;
		this.likes_count = likes_count;
		this.url = url;
	}
	
	public ArtistEntity getArtistEntity() {
		return artistEntity;
	}

	public void setArtistEntity(ArtistEntity artistEntity) {
		this.artistEntity = artistEntity;
	}

	public Duration getDuration() {
		return duration;
	}
	public void setDuration(Duration duration) {
		this.duration = duration;
	}
	public int getLikes_count() {
		return likes_count;
	}
	public void setLikes_count(int likes_count) {
		this.likes_count = likes_count;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

	
	
	
}
