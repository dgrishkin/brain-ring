package dgrishkin.brainring.web.controller

import dgrishkin.brainring.dto.GameDTO
import dgrishkin.brainring.service.GameService
import dgrishkin.brainring.utils.Constants
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("${Constants.API}/game")
class GameController @Autowired constructor(private val gameService: GameService) {

    @GetMapping("/findGames")
    fun findGames() : List<GameDTO> = gameService.findActiveGames()

    @GetMapping("${Constants.MASTER}/findFinishedGames")
    fun findFinishedGames() : List<GameDTO> = gameService.findFinishedGames()

    @GetMapping("${Constants.MASTER}/startGame")
    fun startGame(@RequestParam("name") name: String) : GameDTO = gameService.createGame(name)

    @GetMapping("${Constants.MASTER}/stopGame")
    fun stopGame(@RequestParam("id") id: Long) = gameService.endGame(id)
}