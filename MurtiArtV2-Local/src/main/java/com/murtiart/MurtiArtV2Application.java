package com.murtiart;

import javax.persistence.Column;
import javax.persistence.Id;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.murtiart.about.AboutUs;
import com.murtiart.about.AboutUsRepository;
import com.murtiart.appkaremote.AppKaRemote;
import com.murtiart.appkaremote.AppKaRemoteRepository;
import com.murtiart.category.CategoryRepository;
import com.murtiart.config.AppConstants;
import com.murtiart.howtouse.HowToUse;
import com.murtiart.howtouse.HowToUseRepository;
import com.murtiart.roles.RoleRepository;
import com.murtiart.roles.Roles;

@SpringBootApplication
public class MurtiArtV2Application  implements CommandLineRunner{
	
    @Autowired
    private PasswordEncoder passwordEncoder;
    
	
    @Bean
    ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Autowired
    private RoleRepository roleRepository;
    
    @Autowired
    private AppKaRemoteRepository appKaRemoteRepository;
    
    @Autowired
    private CategoryRepository categoryRepository;
    
    @Autowired
    private AboutUsRepository aboutUsRepository;
    
    @Autowired
    private HowToUseRepository howToUseRepository;
    

	public static void main(String[] args) {
		SpringApplication.run(MurtiArtV2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
    	createRole();
    	createAppKaRemote();
    	createAboutUs();
    	createHowToUse();
	}
 

	private void createHowToUse() {
		
		// Login
		HowToUse hTU1 = new HowToUse();
		
		hTU1.setId(AppConstants.ID1_1);
		hTU1.setType(AppConstants.TYPE1_1); 
		hTU1.setLink(AppConstants. LINK1_1);
		hTU1.setTitle(AppConstants. TITLE1_1);
		hTU1.setDescription(AppConstants. DESCRIPTION1_1);
		hTU1.setThumbnail(AppConstants. THUMBNAIL1_1);
		hTU1.setRemove(AppConstants.REMOVE1_1);
		hTU1.setShow(AppConstants.SHOW1_1);

		this.howToUseRepository.save(hTU1);

		// Registration
		HowToUse hTU2 = new HowToUse();
		
		hTU2.setId(AppConstants.ID2_1);
		hTU2.setType(AppConstants.TYPE2_1); 
		hTU2.setLink(AppConstants. LINK2_1);
		hTU2.setTitle(AppConstants. TITLE2_1);
		hTU2.setDescription(AppConstants. DESCRIPTION2_1);
		hTU2.setThumbnail(AppConstants. THUMBNAIL2_1);
		hTU2.setRemove(AppConstants.REMOVE2_1);
		hTU2.setShow(AppConstants.SHOW2_1);
		
		this.howToUseRepository.save(hTU2);
		
		// Role Selection at login
		HowToUse hTU3 = new HowToUse();
		
		hTU3.setId(AppConstants.ID3_1);
		hTU3.setType(AppConstants.TYPE3_1); 
		hTU3.setLink(AppConstants. LINK3_1);
		hTU3.setTitle(AppConstants. TITLE3_1);
		hTU3.setDescription(AppConstants. DESCRIPTION3_1);
		hTU3.setThumbnail(AppConstants. THUMBNAIL3_1);
		hTU3.setRemove(AppConstants.REMOVE3_1);
		hTU3.setShow(AppConstants.SHOW3_1);
		
		this.howToUseRepository.save(hTU3);
		
		
		/////////////////////////
		
		// home screen information
		HowToUse hTU4 = new HowToUse();
		
		hTU4.setId(AppConstants.ID1_2);
		hTU4.setType(AppConstants.TYPE1_2); 
		hTU4.setLink(AppConstants. LINK1_2);
		hTU4.setTitle(AppConstants. TITLE1_2);
		hTU4.setDescription(AppConstants. DESCRIPTION1_2);
		hTU4.setThumbnail(AppConstants. THUMBNAIL1_2);
		hTU4.setRemove(AppConstants.REMOVE1_2);
		hTU4.setShow(AppConstants.SHOW1_2);
		
		this.howToUseRepository.save(hTU4);
		
		// product list 
		HowToUse hTU5 = new HowToUse();
		
		hTU5.setId(AppConstants.ID2_2);
		hTU5.setType(AppConstants.TYPE2_2); 
		hTU5.setLink(AppConstants. LINK2_2);
		hTU5.setTitle(AppConstants. TITLE2_2);
		hTU5.setDescription(AppConstants. DESCRIPTION2_2);
		hTU5.setThumbnail(AppConstants. THUMBNAIL2_2);
		hTU5.setRemove(AppConstants.REMOVE2_2);
		hTU5.setShow(AppConstants.SHOW2_2);
		
		this.howToUseRepository.save(hTU5);
		
		
		// Detail screen
		HowToUse hTU6 = new HowToUse();
		
		hTU6.setId(AppConstants.ID3_2);
		hTU6.setType(AppConstants.TYPE3_2); 
		hTU6.setLink(AppConstants. LINK3_2);
		hTU6.setTitle(AppConstants. TITLE3_2);
		hTU6.setDescription(AppConstants. DESCRIPTION3_2);
		hTU6.setThumbnail(AppConstants. THUMBNAIL3_2);
		hTU6.setRemove(AppConstants.REMOVE3_2);
		hTU6.setShow(AppConstants.SHOW3_2);
		
		this.howToUseRepository.save(hTU6);

		
		////////////////////
		

		// How to add to fav show from Home screen to Product Detail Screen 
		HowToUse hTU7 = new HowToUse();
		
		hTU7.setId(AppConstants.ID1_3);
		hTU7.setType(AppConstants.TYPE1_3); 
		hTU7.setLink(AppConstants. LINK1_3);
		hTU7.setTitle(AppConstants. TITLE1_3);
		hTU7.setDescription(AppConstants. DESCRIPTION1_3);
		hTU7.setThumbnail(AppConstants. THUMBNAIL1_3);
		hTU7.setRemove(AppConstants.REMOVE1_3);
		hTU7.setShow(AppConstants.SHOW1_3);
		
		this.howToUseRepository.save(hTU7);

		
		// Show fav product present in list
		HowToUse hTU8 = new HowToUse();
		
		hTU8.setId(AppConstants.ID2_3);
		hTU8.setType(AppConstants.TYPE2_3); 
		hTU8.setLink(AppConstants. LINK2_3);
		hTU8.setTitle(AppConstants. TITLE2_3);
		hTU8.setDescription(AppConstants. DESCRIPTION2_3);
		hTU8.setThumbnail(AppConstants. THUMBNAIL2_3);
		hTU8.setRemove(AppConstants.REMOVE2_3);
		hTU8.setShow(AppConstants.SHOW2_3);
		
		this.howToUseRepository.save(hTU8);
		
		///////////////////
		

		// Scan normal product and navigate to that product
	    HowToUse hTU9 = new HowToUse();
		
	    hTU9.setId(AppConstants.ID1_4);
	    hTU9.setType(AppConstants.TYPE1_4); 
	    hTU9.setLink(AppConstants. LINK1_4);
	    hTU9.setTitle(AppConstants. TITLE1_4);
	    hTU9.setDescription(AppConstants. DESCRIPTION1_4);
	    hTU9.setThumbnail(AppConstants. THUMBNAIL1_4);
		hTU9.setRemove(AppConstants.REMOVE1_4);
		hTU9.setShow(AppConstants.SHOW1_4);
		
		this.howToUseRepository.save(hTU9);
		

		//  Scan favourite product and shopkeeper get that product where it is.
		HowToUse hTU10 = new HowToUse();
		
		hTU10.setId(AppConstants.ID2_4);
		hTU10.setType(AppConstants.TYPE2_4); 
		hTU10.setLink(AppConstants. LINK2_4);
		hTU10.setTitle(AppConstants. TITLE2_4);
		hTU10.setDescription(AppConstants. DESCRIPTION2_4);
		hTU10.setThumbnail(AppConstants. THUMBNAIL2_4);
		hTU10.setRemove(AppConstants.REMOVE2_4);
		hTU10.setShow(AppConstants.SHOW2_4);
		
		this.howToUseRepository.save(hTU10);
		
		
		// Show QR code of normal product
		HowToUse hTU11 = new HowToUse();
		
		hTU11.setId(AppConstants.ID3_4);
		hTU11.setType(AppConstants.TYPE3_4); 
		hTU11.setLink(AppConstants. LINK3_4);
		hTU11.setTitle(AppConstants. TITLE3_4);
		hTU11.setDescription(AppConstants. DESCRIPTION3_4);
		hTU11.setThumbnail(AppConstants. THUMBNAIL3_4);
		hTU11.setRemove(AppConstants.REMOVE3_4);
		hTU11.setShow(AppConstants.SHOW3_4);
		
		this.howToUseRepository.save(hTU11);
		
		
		///////////////

		// setting screen
		HowToUse hTU12 = new HowToUse();
		
		hTU12.setId(AppConstants.ID1_5);
		hTU12.setType(AppConstants.TYPE1_5); 
		hTU12.setLink(AppConstants. LINK1_5);
		hTU12.setTitle(AppConstants. TITLE1_5);
		hTU12.setDescription(AppConstants. DESCRIPTION1_5);
		hTU12.setThumbnail(AppConstants. THUMBNAIL1_5);
		hTU12.setRemove(AppConstants.REMOVE1_5);
		hTU12.setShow(AppConstants.SHOW1_5);
		
		this.howToUseRepository.save(hTU12);
		
	 
		//  manage address
		HowToUse hTU13 = new HowToUse();
		
		hTU13.setId(AppConstants.ID2_5);
		hTU13.setType(AppConstants.TYPE2_5); 
		hTU13.setLink(AppConstants. LINK2_5);
		hTU13.setTitle(AppConstants. TITLE2_5);
		hTU13.setDescription(AppConstants. DESCRIPTION2_5);
		hTU13.setThumbnail(AppConstants. THUMBNAIL2_5);
		hTU13.setRemove(AppConstants.REMOVE2_5);
		hTU13.setShow(AppConstants.SHOW2_5);
		
		this.howToUseRepository.save(hTU13);
		
		
		// manage profile
		HowToUse hTU14 = new HowToUse();
		
		hTU14.setId(AppConstants.ID3_5);
		hTU14.setType(AppConstants.TYPE3_5); 
		hTU14.setLink(AppConstants. LINK3_5);
		hTU14.setTitle(AppConstants. TITLE3_5);
		hTU14.setDescription(AppConstants. DESCRIPTION3_5);
		hTU14.setThumbnail(AppConstants. THUMBNAIL3_5);
		hTU14.setRemove(AppConstants.REMOVE3_5);
		hTU14.setShow(AppConstants.SHOW3_5);
		
		this.howToUseRepository.save(hTU14);
		
		
		// manage update,
		HowToUse hTU15 = new HowToUse();
		
		hTU15.setId(AppConstants.ID4_5);
		hTU15.setType(AppConstants.TYPE4_5); 
		hTU15.setLink(AppConstants. LINK4_5);
		hTU15.setTitle(AppConstants. TITLE4_5);
		hTU15.setDescription(AppConstants. DESCRIPTION4_5);
		hTU15.setThumbnail(AppConstants. THUMBNAIL4_5);
		hTU15.setRemove(AppConstants.REMOVE4_5);
		hTU15.setShow(AppConstants.SHOW4_5);
		
		this.howToUseRepository.save(hTU15);
		
		 
		// manage support,
		HowToUse hTU16 = new HowToUse();
		
		hTU16.setId(AppConstants.ID5_5);
		hTU16.setType(AppConstants.TYPE5_5); 
		hTU16.setLink(AppConstants. LINK5_5);
		hTU16.setTitle(AppConstants. TITLE5_5);
		hTU16.setDescription(AppConstants. DESCRIPTION5_5);
		hTU16.setThumbnail(AppConstants. THUMBNAIL5_5);
		hTU16.setRemove(AppConstants.REMOVE5_5);
		hTU16.setShow(AppConstants.SHOW5_5);
		
		this.howToUseRepository.save(hTU16);
		

		// Product Add
		HowToUse hTU17 = new HowToUse();
		
		hTU17.setId(AppConstants.ID1_6);
		hTU17.setType(AppConstants.TYPE1_6); 
		hTU17.setLink(AppConstants. LINK1_6);
		hTU17.setTitle(AppConstants. TITLE1_6);
		hTU17.setDescription(AppConstants. DESCRIPTION1_6);
		hTU17.setThumbnail(AppConstants. THUMBNAIL1_6);
		hTU17.setRemove(AppConstants.REMOVE1_6);
		hTU17.setShow(AppConstants.SHOW1_6);
		
		this.howToUseRepository.save(hTU17);
		
	 
		// Variant Add
		HowToUse hTU18 = new HowToUse();
		
		hTU18.setId(AppConstants.ID2_6);
		hTU18.setType(AppConstants.TYPE2_6); 
		hTU18.setLink(AppConstants. LINK2_6);
		hTU18.setTitle(AppConstants. TITLE2_6);
		hTU18.setDescription(AppConstants. DESCRIPTION2_6);
		hTU18.setThumbnail(AppConstants. THUMBNAIL2_6);
		hTU18.setRemove(AppConstants.REMOVE2_6);
		hTU18.setShow(AppConstants.SHOW2_6);
		
		this.howToUseRepository.save(hTU18);
		
		
		// Attribute Add
		HowToUse hTU19 = new HowToUse();
		
		hTU19.setId(AppConstants.ID3_6);
		hTU19.setType(AppConstants.TYPE3_6); 
		hTU19.setLink(AppConstants. LINK3_6);
		hTU19.setTitle(AppConstants. TITLE3_6);
		hTU19.setDescription(AppConstants. DESCRIPTION3_6);
		hTU19.setThumbnail(AppConstants. THUMBNAIL3_6);
		hTU19.setRemove(AppConstants.REMOVE3_6);
		hTU19.setShow(AppConstants.SHOW3_6);
		
		this.howToUseRepository.save(hTU19);
		
		 
		// Images Add
		HowToUse hTU20 = new HowToUse();
		
		hTU20.setId(AppConstants.ID4_6);
		hTU20.setType(AppConstants.TYPE4_6); 
		hTU20.setLink(AppConstants. LINK4_6);
		hTU20.setTitle(AppConstants. TITLE4_6);
		hTU20.setDescription(AppConstants. DESCRIPTION4_6);
		hTU20.setThumbnail(AppConstants. THUMBNAIL4_6);
		hTU20.setRemove(AppConstants.REMOVE4_6);
		hTU20.setShow(AppConstants.SHOW4_6);
		
		this.howToUseRepository.save(hTU20);
		 
		
		// Product Edit
		HowToUse hTU21 = new HowToUse();
		
		hTU21.setId(AppConstants.ID5_6);
		hTU21.setType(AppConstants.TYPE5_6); 
		hTU21.setLink(AppConstants. LINK5_6);
		hTU21.setTitle(AppConstants. TITLE5_6);
		hTU21.setDescription(AppConstants. DESCRIPTION5_6);
		hTU21.setThumbnail(AppConstants. THUMBNAIL5_6);
		hTU21.setRemove(AppConstants.REMOVE5_6);
		hTU21.setShow(AppConstants.SHOW5_6);
		
		this.howToUseRepository.save(hTU21);
		 
		// Variant Edit
		HowToUse hTU22 = new HowToUse();
		
		hTU22.setId(AppConstants.ID6_6);
		hTU22.setType(AppConstants.TYPE6_6); 
		hTU22.setLink(AppConstants. LINK6_6);
		hTU22.setTitle(AppConstants. TITLE6_6);
		hTU22.setDescription(AppConstants. DESCRIPTION6_6);
		hTU22.setThumbnail(AppConstants. THUMBNAIL6_6);
		hTU22.setRemove(AppConstants.REMOVE6_6);
		hTU22.setShow(AppConstants.SHOW6_6);
		
		this.howToUseRepository.save(hTU22);
		
		 
		// Attribute Edit
	   HowToUse hTU23 = new HowToUse();
		
	   hTU23.setId(AppConstants.ID7_6);
	   hTU23.setType(AppConstants.TYPE7_6); 
	   hTU23.setLink(AppConstants. LINK7_6);
	   hTU23.setTitle(AppConstants. TITLE7_6);
	   hTU23.setDescription(AppConstants. DESCRIPTION7_6);
	   hTU23.setThumbnail(AppConstants. THUMBNAIL7_6);
	   hTU23.setRemove(AppConstants.REMOVE7_6);
	   hTU23.setShow(AppConstants.SHOW7_6);
		
		this.howToUseRepository.save(hTU23);
		
		// Images Edit
		   HowToUse hTU24 = new HowToUse();
			
		   hTU24.setId(AppConstants.ID8_6);
		   hTU24.setType(AppConstants.TYPE8_6); 
		   hTU24.setLink(AppConstants. LINK8_6);
		   hTU24.setTitle(AppConstants. TITLE8_6);
		   hTU24.setDescription(AppConstants. DESCRIPTION8_6);
		   hTU24.setThumbnail(AppConstants. THUMBNAIL8_6);
		   hTU24.setRemove(AppConstants.REMOVE8_6);
		   hTU24.setShow(AppConstants.SHOW8_6);
			
			this.howToUseRepository.save(hTU24);
	}

	private void createAboutUs() {
		try {
			
			AboutUs a = new AboutUs();
			a.setId(AppConstants.ABOUTUS_ID1);
			a.setType(AppConstants.ABOUTUS_TYPE1);
			a.setName(AppConstants.ABOUTUS_NAME1);
			a.setEmail(AppConstants.ABOUTUS_EMAIL1);
			a.setDescription(AppConstants.ABOUTUS_DESCRIPTION1);
			a.setPhone(AppConstants.ABOUTUS_PHONE1);
			a.setGender(AppConstants.ABOUTUS_GENDER1);
			a.setRemove(AppConstants.ABOUTUS_REMOVE1);
			a.setImage(AppConstants.ABOUTUS_IMAGE1);
			
			this.aboutUsRepository.save(a);
			
			
			AboutUs b = new AboutUs();
			b.setId(AppConstants.ABOUTUS_ID2);
			b.setType(AppConstants.ABOUTUS_TYPE2);
			b.setName(AppConstants.ABOUTUS_NAME2);
			b.setEmail(AppConstants.ABOUTUS_EMAIL2);
			b.setDescription(AppConstants.ABOUTUS_DESCRIPTION2);
			b.setPhone(AppConstants.ABOUTUS_PHONE2);
			b.setGender(AppConstants.ABOUTUS_GENDER2);
			b.setRemove(AppConstants.ABOUTUS_REMOVE2);
			b.setImage(AppConstants.ABOUTUS_IMAGE2);
			
			this.aboutUsRepository.save(b);
			 
		} catch (Exception e) {
			System.out.print(e.toString());
		}
	}

	private void createAppKaRemote() {
	try {
			
			AppKaRemote a = new AppKaRemote();
			a.setRemoteid(AppConstants.APPKAREMOTE_ID);
			a.setMessage(AppConstants.APPKAREMOTE_MESSAGE); 
			a.setFroceUpdate(AppConstants.APPKAREMOTE_FORCEUPDATE); 
			a.setFreez(AppConstants.APPKAREMOTE_FREEZ); 
			a.setUrlMaker(AppConstants.APPKAREMOTE_URLMAKER); 
			a.setNoDataPlaceHolder(AppConstants.APPKAREMOTE_NODATAPLACEHOLDER); 
			a.setCurrency(AppConstants.APPKAREMOTE_CURRENCY); 
			a.setSupport(AppConstants.APPKAREMOTE_SUPPORT);
			
			this.appKaRemoteRepository.save(a);
			 
		} catch (Exception e) {
			System.out.print(e.toString());
		}
		
	}

	private void createRole() {
		// Create Default Role At first time
		try {
			
			Roles aRoles = new Roles();
			aRoles.setRoleid(AppConstants.ADMIN_ROLE);
			aRoles.setName(AppConstants.ADMIN);
			
			this.roleRepository.save(aRoles);
			
			Roles sRoles = new Roles();
			sRoles.setRoleid(AppConstants.SHOPKEEPER_ROLE);
			sRoles.setName(AppConstants.SHOPKEEPER);
			
			this.roleRepository.save(sRoles);
			
			Roles cRoles = new Roles();
			cRoles.setRoleid(AppConstants.CUSTOMER_ROLE);
			cRoles.setName(AppConstants.CUSTOMER);
			
			this.roleRepository.save(cRoles);
			
		} catch (Exception e) {
			System.out.print(e.toString());
		}
	}
}
