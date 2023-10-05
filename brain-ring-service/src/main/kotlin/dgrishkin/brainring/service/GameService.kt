package dgrishkin.brainring.service

import dgrishkin.brainring.dao.entity.Game
import dgrishkin.brainring.dao.entity.Game_
import dgrishkin.brainring.dao.enums.GameState
import dgrishkin.brainring.dao.repository.GameRepository
import dgrishkin.brainring.dto.GameDTO
import dgrishkin.brainring.exception.GameRuntimeException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime
import java.util.stream.Collectors

@Service
@Transactional
open class GameService @Autowired constructor(private val gameRepository: GameRepository) {

    open fun findGameById(id: Long): Game {
        return gameRepository.findById(id).orElseThrow { GameRuntimeException("Игра с id = $id не найдена") }
    }

    open fun createGame(name: String): GameDTO {
        val game = Game(gameName = name)
        gameRepository.save(game)

        return mapEntityToDTO(game)
    }

    open fun startGame(id: Long) {
        val game = findGameById(id)
        game.gameState = GameState.STARTED
        gameRepository.save(game)
    }

    open fun endGame(id: Long) {
        val game = findGameById(id)
        game.endDate = LocalDateTime.now()
        game.gameState = GameState.FINISHED
        gameRepository.save(game)
    }

    open fun findActiveGames(): List<GameDTO> =
        gameRepository.findAll { root, _, builder -> builder.isNull(root.get(Game_.endDate)) }
            .stream()
            .map(this::mapEntityToDTO)
            .collect(Collectors.toList())

    open fun findFinishedGames(): List<GameDTO> =
        gameRepository.findAll { root, _, builder -> builder.isNotNull(root.get(Game_.endDate)) }
            .stream()
            .map(this::mapEntityToDTO)
            .collect(Collectors.toList())

    private fun mapEntityToDTO(entity: Game): GameDTO =
        GameDTO(id = entity.id, gameName = entity.gameName, startDate = entity.startDate, endDate = entity.endDate)
}