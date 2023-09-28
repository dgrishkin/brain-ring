package dgrishkin.dao.entity

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "games")
class Game (
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "games_game_id_seq")
    @SequenceGenerator(name = "games_game_id_seq", allocationSize = 1000)
    @Column(name = "game_id")
    override val id: Long? = null,

    @Column(name = "game_name", nullable = false)
    val gameName: String,

    @Column(name = "start_date", nullable = false)
    val startDate: LocalDateTime? = LocalDateTime.now(),

    @Column(name = "end_date")
    var endDate: LocalDateTime? = null,

    @OneToMany(mappedBy = "game")
    val teams: List<Team>? = arrayListOf(),

    @OneToMany(mappedBy = "game")
    val rounds: List<Round>? = arrayListOf(),
) : BaseEntity