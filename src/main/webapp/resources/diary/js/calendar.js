let nav = 0;
let clicked = null;
let events = localStorage.getItem('events') ? JSON.parse(localStorage.getItem('events')) : [];
	 //JSON.parse : translate JSON String to JS String
	 
const calendar = document.getElementById('calendar');
const newEventModal = document.getElementById('newEventModal');
const deleteEventModal = document.getElementById('deleteEventModal');
const backDrop = document.getElementById('modalBackDrop');
const eventTitleInput = document.getElementById('eventTitleInput');
const weekdays = ['Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday'];

function openModal(date) { //when user 'click' date, this function will active
  clicked = date;

  const eventForDay = events.find(e => e.date === clicked);

  if (eventForDay) { //if there is event on day
    document.getElementById('eventText').innerText = eventForDay.title;
    deleteEventModal.style.display = 'block';
  } else {
    newEventModal.style.display = 'block';
  }

  backDrop.style.display = 'block';
}

function load() {
  const dt = new Date();
  	//today
    //this object going to be equal always to whatever date of currently

    //But month can be change. so we need check this   

  if (nav !== 0) {
    dt.setMonth(new Date().getMonth() + nav);
  }
	//if nav = 0 , month is currently month
    //if nav > 0 , month become next month
    //if nav < 0 , month become previous month
    
  const day = dt.getDate(); //day of today
  const month = dt.getMonth(); //month of today
  const year = dt.getFullYear(); //year of today

  const firstDayOfMonth = new Date(year, month, 1); //current month's first day = 1
  const daysInMonth = new Date(year, month + 1, 0).getDate();
  							//0 => (current month+1)'s last day
  							
  const dateString = firstDayOfMonth.toLocaleDateString('en-ko', {
    weekday: 'long',
    year: 'numeric',
    month: 'numeric',
    day: 'numeric',
  });		//printout form: weekdays, month/day/year
  const paddingDays = weekdays.indexOf(dateString.split(', ')[0]);
  										//dateString's first weekday index

	//console.log(dateString);
    //console.log(daysInMonth);
    //console.log(paddingDays);
    
  document.getElementById('monthDisplay').innerText = 
    `${dt.toLocaleDateString('en-ko', { month: 'numeric' })} ${year}`;
		// '' (X), ``(O) 
		
  calendar.innerHTML = '';
  	//calendar initionalizaion for new rendering

  for(let i = 1; i <= paddingDays + daysInMonth; i++) {
	//keep looping paddingDays + daysInMonth => render empty squars on the screen for the padding days  
    const daySquare = document.createElement('div');
    daySquare.classList.add('day');

    const dayString = `${month + 1}/${i - paddingDays}/${year}`;
    					//calendar's form : month/day/year

    if (i > paddingDays) {
      daySquare.innerText = i - paddingDays;
      const eventForDay = events.find(e => e.date === dayString);

      if (i - paddingDays === day && nav === 0) { //if it is current day and month
        daySquare.id = 'currentDay'; //mark highlights
      }
 
      if (eventForDay) { //if there is event
        const eventDiv = document.createElement('div');
        eventDiv.classList.add('event');
        eventDiv.innerText = eventForDay.title;
        daySquare.appendChild(eventDiv);
      }

      daySquare.addEventListener('click', () => openModal(dayString));
    } else {
      daySquare.classList.add('padding');
      daySquare.innerText = i- `${month}/${paddingDays}/${year}`;
    }

    calendar.appendChild(daySquare);    
  }
}

function closeModal() {
  eventTitleInput.classList.remove('error');
  newEventModal.style.display = 'none';
  deleteEventModal.style.display = 'none';
  backDrop.style.display = 'none'; 
  eventTitleInput.value = ''; //cleaning input text.
  clicked = null; //remove click event
  load(); //load calendar again
}

function saveEvent() {
  if (eventTitleInput.value) {
    eventTitleInput.classList.remove('error');

    events.push({
      date: clicked,
      title: eventTitleInput.value,
    });

    localStorage.setItem('events', JSON.stringify(events));
    								//translate JSON of web String to JS String
    closeModal();
  } else {
    eventTitleInput.classList.add('error');
  }
}

function deleteEvent() {
  events = events.filter(e => e.date !== clicked);
  localStorage.setItem('events', JSON.stringify(events));
  closeModal();
}

function initButtons() {
  document.getElementById('nextButton').addEventListener('click', () => {
    nav++;
    load();
  });

  document.getElementById('backButton').addEventListener('click', () => {
    nav--;
    load();
  });

  document.getElementById('saveButton').addEventListener('click', saveEvent);
  document.getElementById('cancelButton').addEventListener('click', closeModal);
  document.getElementById('deleteButton').addEventListener('click', deleteEvent);
  document.getElementById('closeButton').addEventListener('click', closeModal);
}

initButtons();
load();