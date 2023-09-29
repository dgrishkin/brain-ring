package dgrishkin.brainring.dao.entity

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "teams")
class Team (
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "teams_team_id_seq")
    @SequenceGenerator(name = "teams_team_id_seq", allocationSize = 1000)
    @Column(name = "team_id")
    override val id: Long? = null,

    @Column(name = "team_name", nullable = false)
    val teamName: String,

    @Column
    val score: Int? = 0,

    @ManyToOne
    @JoinColumn(name = "game_id", nullable = false)
    val game: Game,

    @OneToOne(mappedBy = "winner")
    val round: Round? = null
) : BaseEntity