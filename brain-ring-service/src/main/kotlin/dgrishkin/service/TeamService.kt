package dgrishkin.service

import dgrishkin.dao.entity.Team
import dgrishkin.dao.entity.Team_
import dgrishkin.dao.repository.TeamRepository
import dgrishkin.dto.TeamDTO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.stream.Collectors

@Service
@Transactional
open class TeamService @Autowired constructor(
    private val teamRepository: TeamRepository,
    private val gameService: GameService
) {
    open fun createTeam(teamName: String, gameId: Long): TeamDTO {
        val game = gameService.findGameById(gameId)
        val team = Team(teamName = teamName, game = game)
        teamRepository.save(team)

        return mapEntityToDTO(team)
    }

    open fun loadTeams(gameId: Long): List<TeamDTO> {
        val game = gameService.findGameById(gameId)
        return teamRepository.findAll { root, _, builder -> builder.equal(root.get(Team_.game), game) }
            .stream()
            .map(this::mapEntityToDTO)
            .collect(Collectors.toList())
    }

    private fun mapEntityToDTO(team: Team): TeamDTO = TeamDTO(
        id = team.id,
        teamName = team.teamName,
        score = team.score
    )
}