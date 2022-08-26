$(document).ready(function () {
    calendarInit();

    let ms = 544321;
    (ms / 1000);
});

function calendarInit() {

    // 날짜 정보 가져오기
    let date = new Date(); // 현재 날짜(로컬 기준) 가져오기
    let utc = date.getTime() + (date.getTimezoneOffset() * 60 * 1000); // uct 표준시 도출
    let kstGap = 9 * 60 * 60 * 1000; // 한국 kst 기준시간 더하기
    let today = new Date(utc + kstGap);

    let thisMonth = new Date(today.getFullYear(), today.getMonth(), today.getDate());

    let currentYear = thisMonth.getFullYear(); // 달력에서 표기하는 연
    let currentMonth = thisMonth.getMonth(); // 달력에서 표기하는 월
    let currentDate = thisMonth.getDate(); // 달력에서 표기하는 일

    // 캘린더 렌더링
    renderCalender(thisMonth);

    function renderCalender(thisMonth) {

        // 렌더링을 위한 데이터 정리
        currentYear = thisMonth.getFullYear();
        currentMonth = thisMonth.getMonth();
        currentDate = thisMonth.getDate();

        // 이전 달의 마지막 날 날짜와 요일 구하기
        let startDay = new Date(currentYear, currentMonth, 0);
        let prevDate = startDay.getDate();
        let prevDay = startDay.getDay();

        // 이번 달의 마지막날 날짜와 요일 구하기
        let endDay = new Date(currentYear, currentMonth + 1, 0);
        let nextDate = endDay.getDate();
        let nextDay = endDay.getDay();

        // 현재 월 표기
        $('.year-month').text(currentYear + '.' + (currentMonth + 1));

        // 렌더링 html 요소 생성
        calendar = document.querySelector('.dates')
        calendar.innerHTML = '';

        // 지난달
        for (let i = prevDate - prevDay + 1; i <= prevDate; i++) {
            calendar.innerHTML = calendar.innerHTML + '<div class="day prev disable">' + i + '</div>'
        }
        // 이번달
        for (let i = 1; i <= nextDate; i++) {
            calendar.innerHTML = calendar.innerHTML + '<div class="day current">' + i + '</div>'
        }
        // 다음달
        for (let i = 1; i <= (7 - nextDay == 7 ? 0 : 7 - nextDay); i++) {
            calendar.innerHTML = calendar.innerHTML + '<div class="day next disable">' + i + '</div>'
        }

        // 오늘 날짜 표기
        if (today.getMonth() == currentMonth) {
            todayDate = today.getDate();
            let currentMonthDate = document.querySelectorAll('.dates .current');
            currentMonthDate[todayDate - 1].classList.add('today');
            currentMonthDate[todayDate - 1].style.color = '#3b5bdb';
            currentMonthDate[todayDate - 1].style.fontWeight = 'bold'
            // currentMonthDate[todayDate -1].innerHTML = currentMonthDate[todayDate -1].innerHTML + '<div><sub>Today</sub></div>'
        }
    }

    // 이전달로 이동
    $('.go-prev').on('click', function () {
        thisMonth = new Date(currentYear, currentMonth - 1, 1);
        renderCalender(thisMonth);
        addClickEvent();
    });

    // 다음달로 이동
    $('.go-next').on('click', function () {
        thisMonth = new Date(currentYear, currentMonth + 1, 1);
        renderCalender(thisMonth);
        addClickEvent();
    });


    // 날짜 선택
    let fileDate = 0;

    // 다른 요소 클릭시 이전 요소 배경을 흰색으로
    function clearBackground() {
        let days = document.querySelectorAll('.current');
        for (let i = 0; i < days.length; i++) {
            days[i].style.background = 'white'
        }

    }

    // 날짜 선택
    function selectDay(event) {
        clearBackground();
        event.target.style.background = '#ced4da';
        fileDate = event.target.innerText;
        fileDate = getYearMonth() + '-' + fileDate;
        (fileDate);
    }

    addClickEvent();

    // 모든 날짜에 click event 추가
    function addClickEvent() {
        let days = document.querySelectorAll('.current');
        for (let i = 0; i < days.length; i++) {
            days[i].addEventListener("click", selectDay);
        }
    }

    // 선택한 일자의 연, 월 구하기
    function getYearMonth() {
        let yearMonthStr = document.querySelector('.year-month').innerText;
        yearMonth = yearMonthStr.split('.');
        if (yearMonth[1] < 10) {
            yearMonthStr = yearMonth[0] + '-' + '0' + yearMonth[1];
        } else {
            yearMonthStr = yearMonth[0] + '-' + yearMonth[1];
        }
        return yearMonthStr;
    }

    // 선택한 날짜 ajax 통신
    document.querySelector('.calendar-btn').addEventListener("click", sendDate);

    function sendDate() {
        $.ajax({
            type: 'post',
            url: '/home/select-date',
            data: {
                date: fileDate
            },
            success: function (data) {
                if (data == true) {
                    window.location.href = '/api/analysis/dags-log/api-type';
                } else {
                    alert("해당 날짜의 file이 존재 하지 않습니다. \n :: Selected Date : " + fileDate);
                }
            },
            error: function () {
                console.log("error");
            }
        })
    }
}
