package web.service.mypage.user;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import web.dao.mypage.user.MypageUserDao;
import web.dao.mypage.user.MypageUserDaoImpl;


public class MypageUserServiceImpl implements MypageUserService {

	MypageUserDao mypageUserDao = new MypageUserDaoImpl();
	
	@Override
	public void secessionUser(HttpServletRequest req) {
		
		mypageUserDao.secessionUserByUserno(req);
		
	}

	@Override
	public void updateCom(HttpServletRequest req) {

		mypageUserDao.updateUserComment(req);
	}
	
		

}
