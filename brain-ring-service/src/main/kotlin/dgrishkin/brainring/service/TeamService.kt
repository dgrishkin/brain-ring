package dgrishkin.brainring.service

import dgrishkin.brainring.dao.entity.Team
import dgrishkin.brainring.dao.repository.TeamRepository
import dgrishkin.brainring.dto.TeamDTO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.stream.Collectors

@Service
@Transactional
open class TeamService @Autowired constructor(
    private val teamRepository: TeamRepository,
    private val gameService: GameService
) : AbstractDataAccessService<Team, TeamDTO>(Team::class, TeamDTO::class) {
    open fun createTeam(teamName: String, gameId: Long): TeamDTO {
        val game = gameService.findGameById(gameId)
        val team = Team(teamName = teamName, game = game)
        teamRepository.save(team)

        return mapEntityToDTO(team)
    }

    open fun loadTeams(gameId: Long): List<TeamDTO> {
        val game = gameService.findGameById(gameId)
        return game.teams!!
            .map(this::mapEntityToDTO)
    }
}