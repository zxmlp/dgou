package com.daigou.action;

import java.io.File;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.UUID;



import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.daigou.dao.MomsDao;
import com.daigou.model.*;
import com.opensymphony.xwork2.ActionSupport;

@Controller @Scope("prototype")
public class MomsAction extends ActionSupport{
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*ҵ������*/
    @Resource MomsDao momsDao;
    private File momsPhoto;
    private String momsPhotoFileName;
    private String momsPhotoContentType;    
    private Moms moms;

	public Moms getMoms() {
		return moms;
	}

	public void setMoms(Moms moms) {
		this.moms = moms;
	}
	
	private List<Moms> momsList;
	
	public List<Moms> getMomsList() {
		return momsList;
	}

	public void setMomsList(List<Moms> momsList) {
		this.momsList = momsList;
	}
	
	private String keyWords;
	
	public String getKeyWords() {
		return keyWords;
	}

	public void setKeyWords(String keyWords) {
		this.keyWords = keyWords;
	}
	
	private User user;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	public File getMomsPhoto() {
		return momsPhoto;
	}

	public void setMomsPhoto(File momsPhoto) {
		this.momsPhoto = momsPhoto;
	}

	public String getMomsPhotoFileName() {
		return momsPhotoFileName;
	}

	public void setMomsPhotoFileName(String momsPhotoFileName) {
		this.momsPhotoFileName = momsPhotoFileName;
	}

	public String getMomsPhotoContentType() {
		return momsPhotoContentType;
	}

	public void setMomsPhotoContentType(String momsPhotoContentType) {
		this.momsPhotoContentType = momsPhotoContentType;
	}


	
	
	/*���Food*/
	public String addMoms() throws Exception{
			String path = ServletActionContext.getServletContext().getRealPath("/upload"); 
	        /*����ͼƬ�ϴ�*/
	        String momsPhotoFileName = ""; 
	   	 	if(momsPhoto!= null) {
	   	 		InputStream is = new FileInputStream(momsPhoto);
	   			String fileContentType = this.getMomsPhotoContentType();
	   			System.out.println(fileContentType);
	   			if(fileContentType.equals("image/jpeg")  || fileContentType.equals("image/pjpeg"))
	   				momsPhotoFileName = UUID.randomUUID().toString() +  ".jpg";
	   			else if(fileContentType.equals("image/gif"))
	   				momsPhotoFileName = UUID.randomUUID().toString() +  ".gif";
	   			else if(fileContentType.equals("image/png"))
	   				momsPhotoFileName = UUID.randomUUID().toString() +  ".png";

	   			File file = new File(path, momsPhotoFileName);
	   			OutputStream os = new FileOutputStream(file);
	   			byte[] b = new byte[1024];
	   			int bs = 0;
	   			while ((bs = is.read(b)) > 0) {
	   				os.write(b, 0, bs);
	   			}
	   			is.close();
	   			os.close();
	   	 	}
	        if(momsPhoto != null)
	        	moms.setMfilepath("upload/" + momsPhotoFileName);
	        else
	        	moms.setMfilepath("upload/NoImage.jpg");
	        
	        momsDao.AddMoms(moms);
			return "message";
		
		/*
		System.out.println(goods.getGoodsname());
		goodsDao.AddGoods(goods);
		return "message";
		*/
	}
	
	/*��ʾ����Food*/
    public String showMoms() {
        
        momsList = momsDao.QueryAllMoms();
        return "show_view";
    }

    /*��ʾĳһFood����ϸ��Ϣ*/
    public String showDetail() {
    	moms = momsDao.GetMomsById(moms.getMomsid());
        return "detail_view";
    }
    
    /*��ʾfood���޸���*/
    public String showEdit() throws Exception {
    moms = momsDao.GetMomsById(moms.getMomsid());
        return "edit_view";
    }

    /*�༭food*/
    public String editMoms() throws Exception {
        String path = ServletActionContext.getServletContext().getRealPath("/upload"); 
          /*处理图片上传*/
        String momsPhotoFileName = ""; 
     	 	if(momsPhoto!= null) {
     	 		InputStream is = new FileInputStream(momsPhoto);
     			String fileContentType = this.getMomsPhotoContentType();
     			System.out.println(fileContentType);
     			if(fileContentType.equals("image/jpeg")  || fileContentType.equals("image/pjpeg"))
     				momsPhotoFileName = UUID.randomUUID().toString() +  ".jpg";
     			else if(fileContentType.equals("image/gif"))
     				momsPhotoFileName= UUID.randomUUID().toString() +  ".gif";
     			else if(fileContentType.equals("image/png"))
     				momsPhotoFileName= UUID.randomUUID().toString() +  ".png";

     			File file = new File(path, momsPhotoFileName);
     			OutputStream os = new FileOutputStream(file);
     			byte[] b = new byte[1024];
     			int bs = 0;
     			while ((bs = is.read(b)) > 0) {
     				os.write(b, 0, bs);
     			}
     			is.close();
     			os.close();
     	 	}
          if(momsPhoto != null)
          	moms.setMfilepath("upload/" +momsPhotoFileName);
          else
          moms.setMfilepath("upload/NoImage.jpg");
          
      	momsDao.UpdateMoms(moms);
          return "edit_message";
      }
    
    /*ɾ��Food*/
    public String deleteMoms() throws Exception {
    	momsDao.DeleteMoms(moms.getMomsid());
        return "delete_message";
    }
    
    /*��ѯFood*/
    public String queryMoms() throws Exception {
    	momsList = momsDao.QueryMomsInfo(keyWords);
        return "show_view";
    }

	


}