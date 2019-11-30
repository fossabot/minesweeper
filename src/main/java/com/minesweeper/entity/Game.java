package com.minesweeper.entity;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import org.hibernate.annotations.GenericGenerator;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name = "games")
public class Game extends TimestampedEntity implements Serializable {
	private static final long serialVersionUID = -6507963547063710509L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	private Long id;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "game_configuration_id", referencedColumnName = "id")
	private GameConfiguration gameConfiguration;

	@Builder
	public Game(Long id, GameConfiguration gameConfiguration, Instant createdOn, Instant lastModified) {
		super(createdOn, lastModified);
		this.id = id;
		this.gameConfiguration = gameConfiguration;
	}
}
