function createTeam() {
  const title = document.getElementById('title').value;
  const membersId = [];
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
    });
}
