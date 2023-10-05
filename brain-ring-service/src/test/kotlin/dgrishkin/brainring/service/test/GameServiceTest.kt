package dgrishkin.brainring.service.test

import dgrishkin.brainring.dao.enums.GameState
import dgrishkin.brainring.dto.GameDTO
import dgrishkin.brainring.service.GameService
import org.junit.jupiter.api.MethodOrderer
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.TestMethodOrder
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.Import
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals
import kotlin.test.assertNotNull

@SpringBootTest(classes = [GameService::class])
@Import(MainTestConfiguration::class)
@TestMethodOrder(MethodOrderer.OrderAnnotation::class)
internal class GameServiceTest @Autowired constructor(private val gameService: GameService) {

    @Test
    @Order(1)
    fun createGameTest() {
        val gameDTO = gameService.createGame("game1")
        assertNotNull(gameDTO.id, "Игра не создана")
        assertState(gameDTO, GameState.CREATED)
    }

    @Test
    @Order(2)
    fun findActiveGamesTest() {
        val games = gameService.findActiveGames()
        assertNotEquals(0, games.size, "Нет активных игр")
    }

    @Test
    @Order(3)
    fun endGameTest() {
        val games = gameService.findActiveGames()
        gameService.endGame(games[0].id!!)
        val activeGames = gameService.findActiveGames()
        assertEquals(0, activeGames.size, "Найдены активные игры")
    }

    @Test
    @Order(4)
    fun findFinishedGamesTest() {
        val games = gameService.findFinishedGames()
        assertEquals(1, games.size, "Не найдено завершенных игр")
        assertState(games[0], GameState.FINISHED)
    }

    private fun assertState(gameDTO: GameDTO, correctState: GameState) {
        val game = gameService.findGameById(gameDTO.id!!)
        assertEquals(correctState, game.gameState, "Не верное состояние игры. Найдено: ${game.gameState}; Должно быть $correctState")
    }
}