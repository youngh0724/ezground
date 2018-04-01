package com.ezground.teamproject.team;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ezground.teamproject.team.dto.Team;

@Repository
public class TeamDao {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	//Mapper��� ���ڿ��� ���ȭ(final��)���� �����Ͽ� �ߺ������� ���� �ʵ����ߴ�.
	private final String mapperRoot = "com.ezground.teamproject.team.TeamMapper.";
	
	//�Է°��� ���ϰ��� Ȯ���ϱ����� �ΰű�� ���
	private static final Logger logger = LoggerFactory.getLogger(TeamDao.class);
		
	public List<Team> teamSelectPage(Map map) {
		logger.debug("teamSelectPage() map.startRow = {}", map.get("startRow"));
		logger.debug("teamSelectPage() map.rowPerPage = {}", map.get("rowPerPage"));
		logger.debug("teamSelectPage() map.searchWord = {}", map.get("searchWord"));
		return sqlSessionTemplate.selectList(mapperRoot+"teamSelectPage", map);
	}
	
	public int teamSelectTotalCount() {
		logger.debug("totalCount() ����Ȯ��"); 
		return sqlSessionTemplate.selectOne(mapperRoot+"teamSelectCount");	
	}
	
	public Team teamSelectListDetail(int teamNo) {
		logger.debug("teamSelectListDetail() teamNo = {}", teamNo);
		return sqlSessionTemplate.selectOne(mapperRoot+"teamSelectListDetail", teamNo);
	}
	public int teamInsert(Team team) {
		logger.debug("teamInsert() team = {}", team);
		//team��ü�� �Ű������� �޾� db�� ������ �Է��Ѵ�.
		return sqlSessionTemplate.insert(mapperRoot+"teamInsert", team);
	}
	
	//�� �Ѱ��� ������Ʈ �ϱ����� �Ѱ��� ���� �������ִ� �������� �����ϴ� �޼���
	public Team teamSelectOneForUpdate(int teamNo) {
		logger.debug("teamSelectOneForUpdate() teamNo = {}", teamNo);
		//���ۿ� �Ű������� ��ġ�ϴ� �ϳ��� ���� ã�� team��üŸ������ �����Ѵ�.		
		return sqlSessionTemplate.selectOne(mapperRoot+"teamSelectOne", teamNo);
	}
	public int teamUpdate(Team team) {
		logger.debug("teamUpdate() team = {}", team);
		//team��ü�� �Ű������� �޾� db�� ������ ������Ʈ(����)�Ѵ�.
		return sqlSessionTemplate.update(mapperRoot+"teamUpdate", team);
	}
	public int teamDelete(int teamNo) {
		logger.debug("teamDelete() teamNo = {}", teamNo);
		//���̵� �Է¹޾� db���� ��ġ�ϴ� ������ �����Ѵ�. 
		return sqlSessionTemplate.delete(mapperRoot+"teamDelete", teamNo);
	}
	
//�� ������ ���� �� ��� �켱 ����
	public int teamDeleteMember(int teamNo) {
		logger.debug("teamDeleteMember() teamNo = {}", teamNo);
		
		return sqlSessionTemplate.delete(mapperRoot+"teamDeleteMember", teamNo);
	}
	//���� �� ��� ��ȸ
	public List<Team> teamSelectMyTeam(Map map) {
		logger.debug("teamSelectMyTeam() map.startRow = {}", map.get("startRow"));
		logger.debug("teamSelectMyTeam() map.rowPerPage = {}", map.get("rowPerPage"));
		logger.debug("teamSelectMyTeam() map.searchWord = {}", map.get("searchWord"));
		logger.debug("teamSelectMyTeam() map.memberNo = {}", map.get("memberNo"));
		return sqlSessionTemplate.selectList(mapperRoot+"teamSelectMyTeam", map);
	}
	//���� �� ���� ī��Ʈ
	public int myTeamSelectTotalCount(int memberNo) {
		logger.debug("totalCount() ����Ȯ��"); 
		return sqlSessionTemplate.selectOne(mapperRoot+"myTeamSelectCount", memberNo);	
	}
	
	
}
