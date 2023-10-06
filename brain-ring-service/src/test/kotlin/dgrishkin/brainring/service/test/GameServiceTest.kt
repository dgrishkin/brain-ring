package dgrishkin.brainring.service.test

import dgrishkin.brainring.dao.enums.GameState
import dgrishkin.brainring.dto.GameDTO
import dgrishkin.brainring.service.GameService
import org.junit.jupiter.api.MethodOrderer
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.TestMethodOrder
import org.slf4j.LoggerFactory
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
    private val LOG = LoggerFactory.getLogger(this::class.java)
    @Test
    @Order(1)
    fun createGameTest() {
        LOG.info(">>>Тест создания игры")
        val gameDTO = gameService.createGame("game1")
        LOG.info(">>>Создана игра: {}", gameDTO)
        assertNotNull(gameDTO.id, "Игра не создана")
        assertState(gameDTO, GameState.CREATED)
    }

    @Test
    @Order(2)
    fun findActiveGamesTest() {
        LOG.info(">>>Тест поиска активных игр")
        val games = gameService.findActiveGames()
        LOG.info(">>>Активные игры: {}", games)
        assertNotEquals(0, games.size, "Нет активных игр")
    }

    @Test
    @Order(3)
    fun endGameTest() {
        LOG.info(">>>Тест завершения игры")
        val games = gameService.findActiveGames()
        gameService.endGame(games[0].id!!)
        val activeGames = gameService.findActiveGames()
        assertEquals(0, activeGames.size, "Найдены активные игры")
    }

    @Test
    @Order(4)
    fun findFinishedGamesTest() {
        LOG.info(">>>Тест поиска завершенных игр")
        val games = gameService.findFinishedGames()
        LOG.info(">>>Завершенные игры: {}", games)
        assertEquals(1, games.size, "Не найдено завершенных игр")
        assertState(games[0], GameState.FINISHED)
    }

    private fun assertState(gameDTO: GameDTO, correctState: GameState) {
        val game = gameService.findGameById(gameDTO.id!!)
        assertEquals(
            correctState,
            game.gameState,
            "Не верное состояние игры. Найдено: ${game.gameState}; Должно быть $correctState"
        )
    }
}