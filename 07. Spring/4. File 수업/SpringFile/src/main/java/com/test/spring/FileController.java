package com.test.spring;

import java.io.File;
import java.io.FileInputStream;
import java.net.URLEncoder;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
public class FileController {

	@GetMapping(value="/add")
	public String add() {
		
		return "add";
	}
	
	@PostMapping(value="/addok")
	public String addok(Model model, String data, HttpServletRequest req) {
		
		//1. 데이터 가져오기
		
		//<form 기본> HttpServletRequest 전달
		// - 텍스트 데이터
		System.out.println(data);

		//<form 파일>
		//MultipartHttpServletRequest 전달, 다운캐스팅
		// - 파일 데이터
		MultipartHttpServletRequest multi = (MultipartHttpServletRequest)req;
		
		//<input type="file" name="attach">
		MultipartFile file = multi.getFile("attach");
		System.out.println(file.getName());
		System.out.println(file.getOriginalFilename());
		System.out.println(file.getContentType());
		System.out.println(file.getSize());
		
		//파일 데이터를 보냈을 때 서버에 파일 업로드는 이미 완료 > 임시 폴더에 저장됨 > 원하는 곳으로 이동하기
		String filename = file.getOriginalFilename();
		String path = req.getRealPath("resources/files");
		
		System.out.println(path);
		
		//파일명 중복 방지
		filename = getFileName(path, filename);
		
		//파일 이동하기
		File uploadFile = new File(path + "\\" + filename); //희망 경로
		
		try {
			
			//file.renameTo(uploadFile)
			file.transferTo(uploadFile); //임시폴더 -> 업로드폴더
			//파일은 C:\class\spring\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\SpringFile\resources\files에서 확인
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		model.addAttribute("data", data);
		model.addAttribute("filename", filename);
		return "addok";
	}

	private String getFileName(String path, String filename) {
		
		//저장 폴더의 파일명을 중복되지 않게 만들기
		//path = "resources/files/"
		//filename (예시) = "MyBatis.png"
		
		int n = 1; //인덱싱 숫자
		int index = filename.lastIndexOf(".");
		
		String tempName = filename.substring(0, index); //파일명 "MyBatis" 
		String tempExt = filename.substring(index);		//.확장자 ".png"
		
		
		while (true) {
			
			File file = new File(path + "\\" + filename); //files\MyBatis.png
			
			if (file.exists()) {
				//있다 > 중복 > 파일명 변경
				filename = tempName + "_" + n + tempExt; //MyBatis_1.png
				n++;
				
			} else {
				//없다 > 파일명 사용 가능
				return filename;
			}
			
		}
	}
	
	@RequestMapping(value="/download", method={RequestMethod.GET})
	   public void download(HttpServletRequest request, HttpServletResponse response, String filename) throws Exception {

	      
	      ServletContext context = request.getSession().getServletContext();

	      
	      String savePath = "/resources/files";
	      
	      String sDownloadPath = context.getRealPath(savePath);

	      String sFilePath = sDownloadPath + "/" + filename;
	      byte b[] = new byte[4096];
	      FileInputStream in = new FileInputStream(sFilePath);
	      String sMimeType = context.getMimeType(sFilePath);
	      System.out.println("sMimeType>>>" + sMimeType);

	      if (sMimeType == null)
	         sMimeType = "application/octet-stream";// MIME. 브라우저에게 해석할 수 없는 데이터라고 타입을 속여서 보내는 작업 중 하나

	      response.setContentType(sMimeType);
	      
	      String agent = request.getHeader("User-Agent");
	      boolean ieBrowser = (agent.indexOf("MSIE") > -1) || (agent.indexOf("Trident") > -1);

	      if (ieBrowser) {
	         filename = URLEncoder.encode(filename, "UTF-8").replaceAll("/+", "%20");
	      } else {
	         filename = new String(filename.getBytes("UTF-8"), "iso-8859-1");
	      }

	      response.setHeader("Content-Disposition", "attachment; filename= " + filename);

	      ServletOutputStream out2 = response.getOutputStream();
	      int numRead;

	      while ((numRead = in.read(b, 0, b.length)) != -1) {
	         out2.write(b, 0, numRead);
	      }

	      out2.flush();
	      out2.close();
	      in.close();
	      
	      
	   }
	   
}
