import utility.*
import java.util.*

val scan = Scanner(System.`in`)
val asker: BychaAsker = BychaAsker(scan)
val fileManager: FileManager = FileManager(asker.askForFileName(), asker)
val entityManager = EntityManager(fileManager.readCollection())
val commandManager = CommandManager(asker)
val requestManager = RequestManager(entityManager, asker, fileManager, commandManager)

fun main(args: Array<String>) {
    val start = ClientManager(scan, commandManager, asker)
    start.run()
}