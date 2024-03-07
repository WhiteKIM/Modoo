const membersId = [];
let index = 0;
document.getElementById('member-submit').addEventListener('click', function () {
  let inputVal = document.getElementById('memberId');
  membersId[index++] = inputVal.value;
  inputVal.value = '';
});

function createTeam() {
  const title = document.getElementById('title').value;

  const data = {
    title: title,
    membersId: membersId,
  };

  fetch('http://127.0.0.1:8080/api/team/create', {
    method: 'POST',
    body: JSON.stringify(data),
    headers: {
      'Content-Type': 'application/json',
      'X-AUTH-TOKEN': localStorage.getItem('authToken'),
    },
  })
    .then((response) => {
      if (response.ok) {
      } else {
        // 에러 처리
      }
    })
    .catch((error) => {
      console.error('Error:', error);
      window.location.href = 'login.html';
    });
}

function getTeamList() {
  fetch('http://127.0.0.1:8080/api/team/list', {
    method: 'GET',
    headers: {
      'Content-Type': 'application/json',
      'X-AUTH-TOKEN': localStorage.getItem('authToken'),
    },
  })
    .then((response) => {
      if (response.ok) {
        return response.json();
      }
    })
    .then((data) => {
      console.log(data);
      let teamList = document.getElementById('team-list');

      for (var i = 0; i < data.length; i++) {
        let teamName = document.createElement('p');
        teamName.innerText = data[i].title;
        let id = data[i].id;
        teamName.addEventListener('click', function () {
          location.href = 'teamDetail.html?id=' + id;
        });
        teamList.appendChild(teamName);
      }
    })
    .catch((error) => {
      console.log(error);
      window.location.href = 'login.html';
    });
}

function getTeamDetail() {
  let queryString = new URLSearchParams(window.location.search);
  let teamId = queryString.get('id');

  fetch('http://127.0.0.1:8080/api/team/' + teamId, {
    method: 'GET',
    headers: {
      'Content-Type': 'application/json',
    },
  })
    .then((response) => {
      if (response.ok) {
        return response.json();
      }
    })
    .then((data) => {
      console.log(data);
    })
    .catch((error) => {
      console.error(error);
    });
}
