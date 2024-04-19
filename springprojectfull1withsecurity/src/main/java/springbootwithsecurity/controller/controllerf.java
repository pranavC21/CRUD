package springbootwithsecurity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import springbootwithsecurity.entity.user;
import springbootwithsecurity.service.servicef;






@RestController
public class controllerf {

 @Autowired
 servicef ser;
	

@GetMapping("/user")
public ResponseEntity<List<user>> GetUser(){
	List<user> k = this.ser.getAll();
	if(k.isEmpty()) {
		return new ResponseEntity<List<user>>(HttpStatus.NOT_FOUND);
	}
	return new ResponseEntity<List<user>>(k,HttpStatus.OK);
}




@GetMapping("/user/{id}")
public ResponseEntity<user> getuserbyid(@PathVariable("id") int id){
	try {
	user t = ser.getuserbyid(id);
	if(t!=null) {
		return new ResponseEntity<>(t,HttpStatus.OK);
	}
	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}catch(Exception e) {
		e.printStackTrace();
		return null;
	}
	
}




@PostMapping("/user")
public ResponseEntity<user> postUser(@RequestBody user u) {
	user t  = ser.postuser(u);
	if(t!=null) {
		return new ResponseEntity<user>(t,HttpStatus.CREATED);
	}
	return new ResponseEntity<user>(HttpStatus.INTERNAL_SERVER_ERROR);
}



@PutMapping("/user/{id}")
	public ResponseEntity<user> updateUser(@RequestBody user u, @PathVariable("id") int id) {
		user g = ser.update(u, id);
		if(g!=null) {
			return new ResponseEntity<user>(g,HttpStatus.CREATED);
		}
		return new ResponseEntity<user>(HttpStatus.BAD_REQUEST);
}





}
