package com.offcn.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.offcn.mapper.GoodsDAO;
import com.offcn.po.Goods;
import com.offcn.service.GoodsService;

/**
 * 商品业务实现
 * 
 */
// 自动添加到Spring容器中
@Service
public class GoodsServiceImpl implements GoodsService {

	// 自动装配
	@Resource
	GoodsDAO goodsdao;

	// 分页
	@Override
	public List<Goods> getGoodsPager(int pageNO, int size) {
		int skip = (pageNO - 1) * size;
		return goodsdao.getGoodsPager(skip, size);
		//判断Redis缓存是否存在
		//1、如果缓存不存在，我们从数据库读取数据，把读取到的数据缓存到redis
		
		//2、如果缓存存在，直接从缓存读取数据

	}

	// 获得单个产品对象
	@Override
	public Goods getGoodsById(int id) {
		return goodsdao.getGoodsById(id);
	}

	// 获得商品总数
	@Override
	public int getGoodsCount() {
		return goodsdao.getGoodsCount();
	}

	// 添加
	@Override
	public int insert(Goods entity) {
		
		return goodsdao.insert(entity);
	}

	// 删除单个
	@Override
	public int delete(int id) {
		
		return goodsdao.delete(id);
	}

	// 删除多个
	@Override
	public int deletes(int[] ids) {
		int rows = 0;
		for (int id : ids) {
			rows += delete(id);
		}
		return rows;
	}

	// 更新
	@Override
	public int update(Goods entity) {
		
		return goodsdao.update(entity);
	}

}
