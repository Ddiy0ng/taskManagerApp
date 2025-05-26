<h3>Task Api</h3>
<table>
  <thead>
    <tr>
      <th>Method</th>
      <th>Url</th>
      <th>Request</th>
      <th>Response</th>
      <th>상태코드</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>POST</td>
      <td>/authors/tasks/post</td>
      <td>{
  "taskTitle": "제목",
  "taskContent": "내용"
}</td>
      <td>"일정을 추가했습니다"</td>
      <td>201 Created</td>
    </tr>
    <tr>
      <td>GET</td>
      <td>/authors/tasks?pageNumber={pageNumber}</td>
      <td>요청 param</td>
      <td>[
    {
        "taskTitle": "제목1",
        "taskContent": "내용1",
        "postDate": "2025-05-13",
        "updateDate": "2025-05-13"
    },
    {
        "taskTitle": "제목2",
        "taskContent": "내용2",
        "postDate": "2025-05-13",
        "updateDate": "2025-05-13"
    }
]</td>
      <td>200 OK</td>
    </tr>
    <tr>
      <td>GET</td>
      <td>/authors/tasks/{taskId}</td>
      <td>ㅡ</td>
      <td>    {
        "taskTitle": "제목1",
        "taskContent": "내용1",
        "postDate": "2025-05-13",
        "updateDate": "2025-05-13"
    }</td>
      <td>200 OK</td>
    </tr>
    <tr>
      <td>PUT</td>
      <td>/authors/tasks/{taskId}</td>
      <td>{
  "taskTitle": "제목",
  "taskContent": "내용"
}</td>
      <td>"수정을 완료했습니다.."</td>
      <td>200 OK</td>
    </tr>
    <tr>
      <td>DELETE</td>
      <td>/authors/tasks/{taskId}</td>
      <td>ㅡ</td>
      <td>"일정을 삭제했습니다."</td>
      <td>200 OK</td>
    </tr>
  </tbody>
</table>


<h3>Author Api</h3>
<table>
  <thead>
    <tr>
      <th>Method</th>
      <th>Url</th>
      <th>Request</th>
      <th>Response</th>
      <th>상태코드</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>POST</td>
      <td>/authors/signUp</td>
      <td>{        
        "authorName": "이름1",
        "email": "name1@gmail.com"
        }</td>
      <td>"회원가입을 완료했습니다."</td>
      <td>201 Created</td>
    </tr>
    <tr>
      <td>GET</td>
      <td>/authors</td>
      <td>—</td>
      <td>    {
        "authorName": "이름1",
        "email": "name1@gmail.com",
        "postDate": "2025-05-13",
        "updateDate": "2025-05-13"
    }</td>
      <td>200 OK</td>
    </tr>
    <tr>
      <td>PUT</td>
      <td>/authors/updateInfo</td>
      <td>{        
        "authorName": "이름1",
        "email": "name1@gmail.com"
        }</td>
      <td>"회원 정보를 수정했습니다"</td>
      <td>200 OK</td>
    </tr>
    <tr>
      <td>PUT</td>
      <td>/authors/updatePw</td>
      <td>{        
        "oldPassword": "1111",
        "newPassword": "2222"
        }</td>
      <td>"비밀번호를 변경했습니다."</td>
      <td>200 OK</td>
    </tr>
    <tr>
      <td>DELETE</td>
      <td>/authors</td>
      <td>—</td>
      <td>"회원 데이터를 삭제했습니다."</td>
      <td>200 OK</td>
    </tr>
  </tbody>
</table>


<h3>Comment Api</h3>
<table>
  <thead>
    <tr>
      <th>Method</th>
      <th>Url</th>
      <th>Request</th>
      <th>Response</th>
      <th>상태코드</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>POST</td>
      <td>/authors/tasks/{taskId}/comments/post</td>
      <td>{        
        "commentContent": "댓글 내용"
        }</td>
      <td>"댓글을 추가했습니다."</td>
      <td>201 Created</td>
    </tr>
    <tr>
      <td>GET</td>
      <td>/authors/tasks/{taskId}/comments</td>
      <td>—</td>
      <td>    {
        "commentContent": "댓글 내용",
        "postDate": "2025-05-13",
        "updateDate": "2025-05-13"
    }</td>
      <td>200 OK</td>
    </tr>
    <tr>
      <td>PUT</td>
      <td>/authors/tasks/{taskId}/comments/{commentId}</td>
      <td>{        
        "commentContent": "댓글 내용"        
        }</td>
      <td>"수정을 완료했습니다."</td>
      <td>200 OK</td>
    </tr>
    <tr>
      <td>DELETE</td>
      <td>/authors/tasks/{taskId}/comments/{commentId}</td>
      <td>—</td>
      <td>"댓글을 삭제했습니다."</td>
      <td>200 OK</td>
    </tr>
  </tbody>
</table>





<h3>ERD</h3>

![화면 캡처 2025-05-21 191648](https://github.com/user-attachments/assets/3efa3a8d-a4bf-4d4a-a18b-ca6d39d39765)
