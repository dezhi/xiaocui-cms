package com.xiaocui.cms.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.xiaocui.cms.vo.Keyword;
import com.xiaocui.dao.hibernate4.BaseDao;
import com.xiaocui.vo.Pager;

public class KeywordDao extends BaseDao<Keyword> implements IKeywordDao {
	// 获取存在的关键词
	@SuppressWarnings("unchecked")
	private Map<String, Integer> getExist2Map() {
		// 获取文章中存在的关键词
		String hql = "select a.keyword from Article a";

		List<String> keys = this.getSession().createQuery(hql).list();

		Map<String, Integer> mapKey = new HashMap<String, Integer>();

		for (String key : keys) {
			// 根据中划线分割出关键词
			String[] ks = key.split("\\|");

			for (String k : ks) {
				// 不能为空并且首尾除空
				if ("".equals(k.trim()))
					continue;

				if (mapKey.containsKey(k)) {
					mapKey.put(k, mapKey.get(k) + 1);
				} else {
					mapKey.put(k, 1);
				}
			}
		}
		return mapKey;
	}

	/**
	 * 获取一组存在的关键词的名称
	 * 
	 * @return
	 */
	private Set<String> getExistKeywords() {
		return getExist2Map().keySet();
	}

	@Override
	public void addOrUpdate(String name) {
		// this.queryObject("")

	}

	@Override
	public List<Keyword> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pager<Keyword> findUsed() {
		// 获取存在的关键词
		// Map<String, Integer> keys = getExist2Map();
		//
		// Set<String> setKeys = keys.keySet();
		//
		// List<Keyword> ks = new ArrayList<Keyword>();
		//
		// for (String setKey : setKeys) {
		// ks.add(new Keyword(setKey, keys.get(setKey)));
		// }
		//
		// Collections.sort(ks);
		return null;
	}

	@Override
	public Pager<Keyword> findNotUsed() {
		String hql = "from Keyword where name not in (:ks)";

		Set<String> ks = getExistKeywords();

		Map<String, Object> alias = new HashMap<String, Object>();
		alias.put("ks", ks);

		return this.findAlias(hql, alias);
	}

	@Override
	public void clearNotUsed() {
		String hql = "delete Keyword k where k.name not in (:ks)";

		Set<String> ks = getExistKeywords();

		this.getSession().createQuery(hql).setParameterList("ks", ks)
				.executeUpdate();
	}

}
