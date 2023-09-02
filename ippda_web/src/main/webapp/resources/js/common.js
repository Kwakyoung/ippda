function modalAlert( type, title, message ){
	$('#modal-alert .modal-title').html( title ); 	//모달창 제목
	$('#modal-alert .modal-body').html( message ); 	//모달창 내용

	//모달창 type에 따라 아이콘모양,색 지정을 위해 모든 클래스 삭제
  	$('.modal-icon').removeClass(
	'text-info text-warning text-danger text-primary text-success fa-circle-question fa-circle-exclamation')
	// 아니오/확인 으로 사용되는 버튼의 색상 초기화
	$('.modal-footer .btn-ok').removeClass(
		'btn-info btn-warning btn-danger btn-primary btn-success');
	  	
  	if( type=='danger' ){//confirm에 해당
  		//아니오, 예 버튼 
  		$('.modal-footer .btn-ok').addClass('btn-secondary').text('아니오')
		$('.modal-footer .btn-danger').removeClass('d-none')
		
  		$('.modal-icon').addClass('fa-circle-question') //아이콘 물음표
		
	}else{
		console.log( '여기')
		//확인 버튼, confirm일때만 사용할 btn-danger 는 필요없음
		$('.modal-footer .btn-ok').addClass('btn-' + type).text('확인')
		$('.modal-footer .btn-danger').addClass('d-none')
		
		$('.modal-icon').addClass('fa-circle-exclamation')  //아이콘 느낌표
	}
	$('.modal-icon').addClass('text-'+ type);
}
