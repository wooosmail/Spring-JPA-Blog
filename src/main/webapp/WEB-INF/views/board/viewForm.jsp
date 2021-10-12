
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>

<div class="container">
    <div>
         글쓴이 : ${board.user.userId}
         글번호 : <span id ="id">${board.boardId}</span>
    </div>
    <br><br>
        <div class="form-group">
            <label for="title">Title</label>
            <h3> ${board.title}</h3>
        </div>


        <div class="form-group">
            <label for="content">Comment:</label>
            <div>
                ${board.content}
            </div>
        </div>
        <hr 1>


    <button id="btn-board-warning" class="btn btn-primary">수정</button>
    <button id="btn-board-secondary" class="btn btn-primary">삭제</button>
    <button id="btn-board-success" class="btn btn-primary" onclick="history.back()">이전</button>

</div>
<script>

</script>
<script src="/js/board.js" ></script>
<%@ include file="../layout/footer.jsp"%>



