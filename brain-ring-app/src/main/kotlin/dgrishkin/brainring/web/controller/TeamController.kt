package dgrishkin.brainring.web.controller

import dgrishkin.brainring.web.dto.AddTeamDTO
import dgrishkin.brainring.dto.TeamDTO
import dgrishkin.brainring.service.TeamService
import dgrishkin.brainring.utils.Constants
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("${Constants.API}/team")
class TeamController @Autowired constructor(private val teamService: TeamService) {
    @GetMapping("/loadTeams")
    fun loadTeams(@RequestParam("gameId") gameId: Long): List<TeamDTO> = teamService.loadTeams(gameId)

    @PostMapping("${Constants.MASTER}/addTeam")
    fun addTeam(@RequestBody dto: AddTeamDTO): TeamDTO = teamService.createTeam(dto.teamName, dto.gameId)
}