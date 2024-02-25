function register() {
  const username = document.getElementById('id').value;
  const password = document.getElementById('password').value;
  const nickname = document.getElementById('nickname').value;
  const email = document.getElementById('email').value;
  const data = {
    username: username,
    password: password,
    email: email,
    nickname: nickname,
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
        alert('회원가입 성공');
        window.location.href = 'main.html';
      } else {
        // 에러 처리
      }
    })
    .catch((error) => {
      console.error('Error:', error);
    });
}
