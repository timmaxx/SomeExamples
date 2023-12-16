/*
Курс акции:
Атрибут		Тип		Описание
operDate	LocalDateTime	Время (тик) выставления курса
share		Акция		Ссылка на акцию
rate		BigDecimal	Курс акции
*/

/*
H2 Database

CREATE TABLE share_rates(
	id BIGINT AUTO_INCREMENT PRIMARY KEY,
	operDate datetime NOT NULL,
	share BIGINT NOT NULL,
	rate DECIMAL(15,2) NOT NULL
);
ALTER TABLE share_rates ADD FOREIGN KEY (share) REFERENCES shares(id);
*/

// Oracle

CREATE TABLE share_rates(
	share_rate_id INTEGER PRIMARY KEY,
	operDate DATE NOT NULL,
	share_id INTEGER NOT NULL,
	rate DECIMAL( 15, 2) NOT NULL
);

ALTER TABLE share_rates ADD FOREIGN KEY ( share_id) REFERENCES shares;