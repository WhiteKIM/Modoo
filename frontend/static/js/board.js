function getBoard() {
  fetch('http://127.0.0.1:8080/api/board', {
    method: 'get',
    headers: {
      'Content-Type': 'application/json',
      'X-AUTH-TOKEN': localStorage.getItem('authToken'),
    },
  })
    .then((response) => {
      if (response.ok) {
        console.log(response.data);
      } else {
        // 에러 처리
      }
    })
    .catch((error) => {
      console.error('Error:', error);
    });
}

function writeBoard() {
  const title = document.getElementById('title').value;
  const content = document.getElementById('content').value;
  const userId = 1;
  const data = {
    title: title,
    content: content,
    userId: userId,
  };

  fetch('http://127.0.0.1:8080/api/board/write', {
    method: 'POST',
    body: JSON.stringify(data),
    headers: {
      'Content-Type': 'application/json',
      'X-AUTH-TOKEN': localStorage.getItem('authToken'),
    },
  })
    .then((response) => {
      if (response.ok) {
        window.location.href = 'main.html';
      } else {
        // 에러 처리
      }
    })
    .catch((error) => {
      console.error('Error:', error);
    });
}
