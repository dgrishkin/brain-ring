package dgrishkin.service.test

import dgrishkin.service.GameService
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
        val game = gameService.createGame("game1")
        assertNotNull(game.id, "Игра не создана")
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
        assertEquals(0, activeGames.size, "Остались активные игры")
    }
}