package org.techhub.service;
import java.util.List;
import org.techhub.model.Voter;
public interface VoterService {
	public boolean isAddVoter(Voter v);
	public List<Voter> isViewAll();
	public boolean isDelete(int id);
	public boolean isUpdate(Voter voter);
	public Voter isSearch(int id);
}
