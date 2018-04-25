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
import com.daigou.model.Gaoding;


@Service @Transactional
public class GaodingDao {
	@Resource SessionFactory factory;
	
	 /*���Food��Ϣ*/
    public void AddGao(Gaoding gao) throws Exception {
    	Session s = factory.getCurrentSession();
    	s.save(gao);
    }
    
    /*ɾ��Food��Ϣ*/
    public void DeleteGao(Integer gaoId) throws Exception {
        Session s = factory.getCurrentSession(); 
        Object gao = s.load(Gaoding.class, gaoId);
        s.delete(gao);
    }
    
    /*����Food��Ϣ*/
    public void UpdateGao(Gaoding gao) throws Exception {
        Session s = factory.getCurrentSession();
        s.update(gao);
    }
    
    /*��ѯ����Food��Ϣ*/
    public ArrayList<Gaoding> QueryAllGao() {
        Session s = factory.getCurrentSession();
        String hql = "From Gaoding";
        Query q = s.createQuery(hql);
        List gaoList = q.list();
        return (ArrayList<Gaoding>) gaoList;
    }

    /*��������ȡ����*/
    public Gaoding GetGaoById(Integer gaoid) {
        Session s = factory.getCurrentSession();
        Gaoding gao = (Gaoding)s.get(Gaoding.class, gaoid);
        return gao;
    }
    
    /*��ݲ�ѯ������ѯ*/

	public ArrayList<Gaoding> QueryGaoInfo(String gaoname) { 
    	Session s = factory.getCurrentSession();
    	String hql = "From Gaoding gaoding where 1=1";
    	if(!gaoname.equals("")) hql = hql + " and gaoding.gaoname like '%" + gaoname + "%'";
    	Query q = s.createQuery(hql);
    	List gaoList = q.list();
    	return (ArrayList<Gaoding>) gaoList;
    }

}
