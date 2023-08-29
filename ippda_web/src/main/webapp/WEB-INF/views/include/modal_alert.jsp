<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    

<div class="modal fade" id="modal-alert" data-bs-backdrop="static" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered">
    <div class="modal-content"  data-no='0'>
      <div class="modal-header">
        <h5 class="modal-title" id="confirmModalLabel">아이디 사용 가능</h5>
        
      </div>
      <div class="modal-body">
        사용 가능한 아이디입니다. 계속 진행하시겠습니까?
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal" id="cancel">취소</button>
        <button type="button" class="btn btn-primary" id="confirmButton">확인</button>
      </div>
    </div>
  </div>
</div>

