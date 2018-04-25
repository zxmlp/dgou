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

import com.daigou.dao.WatchDao;
import com.daigou.model.*;
import com.opensymphony.xwork2.ActionSupport;

@Controller @Scope("prototype")
public class WatchAction extends ActionSupport{
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*ҵ������*/
    @Resource WatchDao watchDao;
    private File watchPhoto;
    private String watchPhotoFileName;
    private String watchPhotoContentType;    
    private Watch watch;

	public Watch getWatch() {
		return watch;
	}

	public void setWatch(Watch watch) {
		this.watch = watch;
	}
	
	private List<Watch> watchList;
	
	public List<Watch> getWatchList() {
		return watchList;
	}

	public void setWatchsList(List<Watch> watchList) {
		this.watchList = watchList;
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
	public File getWatchPhoto() {
		return watchPhoto;
	}

	public void setWatchPhoto(File watchPhoto) {
		this.watchPhoto = watchPhoto;
	}

	public String getWatchPhotoFileName() {
		return watchPhotoFileName;
	}

	public void setWatchPhotoFileName(String watchPhotoFileName) {
		this.watchPhotoFileName = watchPhotoFileName;
	}

	public String getWatchPhotoContentType() {
		return watchPhotoContentType;
	}

	public void setWatchPhotoContentType(String watchPhotoContentType) {
		this.watchPhotoContentType = watchPhotoContentType;
	}


	
	
	/*���Food*/
	public String addWatch() throws Exception{
			String path = ServletActionContext.getServletContext().getRealPath("/upload"); 
	        /*����ͼƬ�ϴ�*/
	        String watchPhotoFileName = ""; 
	   	 	if(watchPhoto!= null) {
	   	 		InputStream is = new FileInputStream(watchPhoto);
	   			String fileContentType = this.getWatchPhotoContentType();
	   			System.out.println(fileContentType);
	   			if(fileContentType.equals("image/jpeg")  || fileContentType.equals("image/pjpeg"))
	   				watchPhotoFileName = UUID.randomUUID().toString() +  ".jpg";
	   			else if(fileContentType.equals("image/gif"))
	   				watchPhotoFileName = UUID.randomUUID().toString() +  ".gif";
	   			else if(fileContentType.equals("image/png"))
	   				watchPhotoFileName = UUID.randomUUID().toString() +  ".png";

	   			File file = new File(path, watchPhotoFileName);
	   			OutputStream os = new FileOutputStream(file);
	   			byte[] b = new byte[1024];
	   			int bs = 0;
	   			while ((bs = is.read(b)) > 0) {
	   				os.write(b, 0, bs);
	   			}
	   			is.close();
	   			os.close();
	   	 	}
	        if(watchPhoto != null)
	        	watch.setWfilepath("upload/" + watchPhotoFileName);
	        else
	        	watch.setWfilepath("upload/NoImage.jpg");
	        
	        watchDao.AddWatch(watch);
			return "message";
		
		/*
		System.out.println(goods.getGoodsname());
		goodsDao.AddGoods(goods);
		return "message";
		*/
	}
	
	/*��ʾ����Food*/
    public String showWatch() {
        
        watchList = watchDao.QueryAllWatch();
        return "show_view";
    }

    /*��ʾĳһFood����ϸ��Ϣ*/
    public String showDetail() {
    	watch = watchDao.GetWatchById(watch.getWatchid());
        return "detail_view";
    }
    
    /*��ʾfood���޸���*/
    public String showEdit() throws Exception {
    watch = watchDao.GetWatchById(watch.getWatchid());
        return "edit_view";
    }

    /*�༭food*/
    public String editWatch() throws Exception {
        String path = ServletActionContext.getServletContext().getRealPath("/upload"); 
          /*处理图片上传*/
        String watchPhotoFileName = ""; 
     	 	if(watchPhoto!= null) {
     	 		InputStream is = new FileInputStream(watchPhoto);
     			String fileContentType = this.getWatchPhotoContentType();
     			System.out.println(fileContentType);
     			if(fileContentType.equals("image/jpeg")  || fileContentType.equals("image/pjpeg"))
     				watchPhotoFileName = UUID.randomUUID().toString() +  ".jpg";
     			else if(fileContentType.equals("image/gif"))
     				watchPhotoFileName= UUID.randomUUID().toString() +  ".gif";
     			else if(fileContentType.equals("image/png"))
     				watchPhotoFileName= UUID.randomUUID().toString() +  ".png";

     			File file = new File(path, watchPhotoFileName);
     			OutputStream os = new FileOutputStream(file);
     			byte[] b = new byte[1024];
     			int bs = 0;
     			while ((bs = is.read(b)) > 0) {
     				os.write(b, 0, bs);
     			}
     			is.close();
     			os.close();
     	 	}
          if(watchPhoto != null)
          	watch.setWfilepath("upload/" +watchPhotoFileName);
          else
         watch.setWfilepath("upload/NoImage.jpg");
          
      	watchDao.UpdateWatch(watch);
          return "edit_message";
      }
    
    /*ɾ��Food*/
    public String deleteWatch() throws Exception {
    	watchDao.DeleteWatch(watch.getWatchid());
        return "delete_message";
    }
    
    /*��ѯFood*/
    public String queryWatch() throws Exception {
    	watchList = watchDao.QueryWatchInfo(keyWords);
        return "show_view";
    }

	


}