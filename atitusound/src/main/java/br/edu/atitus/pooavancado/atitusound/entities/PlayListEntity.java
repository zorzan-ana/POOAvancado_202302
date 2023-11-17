package br.edu.atitus.pooavancado.atitusound.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_playlist")
public class PlayListEntity extends GenericEntity{

	@Column(name = "public_share")
	private Boolean publicshare;
	
	@ManyToAny(fetch = FetchType.EAGER)
	@JoinTable(name = "tb_playlist_music",
				joinColumns = @JoinColumn(name = "playlist_uuid"),
				inverseJoinColumns = @JoinColumn(name = "music_uuid"))
	private List<MusicEntity> musicEntities = new ArrayList<MusicEntity>();
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_uuid")
	private UserEntity user;
	
	public PlayListEntity() {
		
	}
	
	public PlayListEntity( Boolean public_share) {
		super();
		this.publicshare = public_share;
	}
	public Boolean getPublic_share() {
		return publicshare;
	}
	public void setPublic_share(Boolean public_share) {
		this.publicshare = public_share;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public List<MusicEntity> getMusicEntities() {
		return musicEntities;
	}

	public void setMusicEntities(List<MusicEntity> musicEntities) {
		this.musicEntities = musicEntities;
	}	
	
}
