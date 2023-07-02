# Use Case диаграмма

# MVP
- лента;
- выбор ЯП задачи;
- регистрация и вход в аккаунт;
- отправка писем на почту;
- профиль пользователя + редактирование профиля;
- поиск задачи;
- лента пользователя ("ретвиты" решения задачи в свой профиль);
- редактор кода + отправка решения задачи;
- рейтинг сложности задач;
- чат;
- отметка о статусе решения задачи.
  
![use](https://www.plantuml.com/plantuml/svg/fPRDJjj04CVlUOeL5qx90_I0a118bQXI4UZTIeR4gh4ZhqrxXD2MLY0XSUa9saSmWPGq9E4LTj-e_rqxZjSVoQ67sEkTcT_CpiwCiiq3om_24uU5d6gRLZlmV5xJBxOXxiH8F8j8dk7zACRoN0wm7kCt5qCHYPcOoIlnbubNRBp8QoXhWHp00DyRpEBioFMfQ_E0VEeSSV9J-i__9H-Ot4qSeMrnuhLa0H-_556UYocUyC342-ndM5vfmXvHvuDDdp8MAwB2rpNsRhHfo-wwH_sCuQty2hKd9eOC3hKnC5DveTNtlUvRTrLWhthZYnZZUB475TXxtpks7SeO_WRq2HcQ09_DrrYCoY2x7JieGWhUSSkAAY_5EFLzQF6F6PjxE5Jy20x7AXLCvKb-LmcDlSz4b8G0bH7Ua-JmBN8x1yGzvvIQnpdiBUxv1HP_Ag13yrJNvS13h-IGeE8QnAHul3tRxPJ4yG0tPqpUY6TyJ4IaTNTwdiTfttAxeTMbKWjKQQGpCqNiWpW1SUbg_mceHGwr0zljjiZosxrcFx0zTrMnwX9ILNU1pSZ8JAP4MfuJAj9Ep_BHMkIZ9-msPsOcG1Z97sbQvQMyGChdAFDvLUqrWnxvwsl7G5N4g56BGFCi96WEsZJkJBFTblHHhZBYk_5EJiWDgl3tybiIodhKxgdbX5P0rQm1wlbCNYKi5PysRFP9vJx8wDwX55xrtIU7E8VNkNXONa1QnU-8SrLMwV1Ytd5nPEOtwlMjT7ILo9BPP49pqzByPFMmNzzAfbHUb75M51bZAZDjMCCGiJUCFWSuSBdZj24h76ZPOg7GYuYMN4EQu9RIykQhqirD5zO8-urb84MV49fZWa77TjjEsA7QgYQDmKM7rR6aauurLbjMPDBewa9lQcXURSaiwpVJ9DrDRKeRQvtHegdMn9Ff8AsPcgKQstZWxyq_ "use")


### ВИ Зарегистрироваться
| ВИ | Зарегистрироваться |
| ------------- | ------------- |
| Основные лица | Незарегистрированный пользователь |
| Цель | Регистрация в системе |
| Триггер | Решение пользователя о регистрации  |
| Результат | Успешная регистрация незарегистрированного пользователя |

| Действия актора | Отклик системы |
| ------------- | ------------- |
| 1. Нажатие кнопки "Зарегистрироваться" |   |
|   |  2. Открытие формы регистрации. Поля:<br/>- логин;<br/>- почта;<br/>- пароль;<br/>- повтор пароля.<br/>Кнопка "Зарегистрироваться"|
| 3. Заполнение полей. Нажатие кнопки "Зарегистрироваться" |   |
|  | 4. Проверка корректности данных и наличия пользоватля в БД. Если пользователь в базе есть, то выполняется Исключение 1  |
|  | 5. Проверка корректности данных и наличия пользоватля в БД. Если пользователь ввёл некорректные данные, то выполняется Исключение 2  |
|  | 6. Если всё корректно и пользователь не зарегистрирован, то отправляется письмо со ссылкой для авторизации на почту |
| 7. Открытие письма, переход по ссылке |  |
|  | 8. Активация пользователя. Создание ЛК и перенаправление |

Исключение 1
| Действия актора | Отклик системы |
| ------------- | ------------- |
|  | 1. Если пользователь уже зарегистрирован, то вывод сообщения об этом  |
| 2. Исправление ошибки или переход ко входу в ЛК |   |

Исключение 2
| Действия актора | Отклик системы |
| ------------- | ------------- |
|  | 1. Если пользователем введены некорректные данные, то вывод сообщения об этом  |
| 2. Исправление ошибки. Повторное нажатие кнопки "Зарегистрироваться" |   |

### ВИ Поиск задачи
| ВИ | Поиск задачи |
| ------------- | ------------- |
| Основные лица | Зарегистрированный пользователь |
| Цель | Найти задачу |
| Триггер | Решение пользователя о поиске задачи |
| Результат | Найдена необходимая задача |

| Действия актора | Отклик системы |
| ------------- | ------------- |
| 1. Переход к списку задач |   |
|   |  2. Предоставление пользователю информации о задачах в виде списка. Информация о задаче в списке:<br/>- номер задачи;<br/>- название задачи;<br/>- уровень сложности задачи.<br/>Поле для ввода названия задачи и кнопка "Поиска". Поля для ранжирования задач по:<br/>- уровню сложности(easy, medium, hard);<br/>- статусу задачи (решена/не решена/попытка решения).|
| 3. Пользователь может ввести название задачи/часть названия задачи |   |
|  | 4. Проверка наличия задачи с таким названием/такой частью названия. Если такая задача есть, то пользователю выводится её информация из п.2. Если нет, то выполняется Исключение 1  |
| 5. Пользователь может выбрать задачу и перейти к её просмотру | |

Исключение 1
| Действия актора | Отклик системы |
| ------------- | ------------- |
|  | 1. Если искомой задачи нет, то вывод пользователю сообщения об этом  |
| 2. Поиск задачи с другим названием/другим методом |   |

### ВИ Выбор параметров поиска
| ВИ | Выбор параметров поиска |
| ------------- | ------------- |
| Основные лица | Зарегистрированный пользователь |
| Цель | Отсортировать задачи по параметрам |
| Триггер | Решение пользователя о сортировке задач |
| Предусловние | Открыт поиск задач |
| Результат | Найдены задачи, удовлетворяющие условиям поиска |

| Действия актора | Отклик системы |
| ------------- | ------------- |
| 1. Выбор чек-бокса и его открытие. |   |
|   |  2. Предоставление пользователю списка параметров чек-бокса. Поля параметров по:<br/>- уровню сложности(easy, medium, hard);<br/>- статусу задачи (решена/не решена/попытка решения). |
| 3. Выбор нужного параметра из выпадающего списка|   |
|  | 4. Проверка наличия задач по выбранному параметру. Отображение этого списка. Если таких задач не найдено, то Исключение 1  |
| 5. Пользователь может выбрать задачу и перейти к её просмотру | |

Исключение 1
| Действия актора | Отклик системы |
| ------------- | ------------- |
|  | 1. Если задач по искомому параметру нет, то вывод пользователю сообщения об этом  |
| 2. Поиск задач по другим параметрам |   |