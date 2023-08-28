<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    

<!-- HTML -->
<div id="confirmModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="confirmModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="confirmModalLabel">아이디 사용 가능</h5>
        
      </div>
      <div class="modal-body">
        사용 가능한 아이디입니다. 계속 진행하시겠습니까?
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal" id="cancle">취소</button>
        <button type="button" class="btn btn-primary" id="confirmButton">확인</button>
      </div>
    </div>
  </div>
</div>

