Date.prototype.addDays = function(days) {
    let date = new Date(this.valueOf());
    date.setDate(date.getDate() + days);
    return date;
}

Date.prototype.addWeeks = function(weeks) {
    let date = new Date(this.valueOf());
    date.setDate(date.getDate() + weeks * 7);
    return date;
}

Date.prototype.addMonth = function(months) {
    let date = new Date(this.valueOf());
    date.setMonth(date.getMonth() + months);
    return date;
}

Date.prototype.addFullYear = function(years) {
    let date = new Date(this.valueOf());
    date.setFullYear(date.getFullYear() + years);
    return date;
}

Date.prototype.subtractDays = function(days) {
    let date = new Date(this.valueOf());
    date.setDate(date.getDate() - days);
    return date;
}

Date.prototype.subtractWeeks = function(weeks) {
    let date = new Date(this.valueOf());
    date.setDate(date.getDate() - weeks * 7);
    return date;
}

Date.prototype.subtractMonth = function(months) {
    let date = new Date(this.valueOf());
    date.setMonth(date.getMonth() - months);
    return date;
}

Date.prototype.subtractFullYear = function(years) {
    let date = new Date(this.valueOf());
    date.setFullYear(date.getFullYear() - years);
    return date;
}

// get result in Days
Date.prototype.subtractDate = function(date) {
  	const msPerDay = 8.64e7;
  
    let thisDate = new Date(this.valueOf());
    return Math.round( Math.abs((thisDate - date)) / msPerDay ) + 1;
}

Date.prototype.getDayOfWeek = function() {
  	let weekday = new Array(7);
    weekday[0] = "Sunday";
    weekday[1] = "Monday";
    weekday[2] = "Tuesday";
    weekday[3] = "Wednesday";
    weekday[4] = "Thursday";
    weekday[5] = "Friday";
    weekday[6] = "Saturday";
  
    let date = new Date(this.valueOf());
    return weekday[date.getDay()];
}

Date.prototype.getWeekOfMonth = function() {
    let firstWeekday = new Date(this.getFullYear(), this.getMonth(), 1).getDay();
  	let offsetDate = this.getDate() + firstWeekday - 1;
  	return Math.floor( offsetDate / 7 );
}

Date.prototype.nlEngine = function(phrase) {
	let value = 0, newPhrase = phrase;
	let tokens = phrase.split(' ');
	if (!isNaN(tokens[0])) {
		value = parseInt(tokens[0]);
		const [, ...rest] = tokens;
		newPhrase = rest.join(' ');
	}

	let phrases = new Map();
	let thisDate = new Date(this.valueOf());
	phrases.set('today', thisDate);
	phrases.set('tomorrow', thisDate.addDays(1));
	phrases.set('yesterday', thisDate.subtractDays(1));
	phrases.set('days from now', thisDate.addDays(value));
	phrases.set('days earlier', thisDate.subtractDays(value));

	return phrases.get(newPhrase);
}

let date = new Date();
console.log(date.nlEngine('5 days earlier'));