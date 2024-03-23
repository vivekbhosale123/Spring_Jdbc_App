package org.techhub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.techhub.model.Voter;
import org.techhub.repository.VoterRepo;
@Service("voterSer")
public class VoterServiceImple implements VoterService {
	@Autowired
	VoterRepo voterRepoImple;
	public boolean isAddVoter(Voter v) {
		
		if(v.getAge()>18)
		{
			boolean b=voterRepoImple.isAddVoter(v);
			return b;
		}
		else
		{
			return false;
		}
	}
	@Override
	public List<Voter> isViewAll() {
		return voterRepoImple.isViewAll();
	}
	public boolean isDelete(int id) {
		return voterRepoImple.isDelete(id);
	}
	@Override
	public boolean isUpdate(Voter voter) {
		return voterRepoImple.isUpdate(voter);
	}
	@Override
	public Voter isSearch(int id) {	
		return voterRepoImple.isSearch(id);
	}
	

}
