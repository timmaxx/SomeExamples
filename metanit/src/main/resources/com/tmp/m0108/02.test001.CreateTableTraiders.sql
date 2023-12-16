/*
Трейдер:
Атрибут			Тип		Описание
name			String		Время (тик) выставления курса
sfreqTick		int		Частота совершения операций. Задана периодом, в тиках, спустя который трейдер совершает операции
cash			BigDecimal	Сумма денег, помимо акций
traidingMethod		int		Используемый трейдером алгоритм. Зададим его числом-константой, реализация алгоритма будет (в следующих частях) в Java-коде
changeProbability	int		Вероятность выполнения операции, в процентах
about			String		Вероятность смены курса, в процентах, на каждом тике
*/

/*
H2 Database
CREATE TABLE traiders(
	id BIGINT AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(255) NOT NULL,
	freqTiсk INTEGER NOT NULL,
	cash  DECIMAL(15,2) NOT NULL DEFAULT 1000,
	tradingMethod INTEGER NOT NULL,
	changeProbability INTEGER NOT NULL DEFAULT 50,
	about VARCHAR(255) NULL
);
ALTER TABLE traiders ADD CONSTRAINT check_traiders_tradingMethod
	CHECK(tradingMethod IN (1,2,3));
ALTER TABLE traiders ADD CONSTRAINT check_traiders_changeProbability
	CHECK(changeProbability <= 100 AND changeProbability > 0);
*/

// Oracle
CREATE TABLE traiders(
	traider_id INTEGER PRIMARY KEY,
	name VARCHAR2( 255) NOT NULL,
	freqTiсk INTEGER NOT NULL,
	cash  DECIMAL( 15,2) NOT NULL,
	tradingMethod INTEGER NOT NULL,
	changeProbability INTEGER NOT NULL,
	about VARCHAR2( 255) NULL
);
ALTER TABLE traiders ADD CONSTRAINT check_traiders_tradingMethod
	CHECK( tradingMethod IN ( 1, 2, 3));
ALTER TABLE traiders ADD CONSTRAINT check_traiders_changeProbability
	CHECK( changeProbability <= 100 AND changeProbability > 0);
COMMENT on TABLE "TEST001"."TRAIDERS"  IS 'Трейдеры';
COMMENT ON COLUMN TRAIDERS.NAME IS 'Время (тик) выставления курса';
COMMENT ON COLUMN TRAIDERS.FREQTIСK IS 'Частота совершения операций. Задана периодом, в тиках, спустя который трейдер совершает операции';
COMMENT ON COLUMN TRAIDERS.CASH IS 'Сумма денег, помимо акций';
COMMENT ON COLUMN TRAIDERS.TRADINGMETHOD IS 'Используемый трейдером алгоритм. Зададим его числом-константой, реализация алгоритма будет (в следующих частях) в Java-коде';
COMMENT ON COLUMN TRAIDERS.CHANGEPROBABILITY IS 'Вероятность выполнения операции, в процентах';
COMMENT ON COLUMN TRAIDERS.ABOUT IS 'Вероятность смены курса, в процентах, на каждом тике';
