<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    

<div class="modal fade" id="modal-alert" data-bs-backdrop="static" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered">
    <div class="modal-content"  data-no='0'>
      <div class="modal-header">
      	<i class="modal-icon me-2 fs-3 fa-solid"></i>
        <h4 class="modal-title"></h4>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body fs-5">
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-ok" data-bs-dismiss="modal">확인</button>
        <button type="button" class="btn btn-danger px-4">예</button>
      </div>
    </div>
  </div>
</div>
