# Проект по автоматизации тестирования сайта \"4 лапы"
<p align="center">
<img title="4lapy" src="media/screens/4lapy.png">
</p>

«Четыре Лапы» — одна из крупнейших сетей зоомагазинов и сервисов для заботы о питомцах в России. 
Сеть охватывает широкую сферу товаров и услуг: от покупки премиальных кормов до передержки и ветеринарных услуг.   
[Сайт "4 лапы"](https://4lapy.ru/)

## :pushpin: Содержание:

- [Технологии и инструменты](#computer-технологии-и-инструменты)
- [Факты о проекте](#clipboard-факты-о-проекте)
- [Примеры автоматизированных тест-кейсов](#heavy_check_mark-примеры-автоматизированных-тест-кейсов)
- [Команды для запуска из терминала](#arrow_forward-команды-для-запуска-из-терминала)
- [Сборка в Jenkins](#-сборка-в-jenkins)
- [Пример Allure-отчета](#-пример-allure-отчета)
- [Уведомления в Telegram с использованием бота](#-уведомления-в-telegram-с-использованием-бота)
- [Видео примера запуска тестов в Selenoid](#clapper-видео-примера-запуска-тестов-в-selenoid)

## :computer: Технологии и инструменты

<p align="center">
<code><a href="https://www.jetbrains.com/idea/"><img width="5%" title="IntelliJ IDEA" src="media/icons/Intelij_IDEA.svg"></a></code>
<code><a href="https://www.java.com/"><img width="5%" title="Java" src="media/icons/Java.svg"></a></code>
<code><a href="https://gradle.org/"><img width="5%" title="Gradle" src="media/icons/Gradle.svg"></a></code>
<code><a href="https://junit.org/junit5/"><img width="5%" title="JUnit5" src="media/icons/JUnit5.svg"></a></code>
<code><a href="https://selenide.org/"><img width="5%" title="Selenide" src="media/icons/Selenide.svg"></a></code>
<code><a href="https://aerokube.com/selenoid/"><img width="5%" title="Selenoid" src="media/icons/Selenoid.svg"></a></code>
<code><a href="https://rest-assured.io/"><img width="5%" title="REST-Assured" src="media/icons/RestAssured.svg"></a></code>
<code><a href="https://github.com/"><img width="5%" title="GitHub" src="media/icons/GitHub.svg"></a></code>
<code><a href="https://www.jenkins.io/"><img width="5%" title="Jenkins" src="media/icons/Jenkins.svg"></a></code>
<code><a href="https://github.com/allure-framework/allure2"><img width="5%" title="Allure Report" src="media/icons/Allure_Report.svg"></a></code>
<code><a href="https://qameta.io/"><img width="5%" title="Allure TestOps" src="media/icons/AllureTestOps.svg"></a></code>
<code><a href="https://web.telegram.org/"><img width="5%" title="Telegram" src="media/icons/Telegram.svg"></a></code>
<code><a href="https://www.atlassian.com/software/jira"><img width="5%" title="Jira" src="media/icons/Jira.svg"></a></code>
</p>

Автотесты написаны на `Java` с использованием фреймворка `Selenide`.\
`Gradle` - сборщик проекта.  \
`JUnit5` - для выполнения тестов.\
`REST Assured` - для тестирования REST-API сервисов.\
`Jenkins` - CI/CD для запуска тестов удаленно.\
`Selenoid` - для удаленного запуска браузера.\
`Allure Report` - для визуализации результатов тестирования.\
`Telegram Bot` - для уведомлений о результатах тестирования.\
`Allure TestOps` - как система управления тестированием.

## :clipboard: Факты о проекте
- [x] Тестовый проект состоит из UI и API автотестов
- [x] `Page Object` проектирование UI-тестов
- [x] Различные файлы конфигурации для запуска теста в зависимости от параметров сборки
- [x] Конфигурация с библиотекой `Owner`
- [x] Использование `Lombok` для моделей в API тестах
- [x] Использование request/response спецификаций для API тестов
- [x] Custom Allure listener для API requests/responses логов
- [x] Интеграция с `Allure TestOps`
- [x] Автотесты как тестовая документация
- [x] Интеграция с `Jira`

## :heavy_check_mark: Примеры автоматизированных тест-кейсов
- :white_check_mark: Авторизация
    - :heavy_check_mark: Успешная авторизация через почту
    - :heavy_check_mark: Неуспешная авторизация с незарегистрированной почтой
    - :heavy_check_mark: Неуспешная авторизация с пустым паролем
    - :heavy_check_mark: Неуспешная авторизация с пустым номером телефона
- :white_check_mark: Товары
    - :heavy_check_mark: Добавление товара в корзину
    - :heavy_check_mark: Удаление товара из корзины

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
<img title="Allure Overview" src="media/screens/AllureReport.png">
</p>

### *Тест-кейсы*

<p align="center">
<img title="Suites" src="media/screens/TestCase.png">
</p>

### *Графики*

<p align="center">
<img title="Graphs" src="media/screens/Graphs.png">
</p>

## <img width="4%" style="vertical-align:middle" title="Telegram" src="media/icons/Telegram.svg"> Уведомления в Telegram с использованием бота

После завершения сборки бот в <code>Telegram</code> автоматически обрабатывает и отправляет сообщение с результатом.

<p align="center">
<img width="70%" title="Telegram bot" src="media/screens/Telegram.png">
</p>

## :clapper: Видео примера запуска тестов в Selenoid

К каждому тесту в отчете прилагается видео прогона.
<p align="center">
  <img title="Selenoid Video" src="media/screens/Video.gif">
</p>

