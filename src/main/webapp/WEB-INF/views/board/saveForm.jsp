
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>

<div class="container">

    <form >

        <div class="form-group">
            <label for="title">UserName</label>
            <input type="text" class="form-control" placeholder=Title" id="title" name="title">
        </div>


        <div class="form-group">
            <label for="comment">Comment:</label>
            <textarea class="form-control" rows="5" id="comment" name="text"></textarea>
        </div>


    </form>
    <button id="btn-board-save" class="btn btn-primary">글쓰기</button>

</div>

<script src="/js/board.js" ></script>
<%@ include file="../layout/footer.jsp"%>



