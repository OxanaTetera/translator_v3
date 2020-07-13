Для запуска необходима установленная java версии 8 и выше.

Для создания .jar должен быть установлен maven версии не ниже 3.
Выполнить в командной строке
mvn clean install

Затем выполнить
mvn dependency:copy-dependencies

Перенести translator-0.0.1-SNAPSHOT.jar из папки target в папку dependency.

Для запуска открыть терминал по адресу /translator/target/dependency
Выполнить команду: java -jar translator-0.0.1-SNAPSHOT.jar

Для проверки необходимо послать POST запрс сервису, например через POSTMAN:
Выбрать raw и JSON(application/json)
Body:
{
	"text":"London is the capital of Great Britain",
	"from":"en",
	"to":"ru"
}

Так же проект можно запустить из среды разработки.
Для открытия через IntelliJ Idea, необходимо перейти в среду разработки и выбрать File->Open.
Выбрать файл /translator/pom.xml