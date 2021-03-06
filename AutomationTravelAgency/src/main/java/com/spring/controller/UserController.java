package com.spring.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.json.BookTicket;
import com.spring.json.ChangePassword;
import com.spring.service.UserCredentialsService;
import com.spring.service.UserService;
import com.spring.json.Reservation;
import com.spring.json.Route;
import com.spring.json.UserProfile;
import com.spring.json.Vehicle;
@CrossOrigin(origins="*")
@RestController
@RequestMapping("/app/userController")
public class UserController 
{
	@Autowired
	UserService userService;
	 		
	@GetMapping(value="/vehicle/{vehicleId}",produces=MediaType.APPLICATION_JSON_VALUE)
	public Object getVehicleById(@PathVariable(name ="vehicleId") String vehicleid){
		return userService.getVehicleById(Long.valueOf(vehicleid));
	}	
	@GetMapping(value="/route/{routeId}",produces=MediaType.APPLICATION_JSON_VALUE)
	public Object getRouteById(@PathVariable(name ="routeId") String routeId){
		return userService.getRouteById(Long.valueOf(routeId));
	}
	@PutMapping(value="/reservation/{userId}",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public Object bookReservation(@RequestBody UserProfile userProfile ,@PathVariable(name="userId") String userId)
	{
		return userService.bookReservation(userProfile,Long.parseLong(userId));
	}
	@PutMapping(value="/reservation/selectMeans/{userId}",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public Object confirmBooking(@RequestBody BookTicket bookTicket ,@PathVariable(name="userId") String userId)
	{
		return userService.confirmBooking(bookTicket,Long.parseLong(userId));
	}
	@GetMapping(value="/reservation/{reservationId}",produces=MediaType.APPLICATION_JSON_VALUE)
	public Object getBookingStatus(@PathVariable(name="reservationId") String reservationId)
	{
		return userService.getBookingStatus(Long.valueOf(reservationId));
	}
	@DeleteMapping("reservation/{reservationId}")
	public Object cancelBooking(@PathVariable(name="reservationId") String reservationId)
	{
		return userService.cancelBooking(Long.valueOf(reservationId));
	}
	
	
	@PutMapping(value="/user/changePassword",produces=MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
	public Object changePassword(@RequestBody ChangePassword requestedPassword)
	{
		return userService.changePassword(requestedPassword);
	}
	
	
	
}

