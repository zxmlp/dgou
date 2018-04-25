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

import com.daigou.dao.GaodingDao;
import com.daigou.model.*;
import com.opensymphony.xwork2.ActionSupport;

@Controller @Scope("prototype")
public class GaodingAction extends ActionSupport{
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*ҵ������*/
    @Resource GaodingDao gaodingDao;
    private File gaoPhoto;
    private String gaoPhotoFileName;
    private String gaoPhotoContentType;    
    private Gaoding gao;

	public Gaoding  getGao() {
		return gao;
	}

	public void setGao(Gaoding gao) {
		this.gao = gao;
	}
	
	private List<Gaoding> gaoList;
	
	public List<Gaoding> getGaoList() {
		return gaoList;
	}

	public void setGaoList(List<Gaoding> gaoList) {
		this.gaoList = gaoList;
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
	public File getGaoPhoto() {
		return gaoPhoto;
	}

	public void setGaoPhoto(File gaoPhoto) {
		this.gaoPhoto = gaoPhoto;
	}

	public String getGaoPhotoFileName() {
		return gaoPhotoFileName;
	}

	public void setGaoPhotoFileName(String gaoPhotoFileName) {
		this.gaoPhotoFileName = gaoPhotoFileName;
	}

	public String getGaoPhotoContentType() {
		return gaoPhotoContentType;
	}

	public void setGaoPhotoContentType(String gaoPhotoContentType) {
		this.gaoPhotoContentType = gaoPhotoContentType;
	}


	
	
	/*���Food*/
	public String addGao() throws Exception{
			String path = ServletActionContext.getServletContext().getRealPath("/upload"); 
	        /*����ͼƬ�ϴ�*/
	        String gaoPhotoFileName = ""; 
	   	 	if(gaoPhoto!= null) {
	   	 		InputStream is = new FileInputStream(gaoPhoto);
	   			String fileContentType = this.getGaoPhotoContentType();
	   			System.out.println(fileContentType);
	   			if(fileContentType.equals("image/jpeg")  || fileContentType.equals("image/pjpeg"))
	   				gaoPhotoFileName = UUID.randomUUID().toString() +  ".jpg";
	   			else if(fileContentType.equals("image/gif"))
	   				gaoPhotoFileName = UUID.randomUUID().toString() +  ".gif";
	   			else if(fileContentType.equals("image/png"))
	   				gaoPhotoFileName = UUID.randomUUID().toString() +  ".png";

	   			File file = new File(path, gaoPhotoFileName);
	   			OutputStream os = new FileOutputStream(file);
	   			byte[] b = new byte[1024];
	   			int bs = 0;
	   			while ((bs = is.read(b)) > 0) {
	   				os.write(b, 0, bs);
	   			}
	   			is.close();
	   			os.close();
	   	 	}
	        if(gaoPhoto != null)
	        	gao.setGfilepath("upload/" + gaoPhotoFileName);
	        else
	        	gao.setGfilepath("upload/NoImage.jpg");
	        
	        gaodingDao.AddGao(gao);
			return "message";
		
		/*
		System.out.println(goods.getGoodsname());
		goodsDao.AddGoods(goods);
		return "message";
		*/
	}
	
	/*��ʾ����Food*/
    public String showGao() {
        
        gaoList = gaodingDao.QueryAllGao();
        return "show_view";
    }

    /*��ʾĳһFood����ϸ��Ϣ*/
    public String showDetail() {
    	gao = gaodingDao.GetGaoById(gao.getGaoid());
        return "detail_view";
    }
    
    /*��ʾfood���޸���*/
    public String showEdit() throws Exception {
    gao = gaodingDao.GetGaoById(gao.getGaoid());
        return "edit_view";
    }

    /*�༭food*/
    public String editGao() throws Exception {
        String path = ServletActionContext.getServletContext().getRealPath("/upload"); 
          /*处理图片上传*/
        String gaoPhotoFileName = ""; 
     	 	if(gaoPhoto!= null) {
     	 		InputStream is = new FileInputStream(gaoPhoto);
     			String fileContentType = this.getGaoPhotoContentType();
     			System.out.println(fileContentType);
     			if(fileContentType.equals("image/jpeg")  || fileContentType.equals("image/pjpeg"))
     				gaoPhotoFileName = UUID.randomUUID().toString() +  ".jpg";
     			else if(fileContentType.equals("image/gif"))
     				gaoPhotoFileName= UUID.randomUUID().toString() +  ".gif";
     			else if(fileContentType.equals("image/png"))
     				gaoPhotoFileName= UUID.randomUUID().toString() +  ".png";

     			File file = new File(path, gaoPhotoFileName);
     			OutputStream os = new FileOutputStream(file);
     			byte[] b = new byte[1024];
     			int bs = 0;
     			while ((bs = is.read(b)) > 0) {
     				os.write(b, 0, bs);
     			}
     			is.close();
     			os.close();
     	 	}
          if(gaoPhoto != null)
          	gao.setGfilepath("upload/" +gaoPhotoFileName);
          else
          gao.setGfilepath("upload/NoImage.jpg");
          
      	gaodingDao.UpdateGao(gao);
          return "edit_message";
      }
    
    /*ɾ��Food*/
    public String deleteGao() throws Exception {
    	gaodingDao.DeleteGao(gao.getGaoid());
        return "delete_message";
    }
    
    /*��ѯFood*/
    public String queryGao() throws Exception {
    	gaoList = gaodingDao.QueryGaoInfo(keyWords);
        return "show_view";
    }

	


}