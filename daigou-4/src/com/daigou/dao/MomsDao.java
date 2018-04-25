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
import com.daigou.model.Moms;


@Service @Transactional
public class MomsDao {
	@Resource SessionFactory factory;
	
	 /*���Food��Ϣ*/
    public void AddMoms(Moms moms) throws Exception {
    	Session s = factory.getCurrentSession();
    	s.save(moms);
    }
    
    /*ɾ��Food��Ϣ*/
    public void DeleteMoms (Integer momsId) throws Exception {
        Session s = factory.getCurrentSession(); 
        Object moms = s.load(Moms.class, momsId);
        s.delete(moms);
    }
    
    /*����Food��Ϣ*/
    public void UpdateMoms(Moms moms) throws Exception {
        Session s = factory.getCurrentSession();
        s.update(moms);
    }
    
    /*��ѯ����Food��Ϣ*/
    public ArrayList<Moms> QueryAllMoms() {
        Session s = factory.getCurrentSession();
        String hql = "From Moms";
        Query q = s.createQuery(hql);
        List momsList = q.list();
        return (ArrayList<Moms>) momsList;
    }

    /*��������ȡ����*/
    public Moms GetMomsById(Integer momsid) {
        Session s = factory.getCurrentSession();
        Moms moms = (Moms)s.get(Moms.class, momsid);
        return moms;
    }
    
    /*��ݲ�ѯ������ѯ*/

	public ArrayList<Moms> QueryMomsInfo(String momsname) { 
    	Session s = factory.getCurrentSession();
    	String hql = "From Moms moms where 1=1";
    	if(!momsname.equals("")) hql = hql + " and moms.momsname like '%" + momsname + "%'";
    	Query q = s.createQuery(hql);
    	List momsList = q.list();
    	return (ArrayList<Moms>) momsList;
    }

}
