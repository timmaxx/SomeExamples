/*
Акция:
Атрибут			Тип		Описание
name			String		Наименование
changeProbability	int		Вероятность смены курса в процентах на каждом тике
startPrice		BigDecimal	Начальная стоимость
delta			int		Максимальная величина в процентах, на которую может смениться текущая стоимость
*/

/*
H2 Database

*/

// Oracle
CREATE TABLE shares(
	share_id INTEGER PRIMARY KEY,
	name VARCHAR2( 255),
	changeProbability INTEGER NOT NULL,
	startPrice DECIMAL( 15, 2) NOT NULL,
	delta INTEGER
);

comment on table "TEST001"."SHARES"  is 'Акции';

COMMENT ON COLUMN SHARES.NAME IS 'Наименование';
COMMENT ON COLUMN SHARES.CHANGEPROBABILITY IS 'Вероятность смены курса в процентах на каждом тике';
COMMENT ON COLUMN SHARES.STARTPRICE IS 'Начальная стоимость';
COMMENT ON COLUMN SHARES.DELTA IS 'Максимальная величина в процентах, на которую может смениться текущая стоимость';
