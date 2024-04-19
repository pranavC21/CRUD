package springbootwithsecurity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springbootwithsecurity.entity.user;
import springbootwithsecurity.repository.repositoryf;


@Service
public class servicef {
	
@Autowired
repositoryf re;
	


	public List<user> getAll(){
		return re.findAll();		
	}
	
	public user getuserbyid(int id){
		return re.findById(id).get();
	}
	
	public user postuser(user u){
		re.save(u);
		return u;
	}
	
	public user update(user u,int id) {
		for(int i=0;i<re.count();i++) {
			if(re.findById(id)!= null) {
				if(u.getId()==id) {
				re.save(u);
				return u;
				}
			}
		}
		return null;
	}
	
}
