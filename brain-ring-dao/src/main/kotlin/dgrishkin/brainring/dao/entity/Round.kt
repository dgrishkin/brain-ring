package dgrishkin.brainring.dao.entity

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "rounds")
class Round (
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rounds_round_id_seq")
    @SequenceGenerator(name = "rounds_round_id_seq", allocationSize = 1000)
    @Column(name = "round_id")
    override val id: Long,

    @Column(name = "round_num", nullable = false)
    val roundNum: Int,

    @ManyToOne
    @JoinColumn(name = "game_id", nullable = false)
    val game: Game,

    @OneToOne
    @JoinColumn(name = "winner")
    val winner: Team
) : BaseEntity