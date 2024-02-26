function register() {
  const username = document.getElementById('username').value;
  const password = document.getElementById('password').value;
  const nickname = document.getElementById('nickname').value;
  const email = document.getElementById('email').value;
  const data = {
    username: username,
    password: password,
    email: email,
    nickname: nickname,
  };

  fetch('http://127.0.0.1:8080/api/user/join', {
    method: 'post',
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
        alert('잘못된 계정 정보입니다.');
        // 에러 처리
      }
    })
    .catch((error) => {
      console.error('Error:', error);
    });
}
