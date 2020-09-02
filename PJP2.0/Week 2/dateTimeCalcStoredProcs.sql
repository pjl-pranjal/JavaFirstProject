CREATE TABLE ops (
	id serial PRIMARY KEY,
	op_type VARCHAR (255) NOT NULL,
	op_input DATE,
	op_input1 DATE,
	phrase VARCHAR (255),
	val integer,
	output DATE,
	unitType integer
);

CREATE FUNCTION addValue (date DATE, val int, unittype int)
  RETURNS DATE
AS $$
	from datetime import datetime
	from dateutil.relativedelta import relativedelta
	
	startDateTime = datetime.strptime(date, "%Y-%m-%d")
	if (unittype == 0):
		return startDateTime + relativedelta(days=val)
	elif (unittype == 1):
		return startDateTime + relativedelta(weeks=val)
	elif (unittype == 2):
		return startDateTime + relativedelta(months=val)
	elif (unittype == 3):
		return startDateTime + relativedelta(years=val)
		
	return startDateTime
$$ LANGUAGE plpythonu;

CREATE FUNCTION subtractValue (date DATE, val int, unittype int)
  RETURNS DATE
AS $$
	from datetime import datetime
	from dateutil.relativedelta import relativedelta
	
	startDateTime = datetime.strptime(date, "%Y-%m-%d")
	if (unittype == 0):
		return startDateTime - relativedelta(days=val)
	elif (unittype == 1):
		return startDateTime - relativedelta(weeks=val)
	elif (unittype == 2):
		return startDateTime - relativedelta(months=val)
	elif (unittype == 3):
		return startDateTime - relativedelta(years=val)
		
	return startDateTime
$$ LANGUAGE plpythonu;

CREATE FUNCTION subtractDate (date1 DATE, date2 DATE)
  RETURNS varchar
AS $$
	from datetime import datetime
	from dateutil.relativedelta import relativedelta
	
	timeDiff = datetime.strptime(date1, "%Y-%m-%d") - datetime.strptime(date2, "%Y-%m-%d")
	return abs(timeDiff.days)
$$ LANGUAGE plpythonu;

CREATE FUNCTION dayOfWeek (date DATE)
  RETURNS varchar
AS $$
	from datetime import datetime
	from dateutil.relativedelta import relativedelta
	
	return datetime.strptime(date, "%Y-%m-%d").strftime('%A')
$$ LANGUAGE plpythonu;