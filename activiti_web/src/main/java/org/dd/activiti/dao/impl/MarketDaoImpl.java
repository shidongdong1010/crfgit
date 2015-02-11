/*package org.dd.activiti.dao.impl;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

*//**
 * 市场Dao实现
 * Created with IntelliJ IDEA.
 * User: SDD
 * Date: 13-12-25
 * Time: 下午10:46
 * To change this template use File | Settings | File Templates.
 *//*
@Repository
public class MarketDaoImpl extends BaseDao implements MarketDao{

	@Override
	public Market findAll() {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	*//**
	 * 保存一个市场
	 *
	 * @param market
	 *//*
	@Override
	public void save(Market market) {
		StringBuilder sql = new StringBuilder();
		sql.append(" insert into market ");
		sql.append("   (marketId,       ");
		sql.append("    name,           ");
		sql.append("    contactId,      ");
		sql.append("    userId,         ");
		sql.append("    intro,          ");
		sql.append("    imageIds,       ");
		sql.append("    toplevel,       ");
		sql.append("    topBeginTime,    ");
		sql.append("    topEndTime,     ");
		sql.append("    sort,           ");
		sql.append("    `check`,          ");
		sql.append("    createTime,     ");
		sql.append("    updateTime,     ");
		sql.append("    F1,             ");
		sql.append("    F2,             ");
		sql.append("    F3,             ");
		sql.append("    F4,             ");
		sql.append("    area)           ");
		sql.append(" values             ");
		sql.append("   (:MARKETID,      ");
		sql.append("    :NAME,          ");
		sql.append("    :CONTACTID,     ");
		sql.append("    :USERID,        ");
		sql.append("    :INTRO,         ");
		sql.append("    :IMAGEIDS,      ");
		sql.append("    :TOPLEVEL,      ");
		sql.append("    :TOPEGINTIME,   ");
		sql.append("    :TOPENDTIME,    ");
		sql.append("    :SORT,          ");
		sql.append("    :CHECK,         ");
		sql.append("    :CREATETIME,    ");
		sql.append("    :UPDATETIME,    ");
		sql.append("    :F1,            ");
		sql.append("    :F2,            ");
		sql.append("    :F3,            ");
		sql.append("    :F4,            ");
		sql.append("    :AREA)          ");

		Map<String, Object> param = this.getParam(market);
		getNamedParameterJdbcTemplate().update(sql.toString(), param);
	}

	*//**
	 * 保存多个市场
	 *
	 * @param markers
	 *//*
	@Override
	public void save(List<Market> markers) {
		StringBuilder sql = new StringBuilder();
		sql.append(" insert into market ");
		sql.append("   (marketId,       ");
		sql.append("    name,           ");
		sql.append("    contactId,      ");
		sql.append("    userId,         ");
		sql.append("    intro,          ");
		sql.append("    imageIds,       ");
		sql.append("    toplevel,       ");
		sql.append("    topBeginTime,    ");
		sql.append("    topEndTime,     ");
		sql.append("    sort,           ");
		sql.append("    `check`,          ");
		sql.append("    createTime,     ");
		sql.append("    updateTime,     ");
		sql.append("    F1,             ");
		sql.append("    F2,             ");
		sql.append("    F3,             ");
		sql.append("    F4,             ");
		sql.append("    area)           ");
		sql.append(" values             ");
		sql.append("   (:MARKETID,      ");
		sql.append("    :NAME,          ");
		sql.append("    :CONTACTID,     ");
		sql.append("    :USERID,        ");
		sql.append("    :INTRO,         ");
		sql.append("    :IMAGEIDS,      ");
		sql.append("    :TOPLEVEL,      ");
		sql.append("    :TOPEGINTIME,   ");
		sql.append("    :TOPENDTIME,    ");
		sql.append("    :SORT,          ");
		sql.append("    :CHECK,         ");
		sql.append("    :CREATETIME,    ");
		sql.append("    :UPDATETIME,    ");
		sql.append("    :F1,            ");
		sql.append("    :F2,            ");
		sql.append("    :F3,            ");
		sql.append("    :F4,            ");
		sql.append("    :AREA)          ");

		Map<String, Object> params[] = new Map[markers.size()];
		for (int i = 0; i < markers.size(); i++){
			Map<String, Object> map = this.getParam(markers.get(i));
			if(map != null){
				params[i] = map;
			}
		}
		getNamedParameterJdbcTemplate().batchUpdate(sql.toString(), params);
	}

	private Map<String, Object> getParam(Market market){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("MARKETID", market.getMarketId());
		param.put("NAME", market.getName());
		param.put("CONTACTID", market.getContactId());
		param.put("USERID", market.getUserId());
		param.put("INTRO", market.getIntro());
		param.put("IMAGEIDS", market.getImageIds());
		param.put("TOPLEVEL", market.getTopLevel());
		param.put("TOPEGINTIME", market.getTopBeginTime());
		param.put("TOPENDTIME", market.getTopEndTime());
		param.put("SORT", market.getSort());
		param.put("CHECK", market.getCheck());
		param.put("CREATETIME", market.getCreateTime());
		param.put("UPDATETIME", market.getUpdateTime());
		param.put("F1", market.getF1());
		param.put("F2", market.getF2());
		param.put("F3", market.getF3());
		param.put("F4", market.getF4());
		param.put("AREA", market.getArea());
		return param;
	}
}
*/