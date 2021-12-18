package com.hotel.ownerservice.Security;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hotel.ownerservice.OwnerRepo.OwnerRepo;
import com.hotel.ownerservice.models.OwnerInfo;



@Service
public class OwnerService implements UserDetailsService {
	@Autowired
	private OwnerRepo ownerRepo;

//
	public List<OwnerInfo> getOwnerInfos() {
// TODO Auto-generated method stub
		List<OwnerInfo> ownerInfos = ownerRepo.findAll();
		System.out.println("Getting Owner from DB" + ownerInfos);
		return ownerInfos;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		OwnerInfo foundedOwner = ownerRepo.findByEmail(username);
		if (foundedOwner == null)
			return null;
		String Email = foundedOwner.getEmail();
		String Password = foundedOwner.getPassword();
		return new User(Email, Password, new ArrayList<>());
	}
}
