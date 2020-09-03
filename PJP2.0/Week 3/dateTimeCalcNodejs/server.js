const dateTimeCalc = require('./dateTimeCalcES6')

const express = require('express');
const app = express();

const bodyParser = require('body-parser');
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: true }));

// add and subtract POST body
// {
//     "date" : "2020-09-12T00:00:00.000Z",
//     "value" : 2,
//     "unit" : 3
// }

app.post('/api/add', (request, response) => {
    let currentDate = new Date(request.body.date);
    let unitType = parseInt(request.body.unit)

    let finalDate;
    if (unitType == 0) {
        finalDate = currentDate.addDays(request.body.value)
    }
    else if (unitType == 1) {
        finalDate = currentDate.addWeeks(request.body.value)
    }
    else if (unitType == 2) {
        finalDate = currentDate.addMonth(request.body.value)
    }
    else if (unitType == 3) {
        finalDate = currentDate.addFullYear(request.body.value)
    }

    response.json({
        result: finalDate
    });
});

app.post('/api/subtract', (request, response) => {
    let currentDate = new Date(request.body.date);
    let unitType = parseInt(request.body.unit)

    let finalDate;
    if (unitType == 0) {
        finalDate = currentDate.subtractDays(request.body.value)
    }
    else if (unitType == 1) {
        finalDate = currentDate.subtractWeeks(request.body.value)
    }
    else if (unitType == 2) {
        finalDate = currentDate.subtractMonth(request.body.value)
    }
    else if (unitType == 3) {
        finalDate = currentDate.subtractFullYear(request.body.value)
    }

    response.json({
        result: finalDate
    });
});

// subtract-date POST body
// {
//     "date1" : "2020-09-12T00:00:00.000Z",
//     "date2" : "2020-09-15T00:00:00.000Z"
// }

app.post('/api/subtract-date', (request, response) => {
    let date1 = new Date(request.body.date1);
    let date2 = new Date(request.body.date2);

    response.json({
        result: date1.subtractDate(date2) // in days
    });
});

// DoW and WoM POST body
// {
//     "date" : "2020-09-12T00:00:00.000Z"
// }

app.post('/api/day-of-week', (request, response) => {
    let date = new Date(request.body.date);

    response.json({
        result: date.getDayOfWeek()
    });
});

app.post('/api/week-of-month', (request, response) => {
    let date = new Date(request.body.date);

    response.json({
        result: date.getWeekOfMonth()
    });
});

// NL POST body
// {
//     "date" : "2020-09-12T00:00:00.000Z",
//     "phrase": "2 days from now"
// }

app.post('/api/nl', (request, response) => {
    let date = new Date(request.body.date);

    response.json({
        result: date.nlEngine(request.body.phrase)
    });
});

app.listen(8080);