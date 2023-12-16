/*
Действия трейдеров:
Атрибут		Тип		Описание
operation	int		Тип операции (покупка или продажа)
traider		Трейдер		Ссылка на трейдера
shareRate	Курс акции	Ссылка на курс акции (соответственно на саму акцию, её курс и время его выставление)
amount		Long		Количество акций, участвующих в операции
*/

/*
H2 Database

*/

// Oracle

CREATE TABLE traider_actions (
	traider_action_id INTEGER PRIMARY KEY,
	operation INTEGER NOT NULL,
	traider_id INTEGER NOT NULL,
	share_rate_id INTEGER NOT NULL,
	amount INTEGER NOT NULL
);

ALTER TABLE traider_actions ADD FOREIGN KEY ( traider_id) REFERENCES traiders;
ALTER TABLE traider_actions ADD FOREIGN KEY ( share_rate_id) REFERENCES share_rates;
