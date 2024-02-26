function login() {
  const username = document.getElementById('username').value;
  const password = document.getElementById('password').value;
  const data = {
    username: username,
    password: password,
  };

  fetch('http://127.0.0.1:8080/api/user/login', {
    method: 'POST',
    body: JSON.stringify(data),
    headers: {
      'Content-Type': 'application/json',
    },
  })
    .then((response) => {
      if (response.ok) {
        const authToken = response.headers.get('X-AUTH-TOKEN');
        // 토큰을 로컬 스토리지에 저장
        localStorage.setItem('authToken', authToken);
        // 여기서 다음 작업을 수행하거나, 다른 페이지로 리다이렉트할 수 있음

        window.location.href = 'main.html';
      } else {
        // 에러 처리
      }
    })
    .catch((error) => {
      console.error('Error:', error);
    });
}
