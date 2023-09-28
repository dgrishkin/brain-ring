package dgrishkin.controller.game

import dgrishkin.controller.Constants
import dgrishkin.dto.GameDTO
import dgrishkin.service.GameService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("${Constants.API}${Constants.GAME}${Constants.MASTER}")
class MasterController @Autowired constructor(private val gameService: GameService) {
    @GetMapping("/startGame")
    fun startGame(@RequestParam("name") name: String) : GameDTO = gameService.createGame(name)

    @GetMapping("/stopGame")
    fun stopGame(@RequestParam("id") id: Long) = gameService.endGame(id)
}