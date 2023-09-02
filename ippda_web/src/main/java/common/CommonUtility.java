package common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import goods.FileVO;

@Service
public class CommonUtility {
	
	//첨부파일 여러개를 업로드하는 처리
	public ArrayList<FileVO> attachedFiles(String category, MultipartFile[] files
								, HttpServletRequest request) {
		ArrayList<FileVO> list = null;
		for(MultipartFile attached : files) {
			if( attached.isEmpty() ) continue;
			if( list == null ) list = new ArrayList<FileVO>();
			FileVO fileVO = new FileVO();
			fileVO.setFile_name( attached.getOriginalFilename() );
			fileVO.setFile_path( fileUpload(category, attached, request) );
			list.add(fileVO);
		}
		return list;
	}
	
	
	
	
	//첨부파일 삭제: 디스크에 저장된 물리적 파일 삭제
	public void deletedFile(String filepath, HttpServletRequest request) {
		if( filepath != null ) {
			filepath = filepath.replace( appURL(request)
										, "d://app/" + request.getContextPath() );	
			File file = new File( filepath );
			if( file.exists() ) file.delete();
		}
	}
	
	
	//파일다운로드
	public void fileDownload(String filename, String filepath
							, HttpServletRequest request
							, HttpServletResponse response ) throws Exception{
		// filepath :  http://localhost:8080/smart/upload/profile/2023/06/22/abc.png
		// appURL : http://localhost:8080/smart
		filepath = filepath.replace( appURL(request) , "d://app/" + request.getContextPath()); 

		// 다운로드할 파일객체를 생성
		File file = new File( filepath );
		String mime = request.getSession().getServletContext().getMimeType(filename);
		response.setContentType(mime);
		
		//파일IO : 읽기/쓰기 - 단위 문자: reader/writer, 단위 byte: input/output 
		
		//파일을 첨부해서 쓰기작업하기		
		//파일명에 한글이 있다면 인코딩처리
		filename = URLEncoder.encode(filename, "utf-8").replaceAll("\\+", "%20");
		response.setHeader("content-disposition", "attachment; filename=" + filename );
		FileCopyUtils.copy( new FileInputStream(file) , response.getOutputStream());
	}
	
	//파일업로드
	public String fileUpload(String category, MultipartFile file, HttpServletRequest request ) {
		//D:\Study_Spring\Workspace\.metadata\.plugins\org.eclipse.wst.server.core
		// \tmp0\wtpwebapps\02.smart\resources
		//String path = request.getSession().getServletContext().getRealPath("resources");
		if(file == null) return "";
		// d:\\app\smart
		String path = "D:\\app"+ request.getContextPath(); // /smart
//		String path = "D:/app/smart";

		//String upload = "/upload/profile/2023/06/22/abc.png";
		String upload = "/upload/"+ category 
				+ new SimpleDateFormat("/yyyy/MM/dd").format(new Date());
		path += upload;
		//파일을 저장해둘 폴더가 없으면 폴더 만들기
		File folder = new File( path );
		if( ! folder.exists() ) folder.mkdirs();
		
		String filename = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
		try {
			file.transferTo( new File(path, filename) );
		}catch(Exception e) {
		}
		// http://localhost:8080/smart/upload/profile/2023/06/22/abc.png
		return appURL(request) + upload + "/" + filename;
	}
	
	// context root url 지정
	public String appURL( HttpServletRequest request ) {
		//http://localhost:8080/smart
		StringBuffer url = new StringBuffer("http://");
		//localhost = 127.0.0.1 = 본인ip
		url.append( request.getServerName() ).append(":"); //  http://localhost:
		url.append( request.getServerPort() );  //  http://localhost:8080
		url.append( request.getContextPath() ); //  http://localhost:8080/smart
		return url.toString();
	}
	




	

}
