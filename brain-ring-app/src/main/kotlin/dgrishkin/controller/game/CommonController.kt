package dgrishkin.controller.game

import dgrishkin.controller.Constants
import dgrishkin.dto.GameDTO
import dgrishkin.service.GameService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("${Constants.API}${Constants.GAME}")
class CommonController @Autowired constructor(private val gameService: GameService) {

    @GetMapping("/findGames")
    fun findGames() : List<GameDTO> = gameService.findActiveGames()
}