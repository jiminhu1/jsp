package com.product.test;

import com.product.ProductBiz;

public class DeleteTest {

	public static void main(String[] args) {
		ProductBiz biz = new ProductBiz();
		try {
			biz.remove(120);
			System.out.println("OK");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("FAIL");
		}
	}

}
