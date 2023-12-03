package com.magrathea.api.data.entity

import jakarta.persistence.CascadeType
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.JoinTable
import jakarta.persistence.ManyToMany
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import java.time.LocalDate

@Entity
@Table(name = "game")
class GameEntity(
    @Id
    @GeneratedValue
    val id: Long?,
    val date: LocalDate,
    val name: String,
    val street: String,
    val number: String,
    val city: String,
    val state: String,

    @ManyToMany(cascade = [CascadeType.ALL])
    @JoinTable(
        name = "PLAYER_ENROLLED_GAMES",
        joinColumns = [JoinColumn(name = "game_id")],
        inverseJoinColumns = [JoinColumn(name = "player_id")]
    )
    val enrolledPlayers: MutableSet<PlayerEntity> = mutableSetOf(),

    @ManyToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "owner_id")
    var owner: PlayerEntity?
)