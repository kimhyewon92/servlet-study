<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    
   <style>

    body {
      font-weight: bolder;
    }

    body a {
      color: inherit !important;
    }

    .dropdown-menu {
      position: static !important;
      display: none;
      margin-top: 10px;
    }
    .dropdown-menu.show {
      display: block;
      transform: none !important;
    }
    .dropdown-item {
      text-align: center;
    }

    .use {
      width: 20%;
      border-radius: 50%;
    }

    body > div > div:nth-child(3) {
      width: 50% !important;
    }


  </style>
</head>

<body>
	<div class="container text-center">

    <img src="" class="img-fluid use" alt="...">

    <div class="col">
      홍길동
    </div>


     <div class="container text-center">
  <div class="row align-items-start">
    <div class="col">
      입실
    </div>
    <div class="col">
      퇴실
    </div>
    <div class="col">
      외출
    </div>
  </div>
</div>

     <div class="container text-center">
  <div class="row align-items-start">
    <div class="col">
      로그아웃
    </div>

  </div>
</div>    
    
    <ul class="nav flex-column">
     <li class="nav-item">
          <a class="nav-link" href="/calendarView">캘린더</a>
        </li>
            <li class="nav-item dropdown">
              <a class="nav-link dropdown-toggle" href="#" role="button" aria-expanded="false" data-bs-toggle="dropdown" data-bs-auto-close="false">성적관리</a>
              <ul class="dropdown-menu">
                <li><a class="dropdown-item" href="/scoreView">성적입력</a></li>
                <li><a class="dropdown-item" href="#">Another action</a></li>
                <li><a class="dropdown-item" href="#">Something else here</a></li>
              </ul>
            </li>
        <li class="nav-item">
          <a class="nav-link" href="#">좌석</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/calendarView">태블릿</a>
        </li>
             <li class="nav-item dropdown">
              <a class="nav-link dropdown-toggle" href="#" role="button" aria-expanded="false" data-bs-toggle="dropdown" data-bs-auto-close="false">공지사항</a>
              <ul class="dropdown-menu">
                <li><a class="dropdown-item" href="/scoreView">질의응답</a></li>
                <li><a class="dropdown-item" href="#">Another action</a></li>
                <li><a class="dropdown-item" href="#">Something else here</a></li>
              </ul>
            </li>
        <li class="nav-item">
          <a class="nav-link" href="#">질의응답</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">마이페이지</a>
        </li>
      </ul>

</div>
</body>
