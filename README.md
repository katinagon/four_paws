# Автотесты для сайта CrowdTesting
<p align="center">
<img title="CrowdTesting" src="media/screens/CT.png">
</p>

[Сайт CrowdTesting](https://crowdtesting.ru/)

## :pushpin: Содержание:

- [Технологии и инструменты](#computer-технологии-и-инструменты)
- [Команды для запуска из терминала](#arrow_forward-команды-для-запуска-из-терминала)
- [Сборка в Jenkins](#-сборка-в-jenkins)
- [Пример Allure-отчета](#-пример-allure-отчета)
- [Уведомления в Telegram с использованием бота](#-уведомления-в-telegram-с-использованием-бота)
- [Видео примера запуска тестов в Selenoid](clapper-видео-примера-запуска-тестов-в-selenoid)

## :computer: Технологии и инструменты

<p align="center">
<a href="https://www.jetbrains.com/idea/"><img width="6%" title="IntelliJ IDEA" src="media/icons/Intelij_IDEA.svg"></a>
<a href="https://www.java.com/"><img width="6%" title="Java" src="media/icons/Java.svg"></a>
<a href="https://selenide.org/"><img width="6%" title="Selenide" src="media/icons/Selenide.svg"></a>
<a href="https://aerokube.com/selenoid/"><img width="6%" title="Selenoid" src="media/icons/Selenoid.svg"></a>
<a href="https://github.com/allure-framework/allure2"><img width="6%" title="Allure Report" src="media/icons/Allure_Report.svg"></a>
<a href="https://gradle.org/"><img width="6%" title="Gradle" src="media/icons/Gradle.svg"></a>
<a href="https://junit.org/junit5/"><img width="6%" title="JUnit5" src="media/icons/JUnit5.svg"></a>
<a href="https://github.com/"><img width="6%" title="GitHub" src="media/icons/GitHub.svg"></a>
<a href="https://www.jenkins.io/"><img width="6%" title="Jenkins" src="media/icons/Jenkins.svg"></a>
<a href="https://web.telegram.org/"><img width="6%" title="Telegram" src="media/icons/Telegram.svg"></a>
</p>

- Автотесты написаны на языке <code>Java</code> с использованием фреймворков <code>Selenide</code>, <code>JUnit 5</code>
- Сборщик проекта - <code>Gradle</code> 
- При прогоне тестов браузер запускается в<code> Selenoid</code>
- Для удаленного запуска реализована джоба в <code>Jenkins</code> с формированием Allure-отчета и отправкой результатов в <code>Telegram</code> при помощи бота

## :arrow_forward: Команды для запуска из терминала

### *Локальный запуск:*
```
gradle clean open_pages
```
### *Удалённый запуск через Jenkins:*
```
clean
${TASK}
-Dselenide.pageLoadStrategy=eager
"-Dselenoid.url=${SELENOID_URL}"
-Dselenoid.login=${SELENOID_LOGIN}
-Dselenoid.password=${SELENOID_PASSWORD}
"-Dbrowser=${BROWSER}"
"-Dbrowser.version=${BROWSER_VERSION}"
"-Dbrowser.size=${BROWSER_SIZE}"
```
### *Параметры сборки:*

* <code>TASK</code> – задача для запуска
* <code>BROWSER_VERSION</code> - браузер, в котором будут выполняться тесты. По-умолчанию - <code>chrome</code>.
* <code>BROWSER_VERSION</code> – версия браузера, в которой будут выполняться тесты. По-умолчанию - <code>128.0</code>.
* <code>BROWSER_SIZE</code> – размер окна браузера, в котором будут выполняться тесты. По-умолчанию - <code>1920x1080</code>.

## <img src="media/icons/Jenkins.svg" title="Jenkins" width="4%"/> <a href="https://jenkins.autotests.cloud/job/035-katinagon-hw14/">Сборка в Jenkins</a>
<p align="center">
<img title="Jenkins Build" src="media/screens/Jenkins.png">
</p>

## <img src="media/icons/Allure_Report.svg" title="Allure Report" width="4%"/> <a href="https://jenkins.autotests.cloud/job/035-katinagon-hw14/25/allure/">Пример Allure-отчета</a>
### *Основная страница отчёта*

<p align="center">
<img title="Allure Overview" src="media/screens/Allure_Report.png">
</p>

### *Тест-кейсы*

<p align="center">
<img title="Suites" src="media/screens/Suites.png">
</p>

### *Графики*

<p align="center">
<img title="Graphs" src="media/screens/Graphs.png">
</p>

## <img width="4%" style="vertical-align:middle" title="Telegram" src="media/icons/Telegram.svg"> Уведомления в Telegram с использованием бота

После завершения сборки бот в <code>Telegram</code> автоматически обрабатывает и отправляет сообщение с результатом.

<p align="center">
<img width="70%" title="Telegram bot" src="media/screens/TG_bot.png">
</p>

## :clapper: Видео примера запуска тестов в Selenoid

К каждому тесту в отчете прилагается видео прогона.
<p align="center">
  <img title="Selenoid Video" src="media/screens/test_video.gif">
</p>

