package com.product;

import java.sql.Connection;
import java.util.ArrayList;

import com.frame.Biz;

public class ProductBiz extends Biz<Integer, Product> {
	
	ProductDao dao;
	
	public ProductBiz() {
		dao = new ProductDao();
	}
	

	@Override
	public void register(Product v) throws Exception {
		Connection con =getCon();
		try {
			dao.insert(con, v);
		}catch(Exception e) {
			con.rollback();
			throw e;
		}finally {
			close(con);
		}

	}

	@Override
	public void remove(Integer v) throws Exception {
		// TODO Auto-generated method stub
		Connection con = getCon();
		try {
			dao.delete(con, v);
			con.commit();
		} catch (Exception e) {
			con.rollback();
			throw e;
		}finally {
			close(con);
		}
	}

	@Override
	public void modify(Product v) throws Exception {
		// TODO Auto-generated method stub
		Connection con = getCon();
		try {
			dao.update(con, v);
			con.commit();
		} catch (Exception e) {
			con.rollback();
			throw e;
		}finally {
			close(con);
		}
	}

	@Override
	public Product get(Integer k) throws Exception {
		// TODO Auto-generated method stub
		Connection con = getCon();
		Product product = null;
		try {
			dao.select(con, k);
			con.commit();
		} catch (Exception e) {
			con.rollback();
			throw e;
		}finally {
			close(con);
		}
		return product;
	}

	@Override
	public ArrayList<Product> get() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	

}
