package com.daigou.dao;

import java.util.ArrayList;


import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.daigou.model.User;
import com.daigou.model.Watch;


@Service @Transactional
public class WatchDao {
	@Resource SessionFactory factory;
	
	 /*���Food��Ϣ*/
    public void AddWatch(Watch watch) throws Exception {
    	Session s = factory.getCurrentSession();
    	s.save(watch);
    }
    
    /*ɾ��Food��Ϣ*/
    public void DeleteWatch (Integer watchId) throws Exception {
        Session s = factory.getCurrentSession(); 
        Object watch = s.load(Watch.class, watchId);
        s.delete(watch);
    }
    
    /*����Food��Ϣ*/
    public void UpdateWatch(Watch watch) throws Exception {
        Session s = factory.getCurrentSession();
        s.update(watch);
    }
    
    /*��ѯ����Food��Ϣ*/
    public ArrayList<Watch> QueryAllWatch() {
        Session s = factory.getCurrentSession();
        String hql = "From Watch";
        Query q = s.createQuery(hql);
        List watchList = q.list();
        return (ArrayList<Watch>) watchList;
    }

    /*��������ȡ����*/
    public Watch GetWatchById(Integer watchid) {
        Session s = factory.getCurrentSession();
        Watch watch = (Watch)s.get(Watch.class, watchid);
        return watch;
    }
    
    /*��ݲ�ѯ������ѯ*/

	public ArrayList<Watch> QueryWatchInfo(String watchname) { 
    	Session s = factory.getCurrentSession();
    	String hql = "From Watch watch where 1=1";
    	if(!watchname.equals("")) hql = hql + " and watch.watchname like '%" + watchname + "%'";
    	Query q = s.createQuery(hql);
    	List watchList = q.list();
    	return (ArrayList<Watch>) watchList;
    }

}
