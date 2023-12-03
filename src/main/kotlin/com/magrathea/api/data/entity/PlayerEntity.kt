package com.magrathea.api.data.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.ManyToMany
import jakarta.persistence.OneToMany
import jakarta.persistence.Table

@Entity
@Table(name = "player")
class PlayerEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    val id: Long? = null,
    @Column(name = "name")
    val name: String,
    @Column(name = "surname")
    val surname: String,
    @Column(name = "phoneNumber")
    val phoneNumber: String,
    @ManyToMany(mappedBy = "enrolledPlayers", fetch = FetchType.EAGER)
    val enrolledGames: MutableSet<GameEntity>? = mutableSetOf(),
    @OneToMany(mappedBy = "owner")
    val ownedGames: MutableSet<GameEntity> = mutableSetOf()
)