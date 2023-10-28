package br.edu.atitus.pooavancado.atitusound.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_playlist")
public class PlayListEntity extends GenericEntity{

	private Boolean public_share;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "tb_playlist_music")
	private List<MusicEntity> musicEntities = new ArrayList<MusicEntity>();
	
	public PlayListEntity() {
		
	}
	
	public PlayListEntity( Boolean public_share) {
		super();
		this.public_share = public_share;
	}
	public Boolean getPublic_share() {
		return public_share;
	}
	public void setPublic_share(Boolean public_share) {
		this.public_share = public_share;
	}	
	
}
