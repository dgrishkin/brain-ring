package dgrishkin.controller.team

import dgrishkin.controller.Constants
import dgrishkin.dto.TeamDTO
import dgrishkin.service.GameService
import dgrishkin.service.TeamService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("${Constants.API}${Constants.TEAM}")
class CommonController @Autowired constructor(private val teamService: TeamService) {
    @GetMapping("/loadTeams")
    fun loadTeams(@RequestParam("gameId") gameId: Long): List<TeamDTO> = teamService.loadTeams(gameId)
}