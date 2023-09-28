package dgrishkin.controller.team

import dgrishkin.controller.Constants
import dgrishkin.dto.AddTeamDTO
import dgrishkin.dto.TeamDTO
import dgrishkin.service.GameService
import dgrishkin.service.TeamService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("${Constants.API}${Constants.TEAM}${Constants.MASTER}")
class MasterController @Autowired constructor(private val teamService: TeamService) {
    @PostMapping("/addTeam")
    fun addTeam(@RequestBody dto: AddTeamDTO): TeamDTO = teamService.createTeam(dto.teamName, dto.gameId)
}