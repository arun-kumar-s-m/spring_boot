package com.example.demo;

public interface InterfaceRepository {
	
	void save(Token token);
	Token findById(String short_url);

}
