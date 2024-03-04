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
      window.location = 'login.html';
      console.error('Error:', error);
    });
}

function writeReply() {
  fetch('http://127.0.0.1:8080/api/reply/write', {
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
      window.location = 'login.html';

      console.error('Error:', error);
    });
}

function getBoardList() {
  fetch('http://127.0.0.1:8080/api/board', {
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
      let parent = document.getElementById('boardList');
      for (var i = 0; i < data.length; i++) {
        chileDivElement = document.createElement('div');
        childTitleElement = document.createElement('h2');
        childContent = document.createElement('p');

        childTitleElement.innerText = data[i].title;
        childContent.innerText = data[i].content;
        var id = data[i].id;
        chileDivElement.addEventListener('click', function () {
          location.href = 'boardDetail.html?id=' + id;
        });
        chileDivElement.append(childTitleElement);
        chileDivElement.append(childContent);
        parent.append(chileDivElement);
      }
    })
    .catch((error) => {
      console.error('Error:', error);
    });
}

function getBoardDetail() {
  var queryString = new URLSearchParams(window.location.search);
  var id = queryString.get('id');
  console.log(id);
  fetch('http://127.0.0.1:8080/api/board/' + id, {
    method: 'GET',
    headers: {
      'Content-Type': 'application/json',
    },
  })
    .then((response) => {
      if (response.ok) {
        return response.json();
      } else {
        // 에러 처리
      }
    })
    .then((data) => {
      console.log(data);
      let title = document.getElementById('title');
      let content = document.getElementById('content');

      title.innerText = data.title;
      content.innerText = data.content;
      setReplyData(data.replies);
    })
    .catch((error) => {
      localStorage.clear();
      console.error('Error:', error);
    });
}

function setReplyData(replyList) {
  let parent = document.getElementById('replyList');
  for (var i = 0; i < replyList.length; i++) {
    let tr = document.createElement('tr');
    let td_content = document.createElement('td');
    let td_child_reply = replyList.replies;
    td_writer.innerText = replyList[i].message;
    tr.appendChild(td_content);
    for (var j = 0; j < td_child_reply.length; j++) {
      let td_child_reply_content = document.createElement('td');
      td_child_reply_content.innerText = td_child_reply[i].message;
      tr.appendChild(td_child_reply_content);
    }

    parent.append(tr);
  }
}